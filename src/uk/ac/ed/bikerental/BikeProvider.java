package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Map;

public class BikeProvider {
    /* fields */
    private String name;
    private Location location;
    private BigDecimal depositRate;
    private Boolean partnershipAgreement;
    private ArrayList<BikeType> bikeTypes;
    private ArrayList<Bike> bikeStock;

    /* constructor */
    public BikeProvider(String name, Location location, BigDecimal depositRate, Boolean partnershipAgreement) {
        this.name = name;
        this.location = location;
        this.depositRate = depositRate;
        this.partnershipAgreement = partnershipAgreement;
        this.bikeTypes = new ArrayList<BikeType>();
        this.bikeStock = new ArrayList<Bike>();
        // TODO initialise bike provder in list of bike providers
    }

    /* accessors */
    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public BigDecimal getDepositRate() {
        return depositRate;
    }

    public Boolean partnershipExists() {
        return partnershipAgreement;
    }

    public ArrayList<BikeType> getBikeTypes() {
        return bikeTypes;
    }

    public ArrayList<Bike> getBikeStock() {
        return bikeStock;
    }

    /* methods */
    private void addBikeType(BikeProvider this, String typeName, BikeCategory bikeCategory,
                             BigDecimal replacementValue, String dailyRentalPrice) {
        bikeTypes.add(new BikeType(this, typeName, bikeCategory, replacementValue, dailyRentalPrice));
    }

    private void addBike(BikeType bikeType) {
        // TODO (last) change to map implementation so can be called with name string
    	bikeStock.add(new Bike(bikeType));

    }

    public Order requestQuote(QuoteRequest quoteRequest) {
        //TODO write method checking if provider can fufill quote and adding quote to quote request if so
    }

    public void bookOrder(Order order) {
        order.book();
    }

    public void checkoutBikes(Order order) {
        order.ckeckoutBikes();
    }

    public void returnBikes(Order order) {
        order.returnBikes();
    }
}
