package Faculty;

public class Worker extends Employee{
    public Worker(String name, String nationalID, int age, double salary) {
        super(name, nationalID, age, salary);
    }

    @Override
    public String toString() {
        return "Worker: " + getName() + "  with id: " + getID() + " has salary: " + getSalary();
    }
}