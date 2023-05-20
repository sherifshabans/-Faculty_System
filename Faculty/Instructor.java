package Faculty;

import java.util.ArrayList;

public class Instructor extends Employee{
    private String department;
    private ArrayList<String> subjects = new ArrayList<>();

    public Instructor(String name, String nationalID, int age, String department, double salary) {
        super(name, nationalID, age, salary);
        setDepartment(department);
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }

    @Override
    public void display(){
        super.display();
        displayAllSubjects();
    }

    @Override
    public String toString() {
        return "Instructor: " + getName() + "  with id: " + getID() + " in " + getDepartment() + " department " + " has salary: " + getSalary();
    }

    public void addSubject(String subject){
        for (String _subject : subjects)
            if (_subject == subject)
                return;

        subjects.add(subject);
    }

    public void deleteSubject(String subject){
        if (subjects.remove(subject))
            System.out.println("\nDeleted successfully.");
        else
            System.out.println("\nThis subject does not exist.");

        System.out.println();
    }

    public void displayAllSubjects(){
        if (subjects.isEmpty())
            return;

        System.out.println("This instructor teaches the following subjects:");
        for (String subject : subjects)
            System.out.println(subject);

        System.out.println();
    }
}