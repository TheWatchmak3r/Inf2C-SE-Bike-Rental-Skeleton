package uk.ac.ed.bikerental;

public class BikeProvider {
    /* fields */
    private String name;
    private Location location;
    private ArrayList<Bike> bikeStock;
    private HashSet<BikeProvider> partners;
    private String phoneNumber;
    
    /* constructor */
    /**
     * A bike provider registers onto the system by providing the following:
     * @param name        The name of the provider
     * @param location    The address including post code
     * @param phoneNumber The phone number of the provider
     */
    public BikeProvider(String name, Location location, String phoneNumber) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        /* bikeStock is initially empty on registration */
        this.bikeStock = null;
        
    }
    
    /* getters */
    public Location getLocation() {
    	return this.location;
    }
    
    /* methods */
    /**
     * A bike provider can add new bikes into stock
     * @param newBike A new bike to add to stock
     */
    public void addBike(Bike newBike) {
    	bikeStock.add(newBike);
    }
    
    /**
     * This method is used to return available bikes for one of the BikeTypes the Customer
     * searched for using the getQuote method
     * @param type     A specified type of bike wanted
     * @param number   The number of bikes wanted for this type
     * @param dates    The dates for which availability of bikes are checked
     */
    public ArrayList<Bike> checkStock(BikeType type, int number, DateRange dates) {
    	ArrayList<Bike> availableBikes = null;
    	for (Bike bike : bikeStock) {
    		if (bike.getBikeType() == type) {
    			// add the bike to availableBikes if it is available for specified dates
    		}
    	}
    	return availableBikes;
    }
    
    // public makeBooking();

    // public rentOutBikes();

    public void returnBikes(ArrayList<Bike> bikes) {
    	
    }
    
    public void makePartnership(BikeProvider partner) {
    	this.partners.add(partner);
    }
    
}
