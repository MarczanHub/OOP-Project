package staff.staffmodule;

import staff.Employee;
import staff.EmployeeOperations;

import java.util.Scanner;

import static main.Main.isLoggedIn;
import static main.Main.staffModule;

public class StaffFunctions {

    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        System.out.println("Enter the following information in sequence: Name, Surname, Pesel, Salary");
        sc.nextLine();
        Employee newEmployee = new Employee(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());

        System.out.println("\nTo confirm your entries type 'confirm' or type 'decline', to return to the staff module.");
        String decision = sc.next();
        if (decision.equalsIgnoreCase("confirm")) {
            System.out.println();
            new EmployeeOperations().save(newEmployee);
            System.out.println("Employee{" +
                    "name = '" + newEmployee.getName() + '\'' +
                    ", surname = '" + newEmployee.getSurname() + '\'' +
                    ", pesel = '" + newEmployee.getPesel() + '\'' +
                    ", salary = " + newEmployee.getSalary() + '}' + "\n");
        } else if (decision.equalsIgnoreCase("decline")) {
            staffModule();
        } else {
            System.out.println("Invalid command,  you will be taken to the user panel.");
            isLoggedIn();
        }
    }

    public static void deleteEmployee() {
        System.out.println("Enter employee pesel number");
        long pesel = sc.nextLong();
        new EmployeeOperations().deleteById(pesel);

    }

    public static void editEmployeeData() {

    }

    public static void calculateSalary() {

    }
}
