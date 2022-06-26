package bookkeeping.invoices;

public enum PaymentCurrency {

    USD(4),
    EUR(4.6),
    PLN(1);

    double valueInPln;

    PaymentCurrency(double valueInPln) {
        this.valueInPln = valueInPln;
    }

    public double getValueInPln() {
        return valueInPln;
    }
}
