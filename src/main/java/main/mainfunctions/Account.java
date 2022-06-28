package main.mainfunctions;

import java.util.Scanner;

import static main.Main.*;

public class Account {
    static Scanner sc = new Scanner(System.in);
    static boolean isLogged = false;

    public static void createAccount() {
        boolean passwordIsCorrect = true;
        System.out.println("Please enter a username");
        String username = sc.next();
        isUserInDB(username);
        String password = "";
        password = checkPassword(passwordIsCorrect, password);
        System.out.println("User " + username + " has been added to the database.");
        users.put(username, password);
    }

    public static String checkPassword(boolean passwordIsCorrect, String password) {
        while (passwordIsCorrect) {
            System.out.println("Please enter the password");
            password = sc.next();
            System.out.println("Please repeat your password.");
            String secondPass = sc.next();
            passwordIsCorrect = !password.equals(secondPass);
            if (passwordIsCorrect) {
                System.out.println("The passwords you provided are not the same, please try again.");
            }
        }
        return password;
    }

    public static void isUserInDB(String username) {
        if (users.containsKey(username)) {
            System.out.println("In the database there is already a user with the same login. Choose another nickname.");
            createAccount();
        }
    }


    public static void login() {
        System.out.println("Enter your login");
        String login = sc.next();
        System.out.println("Enter the password");
        String pass = sc.next();
        String passFromUsers = users.get(login);
        findUserInDB(login, pass, passFromUsers);
    }

}
