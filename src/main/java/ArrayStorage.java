import java.util.Arrays;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        System.out.println("The store is cleared and empty.");
        size = 0;
    }

    void save(Employee employee) {
        if (storage.length == size) {
            System.out.println("The array is full. Employee: " + employee + ", not added.");
            return;
        }
        if (employee.getUuid() == null) {
            System.out.println("Not added. Employee parameter is null.");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(employee.getUuid())) {
                System.out.println("Employee with UUID: " + employee.getUuid() + ", not added. Employee has already been entered earlier.");
                return;
            }
        }
        storage[size] = employee;
        System.out.println("Employee " + employee + " - added!");
        size++;
    }

    Employee get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int temp = size;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size() - 1] = null;
                size--;
            }
        }
        if (temp > size) {
            System.out.println("Employee " + uuid + " DELETED!");
        } else {
            System.out.println("Employee NOT deleted. Employee: " + uuid + " - not found!");
        }
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}