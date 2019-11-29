
import java.util.ArrayList;

// Bike Rental System Database

public class SystemDatabase {
    /* fields */
    public static ArrayList<BikeProvider> bikeProviders = new ArrayList<BikeProvider>();

    /*accessors */
    public static ArrayList<BikeProvider> getBikeProviders() {
        return bikeProviders;
    }

    /* methods */
    public static void addBikeProvider(BikeProvider bikeProvider) {
        bikeProviders.add(bikeProvider);
    }
}