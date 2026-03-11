import java.util.*;

// Room class
class Room {
    String type;
    int beds;
    int size;
    double price;

    Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    void displayRoom() {
        System.out.println(type + " Room:");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}

// RoomInventory class
class RoomInventory {

    Map<String, Integer> availability = new HashMap<>();

    RoomInventory() {
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    Map<String, Integer> getRoomAvailability() {
        return availability;
    }
}

// RoomSearchService class
class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory,
                                     Room singleRoom,
                                     Room doubleRoom,
                                     Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.get("Single") > 0) {
            singleRoom.displayRoom();
            System.out.println("Available: " + availability.get("Single"));
            System.out.println();
        }

        if (availability.get("Double") > 0) {
            doubleRoom.displayRoom();
            System.out.println("Available: " + availability.get("Double"));
            System.out.println();
        }

        if (availability.get("Suite") > 0) {
            suiteRoom.displayRoom();
            System.out.println("Available: " + availability.get("Suite"));
        }
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room singleRoom = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suiteRoom = new Room("Suite", 3, 750, 5000.0);

        RoomSearchService service = new RoomSearchService();

        System.out.println("Room Search\n");

        service.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}