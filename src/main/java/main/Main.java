package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static bookkeeping.contractor.contractormodule.ContractorFunctions.addContractor;
import static bookkeeping.invoices.modules.InvoiceFunctions.*;
import static bookkeeping.taxes.TaxModule.showMonthSummary;
import static main.mainfunctions.Account.createAccount;
import static main.mainfunctions.Account.login;
import static staff.staffmodule.StaffFunctions.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static boolean exit = true;
    static boolean isLogged = false;
    public static Map<String, String> users = new HashMap<>();
    static Map<String, Integer> stockStatus = new HashMap<>();

    public static void main(String[] args) {
        stockStatus.put("Ceg³a pe³na \tiloœæ: ", 500);
        stockStatus.put("Strop ceramiczny \tiloœæ: ", 1000);
        stockStatus.put("Tynk silikonowy \tiloœæ: ", 2000);
        stockStatus.put("Farba akrylowa \tiloœæ: ", 1500);

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

    public static void logout() {
        isLogged = false;
        System.out.println("You're logged out.");
    }

    public static void findUserInDB(String login, String pass, String passFromUsers) {
        if (pass.equals(passFromUsers)) {
            System.out.println("You're logged as: " + login);
            isLogged = !isLogged;
        } else {
            System.out.println("The login or password you entered is incorrect");
        }
    }

    public static void exit() {
        System.out.println("The application is going to be shut down. Welcome again.");
        System.exit(0);
    }

    public static void isLoggedIn() {

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

    public static void bookkeepingModule() {

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

    public static void staffModule() {

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


}


