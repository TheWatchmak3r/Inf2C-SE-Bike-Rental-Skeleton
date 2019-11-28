package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.TreeSet;

public class Bike {
    /* fields */
    private BikeProvider bikeProvider;
    private BikeType bikeType;
    private BigDecimal replacementValue;
    public Boolean checkedIn;
    public TreeSet<DateRange> bookings;



    /* constructor */
    Bike(BikeType bikeType,  BikeProvider bikeProvider, BigDecimal replacementValue) {
        this.bikeProvider = bikeProvider;
        this.bikeType = bikeType;
        this.replacementValue = replacementValue;
        this.checkedIn = true;
        this.bookings = new TreeSet<DateRange>();
    }

    /* accessors */
    public BikeProvider getBikeProvider() {return this.bikeProvider;}

    public BikeType getBikeType() {return this.bikeType;}

    public BigDecimal getReplacementValue() {return this.replacementValue;}

    public Boolean isCheckedIn() {return this.checkedIn;}

    // TODO test functionality (do we even need this)
    public BigDecimal getDepositValue(BigDecimal depositRate) {
        return depositRate.multiply(this.getType().getReplacementValue());
    }

    public TreeSet<DateRange> getBookings() {return this.bookings;}

    /* methods */
    public void checkOut() {this.checkedIn = false;}

    public void checkIn() {this.checkedIn = true;}

    public Boolean checkDateRange(DateRange) {}
        // TODO check if bike is avaliable to book over a specified date range

    public void book(DateRange) {}
        // TODO add dateRange to treemap



}