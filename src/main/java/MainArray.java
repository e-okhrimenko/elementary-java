import java.util.Scanner;

public class MainArray {
    private static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        System.out.print("\nHello!");
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        while (repeat) {
            System.out.print("\n(list | save uuid | delete uuid | get uuid | size | clear | exit)" + "\n"
                    + "Enter one of the commands: ");
            String stringIn = scanner.nextLine();
            String[] result = stringIn.split("\\s", 2);
            if (result[0] != null) {
                result[0] = result[0].toLowerCase();
            }
            if (result.length == 1) {
                assert result[0] != null;
                if (result[0].equals("save") || result[0].equals("delete")
                        || result[0].equals("get")) {
                    System.out.println("The UUID not entered!");
                    continue;
                }
            }
            if (result.length == 2) {
                char[] temp = result[1].toCharArray();
                int wTemp = 0;
                for (int i = 0; i < temp.length; i++) {
                    if (!Character.isWhitespace(result[1].charAt(i))) {
                        result[1] = result[1].trim();
                        wTemp = 1;
                        break;
                    }
                }
                if (wTemp != 1) {
                    System.out.println("Entered incorrectly command or UUID!");
                    continue;
                }
            }
            if (result[0] != null) {
                switch (result[0]) {
                    case "list":
                        printAll();
                        break;
                    case "save":
                        Employee employee = new Employee(result[1]);
                        ARRAY_STORAGE.save(employee);
                        printAll();
                        break;
                    case "delete":
                        ARRAY_STORAGE.delete(result[1]);
                        printAll();
                        break;
                    case "get":
                        if (ARRAY_STORAGE.get(result[1]) == null) {
                            System.out.println("Employee " + result[1] + " - not found!");
                        } else {
                            System.out.println("Employees " + result[1] + ": " + ARRAY_STORAGE.get(result[1]));
                        }
                        break;
                    case "size":
                        if (ARRAY_STORAGE.size() > 0) {
                            System.out.println("Added and stored: " + ARRAY_STORAGE.size() + " employees.");
                        } else {
                            System.out.println("No employees added. The storage is empty.");
                        }
                        break;
                    case "clear":
                        ARRAY_STORAGE.clear();
                        printAll();
                        break;
                    case "exit":
                        repeat = false;
                        System.out.println("Exiting ... Goodbye.");
                        break;
                    default:
                        System.out.println("The command is missing or entered incorrectly!");
                }
            }
        }
    }

    private static void printAll() {
        System.out.println("List of employees (UUID): ");
        if ((ARRAY_STORAGE.size() == 0)) {
            System.out.println("No employees.");
        } else {
            for (Employee employee : ARRAY_STORAGE.getAll()) {
                System.out.println(employee);
            }
        }
    }
}