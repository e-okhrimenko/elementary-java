/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];

    void clear() {
        for (int i = 0; i < size(); i++) storage[i] = null;
    }

    void save(Employee employee) {
        if (storage.length == size()) {
            System.out.println("The array is full. Employee: " + employee + ", not added.");
            return;
        }
        storage[size()] = employee;
    }

    Employee get(String uuid) {
        for (int i = 0; i < size(); i++)
            if (storage[i].uuid.equals(uuid)) return storage[i];
        System.out.println("Employee " + uuid + " - not found!");
        return null;
    }

    void delete(String uuid) {
        //Варивнт с переносом крайнего, на место удаленного.
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
            }
        }

        //Варивнт со смещением всех последующих сотрудников методом arraycopy.
        /*for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size() - 1);
                storage[size() - 1] = null;
                return;
            }
        }*/

        //Варивнт со смещением всех последующих сотрудников.
        /*for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                while (i < (size() - 1)) {
                    storage[i] = storage[i + 1];
                    i++;
                }
                storage[size() - 1] = null;
                return;
            }
        }*/
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        Employee[] getAll = new Employee[size()];
        if (size() != 0) for (int i = 0; i < size(); i++) getAll[i] = storage[i];
        else System.out.println("Employees are missing!");
        return getAll;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++)
            if (storage[i] != null) {
                size++;
            } else break;
        return size;
    }
}