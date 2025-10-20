import java.util.Scanner;

// Base class
class Employee {
    String name;
    int employeeId;

    // Constructor
    Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Common method
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

// Derived class 1: Full-time Employee
class FullTimeEmployee extends Employee {
    double salary;

    // Constructor
    FullTimeEmployee(String name, int employeeId, double salary) {
        super(name, employeeId); // call parent constructor
        this.salary = salary;
    }

    // Same method name (acts as override)
    void displayDetails() {
        super.displayDetails();  // show common details
        System.out.println("Salary: " + salary);
        System.out.println("--------------------------");
    }
}

// Derived class 2: Part-time Employee
class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    // Constructor
    PartTimeEmployee(String name, int employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Same method name (acts as override)
    void displayDetails() {
        super.displayDetails();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Pay: " + (hourlyRate * hoursWorked));
        System.out.println("--------------------------");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get Full-Time Employee details
        System.out.println("Enter Full-Time Employee details:");
        System.out.print("Name: ");
        String name1 = sc.nextLine();
        System.out.print("Employee ID: ");
        int id1 = sc.nextInt();
        System.out.print("Salary: ");
        double salary = sc.nextDouble();

        FullTimeEmployee fte = new FullTimeEmployee(name1, id1, salary);

        // Get Part-Time Employee details
        sc.nextLine(); // clear input buffer
        System.out.println("\nEnter Part-Time Employee details:");
        System.out.print("Name: ");
        String name2 = sc.nextLine();
        System.out.print("Employee ID: ");
        int id2 = sc.nextInt();
        System.out.print("Hourly Rate: ");
        double rate = sc.nextDouble();
        System.out.print("Hours Worked: ");
        int hours = sc.nextInt();

        PartTimeEmployee pte = new PartTimeEmployee(name2, id2, rate, hours);

        // Display all details
        System.out.println("\n=== Full-Time Employee Details ===");
        fte.displayDetails();

        System.out.println("=== Part-Time Employee Details ===");
        pte.displayDetails();

        sc.close();
    }
}
