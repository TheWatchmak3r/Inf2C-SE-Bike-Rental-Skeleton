
import java.util.ArrayList;
import java.util.HashMap;

// Bike Rental System Database

public class SystemDatabase {
    /* fields */
    public static ArrayList<BikeProvider> bikeProviders = new ArrayList<BikeProvider>();
    public static HashMap<String,Order> orders = new HashMap<String, Order>();

    /*accessors */
    public ArrayList<BikeProvider> getBikeProviders() {
        return bikeProviders;
    }

    public static HashMap<String,Order> getOrders() {
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