import java.util.*;

// Reservation class
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}


// RoomInventory class
class RoomInventory {

    private Map<String, Integer> rooms = new HashMap<>();

    public RoomInventory() {
        rooms.put("Single", 2);
        rooms.put("Double", 2);
        rooms.put("Suite", 1);
    }

    public boolean isAvailable(String roomType) {
        return rooms.getOrDefault(roomType, 0) > 0;
    }

    public void bookRoom(String roomType) {
        rooms.put(roomType, rooms.get(roomType) - 1);
    }
}


// RoomAllocationService
class RoomAllocationService {

    private Set<String> allocatedRoomIds = new HashSet<>();
    private Map<String, Set<String>> assignedRoomsByType = new HashMap<>();

    public RoomAllocationService() {
        assignedRoomsByType.put("Single", new HashSet<>());
        assignedRoomsByType.put("Double", new HashSet<>());
        assignedRoomsByType.put("Suite", new HashSet<>());
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        if (inventory.isAvailable(roomType)) {

            String roomId = generateRoomId(roomType);

            allocatedRoomIds.add(roomId);
            assignedRoomsByType.get(roomType).add(roomId);

            inventory.bookRoom(roomType);

            System.out.println(
                    "Booking confirmed for Guest: "
                            + reservation.getGuestName()
                            + ", Room ID: "
                            + roomId
            );

        } else {
            System.out.println("No rooms available for " + roomType);
        }
    }

    private String generateRoomId(String roomType) {

        int number = assignedRoomsByType.get(roomType).size() + 1;

        return roomType + "-" + number;
    }
}


// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        Reservation r1 = new Reservation("Amit", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Varmesh", "Suite");

        service.allocateRoom(r1, inventory);
        service.allocateRoom(r2, inventory);
        service.allocateRoom(r3, inventory);
    }
}