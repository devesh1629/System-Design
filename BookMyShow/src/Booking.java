import java.util.HashSet;
import java.util.Set;

public class Booking {
    int bookingId;
    Show show;
    Set<Seat> bookedSeats = new HashSet<>();
    Payment payment;
    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    public Show getShow() {
        return show;
    }
    public void setShow(Show show) {
        this.show = show;
    }
    public Set<Seat> getBookedSeats() {
        return bookedSeats;
    }
    public boolean setBookedSeats(Set<Seat> bookedSeats) {
        if(!show.setBookedSeatIds(bookedSeats))
            return false;
        this.bookedSeats = bookedSeats;
        return true;
    }
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
