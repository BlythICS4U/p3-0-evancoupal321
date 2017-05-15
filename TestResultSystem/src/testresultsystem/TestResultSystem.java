package testresultsystem;

import java.util.Scanner;
import java.util.StringTokenizer;

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
        System.out.println("0) Exit");
    }
    
    private static void addStudent(Scanner keyboard, Course course) {
        System.out.println("Enter the student's information in the form: <ID> <Name> <Age>");
        String studentData = keyboard.nextLine();
        
        StringTokenizer tokens = new StringTokenizer(studentData);
        if (tokens.countTokens() != 3) {
            System.out.println("Invalid input");
        } else {
            String id = tokens.nextToken();
            String name = tokens.nextToken();
            int age = Integer.valueOf(tokens.nextToken());
            course.addStudent(new Student(id, name, age));
            System.out.println("Student added successfully");
        }
    }
    
    private static void addTestResult(Scanner keyboard, Course course) {
        System.out.println("Enter the student's information in the form: <Student ID> <Test score> <Test weight>");
        String testData = keyboard.nextLine();
        
        StringTokenizer tokens = new StringTokenizer(testData);
        if (tokens.countTokens() != 3) {
            System.out.println("Invalid input");
        } else {
            String id = tokens.nextToken();
            double score = Double.valueOf(tokens.nextToken());
            int weight = Integer.valueOf(tokens.nextToken());
            
            Student student = course.getStudent(id);
            if (student == null) {
                System.out.println("Invalid input");
            } else {
                student.addTestResult(new TestResult(score, weight));
                System.out.println("Result added successfully");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Teacher teacher = new Teacher("007", "Chris", 35, new String[]{"CS", "Math", "Physics"});
        Course csCourse = new Course("ICS4U", "Grade 12 Computer Science");
        csCourse.setTeacher(teacher);
        
        System.out.println("Welcome to the Test Result System");
        
        Scanner keyboard = new Scanner(System.in);
        while(true) {
            printOptions();
            String option = keyboard.nextLine();
            
            if (option.equals("0")) {
                System.out.println("Good bye!");
                break;
            }
            
            switch(option) {
                case "1":
                    addStudent(keyboard, csCourse);
                    break;
                case "2":
                    addTestResult(keyboard, csCourse);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    
}
