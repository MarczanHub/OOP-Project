package bookkeeping.contractor;

import operations.CrudOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractorOperations implements CrudOperations<Contractor> {

    public static final String CONTRACTOR_CSV = "src/main/java/resources/contractor.csv";

    @Override
    public void save(Contractor type) {
        try (FileWriter fileWriter = new FileWriter(CONTRACTOR_CSV, true)) {
            fileWriter.append(String.format("%s,%s,%s\n", type.getContractorId(), type.getName(), type.getNip()));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(long id, Contractor type) {

    }

    @Override
    public Contractor findById(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTRACTOR_CSV))){
            String line;
            while ((line = reader.readLine()) != null) {
                Contractor contractor = new Contractor(line);
                if (contractor.getContractorId() == id){
                    return contractor;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Contractor> findAll() {
        List<Contractor> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTRACTOR_CSV))){
            String line;
            while ((line = reader.readLine()) != null) {
                Contractor contractor = new Contractor(line);
                list.add(contractor);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return list;
    }
}
