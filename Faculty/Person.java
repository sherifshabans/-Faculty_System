package Faculty;

import java.util.Objects;

public abstract class Person implements FacultyInterface {
    private final String name;
    private final String nationalID;
    private int age;

    public Person(String name, String nationalID, int age) {
        this.name = name;
        this.nationalID = nationalID;
        try {
            setAge(age);
        }catch (IllegalArgumentException e){
            this.age = 18;
            System.out.println( "\n****\n" + e.getMessage() + "\n****");
            System.out.println("Age is now set to 18.\n\n");
        }
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return nationalID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 1 || age > 80)
            throw new IllegalArgumentException("Age should be greater than or equal to 1 and less than or equal to 80");

        this.age = age;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && nationalID.equals(person.nationalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getID());
    }
}