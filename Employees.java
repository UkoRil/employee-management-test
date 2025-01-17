import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

class Employee {
    String EmployeeName;
    String DepartmentName;
    int Id;
    int Salary;

    public Employee(int Id, String EmployeeName, String DepartmentName, int Salary) {
        this.EmployeeName = EmployeeName;
        this.DepartmentName = DepartmentName;
        this.Id = Id;
        this.Salary = Salary;
    }

    public int getId() {
        return Id;
    }
}

class Employees {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            ShowMenu();
            choice = scanner.nextInt();
            handleChoice(choice);
        } while (choice != 5);
    }

    public static void ShowMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee details");
        System.out.println("3. Delete Employee");
        System.out.println("4. Show all Employees");
        System.out.println("5. Exit");
    }

    public static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                AddEmployee();
                break;
            case 2:
                UpdateEmployee();
                break;
            case 3:
                DeleteEmployee();
                break;
            case 4:
                ShowEmployees();
                break;
            case 5:
                System.out.println("Exiting the system.");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void AddEmployee() {
        System.out.println("Enter Employee Id:");
        int Id = scanner.nextInt();
        for (Employee employee : employees) {
            if (employee.Id == Id) {
                System.out.println("Employee with this ID already exists.");
                return;
            }
        }
        System.out.println("Enter Employee Name:");
        scanner.nextLine(); // Clear buffer
        String EmployeeName = scanner.nextLine();
        System.out.println("Enter Department Name:");
        String DepartmentName = scanner.nextLine();
        System.out.println("Enter Salary:");
        int Salary = scanner.nextInt();

        Employee employee = new Employee(Id, EmployeeName, DepartmentName, Salary);
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public static void UpdateEmployee() {
        System.out.print("Enter Employee Id:");
        int SearchId = scanner.nextInt();

        for (Employee employee : employees) {
            if (employee.Id == SearchId) {
                System.out.println("What would you like to update?");
                System.out.println("1. Salary");
                System.out.println("2. Department");
                System.out.println("3. Name");
                int updateChoice = scanner.nextInt();

                scanner.nextLine(); // Clear buffer
                switch (updateChoice) {
                    case 1:
                        System.out.println("Enter new Salary:");
                        employee.Salary = scanner.nextInt();
                        break;
                    case 2:
                        System.out.println("Enter new Department:");
                        employee.DepartmentName = scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Enter new Name:");
                        employee.EmployeeName = scanner.nextLine();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }
                System.out.println("Employee details updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void DeleteEmployee() {
        System.out.print("Enter Employee Id:");
        int Id = scanner.nextInt();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == Id) {
                iterator.remove();
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void ShowEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees to show");
            return;
        }

        System.out.printf("%-10s %-20s %-20s %-10s%n", "ID", "Name", "Department", "Salary");
        for (Employee employee : employees) {
            System.out.printf("%-10d %-20s %-20s %-10d%n", employee.Id, employee.EmployeeName, employee.DepartmentName, employee.Salary);
        }
    }
}