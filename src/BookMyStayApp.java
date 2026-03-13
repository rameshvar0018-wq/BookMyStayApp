// Main.java

// Service Interface
interface Service {
    int perform(int num1, int num2);
}

// Service Implementation
class ServiceImpl implements Service {

    public ServiceImpl() {
        System.out.println("Service object created");
    }

    @Override
    public int perform(int num1, int num2) {
        return num1 + num2;
    }
}

// Service Configurer
class ServiceConfigurer {

    public ServiceConfigurer() {
        System.out.println("Configurer created");
    }

    public Service getService() {
        return new ServiceImpl();
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // create configurer object
        ServiceConfigurer config = new ServiceConfigurer();

        // get service object
        Service service = config.getService();

        // perform addition
        int result = service.perform(10, 20);

        // print result
        System.out.println("Result is: " + result);
    }
}