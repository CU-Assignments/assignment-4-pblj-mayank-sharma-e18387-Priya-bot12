import java.util.ArrayList;
import java.util.Scanner;

// Employee class using encapsulation
class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display employee details
    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Salary: ₹" + salary);
    }
}

// Main class
public class EmployeeManagement {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> searchEmployee();
                case 5 -> displayAllEmployees();
                case 0 -> System.out.println("Exiting... 👋");
                default -> System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 0);
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, salary);
        employeeList.add(emp);
        System.out.println("✅ Employee added successfully!");
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.print("Enter new name: ");
                emp.setName(sc.nextLine());
                System.out.print("Enter new salary: ");
                emp.setSalary(sc.nextDouble());
                System.out.println("✅ Employee updated successfully!");
                return;
            }
        }

        System.out.println("❌ Employee not found!");
    }

    private static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = sc.nextInt();

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                employeeList.remove(emp);
                System.out.println("✅ Employee removed successfully!");
                return;
            }
        }

        System.out.println("❌ Employee not found!");
    }

    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.println("✅ Employee found:");
                emp.display();
                return;
            }
        }

        System.out.println("❌ Employee not found!");
    }

    private static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("📭 No employees found!");
            return;
        }

        System.out.println("\n📋 All Employees:");
        for (Employee emp : employeeList) {
            emp.display();
        }
    }
}
