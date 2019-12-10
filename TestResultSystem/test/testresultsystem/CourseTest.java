/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testresultsystem;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CourseTest {

    /**
     * Test of getName method, of class Course.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Course course = new Course("name", "description", "subject");
        String expResult = "name";
        String result = course.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Course.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Course course = new Course("name", "description", "subject");
        String expResult = "description";
        String result = course.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTeacher method, of class Course.
     */
    @Test
    public void testGetTeacher() {
        System.out.println("getTeacher");
        Course course = new Course("name", "description", "CS");
        Teacher expResult = new Teacher("007", "Chris", 35, new String[]{"CS", "Math", "Physics"});
        course.setTeacher(expResult);
        Teacher result = course.getTeacher();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTeacher method, of class Course.
     */
    @Test
    public void testSetTeacher() {
        System.out.println("setTeacher");
        Course course = new Course("name", "description", "subject");
        Teacher teacher1 = new Teacher("007", "Chris", 35, new String[]{"CS", "Math", "subject"});
        Teacher teacher2 = new Teacher("008", "Dave", 36, new String[]{"CS", "Math", "Physics"});
        boolean result1 = course.setTeacher(teacher1);
        boolean result2 = course.setTeacher(teacher2);
        assertTrue(result1);
        assertFalse(result2);
    }

    /**
     * Test of getNumStudents method, of class Course.
     */
    @Test
    public void testGetNumStudents() {
        System.out.println("getNumStudents");
        Course course = new Course("name", "description", "subject");
        Student student = new Student("001", "name", 16);
        int expResult1 = 0;
        int expResult2 = 1;
        int result1 = course.getNumStudents();
        course.addStudent(student);
        int result2 = course.getNumStudents();
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getStudents method, of class Course.
     */
    @Test
    public void testGetStudents() {
        System.out.println("getStudents");
        Course course = new Course("name", "description", "subject");
        Student student1 = new Student("001", "name1", 16);
        Student student2 = new Student("002", "name2", 16);
        Student student3 = new Student("003", "name3", 16);
        Student student4 = new Student("004", "name4", 16);
        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);
        course.addStudent(student4);
        Student[] expResult = new Student[30];
        expResult[0] = student1;
        expResult[1] = student2;
        expResult[2] = student3;
        expResult[3] = student4;
        Student[] result = course.getStudents();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getStudent method, of class Course.
     */
    @Test
    public void testGetStudent() {
        System.out.println("getStudent");
        Course course = new Course("name", "description", "subject");
        Student student1 = new Student("001", "name1", 16);
        Student student2 = new Student("002", "name2", 16);
        Student student3 = new Student("003", "name3", 16);
        Student student4 = new Student("004", "name4", 16);
        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);
        course.addStudent(student4);
        Student result1 = course.getStudent("001");
        Student result2 = course.getStudent("002");
        Student result3 = course.getStudent("003");
        Student result4 = course.getStudent("004");
        assertEquals(student1, result1);
        assertEquals(student2, result2);
        assertEquals(student3, result3);
        assertEquals(student4, result4);
    }

    /**
     * Test of addStudent method, of class Course.
     */
    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        Student student = new Student("001", "name", 16);
        Course course = new Course("name", "description", "subject");
        boolean result1 = course.addStudent(student);
        boolean result2 = course.addStudent(student);
        assertTrue(result1);
        assertFalse(result2);
    }
    
}
