// CommandBookingProcessor Interface
interface CommandBookingProcessor {
    void processBooking(String bookingId, String customerName, String seatType);
}

// CommandBookingService class
class CommandBookingService {

    public void bookSeat(String bookingId, String customerName, String seatType) {
        System.out.println("Booking confirmed: " + bookingId +
                ", Name: " + customerName +
                ", Seat: " + seatType);
    }

    public void cancelSeat(String bookingId) {
        System.out.println("Booking cancelled: " + bookingId);
    }
}

// ReservationCommandProcessor class
class ReservationCommandProcessor implements CommandBookingProcessor {

    CommandBookingService service = new CommandBookingService();

    public void processBooking(String bookingId, String customerName, String seatType) {
        service.bookSeat(bookingId, customerName, seatType);
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        CommandBookingProcessor processor = new ReservationCommandProcessor();

        processor.processBooking("101", "Alice", "Sleeper");
        processor.processBooking("102", "Bob", "AC");

        System.out.println("Processing complete...");
    }
}