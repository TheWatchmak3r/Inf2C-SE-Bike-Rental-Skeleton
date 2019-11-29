package uk.ac.ed.bikerental;

import java.util.ArrayList;

public class QuoteRequest {
    /* fields */
    private DateRange dateRange;
    private Location location;
    private ArrayList<BikeCategory> bikes;
    public ArrayList<Order> quotes;

    /* constructor */
    QuoteRequest(DateRange dateRange, Location location, ArrayList<BikeCategory> bikes) {
        this.dateRange = dateRange;
        this.location = location;
        this.bikes = bikes;
        this.quotes = new ArrayList<Order>();
    }

    /* accessors */
    public DateRange getDateRange() {
        return dateRange;
    }

    public Location getLocation() {
        return location;
    }

    public ArrayList<BikeType> getBikes() {
        return bikes;
    }

    public ArrayList<Order> getQuotes() {
        return quotes;
    }

    /* methods */
    public void addQuote(Order order) {
        quotes.add(order);
    }

    public void makeOrder(Customer customer, Order order) {
        order.customer = customer;
        order.book();
        customer.makeOrder;
    }

}
