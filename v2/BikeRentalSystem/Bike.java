
import java.math.BigDecimal;
import java.util.TreeSet;

enum BikeStatus {
	AVAILABLE,
	RESERVED,
	CHECKED_OUT,
	ON_DELIVERY;
}

public class Bike extends BikeType implements Deliverable {
	/* fields */
    public TreeSet<DateRange> bookings;
    public BikeStatus status;  // there are 4 statuses for a bike

    /* constructor */
    public Bike(BikeType bikeType) {
        super(bikeType.getBikeProvider(), bikeType.getBikeType(), 
        		bikeType.getBikeCategory(), bikeType.getReplacementValue(), 
        		bikeType.getDailyRentalPrice());
        // TODO work out how to sort by start-date
        this.bookings = new TreeSet<>();
        this.status = BikeStatus.AVAILABLE;
    }

    /* accessors */
    public BikeProvider getBikeProvider() {return super.getBikeProvider();}
    
    // TODO test functionality (do we even need this)
    public BigDecimal getDepositValue(BigDecimal depositRate) {
        return depositRate.multiply(getReplacementValue());
    }

    public TreeSet<DateRange> getBookings() {
        return bookings;
    }

    /* methods */
    
    public Boolean isAvailable() {return status == BikeStatus.AVAILABLE;}
    
    public void checkOut() {status = BikeStatus.CHECKED_OUT;}

    public void checkIn() {status = BikeStatus.AVAILABLE;}

    public boolean checkDateRange(DateRange dates) {
    	// TODO check if bike is avaliable to book over a specified date range
    	return false;
    }

    public void book(DateRange dates) {
        // TODO add dateRange to treemap
        status = BikeStatus.RESERVED;
    }
    
    public void onPickup() {
    	status = BikeStatus.ON_DELIVERY;
    }
    
    public void onDropoff() {
    	status = BikeStatus.CHECKED_OUT;
    }
    
}