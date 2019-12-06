package testresultsystem;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

/**
 * TestResultSystem program provides functionality to enroll students in a
 * computer science course and record test results for those students.
 * 
 * @author cgallinaro
 */
public class TestResultSystem {
    
    private static void printOptions() {
        System.out.println("Select an option:");
        System.out.println("1) Add a student to the course");
        System.out.println("2) Add test result for a student");
        System.out.println("3) Display data for a student or teacher");
        System.out.println("4) Display a student's average score");
        System.out.println("5) Add students from a file");
        System.out.println("6) Add a course to the catalog");
        System.out.println("7) Set a teacher to a course");
        System.out.println("0) Exit");
    }
    
    private static Course selectCourse(Scanner keyboard, Catalog catalog)
    {
        System.out.println("Select a course to search within.");
        String name = keyboard.nextLine();
        return catalog.getCourse(name);
    }
    
    private static Teacher selectTeacher(Scanner keyboard, Catalog catalog)
    {
        System.out.println("Enter the id of the teacher you would like to add.");
        String id = keyboard.nextLine();
        Course course = null;
        Teacher teacher = null;
        for (int i = 0; i < 5; i++)
        {
            course = catalog.getCourseNum(i);
            if (course != null)
            {
                teacher = course.getTeacher();
                if (teacher != null)
                {
                    if (teacher.getId().equals(id))
                    {
                        return teacher;
                    }
                }
            }
        }
        return null;
    }
    
    private static void addStudent(Scanner keyboard, Course course)
    {
        System.out.println("Enter the student's information in the form: <ID> <Name> <Age>");
        String studentData = keyboard.nextLine();
        StringTokenizer tokens = new StringTokenizer(studentData);
        if (tokens.countTokens() != 3)
        {
            System.out.println("Invalid input (Incorrect String input)");
        }
        else
        {
            String id = tokens.nextToken();
            String name = tokens.nextToken();
            int age = Integer.valueOf(tokens.nextToken()); 
            if (course.addStudent(new Student(id, name, age)))
            {
                System.out.println("Student added successfully");
            }
            else
            {
                System.out.println("Invalid input (Course is full or ID already exists)");
            }
        }
    }
    
    private static void addTestResult(Scanner keyboard, Course course) {
        System.out.println("Enter the student's information in the form: <Student ID> <Test score> <Test weight>");
        String testData = keyboard.nextLine();
        
        StringTokenizer tokens = new StringTokenizer(testData);
        if (tokens.countTokens() != 3) {
            System.out.println("Invalid input (Incorrect String input)");
        } else {
            String id = tokens.nextToken();
            double score = Double.valueOf(tokens.nextToken());
            int weight = Integer.valueOf(tokens.nextToken());
            
            Student student = course.getStudent(id);
            if (student == null) {
                System.out.println("Invalid input (Student not found)");
            } else {
                if (student.addTestResult(new TestResult(score, weight)))
                {
                    System.out.println("Result added successfully");
                }
                else
                {
                    System.out.println("Too many test results");
                }
            }
        }
    }
    
    private static void outputNameAndId (Person person) {
        System.out.println("Name: " + person.getName());
	System.out.println("Age: " + person.getAge());
    }
    
    private static void displayPerson(Scanner keyboard, Course course) {
        System.out.println("Enter the person's ID:");
        String id = keyboard.nextLine();
        
        // First, check if they are the teacher
        Person person = course.getTeacher();
        if (person.getId().equals(id)) {
            outputNameAndId(person);
        } else {
            // Not the teacher.  See if they are a student
            person = course.getStudent(id);
            if (person == null) {
                System.out.println("Invalid input");
            } else {
                outputNameAndId(person);
            }
        }
    }
    
    private static void displayAverage(Scanner keyboard, Course course)
    {
        System.out.println("Enter the student's ID");
        String id = keyboard.nextLine();
        
        Student student = course.getStudent(id);
        if (student == null)
        {
            System.out.println("Invalid input (Student not found)");
        }
        else
        {
            System.out.println("Average test result: " + student.getAverage());
        }
    }
    
    private static void enrollFromFile(Scanner keyboard, Course course)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("StudentData.txt"));
            String data = br.readLine();
            StringTokenizer splitData;
            while (data != null)
            {
                splitData = new StringTokenizer(data);
                if (splitData.countTokens() != 3)
                {
                    System.out.println("Invalid input");
                }
                else
                {
                    String id = splitData.nextToken();
                    String name = splitData.nextToken();
                    int age = Integer.valueOf(splitData.nextToken()); 
                    if (course.addStudent(new Student(id, name, age)))
                    {
                        System.out.println("Student added successfully");
                    }
                    else
                    {
                        System.out.println("Invalid input (Course is full or ID already exists)");
                    }
                }
                data = br.readLine();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    private static Catalog addCourse(Scanner keyboard, Catalog catalog)
    {
        System.out.println("Enter the course information in the form: <Name> <Subject> <Description>");
        String courseInfo = keyboard.nextLine();
        StringTokenizer tokens = new StringTokenizer(courseInfo);
        if (tokens.countTokens() < 2)
        {
            System.out.println("Invalid input");
            return catalog;
        }
        else
        {
            String name = tokens.nextToken();
            String subject = tokens.nextToken();
            String description = "";
            while (tokens.hasMoreTokens())
            {
                description = description + tokens.nextToken() + " ";
            }
            description.trim();
            if (catalog.addCourse(name, description, subject))
            {
                System.out.println("Course added successfully.");
            }
            else
            {
                System.out.println("Too many courses");
            }
        }
        return catalog;
    }
    
    private static void setTeacherToCourse(Scanner keyboard, Course course, Teacher teacher)
    {    
        if (course.setTeacher(teacher))
        {
            System.out.println("Teacher set successfully.");
        }
        else
        {
            System.out.println("Invalid input");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Teacher teacher = new Teacher("007", "Chris", 35, new String[]{"CS", "Math", "Physics"});
        Teacher teacherSelection = teacher;
        Catalog catalog = new Catalog();
        catalog.addCourse("ICS4U", "Grade 12 Computer Science", "CS");
        catalog.setTeacher(teacher, "ICS4U");
        Course courseSelection = catalog.getCourse("ICS4U");
        System.out.println("Welcome to the Test Result System");
        
        Scanner keyboard = new Scanner(System.in);
        while(true) {
            printOptions();
            String option = keyboard.nextLine();
            
            if (option.equals("0")) {
                System.out.println("Good bye!");
                break;
            }
            
            if (!option.equals("6"))
            {
                courseSelection = selectCourse(keyboard, catalog);
            }
            
            if (option.equals("7"))
            {
                teacherSelection = selectTeacher(keyboard, catalog);
            }
            
            switch(option) {
                case "1":
                    addStudent(keyboard, courseSelection);
                    break;
                case "2":
                    addTestResult(keyboard, courseSelection);
                    break;
                case "3":
                    displayPerson(keyboard, courseSelection);
                    break;
                case "4":
                    displayAverage(keyboard, courseSelection);
                    break;
                case "5":
                    enrollFromFile(keyboard, courseSelection);
                    break;
                case "6":
                    catalog = addCourse(keyboard, catalog);
                    break;
                case "7":
                    setTeacherToCourse(keyboard, courseSelection, teacherSelection);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    
}
