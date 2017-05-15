# p3-0 Object Oriented Programming Practice

All of the questions in this practice set involve modifying the Test Result System we wrote in class.  The code we covered has been provided for you in the accompanying NetBeans project.

1. Update Course::addStudent as follows:
 * Before adding the new student to the array, check to make sure the student ID does not already exist
 * Change the return type of the method from *void* to *boolean*
   * If the student ID did not exist, add the student to the array and return **true**
   * If the student ID already exists, do not add the student and return **false**
 * In TestResultSystem::addStudent, check the return value of the course.addStudent call and if the result is **false**, print out and "Invalid input" message to the console

2. Update Course::addStudent and Student::addTestResult as follows:
 * Change the return type of the method from *void* to *boolean* (if you did question 1 above, then this is already done for Course::addStudent)
 * All elements in the respective array are filled, then we cannot add the student/result so we return **false**
   * If there is space in the array for the addition, we can update the array and return **true**
 * Update the necessary calls in TestResultSystem so that we check the returned value Course::addStudent and Student::addTestResult (outputting a message like "Course is full" or "No more test results allowed" if the value is **false**)

3. Add a method to the Student class called getAverage, which calculates and returns the student's average score on their recorded tests.  As a first attempt, assume the weights of all test results is 1.  As a challenge, take the result's weight into account when calculating the average.  You would do that as follows:

```
average =      weight of test 1                              weight of test 2    
          ------------------------- x score of test 1 + ------------------------- x score of test 2 + ...
          total weight of all tests                     total weight of all tests
```

Once your getAverage has been added, add another command line option to TestResultSystem to ask for a student's ID and output their average.

4. Add an option to TestResultSystem to read in student data from a text file.  The file can be called "studentData.txt" and contain lines like the following:

```
26489 David 26
6539 Jim 21
892677 Denise 24
...
```

Your program should read in the file and enroll all of the students in the file.

5. Update the TestResultSystem program to support more that one course (say max of 5).  One way to do this is to introduce a new class called *Catalog*, which contains a Course array.  This class can have methods to add a course, get the array or courses etc.  A new command line option should be added to "add a course", and the existing option for adding a student should be updated to take a course ID as well.

6. Update the Course class as follows:
 * Add a new string field called *subject*
 * Update the Course constructor by adding an additional *subject* parameter
 * Change the return type of the setTeacher method from void to boolean
 * Update the implementation of setTeacher to check which subjects the teacher can teach:
   * If the course's subject is in the teacher's list, allow the update to happen and return **true**
   * If the course's subject is not in the teacher's list, do not allow the update to happen and return **false**

Once those updates have been made, add a command line option in TestResultSystem to assign a teacher to a course.
