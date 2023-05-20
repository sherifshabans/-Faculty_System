package Faculty;

public class Administrator extends Employee{
    public Administrator(String name, String nationalID, int age, double salary) {
        super(name, nationalID, age, salary);
    }

    @Override
    public String toString() {
        return "Administrator: " + getName() + "  with id: " + getID() + " has salary: " + getSalary();
    }
}