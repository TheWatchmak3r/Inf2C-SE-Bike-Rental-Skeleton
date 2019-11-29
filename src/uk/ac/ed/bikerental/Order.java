package uk.ac.ed.bikerental;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Order {

    /* fields */
    private static final String id = UUID.randomUUID().toString();
    private Customer customer;
    private DateRange date;
    private ArrayList<Bike> bikes;
    private Boolean delivery;
    public Boolean booked;
    public Boolean bikesTaken;

    /* constructor */
    Order(Customer customer, DateRange date, ArrayList<Bike> bikes, Boolean delivery) {
        this.customer = customer;
        this.date = date;
        this.bikes = bikes;
        this.delivery = delivery;
        this.booked = false;
        this.bikesTaken = false;
    }

    /* accessors */
    public Customer getCustomer() {
        return customer;
    }

    public String getId() {
        return id;
    }

    public DateRange getDate() {
        return date;
    }

    public ArrayList<Bike> getBikes() {
        return bikes;
    }

    public Boolean isDelivery() {
        return delivery;
    }

    public Boolean isBooked() {
        return booked;
    }

    public Boolean isTaken() {
        return bikesTaken;
    }

    /* methods */
    public void book() {
        for (Bike bike : bikes) {
            bike.book(this.date);
        }
        // TODO (last) add error message if bikes are no longer bookable
    }

    public void ckeckoutBikes() {this.bikesTaken = true;}

    public void returnBikes() {this.bikesTaken = false;}

}
