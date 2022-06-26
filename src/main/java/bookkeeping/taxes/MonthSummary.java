package bookkeeping.taxes;

import bookkeeping.invoices.Invoice;
import bookkeeping.invoices.InvoicesOperations;
import bookkeeping.invoices.PaymentCurrency;
import staff.Employee;
import staff.EmployeeOperations;

import java.util.List;

public class MonthSummary {

    InvoicesOperations invoicesOperations = new InvoicesOperations();
    EmployeeOperations employeeOperations = new EmployeeOperations();

    TaxCalculator calculator = new TaxCalculator();

    public double getTaxToPay() {
        double totalIncome = getTotalIncome();
        double employeeSalaries = calculateAllEmployeeSalaries();
        return calculator.calculateTax(totalIncome - employeeSalaries);
    }

    public double getTotalIncome(){
        List<Invoice> invoices = invoicesOperations.findAll();
        double income = 0;
        for (Invoice invoice : invoices) {
            income += calculateCurrency(invoice);
        }
        return income;
    }

    private double calculateCurrency(Invoice invoice) {
        double amount = invoice.getAmount();
        PaymentCurrency currency = invoice.getCurrency();

        return amount * currency.getValueInPln();
    }

    public double calculateAllEmployeeSalaries() {
        List<Employee> employees = employeeOperations.findAll();
        double allSalaries = 0;
        for (Employee employee : employees) {
            allSalaries += employee.getSalary();
        }
        return allSalaries;
    }
}
