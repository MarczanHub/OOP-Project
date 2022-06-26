package staff;

import operations.CrudOperations;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeOperations implements CrudOperations<Employee> {

    public static final String EMPLOYEE_CSV = "src/main/resources/employee.csv";

    @Override
    public void save(Employee employee) {
        try (FileWriter fileWriter = new FileWriter(EMPLOYEE_CSV, true)) {
            fileWriter.append(String.format("%s%s%s%s\n", employee.getName(),
                    employee.getSurname(), employee.getPesel(), employee.getSalary()));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(long id, Employee type) {

    }

    @Override
    public Employee findById(long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader(EMPLOYEE_CSV)))){
            String line;
            while ((line = reader.readLine()) != null) {
                Employee invoice = new Employee(line);
                list.add(invoice);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return list;
    }
}
