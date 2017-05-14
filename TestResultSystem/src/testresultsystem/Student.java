package testresultsystem;

/**
 * Student represents all students enrolled at the school.
 * This class extends the Person class and stores all test results for the student.
 * 
 * @author cgallinaro
 */
public class Student extends Person {
    
    private TestResult[] results = new TestResult[10]; // Stores test results for the student
    
    private int numResults = 0; // Number of stored test results

    /**
     * Constructor
     * @param id Student's id
     */
    public Student(String id) {
        super(id);
    }

    /**
     * Constructor
     * @param id Student's id
     * @param name Student's name
     * @param age Student's age
     */
    public Student(String id, String name, int age) {
        super(id, name, age);
    }
    
    /**
     * Get all test results for the student
     * @return Array containing all test results.
     *  Some test result entries may be null if an entry has not been added for it yet.
     */
    public TestResult[] getTestResults() {
        return results;
    }

    /**
     * Get number of test results recorded
     * @return Number of recorded test results
     */
    public int getNumTestResults() {
        return numResults;
    }
    
    /**
     * Record a test result for this student
     * @param result Test result to record
     */
    public void addTestResult(TestResult result) {
        this.results[this.numResults] = result;
        this.numResults++;
    }
    
    /**
     * Get a particular test result
     * @param testNumber The test result to retrieve
     * @return The requested test result, or null if not found.
     */
    public TestResult getTestResult(int testNumber) {
        if (testNumber >= 0 && testNumber < this.numResults) {
            return this.results[testNumber];
        } else {
            return null;
        }
    }
    
}