class FileNotFoundException1 extends Exception {
    public FileNotFoundException1(String message) {
        super(message);
    }
}

public class BookMyStayApp {

    // Method that may throw the custom exception
    public static void inventoryProduct(int quantity, String fileName)
            throws FileNotFoundException1 {

        if (fileName == null || fileName.isEmpty()) {
            throw new FileNotFoundException1("File name is missing!");
        }

        System.out.println("Inventory updated.");
        System.out.println("Quantity: " + quantity);
        System.out.println("File: " + fileName);
    }

    public static void main(String[] args) {

        try {
            // calling the method
            inventoryProduct(50, "");
        }
        catch (FileNotFoundException1 e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}