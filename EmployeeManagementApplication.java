import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private int age;
    private String position;

    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
@Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Position: " + position;
    }
}

public class EmployeeManagementApplication {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
 private static void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();

        Employee employee = new Employee(name, age, position);
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter employee name to update: ");
        String name = scanner.nextLine();
boolean found = false;
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                found = true;
                System.out.print("Enter new age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new position: ");
                String position = scanner.nextLine();

                employee = new Employee(name, age, position);
                System.out.println("Employee updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee() {
 System.out.print("Enter employee name to delete: ");
        String name = scanner.nextLine();
        boolean removed = employees.removeIf(employee -> employee.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}