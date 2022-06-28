package bookkeeping.taxes;


public class TaxModule {
    public static void showMonthSummary() {
        MonthSummary summary = new MonthSummary();
        System.out.println(summary.getTaxToPay());
    }
}
