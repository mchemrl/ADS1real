/*
    files: Teacher.java, Person.java, DataInput.java, Main.java

    this class extends Person class and has the following field discipline.
    it contains setters, getters, a toString method, methods to add/delete/change.
 */

package Members;

import Extends.DataInput;

public class
Teacher extends Person {
    private String discipline;

    public static Teacher[] teachers = new Teacher[0];


    /**
     * constructor for a teacher
     *
     * @param fullname   full name
     * @param discipline discipline
     */
    public Teacher(String fullname, String discipline) {
        super(fullname);
        this.discipline = discipline;
    }

    /**
     * default constructor
     */
    public Teacher() {
        this("undefined name", "undefined discipline");
    }

    /**
     * getter for discipline
     *
     * @return discipline
     */
    public String getDiscipline() {
        return discipline;
    }

    /**
     * setter for discipline
     *
     * @param discipline discipline
     */
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    /**
     * create a new teacher
     */
    public Teacher createTeacher() {
        String name  = DataInput.getString("enter full name: ");
        String discipline = DataInput.getString("enter discipline: ");
        Teacher teacher = new Teacher(name, discipline);
        Teacher[] newTeachers = new Teacher[ teachers.length + 1];
        System.arraycopy(teachers, 0, newTeachers, 0, teachers.length);
        newTeachers[teachers.length] = teacher;
        teachers = newTeachers;
        return teacher;
    }

    /**
     * show all the teachers
     */

    public static void showTeachers() {
        System.out.println("list of teacher:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }


    /**
     * to string method
     *
     * @return string with teachers data
     */
    @Override
    public String toString() {
        return "teacher " + fullName + ", discipline - " + discipline;
    }

}
