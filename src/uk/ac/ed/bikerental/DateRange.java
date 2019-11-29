package uk.ac.ed.bikerental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.function.BooleanSupplier;

/**
 * Class to store and query the date range of a rental agreement
 */
public class DateRange {
    private LocalDate start, end;

    /**
     * Creates an instace of the Location class
     *
     * @param start The start date of the rental (inclusive)
     * @param end The end date of the rental (exclusive)
     */
    public DateRange(LocalDate start, LocalDate end) {
        assert start.isBefore(end);
        this.start = start;
        this.end = end;
    }

    /**
     * Gets the start dat of the rental agreement
     *
     * @return start date of rental agreement
     */
    public LocalDate getStart() {
        return start;
    }

    /**
     * Gets the end date of the rental agreement
     *
     * @return end date of rental agreement
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * Converts duration to chronounit years
     *
     * @return returns duration of rental agreement in chronounit years
     */
    public long toYears() {
        return ChronoUnit.YEARS.between(start, end);
    }

    /**
     * Converts duration to chronounit days
     *
     * @return returns duration of rental agreement in chrono unit years
     */
    public long toDays() {
        return ChronoUnit.DAYS.between(start, end);
    }

    /**
     * Check if the DateRange overlaps with another DateRange booking
     *
     * @param The Other DateRange booking this DateRange is being compared to
     * @return True if overlaps with other DateRange specified
     */
    public Boolean overlaps(DateRange other) {
        if ((start.isBefore(other.end)) && (end.isAfter(other.start))) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        // hashCode method allowing use in collections
        return Objects.hash(end, start);
    }

    @Override
    public boolean equals(Object obj) {
        // equals method for testing equality in tests
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DateRange other = (DateRange) obj;
        return Objects.equals(end, other.end) && Objects.equals(start, other.start);
    }
    
    // You can add your own methods here
}
