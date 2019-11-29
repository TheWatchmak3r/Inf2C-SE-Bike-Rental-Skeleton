package uk.ac.ed.bikerental;

import java.math.BigDecimal;
<<<<<<< HEAD

import java.util.TreeSet;
=======
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
>>>>>>> 37c057210c65243aa7b5aed3d24d76ae1ee48783

public class Bike extends BikeType {
    private Boolean checkedIn = true;
    private TreeSet<DateRange> bookings;

    /* constructor */
<<<<<<< HEAD
    Bike(BikeType bikeType) {
        super(bikeType.bikeProvider, bikeType.typeName, bikeType.bikeCategory, bikeType.replacementValue, bikeType.dailyRentalPrice);
        /* fields */
        this.bookings = new TreeSet<>(); // TODO work out how to sort by start-date
    }

    /* accessors */
    public Boolean isCheckedIn() {
        return checkedIn;
=======
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
>>>>>>> 37c057210c65243aa7b5aed3d24d76ae1ee48783
    }

    public TreeSet<DateRange> getBookings() {
        return this.bookings;
    }

    /* methods */
<<<<<<< HEAD
    public void checkOut() {
        this.checkedIn = false;
    }

    public void checkIn() {
        this.checkedIn = true;
    }

    public Boolean checkDateRange(DateRange) {
        // TODO check if bike is avaliable to book over a specified date range
    }
    public void makeBooking(DateRange) {
        // TODO add dateRange to treemap
    }
}
=======
    public void checkOut() {this.status = BikeStatus.CHECKED_OUT;}

    public void checkIn() {this.status = BikeStatus.AVAILABLE;}

    public Boolean checkDateRange(DateRange dates) {}
        // TODO check if bike is avaliable to book over a specified date range

    public void book(DateRange dates) {
        // TODO add dateRange to treemap
        this.status = BikeStatus.RESERVED;
    }
    
}
>>>>>>> 37c057210c65243aa7b5aed3d24d76ae1ee48783
