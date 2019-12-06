/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testresultsystem;

/**
 *
 * @author User
 */
public class Catalog
{
    private Course[] courses = new Course[5];
    private int numCourses = 0;
    
    public Catalog()
    {
    }
    
    /**
     * Add a course to the catalog
     * @param name name of the course
     * @param description description of the course
     * @param subject subject of the course
     * @return true if catalog is not full and course addition was successful, false if not
     */
    public boolean addCourse(String name, String description, String subject)
    {
        Course course = new Course(name, description, subject);
        if (this.numCourses >= 5)
        {
            return false;
        }
        else
        {
            this.courses[this.numCourses] = course; 
            numCourses++;
            return true;
        }
        
    }
    
    /**
     * Get a course from the catalog
     * @param name The name of the course
     * @return The full course
     */
    public Course getCourse(String name)
    {
        for (int i = 0; i < 5; i++)
        {
            if (this.courses[i] != null)
            {
                if (this.courses[i].getName().equals(name))
                {
                    return this.courses[i];
                }
            }
        }
        return null;
    }
    public Course getCourseNum(int num)
    {
        return this.courses[num];
    }
    
    /**
     * Set a teacher to a course in the catalog
     * @param teacher The teacher you want to set
     * @param name The name of the course you want to set
     */
    public void setTeacher(Teacher teacher, String name)
    {
        Course course = getCourse(name);
        course.setTeacher(teacher);
    }
}
