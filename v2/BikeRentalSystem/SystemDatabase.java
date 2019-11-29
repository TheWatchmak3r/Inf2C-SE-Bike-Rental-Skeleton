import java.util.*;

// Bike Rental System Database

public class SystemDatabase {
    /* fields */
    public static ArrayList<BikeProvider> bikeProviders;
    public static Map<String,Order> orders;

    /* constructor */
    SystemDatabase() {
        bikeProviders = new ArrayList<BikeProvider>();
        orders = new HashMap<String, Order>();
    }

    /*accessors */
    public ArrayList<BikeProvider> getBikeProviders() {
        return bikeProviders;
    }

    public Map<String,Order> getOrders() {
        return orders;
    }

    /* methods */
    public static void addBikeProvider(BikeProvider bikeProvider) {
        bikeProviders.add(bikeProvider);
    }

    public static void addOrder(Order order) {
        orders.put(order.getId(), order);
    }
}
