/*
    files: Student.java, Person.java, DataInput.java, Main.java

    this class extends Person class and has the following fields: course, group, specialty.
    it contains setters, getters, a toString method, methods to add/delete/change.
 */

package Members;

import Extends.DataInput;

public class Student extends Person {
    private int course;
    private int group;

    public static Student[] students = new Student[0];


    /**
     * constructor for a student
     *
     * @param fullname full name
     * @param course   course
     * @param group    group
     */
    public Student(String fullname, int course, int group) {
        super(fullname);
        this.course = course;
        this.group = group;
    }

    /**
     * default constructor
     */
    public Student() {
        this("undefined name", 0, 0);
    }


    /**
     * getter for course
     *
     * @return course
     */
    public int getCourse() {
        return course;
    }

    /**
     * getter for group
     *
     * @return group
     */
    public int getGroup() {
        return group;
    }

    /**
     * setter for course
     *
     * @param course course
     */
    public void setCourse(int course) {
        if (course > 0 && course <= 6) {
            this.course = course;
        } else {
            System.out.println("course can be only in range of 1 to 6");
            setCourse(DataInput.getInt("enter the new course: "));
        }
    }

    /**
     * setter for group
     *
     * @param group group
     */
    public void setGroup(int group) {

        if (group > 0 && group <= 10) {
            this.group = group;
        } else {
            System.out.println("group can be only in range of 1 to 10");
        }
    }

    /**
     * create a new student
     */
    public Student createStudent() {
        Student student = new Student();
        String name = DataInput.getString("Enter pib: ");
        student.setFullName(name);
        int course = DataInput.getInt("enter the course: ");
        student.setCourse(course);
        int group;
        do{
        group = DataInput.getInt("enter the group: ");}
        while (group < 1 || group > 10);
        student.setGroup(group);
        Student[] newStudents = new Student[students.length + 1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        newStudents[students.length] = student;
        students = newStudents;
        return student;
    }

    /**
     * to string method
     *
     * @return string with students data
     */
    @Override
    public String toString() {
        return "student " + fullName + ", " + course + " course" + ", group " + group;
    }

}

