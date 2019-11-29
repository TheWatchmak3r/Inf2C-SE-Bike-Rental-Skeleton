
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class EntryPoint {
    /* fields */

    /* constructor */
    public EntryPoint() {
    }

    /* accessors */

    /* methods */
    public ArrayList<Order> requestQuote(DateRange dateRange, Location location,
                                         ArrayList<BikeCategory> requestedBikeCategories, Boolean delivery) {
        ArrayList<Order> quotes =  new ArrayList<Order>();
        for (BikeProvider bikeProvider : SystemDatabase.bikeProviders) {
            if (bikeProvider.getLocation().isNearTo(location)) {
                Order quote = bikeProvider.searchForQuote(dateRange, location, requestedBikeCategories, delivery);
                if (quote != null) {
                    quotes.add(quote);
                }
            }
        }
        return quotes;
    }

    // TODO accept quote by becoming a customer

}