package main;

import bookkeeping.contractor.Contractor;
import bookkeeping.contractor.ContractorOperations;
import bookkeeping.invoices.Invoice;
import bookkeeping.invoices.InvoicesOperations;
import bookkeeping.invoices.PaymentCurrency;
import bookkeeping.invoices.PaymentWay;
import bookkeeping.taxes.MonthSummary;
import staff.Employee;
import staff.EmployeeOperations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static main.mainfunctions.Account.*;
import static main.mainfunctions.Exit.exit;
import static main.mainfunctions.Exit.logout;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static boolean exit = true;
    static boolean isLogged = false;
    public static Map<String, String> users = new HashMap<>();
    static Map<String, Integer> stockStatus = new HashMap<>();

    public static void main(String[] args) {
        stockStatus.put("Ceg�a pe�na \tilo��: ", 500);
        stockStatus.put("Strop ceramiczny \tilo��: ", 1000);
        stockStatus.put("Tynk silikonowy \tilo��: ", 2000);
        stockStatus.put("Farba akrylowa \tilo��: ", 1500);

        while (exit) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t* Modular program for business management *\n");
            System.out.println("1. Log in\n" + "2. Create account \n" + "3. Exit");
            String decision = sc.next();
            switch (decision) {
                case "1" -> login();
                case "2" -> createAccount();
                case "3" -> exit();
                default -> System.out.println("Invalid command");
            }
            isLoggedIn();
        }
    }


    private static void isLoggedIn() {

        while (isLogged) {
            System.out.println("\nUser panel:\n");
            System.out.println("1. Bookkeeping module\n" + "2. Staff module\n" + "3. Logout");
            String decision = sc.next();
            switch (decision) {
                case "1" -> bookkeepingModule();
                case "2" -> staffModule();
                case "3" -> logout();
                default -> System.out.println("Invalid command");
            }
        }
    }

    private static void bookkeepingModule() {

        while (isLogged) {
            System.out.println("\n1. Add Contractors\n" +
                    "2. Create invoice\n" +
                    "3. Pay the invoice\n" +
                    "4. Delete the invoice\n" +
                    "5. Edit the invoice\n" +
                    "6. Show invoices\n" +
                    "7. Show month summary + income tax\n" +
                    "8. Back to user panel");
            String decision = sc.next();
            switch (decision) {
                case "1" -> addContractor();
                case "2" -> createInvoice();
                case "3" -> payInvoice();
                case "4" -> deleteInvoice();
                case "5" -> editInvoice();
                case "6" -> showAllInvoices();
                case "7" -> showMonthSummary();
                case "8" -> isLoggedIn();
                default -> System.out.println("Invalid command");
            }
        }

    }

    private static void showMonthSummary() {
        MonthSummary summary = new MonthSummary();
        System.out.println(summary.getTaxToPay());
    }

    private static void showAllInvoices() {
        System.out.println(new InvoicesOperations().findAll());
        //idk co dalej
    }

    private static void editInvoice() {
    }

    private static void deleteInvoice() {
//        System.out.println("Please enter Invoice ID to delete invoice:");
//            new InvoicesOperations().deleteById(sc.nextLong());
//        if (sc.next){
//            System.out.println("The invoice has been deleted");
//        } else {
//            System.out.println("Given invoice ID does not exist");
//        }

    }

    private static void payInvoice() {
        Invoice invoice = null;
        invoice.getInvoiceId();
        boolean isPaid = false;
        if (!invoice.isPaid) {
            System.out.println("Invoice has been already paid");
        } else {
            System.out.println("Type 'pay' to pay the invoice or type 'decline' to go back to the user panel");
            String decision = sc.next();
            if (decision.equalsIgnoreCase("pay")) {
                System.out.println("The invoice has been paid");
                isPaid = true;
            } else if (decision.equalsIgnoreCase("decline")) {
                System.out.println("You will be taken to user's panel");
                isLoggedIn();
            }
        }
    }

    private static void createInvoice() {

        System.out.println("Enter the following information in sequence: Invoice ID, Payment Way (CASH/TRANSFER), Payment Currency (USD/EUR/PLN), Amount, Contractor ID, Is Paid (true/false)");
        Invoice invoice = new Invoice(sc.nextLong(), PaymentWay.valueOf(sc.next()), PaymentCurrency.valueOf(sc.next()), sc.nextDouble(), sc.nextLong(), sc.nextBoolean());

        System.out.println("\nTo confirm your entries type 'confirm' or type 'decline', to return to the accounting module.");
        String decision = sc.next();
        if (decision.equalsIgnoreCase("confirm")) {
            System.out.println();
            new InvoicesOperations().save(invoice);
            invoice.printInvoiceData();
        } else if (decision.equalsIgnoreCase("decline")) {
            bookkeepingModule();
        } else {
            System.out.println("Invalid command,  you will be taken to the user panel.");
            isLoggedIn();
        }

    }

    private static void addContractor() {
        System.out.println("Enter the following information in sequence: Contractor ID, Name, NIP");
        Contractor contractor = new Contractor(sc.nextLong(), sc.next(), sc.next());

        System.out.println("\nTo confirm your entries type 'confirm' or type 'decline', to return to the accounting module.");
        String decision = sc.next();
        if (decision.equalsIgnoreCase("confirm")) {
            System.out.println();
            new ContractorOperations().save(contractor);
            contractor.getContractorData();
        } else if (decision.equalsIgnoreCase("decline")) {
            bookkeepingModule();
        } else {
            System.out.println("Invalid command,  you will be taken to the user panel.");
            isLoggedIn();
        }

    }

    private static void staffModule() {

        while (isLogged) {
            System.out.println("\n1. Add employee\n" +
                    "2. Delete employee\n" +
                    "3. Edit employee data\n" +
                    "4. Calculate employee's salary\n" +
                    "5. Back to user panel");
            String decision = sc.next();
            switch (decision) {
                case "1" -> addEmployee();
                case "2" -> deleteEmployee();
                case "3" -> editEmployeeData();
                case "4" -> calculateSalary();
                case "5" -> isLoggedIn();
                default -> System.out.println("Invalid command");
            }
        }
    }

    private static void addEmployee() {
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

    private static void deleteEmployee() {
        System.out.println("Enter employee pesel number");
        long pesel = sc.nextLong();
        new EmployeeOperations().deleteById(pesel);

    }

    private static void editEmployeeData() {

    }

    private static void calculateSalary() {

    }
}

