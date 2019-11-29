
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TestLocation {
	private Location location1, location2, location3, location4;
	
    @BeforeEach
    void setUp() throws Exception {
        // TODO: setup some resources before each test
    	this.location1 = new Location("EH16 5AY", "Pollock Halls address");
    	this.location2 = new Location("AB10 1DB", "some street in Aberdeen");
    	this.location3 = new Location("IV2 3EG", "address of Inverness castle");
    	this.location4 = new Location("EH8 9LJ", "30 George Square");
    }
    
    @Test
    void testIsNearTo() {
    	assertTrue(this.location1.isNearTo(this.location4) && this.location4.isNearTo(this.location1));
    	assertFalse(this.location2.isNearTo(this.location3));
    	assertFalse(this.location4.isNearTo(this.location2));
    }
    
    @Test
    void testGetPostcode() {
    	assertEquals("EH16 5AY", this.location1.getPostcode());
    	assertEquals("IV2 3EG", this.location3.getPostcode());
    }
    
    @Test
    void testGetAddress() {
    	assertEquals("some street in Aberdeen", this.location2.getAddress());
    	assertEquals("30 George Square", this.location4.getAddress());
    }
    
}
