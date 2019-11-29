
import sun.reflect.generics.tree.Tree;

import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;

enum BikeStatus {
	AVAILABLE,
	CHECKED_OUT,
	ON_DELIVERY
}

public class Bike extends BikeType {
	/* fields */
    public TreeSet<DateRange> bookings;
    public BikeStatus bikeStatus;

    /* constructor */
    public Bike(BikeType bikeType) {
        super(bikeType.getBikeProvider(), bikeType.getBikeType(), bikeType.getBikeCategory(),
                bikeType.getReplacementValue(), bikeType.getDailyRentalPrice());
        this.bookings = new TreeSet<>();
        this.bikeStatus = BikeStatus.AVAILABLE;
    }

    /* accessors */
    public BikeStatus getBikeStatus() {
        return bikeStatus;
    }

    public TreeSet<DateRange> getBookings() {
        return bookings;
    }

    /* methods */
    public void checkOut() {
        bikeStatus = BikeStatus.CHECKED_OUT;
    }

    public void checkIn() {
        bikeStatus = BikeStatus.AVAILABLE;
    }

    // checks if a bike is available to be booked over a certain date range
    public boolean checkDateRange(DateRange dates) {
        DateRange ceiling = bookings.ceiling(dates);
        DateRange floor = bookings.floor(dates);
        if ((ceiling != null) && (dates.overlaps(ceiling))) {
            return false;
        }
        if ((floor != null) && (dates.overlaps(floor))) {
            return false;
        }
        return true;
    }

    public void book(DateRange dates) {
        assert checkDateRange(dates);
        bookings.add(dates);
    }

}