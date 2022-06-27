import bookkeeping.contractor.Contractor;
import bookkeeping.contractor.ContractorOperations;
import bookkeeping.taxes.MonthSummary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static boolean exit = true;
    static boolean isLogged = false;
    static Map<String, String> users = new HashMap<>();
    static Map<String, Integer> stockStatus = new HashMap<>();

    public static void main(String[] args) {
        stockStatus.put("Ceg³a pe³na \tiloœæ: ", 500);
        stockStatus.put("Strop ceramiczny \tiloœæ: ", 1000);
        stockStatus.put("Tynk silikonowy \tiloœæ: ", 2000);
        stockStatus.put("Farba akrylowa \tiloœæ: ", 1500);

        while (exit) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t* Program modu³owy do zarz¹dzania firm¹ *\n");
            System.out.println("1. Zaloguj siê \n" + "2. Stwórz konto \n" + "3. WyjdŸ");
            String decision = sc.next();
            switch (decision) {
                case "1" -> login();
                case "2" -> createAccount();
                case "3" -> exit();
                default -> System.out.println("Niepoprawna komenda");
            }
            isLoggedIn();
        }
    }


    public static void exit() {
        System.out.println("Aplikacja zostanie zamkniêta. Zapraszamy ponownie.");
        System.exit(0);
    }

    private static void logout() {
        isLogged = false;
        System.out.println("Wylogowano");
    }

    private static void createAccount() {
        boolean passwordIsCorrect = true;
        System.out.println("Proszê podaæ nazwê u¿ytkownika");
        String username = sc.next();
        isUserInDB(username);
        String password = "";
        password = checkPassword(passwordIsCorrect, password);
        System.out.println("U¿ytkownik " + username + " zosta³ dodany do bazy danych");
        users.put(username, password);
    }

    private static String checkPassword(boolean passwordIsCorrect, String password) {
        while (passwordIsCorrect) {
            System.out.println("Proszê podaæ has³o");
            password = sc.next();
            System.out.println("Proszê powtórzyæ has³o");
            String secondPass = sc.next();
            passwordIsCorrect = !password.equals(secondPass);
            if (passwordIsCorrect) {
                System.out.println("Podane has³a nie s¹ takie same, spróbuj ponownie");
            }
        }
        return password;
    }

    private static void isUserInDB(String username) {
        if (users.containsKey(username)) {
            System.out.println("U¿ytkownik o podanym loginie ju¿ istnieje w bazie danych");
            createAccount();
        }
    }

    private static void login() {
        System.out.println("Podaj login");
        String login = sc.next();
        System.out.println("Podaj has³o");
        String pass = sc.next();
        String passFromUsers = users.get(login);
        findUserInDB(login, pass, passFromUsers);
    }

    private static void findUserInDB(String login, String pass, String passFromUsers) {
        if (pass.equals(passFromUsers)) {
            System.out.println("Jesteœ zalogowany jako: " + login);
            isLogged = !isLogged;
        } else {
            System.out.println("Podany login lub has³o jest niepoprawne");
        }
    }

    private static void isLoggedIn() {

        while (isLogged) {
            System.out.println("\nPanel u¿ytkownika:\n");
            System.out.println("1. Modu³ ksiêgowy\n" + "2. Modu³ kadrowy\n" + "3. Wyloguj siê");
            String decision = sc.next();
            switch (decision) {
                case "1" -> bookkeepingModule();
                case "2" -> staffModule();
                case "3" -> logout();
                default -> System.out.println("Niepoprawna komenda");
            }
        }
    }

    private static void bookkeepingModule() {

        while (isLogged){
            System.out.println("\n1. Dodaj kontrahentów\n" +
                    "2. Wystaw fakturê\n" +
                    "3. Op³aæ fakturê\n" +
                    "4. Usuñ fakturê\n"+
                    "5. Edytuj wprowadzon¹ fakturê\n" +
                    "6. Poka¿ wprowadzone faktury\n" +
                    "7. Poka¿ podsumowanie miesi¹ca + podatek dochodowy\n" +
                    "8. Wróæ do panelu u¿ytkownika");
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
                default -> System.out.println("Niepoprawna komenda");
            }
        }

    }

    private static void showMonthSummary() {
        MonthSummary summary = new MonthSummary();
        System.out.println(summary.getTaxToPay());
    }

    private static void showAllInvoices() {
        
    }

    private static void editInvoice() {
        
    }

    private static void deleteInvoice() {
        
    }

    private static void payInvoice() {
        
    }

    private static void createInvoice() {
        
    }

    private static void addContractor() {
        System.out.println("Wpisz kolejno nastêpuj¹ce dane: ID kontrahenta, Nazwê Firmy, NIP");
        Contractor contractor = new Contractor(sc.nextLong(), sc.next(), sc.next());

        System.out.println("\nW celu zatwierdzenia wpisanych danych wpisz 'confirm' lub wprowadŸ 'back', aby powróciæ do modu³u ksiêgowego.");
        String decision = sc.next();
        if (decision.equals("confirm")){
            System.out.println();
            new ContractorOperations().save(contractor);
            contractor.getBio();
        } else if (decision.equals("decline")){
            bookkeepingModule();
        } else {
            System.out.println("Niepoprawna komenda, zostajesz przeniesiony do panelu u¿ytkownika.");
            isLoggedIn();
        }

    }

    private static void staffModule() {

        while (isLogged) {
            System.out.println("\n1. Dodaj pracownika\n"+
                    "2. Usuñ pracownika\n" +
                    "3. Edytuj dane istniej¹cego pracownika\n" +
                    "4. Oblicz pensjê pracownika\n" +
                    "5. Wróæ do panelu u¿ytkownika");
            String decision = sc.next();
            switch (decision) {
                case "1" -> addEmployee();
                case "2" -> deleteEmployee();
                case "3" -> editEmployeeData();
                case "4" -> calculateSalary();
                case "5" -> isLoggedIn();
                default -> System.out.println("Niepoprawna komenda");
            }
        }
    }

    private static void addEmployee() {

    }

    private static void deleteEmployee() {

    }

    private static void editEmployeeData() {

    }

    private static void calculateSalary() {

    }
}


