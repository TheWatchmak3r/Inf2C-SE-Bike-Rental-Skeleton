
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class EntryPoint {
    /* fields */
    ArrayList<Order> quoteList = null;

    /* constructor */
    public EntryPoint() {
    }

    /* accessors */
    ArrayList<Order> getQuoteList() {
        return quoteList;
    }

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
        quoteList = quotes;
        return quotes;
    }

    // books a quote by becoming a customer
    public Order bookQuote(String firstName, String surname, Order chosenQuote) {
        assert quoteList.contains(chosenQuote);
        Customer customer =  new Customer(firstName, surname, chosenQuote.getLocation(), chosenQuote);
        chosenQuote.addCustomer(customer);
        chosenQuote.book();
        SystemDatabase.addOrder(chosenQuote);
        chosenQuote.getBikeProvider().addOrder(chosenQuote);
        if (chosenQuote.isDelivery()) {
            DeliveryServiceFactory.getDeliveryService().scheduleDelivery(chosenQuote, chosenQuote.getBikeProvider()
                    .getLocation(), chosenQuote.getLocation(), chosenQuote.getDateRange().getStart());
        }
        return chosenQuote;
    }
}