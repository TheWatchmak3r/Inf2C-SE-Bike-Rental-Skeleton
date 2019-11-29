
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

enum OrderStatus {
	QUOTED,
	BOOKED,
	STARTED, // when bikes are taken out
	COMPLETE; // when bike returned by customer & deposit returned by provider
}

public class Order { // TODO extends deliverable?

    /* fields */
    private static final String id = UUID.randomUUID().toString();
    private BikeProvider bikeProvider;
    private Customer customer = null;
    private DateRange dateRange;
    private Location location;
    private HashSet<Bike> bikes;
    private BigDecimal price;
    private BigDecimal deposit;
    private Boolean delivery;
    public OrderStatus status;


    /* constructor */
    Order(BikeProvider bikeProvider, DateRange dateRange,  Location location, HashSet<Bike> bikes, Boolean delivery) {
        this.bikeProvider = bikeProvider;
        this.dateRange = dateRange;
        this.location = location;
        this.bikes = bikes;
        this.price = calculatePrice();
        this.deposit = calculateDeposit();
        this.delivery = delivery;
        this.status = OrderStatus.QUOTED;
    }

    /* accessors */
    public String getId() {
        return id;
    }

    public BikeProvider getBikeProvider() { return bikeProvider; }

    public Customer getCustomer() { return customer; }

    public DateRange getDateRange() {
        return dateRange;
    }

    public Location getLocation() { return location;}

    public HashSet<Bike> getBikes() {
        return bikes;
    }

    public BigDecimal getPrice() { return price; }

    public BigDecimal getDeposit() { return deposit; }

    public boolean isDelivery() {return delivery;}

    public OrderStatus getStatus() {
        return status;
    }

    /* methods */
    public BigDecimal calculatePrice() {
        BigDecimal sumPrice = new BigDecimal(0);
        BigDecimal days = new BigDecimal(dateRange.toDays());
        for (Bike bike : bikes) {
            sumPrice = sumPrice.add(bike.getDailyRentalPrice().multiply(days));
        }
        return sumPrice;
    }

    public BigDecimal calculateDeposit() {
        BigDecimal sumDeposit = new BigDecimal(0);
        for (Bike bike : bikes) {
            sumDeposit = sumDeposit.add(bike.getDepositValue().multiply(bike.getReplacementValue()));
        }
        return sumDeposit;
    }

    public void book() {
        for (Bike bike : bikes) {
            bike.book(dateRange);
        }
        this.status = OrderStatus.BOOKED;
    }

    public void takeBikes() {
    	status = OrderStatus.STARTED;
    	if (this.isDelivery()) {
    		MockDeliveryService mockdelivery = new MockDeliveryService();
    		mockdelivery.carryOutPickups(dateRange.getStart());
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