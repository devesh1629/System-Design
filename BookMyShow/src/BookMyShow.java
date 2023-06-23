import enums.City;
import enums.Movie;
import enums.SeatCategory;

import java.util.*;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;
    Utils utils;
    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
        Utils utils;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        while(true) {
            System.out.println("Choose City: " + City.DELHI + " or " + City.BANGALORE + " or " + City.MUMBAI);
            String userCity = in.next();
            if(userCity.equals("X")) {
                System.out.println("Booking Closed");
                break;
            }
            bookMyShow.createBooking(in, userCity);
        }
    }
    public void createBooking(Scanner in, String userCity) {
        City city = this.utils.getCityByName(userCity);
        if(city == null) {
            System.out.println("Chosen city is not available currently. Try again");
            return;
        }
        System.out.println(city);
        System.out.println("Choose Movie: RRR or AVENGERS or PUSHPA");
        String userMovie = in.next();
        Movie movie  = this.utils.getMovieByName(userMovie);
        if(movie == null) {
            System.out.println("Chosen movie is not available currently. Try again");
            return;
        }
        Map<Theatre, List<Show>> optionsAvailable = theatreController.getAllShows(movie, city);
        System.out.println("Theatres available are: ");
        for(Theatre theatre : optionsAvailable.keySet()) {
            System.out.print(theatre.getTheatreId() + " ");
        }

        int chosenTheatreId = in.nextInt();
        Theatre chosenTheatre = theatreController.getTheatreById(chosenTheatreId);
        List<Show> shows = optionsAvailable.get(chosenTheatre);
        System.out.println("Shows available are: ");
        for(Show show : shows)
            System.out.println("Screen is: " + show.getScreen() + " startTime: " + show.getShowStartTime() + " . Id: "  + show.getShowId());


        int chosenShowId = in.nextInt();
        Show chosenShow = chosenTheatre.getShowById(chosenShowId);
        Screen chosenScreen = chosenShow.getScreen();
        System.out.println("Enter number of seats to be booked: ");

        int numberOfSeats = in.nextInt();
        System.out.println("Seats available are: ");
        for(Seat seat : chosenScreen.getSeats())
            System.out.println("Category: " + seat.getSeatCategory() + " " + seat.getSeatId());
        Set<Seat> chosenSeats = new HashSet<>();
        for(int i=0; i<numberOfSeats; i++) {
            int chosenSeatId = in.nextInt();
            Seat chosenSeat = chosenScreen.getSeatById(chosenSeatId);
            chosenSeats.add(chosenSeat);
        }
        if(!chosenShow.setBookedSeatIds(chosenSeats)) {
            System.out.println("Seats unavailable");
            return;
        }
        System.out.println("Enter payment id");
        int paymentId = in.nextInt();

        System.out.println("Congratulations, your booking is done");

    }
    private void initialize() {
        createMovies();
        createTheatre();
    }
    private void createTheatre() {
        Movie avengers = movieController.getMovieByName("AVENGERS");
        Movie rrr = movieController.getMovieByName("RRR");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setCity(City.BANGALORE);
        inoxTheatre.setScreens(createScreens());
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShow(1, avengers, inoxTheatre.getScreens().get(0), 9);
        Show inoxEveningShow = createShow(2, rrr, inoxTheatre.getScreens().get(0), 19);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setCity(City.DELHI);
        pvrTheatre.setScreens(createScreens());
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShow(1, avengers, pvrTheatre.getScreens().get(0), 9);
        Show pvrEveningShow = createShow(2, rrr, pvrTheatre.getScreens().get(0), 19);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(City.DELHI, pvrTheatre);
        theatreController.addTheatre(City.BANGALORE, inoxTheatre);
    }

    private Show createShow(int showId, Movie movie, Screen screen, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setShowStartTime(showStartTime);
        return show;
    }

    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }
    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        // 40 silver seats
        for(int i=1; i<=40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }
        for(int i=41; i<=100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }
        for(int i=101; i<=125; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }
        return seats;
    }

    private void createMovies() {
        movieController.addMovie(Movie.AVENGERS, City.DELHI);
        movieController.addMovie(Movie.AVENGERS, City.BANGALORE);
        movieController.addMovie(Movie.RRR, City.DELHI);
        movieController.addMovie(Movie.RRR, City.BANGALORE);
        movieController.addMovie(Movie.AVENGERS, City.MUMBAI);
        movieController.addMovie(Movie.PUSHPA, City.BANGALORE);
    }
}