package bookkeeping.contractor.contractormodule;

import bookkeeping.contractor.Contractor;
import bookkeeping.contractor.ContractorOperations;

import java.util.Scanner;

import static main.Main.bookkeepingModule;
import static main.Main.isLoggedIn;

public class ContractorFunctions {

    static Scanner sc = new Scanner(System.in);
    public static void addContractor() {
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
}
