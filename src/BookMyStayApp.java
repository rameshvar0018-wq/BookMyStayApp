abstract class Room {

    protected int numberOfBeds;
    protected int size;
    protected double pricePerNight;

    public Room(int numberOfBeds, int size, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.size = size;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomInfo(String roomType, int available) {
        System.out.println(roomType + ":");
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Available: " + available);
        System.out.println();
    }
}

class SingleRoom extends Room {

    public static int available = 5;

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {

    public static int available = 3;

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {

    public static int available = 2;

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        SingleRoom single = new SingleRoom();
        DoubleRoom dbl = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        single.displayRoomInfo("Single Room", SingleRoom.available);
        dbl.displayRoomInfo("Double Room", DoubleRoom.available);
        suite.displayRoomInfo("Suite Room", SuiteRoom.available);
    }
}