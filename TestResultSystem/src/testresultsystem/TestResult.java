package testresultsystem;

/**
 * TestResult represents the score a student received on a test.
 * Class also contains a test's weight towards their final mark.
 * 
 * @author cgallinaro
 */
public class TestResult {
    
    private final double score; // Test score
    
    private final int weight; // Weight towards average

    /**
     * Constructor
     * @param score Test score
     * @param weight Weight towards average
     */
    public TestResult(double score, int weight) {
        this.score = score;
        this.weight = weight;
    }

    /**
     * Constructor
     * Test result had a weight of 1
     * @param score Test score
     */
    public TestResult(double score) {
        this.score = score;
        this.weight = 1;
    }

    /**
     * Get the test score
     * @return Test's score
     */
    public double getScore() {
        return score;
    }

    /**
     * Get the weight of the test
     * @return Test's weight
     */
    public int getWeight() {
        return weight;
    }
    
}
