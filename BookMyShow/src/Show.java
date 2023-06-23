import enums.Movie;

import java.util.HashSet;
import java.util.Set;

public class Show {
    int showId;
    Movie movie;
    Screen screen;
    int showStartTime;
    Set<Integer> bookedSeatIds = new HashSet<>();
    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    public Screen getScreen() { return screen; }
    public void setScreen(Screen screen) { this.screen = screen; }
    public int getShowStartTime() { return showStartTime; }
    public void setShowStartTime(int showStartTime) { this.showStartTime = showStartTime; }
    public Set<Integer> getBookedSeatIds() { return bookedSeatIds; }
    public boolean setBookedSeatIds(Set<Seat> bookingSeats) {
        Set<Integer> bookingSeatIds = new HashSet<>();
        for(Seat seat : bookingSeats)
            bookingSeatIds.add(seat.getSeatId());
        boolean seatsAvailable = checkBookingAvailable(bookingSeatIds);
        if(!seatsAvailable)
            return false;
        for(Integer id : bookingSeatIds)
            bookedSeatIds.add(id);
        return true;
    }
    private boolean checkBookingAvailable(Set<Integer> bookingSeats) {
        for(Integer seatId : bookedSeatIds) {
            if(bookingSeats.contains(seatId))
                return false;
        }
        return true;
    }
}
