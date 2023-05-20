package Faculty;

public class Technician extends Employee{
    public Technician(String name, String nationalID, int age, double salary) {
        super(name, nationalID, age, salary);
    }

    @Override
    public String toString() {
        return "Technician: " + getName() + "  with id: " + getID() + " has salary: " + getSalary();
    }
}