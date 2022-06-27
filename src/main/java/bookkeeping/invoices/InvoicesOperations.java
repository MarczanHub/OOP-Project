package bookkeeping.invoices;

import bookkeeping.contractor.ContractorOperations;
import operations.CrudOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InvoicesOperations implements CrudOperations<Invoice> {

    public static final String INVOICE_CSV = "src/main/resources/invoice.csv";

    @Override
    public void save(Invoice i) {
        ContractorOperations operations = new ContractorOperations();
        if (operations.findById(i.getContractorId()) == null) {
            System.out.println("Given contractor does not exist.");
            return;
        }
        try (FileWriter fileWriter = new FileWriter(INVOICE_CSV, true)) {
            fileWriter.append(String.format("%s%s%s%s%s\n", i.getInvoiceId(),
                    i.getPaymentWay(), i.getCurrency(), i.getAmount(),
                    i.getContractorId()));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(long id, Invoice type) {

    }

    @Override
    public Invoice findById(long id) {
        return null;
    }

    @Override
    public List<Invoice> findAll() {
        List<Invoice> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(INVOICE_CSV))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Invoice invoice = new Invoice(line);
                list.add(invoice);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return list;
    }
}
