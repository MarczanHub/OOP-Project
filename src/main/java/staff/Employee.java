package staff;

public class Employee {

    private String name;
    private String surname;
    private String pesel;
    private double salary;

    public Employee(String name, String surname, String pesel, double salary) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.salary = salary;
    }

    public Employee(String line) {
        String[] split = line.split(",");
        this.name = split[0];
        this.surname = split[1];
        this.pesel = split[2];
        this.salary = Double.parseDouble(split[3]);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", pesel = '" + pesel + '\'' +
                ", salary = " + salary + '}' + "\n";
    }
}
