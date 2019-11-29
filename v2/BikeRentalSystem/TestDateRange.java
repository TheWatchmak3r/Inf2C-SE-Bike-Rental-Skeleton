
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDateRange {
    private DateRange dateRange1, dateRange2, dateRange3;

    @BeforeEach
    void setUp() throws Exception {
        // Setup resources before each test
        this.dateRange1 = new DateRange(LocalDate.of(2019, 1, 7),
                LocalDate.of(2019, 1, 10));
        this.dateRange2 = new DateRange(LocalDate.of(2019, 1, 5),
                LocalDate.of(2019, 1, 23));
        this.dateRange3 = new DateRange(LocalDate.of(2015, 1, 7),
                LocalDate.of(2018, 1, 10));
    }

    // Sample JUnit tests checking toYears works
    @Test
    void testToYears1() {
        assertEquals(0, this.dateRange1.toYears());
    }

    @Test
    void testToYears3() {
        assertEquals(3, this.dateRange3.toYears());
    }

    @Test
    void testOverlapsTrue() {
    	assertTrue(this.dateRange1.overlaps(this.dateRange2));
    	assertTrue(this.dateRange2.overlaps(this.dateRange1));
    }

    @Test
    void testOverlapsFalse() {
    	assertFalse(this.dateRange1.overlaps(this.dateRange3));
    	assertFalse(this.dateRange3.overlaps(this.dateRange2));
    	assertFalse(this.dateRange3.overlaps(this.dateRange1));
    	assertFalse(this.dateRange2.overlaps(this.dateRange3));
    }

    @Test
    void testToDays() {
    	assertEquals(3, this.dateRange1.toDays());
    	assertEquals(18, this.dateRange2.toDays());
    	assertEquals(1099, this.dateRange3.toDays());
    }
    
    @Test
    void testStartEnd() {
    	// testing if start and end are correct
    	assertEquals(this.dateRange1.getStart(), LocalDate.of(2019, 1, 7));
    	assertEquals(this.dateRange3.getEnd(), LocalDate.of(2018, 1, 10));
    	// also, in the constructor of DateRange, we asserted that start is before end
    }
    
    @Test
    void testEquals() {
    	// test if the override equals is correct
    	assertTrue(this.dateRange1.equals(new DateRange(LocalDate.of(2019, 1, 7),
                LocalDate.of(2019, 1, 10))));
    	assertFalse(this.dateRange2.equals(this.dateRange3));
    }
    
}
