package testresultsystem;

/**
 * Person represents all possible people affiliated with the school.
 * Class contains school identification number and other meta data.
 * 
 * @author cgallinaro
 */
public class Person {
    
    private final String id;  // School identifier
    
    private String name; // Person's name
    
    private int age; // Person's age

    /**
     * Constructor
     * @param id
     */
    public Person(String id) {
        this.id = id;
    }

    /**
     * Constructor
     * @param id
     * @param name
     * @param age
     */
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    /**
     * Get the person's school identifier
     * @return Person's id
     */
    public String getId() {
        return id;
    }

    /**
     * Get the person's name
     * @return Person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the person's name
     * @param name Person's new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the person's age
     * @return Person's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the person's age
     * @param age Person's new age
     */
    public void setAge(int age) {
        this.age = age;
    }
    
}