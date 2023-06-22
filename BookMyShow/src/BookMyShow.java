import enums.City;
import enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;
    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        bookMyShow.createBooking(City.DELHI, "AVENGERS");
        bookMyShow.createBooking(City.BANGALORE, "RRR");

    }

    private void createBooking(City city, String movieName) {
        List<Movie> movies = movieController.getMoviesByCity(city);

        Movie interestedMovie = null;
        for(Movie movie : movies) {
            if((movie.getMovieName()).equals(movieName))
                interestedMovie  = movie;
        }
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShows(interestedMovie, city);
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
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setMovieDuration(180);

        Movie rrr = new Movie();
        rrr.setMovieId(2);
        rrr.setMovieName("RRR");
        rrr.setMovieDuration(150);

        movieController.addMovie(avengers, City.DELHI);
        movieController.addMovie(avengers, City.BANGALORE);
        movieController.addMovie(rrr, City.DELHI);
        movieController.addMovie(rrr, City.BANGALORE);
    }
}