import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom Exception 1: Duplicate ID
class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}

// Custom Exception 2: ID not found
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

// 1. Employee Class with fields: id, name, designation
class Employee {
    private final int id; // Use final as ID shouldn't change
    private final String name;
    private final String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation;
    }
}

public class EmployeeDirectoryOptimized {

    // Optimized storage: Use HashMap for O(1) ID lookups.
    // Key is the employee ID (Integer), Value is the Employee object.
    private final Map<Integer, Employee> employeeMap;
    private final Scanner scanner;

    public EmployeeDirectoryOptimized() {
        this.employeeMap = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    // 2. Add new employees & 3. Throw DuplicateEmployeeException
    public void addEmployee(int id, String name, String designation) throws DuplicateEmployeeException {
        // Checking for duplicate is O(1) with HashMap's containsKey()
        if (employeeMap.containsKey(id)) {
            throw new DuplicateEmployeeException("Error: Employee with ID " + id + " already exists.");
        }

        Employee newEmployee = new Employee(id, name, designation);
        employeeMap.put(id, newEmployee);
        System.out.println("✅ Successfully added: " + name);
    }

    // 4. Provide a search feature by ID & Throw EmployeeNotFoundException
    public Employee searchEmployee(int id) throws EmployeeNotFoundException {
        // Searching is O(1) with HashMap's get()
        Employee foundEmp = employeeMap.get(id);

        if (foundEmp == null) {
            throw new EmployeeNotFoundException("Error: Employee with ID " + id + " not found.");
        }
        return foundEmp;
    }

    // 5. Print all employees at the end
    public void printAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("\n--- Employee List is Empty ---");
            return;
        }
        System.out.println("\n--- Current Employee Directory (Total: " + employeeMap.size() + ") ---");
        // Iterate over the values (Employee objects) in the Map
        for (Employee emp : employeeMap.values()) {
            System.out.println(emp);
        }
        System.out.println("------------------------------------");
    }

    // Main interaction loop
    public void run() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=== Employee Directory Menu ===");
            System.out.println("1. Add New Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Print All Employees");
            System.out.println("0. Exit and Print Final List");
            System.out.print("Enter your choice: ");

            try {
                // Safely read user input as a full line first
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        handleEmployeeAddition();
                        break;
                    case 2:
                        handleEmployeeSearch();
                        break;
                    case 3:
                        printAllEmployees();
                        break;
                    case 0:
                        System.out.println("\nExiting system...");
                        break;
                    default:
                        System.out.println("❌ Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number for the menu choice.");
            }
        }
        // Final requirement: Print all employees at the end
        printAllEmployees();
    }

    private void handleEmployeeAddition() {
        try {
            System.out.print("Enter Employee ID (integer): ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();

            addEmployee(id, name, designation);
        } catch (DuplicateEmployeeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid ID format. ID must be an integer.");
        }
    }

    private void handleEmployeeSearch() {
        try {
            System.out.print("Enter Employee ID to search (integer): ");
            int id = Integer.parseInt(scanner.nextLine());

            Employee foundEmp = searchEmployee(id);
            System.out.println("\n🎉 Employee Found:");
            System.out.println(foundEmp);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid ID format. ID must be an integer.");
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        EmployeeDirectoryOptimized directory = new EmployeeDirectoryOptimized();
        directory.run();
    }
}
