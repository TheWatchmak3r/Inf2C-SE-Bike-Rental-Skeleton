package uk.ac.ed.bikerental;

public class Customer {

    /* fields */
    private String name;
    private int id;
    private Location location;
    private ArrayList<Order> orders;

    /* constructor */
    Customer(String name, Location location) {
        this.name = name;
        this.location = location;
        this.id = 0; //TODO generate a UUID
        this.orders = new ArrayList<Order>();

    }

    /* accessors */

    /* methods */
    private ArrayList<Order> getQuotes();

    private void makeOrder();





}