package uk.ac.ed.bikerental;

/**
 * Class to store the postcode and adress of a location
 */
public class Location {

    /**
     * postcode of the location
     */
    private String postcode;

    /**
     * street adress of the location
     */
    private String address;

    /**
     * Creates an instace of the Location class
     *
     * @param postcode The postcode of this location
     * @param address The street address of this location
     */
    public Location(String postcode, String address) {
        assert postcode.length() >= 6;
        this.postcode = postcode;
        this.address = address;
    }

    /**
     * Checks if this location is near enough to another location to allow for collection/delivery of bikes
     *
     * @param other The Location of the place this Location is being checked against
     * @return True if first two digets of Locations postcodes are equal e.g "EH" in "EH1 6US"
     */
    public boolean isNearTo(Location other) {
        if (this.postcode.substring(0,2) == other.postcode.substring(0,2)) {
            return true;
        }
        else {return false;}
    }

    /**
     * Gets the postcode of a Location
     *
     * @return postcode string
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Get the street address of a Location
     *
     * @return address string
     */
    public String getAddress() {
        return address;
    }
    
    // You can add your own methods here
}
