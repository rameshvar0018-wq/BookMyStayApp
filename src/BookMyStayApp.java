// BookingCancellation class
class BookingCancellation {

    int bookingId;
    String passengerName;
    String seatType;

    // constructor
    public BookingCancellation(int bookingId, String passengerName, String seatType) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.seatType = seatType;
    }

    public String toString() {
        return "Booking ID: " + bookingId +
                ", Passenger: " + passengerName +
                ", Seat Type: " + seatType;
    }
}

// BookingService class
class BookingService {

    int totalSeats = 5;

    // method to cancel booking
    public void cancelBooking(BookingCancellation booking) {
        System.out.println("Booking cancelled successfully, refunded amount for seat type: "
                + booking.seatType);
    }

    // method to update seat availability
    public void updateSeatAvailability() {
        totalSeats++;
        System.out.println("Updated seats free: " + totalSeats);
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        BookingCancellation booking =
                new BookingCancellation(101, "Alice", "Sleeper");

        BookingService service = new BookingService();

        service.cancelBooking(booking);
        service.updateSeatAvailability();
    }
}