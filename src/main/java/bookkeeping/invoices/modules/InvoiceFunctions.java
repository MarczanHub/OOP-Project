package bookkeeping.invoices.modules;

import bookkeeping.invoices.Invoice;
import bookkeeping.invoices.InvoicesOperations;
import bookkeeping.invoices.PaymentCurrency;
import bookkeeping.invoices.PaymentWay;

import java.util.Scanner;

import static main.Main.bookkeepingModule;
import static main.Main.isLoggedIn;

public class InvoiceFunctions {

    static Scanner sc = new Scanner(System.in);
    public static void showAllInvoices() {
        System.out.println(new InvoicesOperations().findAll());
        //idk co dalej
    }

    public static void editInvoice() {
    }

    public static void deleteInvoice() {
//        System.out.println("Please enter Invoice ID to delete invoice:");
//            new InvoicesOperations().deleteById(sc.nextLong());
//        if (sc.next){
//            System.out.println("The invoice has been deleted");
//        } else {
//            System.out.println("Given invoice ID does not exist");
//        }

    }

    public static void payInvoice() {
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

    public static void createInvoice() {

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
}
