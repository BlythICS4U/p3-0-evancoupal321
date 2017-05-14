package testresultsystem;

/**
 * Teacher represents an instructor affiliated with the school.
 * Class extends the Person class and additionally stores the subjects the instructor can teach.
 * 
 * @author cgallinaro
 */
public class Teacher extends Person {
    
    private String[] subjects; // Possible subjects the instructor can teach

    /**
     * Constructor
     * @param id Teacher's id 
     * @param subjects Subjects taught by this teacher
     */
    public Teacher(String id, String[] subjects) {
        super(id);
        this.subjects = subjects;
    }

    /**
     * Constructor
     * @param id Teacher's id 
     * @param name Teacher's name
     * @param age Teacher's age
     * @param subjects Subjects taught by this teacher
     */
    public Teacher(String id, String name, int age, String[] subjects) {
        super(id, name, age);
        this.subjects = subjects;
    }
    
    /**
     * Get all subjects taught by this teacher
     * @return Array containing all subjects taught by this teacher
     */
    public String[] getSubjects() {
        return subjects;
    }

    /**
     * Update the subjects taught by this teacher
     * @param subjects The new array of subjects
     */
    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}