package Faculty;

import java.util.Objects;

public class Student extends Person {
    private int level;
    private  String department;
    private double GPA;

    public Student(String name, String nationalID, int age, int level, String department, double GPA) {
        super(name, nationalID, age);

        try {
            setLevel(level);
        }catch (IllegalArgumentException e){
            this.level = 1;
            System.out.println( "\n****\n" + e.getMessage() + "\n****");
            System.out.println("Level is now set to 1.\n\n");
        }

        setDepartment(department);
        try {
            setGPA(GPA);
        }catch (IllegalArgumentException e){
            this.GPA = 0.0;
            System.out.println( "\n****\n" + e.getMessage() + "\n****");
            System.out.println("GPA is now set to 0.0.\n\n");
        }
    }

    @Override
    public String toString() {
        return "Student: " + getName() + "  with id: " + getID() + " is in level " + getLevel() + " in " + getDepartment() + " department " + "and his GPA is: " + getGPA();
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGPA(double GPA) {
        if (GPA < 0.0 || GPA > 4.0)
            throw new IllegalArgumentException("GPA should be between 0.0 and 4.0");

        this.GPA = GPA;
    }

    public void setLevel(int level) {
        if (level < 1 || level > 4)
            throw new IllegalArgumentException("Level should be between 1 and 4");

        this.level = level;
    }

    public double getGPA() {
        return GPA;
    }

    public String getDepartment() {
        return department;
    }

    public int getLevel() {
        return level;
    }
}