package uk.ac.ed.bikerental;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

enum OrderStatus {
	QUOTED,
	BOOKED,
	PAID,
	STARTED, // when bikes are taken out
	COMPLETE; // when bike returned by customer & deposit returned by provider
}

public class Order {

    /* fields */
    private static final String id = UUID.randomUUID().toString();
    private DateRange date;
    private ArrayList<Bike> bikes;
    private Boolean delivery;
    // public Boolean booked;
    // public Boolean bikesTaken;
    public OrderStatus status;

    /* constructor */
    Order(DateRange date, ArrayList<Bike> bikes, Boolean delivery) {
        this.bikes = bikes;
        this.delivery = delivery;
        // this.booked = false;
        // this.bikesTaken = false;
        this.status = OrderStatus.QUOTED;
    }

    /* accessors */
    public String getId() {return id;}

    public DateRange getDate() {return date;}

    public ArrayList<Bike> getBikes() {return bikes;}

    public Boolean isDelivery() {return delivery;}

    public Boolean isBooked() {return this.status == OrderStatus.BOOKED;}

    public Boolean isTaken() {return this.status == OrderStatus.STARTED;}

    /* methods */
    public void book() {
        for (Bike bike : bikes) {
            bike.book(this.date);
        }
        this.status = OrderStatus.BOOKED;
    }
    
    public void pay() {
    	this.status = OrderStatus.PAID;
    }

    public void takeBikes() {this.status = OrderStatus.STARTED;}

    public void returnBikes() {this.status = OrderStatus.COMPLETE;}

}
