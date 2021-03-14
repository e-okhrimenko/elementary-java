/**
 * Initial employee class
 */
public class Employee {

    // Unique identifier
    private final String uuid;

    public Employee(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid(String uuid) {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
