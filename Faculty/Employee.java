package Faculty;

public abstract class Employee extends Person{
    private double salary;

    public Employee(String name, String nationalID, int age, double salary) {
        super(name, nationalID, age);
        try {
            setSalary(salary);
        }catch (IllegalArgumentException e){
            this.salary = 2000.0;
            System.out.println( "\n****\n" + e.getMessage() + "\n****");
            System.out.println("Salary is now set to 2000.0LE.\n\n");
        }
    }

    public void setSalary(double salary) {
        if(salary <= 0)
            throw new IllegalArgumentException("Salary should be greater than 0");

        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}