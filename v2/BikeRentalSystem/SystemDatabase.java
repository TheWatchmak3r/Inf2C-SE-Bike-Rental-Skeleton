import java.util.ArrayList;

// Bike Rental System Database

public class SystemDatabase {
    /* fields */
    public static ArrayList<BikeProvider> bikeProviders;

    /* constructor */
    SystemDatabase() {

    }

    /*accessors */
    public ArrayList<BikeProvider> getBikeProviders() {
        return bikeProviders;
    }

    /* methods */
    public static void addBikeProvider(BikeProvider bikeProvider) {
        bikeProviders.add(bikeProvider);
    }
}
