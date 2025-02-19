
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class DateRange implements Comparable {
    private LocalDate start, end;
    
    public DateRange(LocalDate start, LocalDate end) {
    	assert start.isBefore(end);
        this.start = start;
        this.end = end;
    }
    
    public LocalDate getStart() {
        return this.start;
    }
    
    public LocalDate getEnd() {
        return this.end;
    }

    public long toYears() {
        return ChronoUnit.YEARS.between(this.getStart(), this.getEnd());
    }

    public long toDays() {
        return ChronoUnit.DAYS.between(this.getStart(), this.getEnd());
    }

    public Boolean overlaps(DateRange other) {
    	if ((this.start.isBefore(other.end)) && (this.end.isAfter(other.start))) {
            return true;
        }
        else {return false;}
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
    @Override
    public int compareTo(Object anotherDateRange) {
        if (this.start.isBefore(((DateRange)anotherDateRange).start)) {
            return 1;
        }
        else if (this.equals((DateRange)anotherDateRange)) {
            return 0;
        }
        else {
        	return -1;
        }
    }
    
}
