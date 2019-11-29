package uk.ac.ed.bikerental;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class EntryPoint {
    /* fields */
    private final String id = UUID.randomUUID().toString();
    private QuoteRequest quoteRequest;

    /* constructor */
    ArrayList<Order> EntryPoint(DateRange dateRange, Location location, ArrayList<BikeCategory> bikes) {
        this.quoteRequest = new QuoteRequest(dateRange, location, bikes);
    }

    /* accessors */

    /* methods */
    ArrayList<Order> requestQuote(QuoteRequest quoteRequest) {
        QuoteRequest quoteRequest = QuoteRequest(dateRange, location, bikes);
        ArrayList<Order> quotes = new ArrayList<Order>();
        for (BikeProvider bikeProvider : BikeProviders) {
            Order quote = bikeProvider.requestQuote(quoteRequest);
            if (quote != null) {
                quotes.add(quote);
            }
        }
        return quotes;
    }

}
