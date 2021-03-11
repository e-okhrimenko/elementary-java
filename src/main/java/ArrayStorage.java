import java.util.Arrays;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Employee employee) {
        if (storage.length == size) {
            System.out.println("The array is full. Employee: " + employee + ", not added.");
            return;
        }
        if (employee == null) {
            System.out.println("Not added. Employee parameter is null.");
            return;
        }
        storage[size] = employee;
        size++;
    }

    Employee get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Employee " + uuid + " - not found!");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size() - 1] = null;
                size--;
            }
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