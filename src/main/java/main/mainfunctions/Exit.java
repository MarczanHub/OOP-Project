package main.mainfunctions;

public class Exit {
    public static void exit() {
        System.out.println("The application is going to be shut down. Welcome again.");
        System.exit(0);
    }

    public static void logout() {
        boolean isLogged = false;
        System.out.println("You're logged out.");
    }
}
