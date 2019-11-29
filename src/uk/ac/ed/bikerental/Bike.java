package uk.ac.ed.bikerental;

import java.math.BigDecimal;

import java.util.TreeSet;

public class Bike extends BikeType {
    private Boolean checkedIn = true;
    private TreeSet<DateRange> bookings;

    /* constructor */
    Bike(BikeType bikeType) {
        super(bikeType.bikeProvider, bikeType.typeName, bikeType.bikeCategory, bikeType.replacementValue, bikeType.dailyRentalPrice);
        /* fields */
        this.bookings = new TreeSet<>(); // TODO work out how to sort by start-date
    }

    /* accessors */
    public Boolean isCheckedIn() {
        return checkedIn;
    }

    public TreeSet<DateRange> getBookings() {
        return this.bookings;
    }

    /* methods */
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