package testresultsystem;

/**
 * Course represents a high school course available for students to enroll in.
 * Class contains course meta data, teacher information and all students enrolled.
 * 
 * @author cgallinaro
 */
public class Course {
    
    private final String name; // Course name
    
    private final String description; // Course description
    
    private Teacher teacher; // Course's teacher data
    
    private final Student[] students = new Student[30]; // Students enrolled in course
    
    private int numStudents = 0; // Number of students enrolled

    /**
     * Constructor
     * @param name Course name
     * @param description Course description
     */
    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Get course name
     * @return Course name
     */
    public String getName() {
        return name;
    }

    /**
     * Get course description
     * @return Course description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get course teacher
     * @return Course teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Get number of students enrolled
     * @return Number of enrolled students
     */
    public int getNumStudents() {
        return numStudents;
    }

    /**
     * Get enrolled students
     * @return Array containing data for all enrolled students.
     *  Some entries may be null if there are still spaces available in the course.
     */
    public Student[] getStudents() {
        return students;
    }
    
    /**
     * Get data for enrolled student
     * @param id The student's ID
     * @return The data for the enrolled student, or null if not found.
     */
    public Student getStudent(String id) {
        for (int i = 0; i < this.numStudents; i++) {
            if (this.students[i].getId().equals(id)) {
                return this.students[i];
            }
        }
        
        return null;
    }
    
    /**
     * Enroll a student in the course
     * @param student Data for the student to enroll
     */
    public void addStudent(Student student) {
        this.students[this.numStudents] = student;
        this.numStudents++;
    }
}
