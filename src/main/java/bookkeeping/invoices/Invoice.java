package bookkeeping.invoices;

public class Invoice {

    private long invoiceId;
    private PaymentWay paymentWay;
    private PaymentCurrency currency;
    private double amount;
    private long contractorId;

    public Invoice(long invoiceId, PaymentWay paymentWay, PaymentCurrency currency, double amount, long contractorId) {
        this.invoiceId = invoiceId;
        this.paymentWay = paymentWay;
        this.currency = currency;
        this.amount = amount;
        this.contractorId = contractorId;
    }

    public Invoice(String line) {
        String[] split = line.split(",");
        this.invoiceId = Long.parseLong(split[0]);
        this.paymentWay = PaymentWay.valueOf(split[1]);
        this.currency = PaymentCurrency.valueOf(split[2]);
        this.amount = Double.parseDouble(split[3]);
        this.contractorId = Long.parseLong(split[4]);
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public PaymentWay getPaymentWay() {
        return paymentWay;
    }

    public PaymentCurrency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public long getContractorId() {
        return contractorId;
    }

    public void printInvoiceData() {
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Payment way: " + paymentWay);
        System.out.println("Payment currency: " + currency);
        System.out.println("Amount: " + amount);
        System.out.println("Contractor ID: " + contractorId);

    }
}
