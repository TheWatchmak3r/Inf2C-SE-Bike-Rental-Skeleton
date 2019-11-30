
import java.util.UUID;

public class Customer {

    /* fields */
    private final String firstName;
    private final String surname;
    private final String id;
    private Location location;
    private Order order;

    /* constructor */
    Customer(String firstName, String surname, Location location) {
        this.firstName = firstName;
        this.surname = surname;
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.order = null;
    }

    /* accessors */
    public String getName() {
        return (firstName + " " + surname);
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public Order getOrder() {
        return order;
    }

    /* methods */
    public void makeOrder(Order acceptedOrder) {
        this.order = acceptedOrder;
        acceptedOrder.book(this);
    }
}