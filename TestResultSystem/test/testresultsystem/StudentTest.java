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
public class StudentTest {

    /**
     * Test of getTestResults method, of class Student.
     */
    @Test
    public void testGetTestResults() {
        System.out.println("getTestResults");
        Student student = new Student("001", "name", 16);
        TestResult[] expResult = new TestResult[10];
        for (int i = 0; i < 3; i++)
        {
            expResult[i] = new TestResult(100 - 3*i, i);
            student.addTestResult(expResult[i]);
        }
        TestResult[] result = student.getTestResults();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getNumTestResults method, of class Student.
     */
    @Test
    public void testGetNumTestResults() {
        System.out.println("getNumTestResults");
        Student student = new Student("001", "name", 16);
        TestResult[] results = new TestResult[10];
        for (int i = 0; i < 3; i++)
        {
            results[i] = new TestResult(100 - 3*i, i);
            student.addTestResult(results[i]);
        }
        int expResult = 0;
        for (int i = 0; i < results.length; i++)
        {
            if (results[i] != null)
            {
                expResult++;
            }
        }        
        int result = student.getNumTestResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of addTestResult method, of class Student.
     */
    @Test
    public void testAddTestResult() {
        System.out.println("addTestResult");
        TestResult testResult = new TestResult(90, 1);
        Student student = new Student("001", "name", 16);
        boolean result1 = student.addTestResult(testResult);
        for (int i = 0; i < 9; i++)
        {
            student.addTestResult(testResult);
        }
        boolean result2 = student.addTestResult(testResult);
        assertTrue(result1);
        assertFalse(result2);
    }

    /**
     * Test of getTestResult method, of class Student.
     */
    @Test
    public void testGetTestResult() {
        System.out.println("getTestResult");
        Student student = new Student("001", "name", 16);
        TestResult[] expResult = new TestResult[3];
        for (int i = 0; i < 3; i++)
        {
            expResult[i] = new TestResult(100 - 3*i, i);
            student.addTestResult(expResult[i]);
        }
        TestResult expResult1 = expResult[0];
        TestResult expResult2 = expResult[1];
        TestResult expResult3 = expResult[2];
        TestResult result1 = student.getTestResult(0);
        TestResult result2 = student.getTestResult(1);
        TestResult result3 = student.getTestResult(2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of getAverage method, of class Student.
     */
    @Test
    public void testGetAverage() {
        System.out.println("getAverage");
        Student student = new Student("001", "name", 16);
        TestResult[] results = new TestResult[3];
        for (int i = 0; i < 3; i++)
        {
            results[i] = new TestResult(100 - 3*i, i+1);
            student.addTestResult(results[i]);
        }
        double result = student.getAverage();
        assertEquals(96, result, 0.0);
    }
    
}
