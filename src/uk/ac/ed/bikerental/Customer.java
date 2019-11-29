package uk.ac.ed.bikerental;

import java.util.UUID;
import java.util.ArrayList;

public class Customer {

    /* fields */
    private final String firstName;
    private final String surname;
    private final String id;
    private Location location;
    private QuoteRequest quoteRequest;
    private Order order;

    /* constructor */
    Customer(String firstName, String surname, Location location, QuoteRequest quoteRequest) {
        this.firstName = firstName;
        this.surname = surname;
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.quoteRequest = quoteRequest;
        this.order = null;
    }

    /* accessors */
    public String getName() {
        return (firstName + " " + surname);
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public Order getOrder() {
        return order;
    }

    /* methods */
    private void makeOrder(Order acceptedOrder) {
        order = acceptedOrder;
        acceptedOrder.book();
    };






}