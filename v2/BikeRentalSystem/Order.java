
import java.util.ArrayList;
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
    private Customer customer;
    private DateRange date;
    private ArrayList<Bike> bikes;
    private boolean delivery;
    public OrderStatus status;

    /* constructor */
    Order(Customer customer, DateRange date, ArrayList<Bike> bikes, Boolean delivery) {
        this.customer = customer;
        this.date = date;
        this.bikes = bikes;
        this.delivery = delivery;
        this.status = OrderStatus.QUOTED;
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

    /* methods */
    public boolean isDelivery() {return delivery;}
    
    public boolean isBooked() {return this.status == OrderStatus.BOOKED;}

    public boolean isStarted() {return this.status == OrderStatus.STARTED;}

    public void book() {
        for (Bike bike : bikes) {
            bike.book(this.date);
        }
        this.status = OrderStatus.BOOKED;
        // TODO (last) add error message if bikes are no longer bookable
    }
    
    public void pay() {
    	this.status = OrderStatus.PAID;
    }

    public void takeBikes() {
    	status = OrderStatus.STARTED;
    	if (this.isDelivery()) {
    		MockDeliveryService mockdelivery = new MockDeliveryService();
    		mockdelivery.carryOutPickups(date.getStart());
    		mockdelivery.carryOutDropoffs();
    	}
    	else {
    		for (Bike b : bikes) {b.checkOut();}
    	}
    }

    public void returnBikes() {
    	this.status = OrderStatus.COMPLETE;
    	for (Bike b : bikes) {b.checkIn();}
    }

}