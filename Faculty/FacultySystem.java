package Faculty;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class FacultySystem {
    private static ArrayList<Person> members = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static int getChoice(int start, int end){
        int choice = 0;
        do{
            boolean valid = false;
            while (!valid){
                System.out.print("Enter a valid choice [" + start + "-" + end + "]: ");
                try{
                    choice = scanner.nextInt();

                    valid = true;
                }
                catch(Exception e){
                    scanner.nextLine();
                    System.out.println("\nInvalid input. Please try again.\n");
                }
            }

            if (choice < start || choice > end)
                System.out.println("Invalid choice. Please try again\n");
            else
                break;
        }while(true);

        return choice;
    }

    private static int menu(){
        System.out.println("Menu:");
        System.out.println("    1: add new person.");
        System.out.println("    2: search for a person.");
        System.out.println("    3: delete a person.");
        System.out.println("    4: display a person.");
        System.out.println("    5: display all persons.");
        System.out.println("    6: exit the system.\n");

        return getChoice(1, 6);
    }

    private static int subMenu(Person member){
        System.out.println("choose the functionality you want: ");
        if (member instanceof Student){
            System.out.println("    1: edit the level.");
            System.out.println("    2: edit the department.");
            System.out.println("    3: edit the gpa.");
            System.out.println("    4: display the level.");
            System.out.println("    5: display the department.");
            System.out.println("    6: display the gpa.");
            System.out.println("    7: display all data.");
            System.out.println("    8: back to main menu.\n");

            return getChoice(1, 8);
        }
        else if (member instanceof Instructor){
            System.out.println("    1: edit the salary.");
            System.out.println("    2: display the salary.");
            System.out.println("    3: edit the department.");
            System.out.println("    4: display the department.");
            System.out.println("    5: add new subject.");
            System.out.println("    6: delete subject.");
            System.out.println("    7: display all subjects.");
            System.out.println("    8: display all data.");
            System.out.println("    9: back to main menu.\n");

            return getChoice(1, 9);
        }
        else if (member instanceof Employee){
            System.out.println("    1: edit the salary.");
            System.out.println("    2: display the salary.");
            System.out.println("    3: display all data.");
            System.out.println("    4: back to main menu.\n");

            return getChoice(1, 4);
        }

        throw new IllegalArgumentException("Invalid instance does not have subMenu.");
    }

    private static void studentSubMenu(Student member){
        while (true){
            int choice;
            try {
                choice = subMenu(member);
            }catch (IllegalArgumentException e){
                System.out.println( "\n****\n" + e.getMessage() + "\n****\n");
                return;
            }

            if (choice == 1){
                int level = getLevel();

                try {
                    member.setLevel(level);
                }catch (IllegalArgumentException e){
                    System.out.println( "\n****\n" + e.getMessage() + "\n****\n");
                    return;
                }
            }
            else if (choice == 2){
                String department = getDepartment();

                member.setDepartment(department);
            }
            else if (choice == 3){
                double gpa = getGPA();

                try {
                    member.setGPA(gpa);
                }catch (IllegalArgumentException e){
                    System.out.println( "\n****\n" + e.getMessage() + "\n****\n");
                    return;
                }
            }
            else if (choice == 4)
                System.out.println(member.getLevel());
            else if (choice == 5)
                System.out.println(member.getDepartment());
            else if (choice == 6)
                System.out.println(member.getGPA());
            else if (choice == 7)
                member.display();
            else
                return;
        }
    }

    private static void instructorSubMenu(Instructor member){
        while (true){
            int choice;
            try {
                choice = subMenu(member);
            }
            catch (IllegalArgumentException e){
                System.out.println( "\n****\n" + e.getMessage() + "\n****\n");
                return;
            }

            if (choice == 1){
                double salary = getSalary();

                try {
                    member.setSalary(salary);
                }catch (IllegalArgumentException e){
                    System.out.println( "\n****\n" + e.getMessage() + "\n****\n");
                    return;
                }
            }
            else if (choice == 2)
                System.out.println(member.getSalary());
            else if (choice == 3){
                String department = getDepartment();

                member.setDepartment(department);
            }
            else if (choice == 4)
                System.out.println(member.getDepartment());
            else if (choice == 5){
                String subject;
                System.out.print("Enter a new subject: ");
                subject = scanner.next();

                member.addSubject(subject);
            }
            else if (choice == 6){
                String subject;
                System.out.print("Enter a subject to delete: ");
                subject = scanner.next();

                member.deleteSubject(subject);
            }
            else if (choice == 7)
                member.displayAllSubjects();
            else if (choice == 8)
                member.display();
            else if (choice == 9)
                return;
        }
    }

    private static void employeeSubMenu(Employee member){
        while (true){
            int choice;
            try {
                choice = subMenu(member);
            }catch (IllegalArgumentException e){
                System.out.println( "\n****\n" + e.getMessage() + "\n****\n");
                return;
            }

            if (choice == 1){
                double salary = getSalary();

                member.setSalary(salary);
            }
            else if (choice == 2)
                System.out.println(member.getSalary());
            else if (choice == 3)
                member.display();
            else
                return;
        }
    }

    private static int getTitle(){
        System.out.println("Choose the title: ");
        System.out.println("    1: Student");
        System.out.println("    2: Instructor");
        System.out.println("    3: Administrator");
        System.out.println("    4: Technician");
        System.out.println("    5: Worker\n");

        return getChoice(1, 5);
    }

    private static String getDepartment(){
        System.out.println("Choose the department: ");
        System.out.println("    1: Computer Science");
        System.out.println("    2: Information Technology");
        System.out.println("    3: Information Systems");
        System.out.println("    4: Cyber Security");
        System.out.println("    5: Artificial Intelligence\n");

        int choice = getChoice(1, 5);

        if (choice == 1)
            return "Computer Science";
        else if (choice == 2)
            return "Information Technology";
        else if (choice == 3)
            return "Information Systems";
        else if (choice == 4)
            return "Cyber Security";
        else
            return "Artificial Intelligence";
    }

    private static int getAge(){
        int age = 0;
        do {
            boolean valid = false;
            while (!valid){
                System.out.print("Enter the age: ");
                try{
                    age = scanner.nextInt();

                    valid = true;
                }
                catch(InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("\nInvalid input. Please try again.\n");
                }
            }

            if (age > 17 && age <= 80)
                break;
            else
                System.out.println("Age should be greater than 17 and less than or equal to 80.");
        }while(true);

        return age;
    }

    private static int getLevel(){
        int level = 0;
        do{
            boolean valid = false;
            while (!valid){
                System.out.print("Enter the level [1-4]: ");
                try{
                    level = scanner.nextInt();

                    valid = true;
                }
                catch(Exception e){
                    scanner.nextLine();
                    System.out.println("\nInvalid input. Please try again.\n");
                }
            }

            if (level < 1 || level > 4)
                System.out.println("Level must be between 1 and 4.\n");
            else
                break;
        }while(true);

        return level;
    }

    private static double getGPA(){
        double gpa = 0.0;
        do{
            boolean valid = false;
            while (!valid){
                System.out.print("Enter the gpa [0.0-4.0]: ");
                try{
                    gpa = scanner.nextDouble();

                    valid = true;
                }
                catch(InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("\nInvalid input. Please try again.\n");
                }
            }

            if (gpa < 0.0 || gpa > 4.0)
                System.out.println("GPA must be between 0 and 4.\n");
            else
                break;
        }while(true);

        return gpa;
    }

    private static double getSalary(){
        double salary = 0.0;
        do {
            boolean valid = false;
            while (!valid){
                System.out.print("Enter the salary: ");
                try{
                    salary = scanner.nextDouble();

                    valid = true;
                }
                catch(InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("\nInvalid input. Please try again.\n");
                }
            }

            if (salary > 0.0)
                break;
            else
                System.out.println("Salary cannot be less than or equal to 0. Please try again.");
        }while(true);

        return salary;
    }

    private static void addPerson(){
        String nationalId;
        System.out.print("Enter the national id: ");
        nationalId = scanner.next();

        for (Person person : members){
            if (person.getID().equals(nationalId)){
                System.out.println("This person already exists.");
                return;
            }
        }

        String name;
        System.out.print("Enter the name: ");
        name = scanner.next();

        int age = getAge();

        int choice = getTitle();

        Person newPerson;
        if (choice == 1) {
            int level = getLevel();

            String department = getDepartment();

            double gpa = getGPA();

            newPerson = new Student(name, nationalId, age, level, department, gpa);

            studentSubMenu((Student) newPerson);
        }
        else{
            double salary = getSalary();

            if (choice == 2) {
                String department = getDepartment();

                newPerson = new Instructor(name, nationalId, age, department, salary);

                instructorSubMenu((Instructor) newPerson);
            }
            else{
                if (choice == 3)
                    newPerson = new Administrator(name, nationalId, age, salary);
                else if (choice == 4)
                    newPerson = new Technician(name, nationalId, age, salary);
                else
                    newPerson = new Worker(name, nationalId, age, salary);

                employeeSubMenu((Employee) newPerson);
            }
        }

        members.add(newPerson);
    }

    private static Person searchPerson(){
        String id;
        System.out.print("Enter the national id: ");
        id = scanner.next();

        for (Person person : members) {
            if (person.getID().equals(id))
                return person;
        }

        return null;
    }

    private static void deletePerson(){
        Person person = searchPerson();

        if (person == null){
            System.out.println("This person does not exist.\n");
            return;
        }

        members.remove(person);
        System.out.println("Deleted successfully.\n");
    }

    private static void displayPerson(){
        Person person = searchPerson();

        if (person == null){
            System.out.println("This person does not exist.\n");
            return;
        }

        person.display();
    }

    private static void displayAllPersons(){
        if (members.isEmpty()) {
            System.out.println("There are no members at the moment.\n");
            return;
        }

        for (Person person : members)
            person.display();
    }

    public static void start(){
        System.out.println("Faculty Of Computers And Information members System:");
        System.out.println("****************************************************\n");
        while (true){
            int choice = menu();

            if (choice == 1)
                addPerson();
            else if (choice == 2) {
                Person target = searchPerson();
                if (target != null){
                    if (target instanceof Student)
                        studentSubMenu((Student) target);
                    else if (target instanceof Instructor)
                        instructorSubMenu((Instructor) target);
                    else if (target instanceof Employee)
                        employeeSubMenu((Employee) target);
                    else
                        System.out.println("\n\n**Invalid instance**\n\n");
                }
                else
                    System.out.println("This person does not exist.\n");
            }
            else if (choice == 3)
                deletePerson();
            else if (choice == 4)
                displayPerson();
            else if (choice == 5)
                displayAllPersons();
            else
                break;
        }
    }
}