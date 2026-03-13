
import java.util.*;

// BookingHistory class
class BookingHistory {

    int bookingId;
    String guestName;
    String roomType;
    int nights;

    public BookingHistory(int bookingId, String guestName, String roomType, int nights) {
        this.bookingId = bookingId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public String toString() {
        return "Booking ID: " + bookingId +
                "\nGuest Name: " + guestName +
                "\nRoom Type: " + roomType +
                "\nNights: " + nights;
    }
}

// Repository Interface
interface BookingHistoryRepository {

    void addBooking(BookingHistory booking);

    List<BookingHistory> getAllBookings();
}

// Repository Implementation
class InMemoryBookingHistoryRepository implements BookingHistoryRepository {

    List<BookingHistory> bookings = new ArrayList<>();

    public void addBooking(BookingHistory booking) {
        bookings.add(booking);
    }

    public List<BookingHistory> getAllBookings() {
        return bookings;
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        BookingHistoryRepository repo = new InMemoryBookingHistoryRepository();

        repo.addBooking(new BookingHistory(101, "John", "Single", 2));
        repo.addBooking(new BookingHistory(102, "Alice", "Double", 3));

        List<BookingHistory> list = repo.getAllBookings();

        for (BookingHistory b : list) {
            System.out.println(b);
            System.out.println();
        }
    }
}