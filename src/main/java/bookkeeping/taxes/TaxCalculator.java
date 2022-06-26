package bookkeeping.taxes;

public class TaxCalculator {

    private static final double TAX_FREE = 30_000;

    public double calculateTax(double income) {
        double incomeWithoutTaxFree = income - TAX_FREE;
        if (incomeWithoutTaxFree > 0 && incomeWithoutTaxFree <= 120_000) {
            return calculateFirstWayTax(incomeWithoutTaxFree);
        }
        if (incomeWithoutTaxFree > 120_000) {
            return calculateSecondWayTax(incomeWithoutTaxFree);
        }
        return 0;
    }


    private double calculateFirstWayTax(double incomeWithoutTaxFree) {
        double tax = 120_000 * 0.17;
        tax += (incomeWithoutTaxFree - 120_000) * 0.32;

        return tax;
    }

    private double calculateSecondWayTax(double incomeWithoutTaxFree) {
        return incomeWithoutTaxFree * 0.17;
    }
}
