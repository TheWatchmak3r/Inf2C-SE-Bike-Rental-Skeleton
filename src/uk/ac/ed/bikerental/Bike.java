package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.TreeSet;

enum BikeStatus {
	AVAILABLE,
	RESERVED,
	CHECKED_OUT,
	ON_DELICERY;
}

public class Bike {
    /* fields */
    private BikeProvider bikeProvider;
    private BikeType bikeType;
    // private BigDecimal replacementValue; moved to BikeType class
    // public Boolean checkedIn; combined into BikeStatus
    public TreeSet<DateRange> bookings;
    public BikeStatus status;  // there are 4 statuses for a bike


    /* constructor */
    Bike(BikeType bikeType,  BikeProvider bikeProvider, BigDecimal replacementValue) {
        this.bikeProvider = bikeProvider;
        this.bikeType = bikeType;
        // this.replacementValue = replacementValue;
        // this.checkedIn = true;
        this.status = BikeStatus.AVAILABLE;
        this.bookings = new TreeSet<DateRange>();
    }

    /* accessors */
    public BikeProvider getBikeProvider() {return this.bikeProvider;}

    public BikeType getBikeType() {return this.bikeType;}

    // public BigDecimal getReplacementValue() {return this.replacementValue;}

    // public Boolean isCheckedIn() {return this.checkedIn;}
    public Boolean isAvailable() {return this.status == BikeStatus.AVAILABLE;}
    
    // TODO test functionality (do we even need this)
    public BigDecimal getDepositValue(BigDecimal depositRate) {
        return depositRate.multiply(this.getType().getReplacementValue());
    }

    public TreeSet<DateRange> getBookings() {return this.bookings;}

    /* methods */
    public void checkOut() {this.status = BikeStatus.CHECKED_OUT;}

    public void checkIn() {this.status = BikeStatus.AVAILABLE;}

    public Boolean checkDateRange(DateRange dates) {}
        // TODO check if bike is avaliable to book over a specified date range

    public void book(DateRange dates) {
        // TODO add dateRange to treemap
        this.status = BikeStatus.RESERVED;
    }
    
}
