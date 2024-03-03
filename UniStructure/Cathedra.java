/*
class Cathedra is a class that contains the name of the cathedra, the list of teachers and the list of students.
The class has the following methods:
- addStudent() - adds a student to the list of students
- addTeacher() - adds a teacher to the list of teachers
- deleteStudent() - deletes a student from the list of students
- deleteTeacher() - deletes a teacher from the list of teachers
- editStudent() - edits a student from the list of students
- editTeacher() - edits a teacher from the list of teachers
- getStudents() - returns the list of students
- getTeachers() - returns the list of teachers
- toString() - returns the name of the cathedra

The class also has a constructor that takes the name of the cathedra as a parameter.

@files: Cathedra.java, Faculty.java, Student.java, Teacher.java, DataInput.java, Main.java
 */

package UniStructure;

import Extends.DataInput;
import Members.Student;
import Members.Teacher;

public class Cathedra {
    private String name;
    private Teacher[] teachers;
    private Teacher teacher;
    private Student student;
    private Student[] students;

    /**
     * constructor for a cathedra
     *
     * @param name
     */
    public Cathedra(String name) {
        this.name = name;
        this.teachers = new Teacher[0];
        this.students = new Student[0];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * adds a student to the list of students
     */
    public void addStudent() {
        Student[] newStudents = new Student[students.length + 1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        student = new Student();
        newStudents[students.length] = student.createStudent();
        this.students = newStudents;
    }

    public void addDefStudent(String name, int course, int group) {
        Student[] newStudents = new Student[students.length + 1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        newStudents[students.length] = new Student(name, course, group);
        this.students = newStudents;
    }

    public void addDefTeacher(String name, String discipline) {
        Teacher[] newTeachers = new Teacher[teachers.length + 1];
        System.arraycopy(teachers, 0, newTeachers, 0, teachers.length);
        newTeachers[teachers.length] = new Teacher(name, discipline);
        this.teachers = newTeachers;
    }

    public static void addDef() {
        Faculty getFI = University.faculties[0];
        Faculty getFPVN = University.faculties[1];

        Cathedra getMath = getFI.cathedras[0];
        Cathedra getProgramming = getFI.cathedras[1];
        Cathedra getDushno = getFI.cathedras[2];
        Cathedra getPravo = getFPVN.cathedras[0];
        Cathedra getLivo = getFPVN.cathedras[1];

        getDushno.addDefStudent("Nazar Stepanenko", 1, 1);
        getProgramming.addDefStudent("Dog Patron", 2, 2);
        getProgramming.addDefStudent("Cat Power", 3, 3);
        getMath.addDefStudent("Канекі кен", 2, 4);
        getMath.addDefStudent("Курт кобейн", 2, 5);
        getMath.addDefStudent("Cher Baguette", 2, 6);

        getProgramming.addDefTeacher("Thom Yorke", "Radiotechnics");
        getProgramming.addDefTeacher("Anastasiia Hrysiuk", "Swift");
        getProgramming.addDefTeacher("Billy Jean", "OOP");
        getProgramming.addDefTeacher("Michael Jackson", "Electronics");

        getPravo.addDefStudent("Максим Баришов", 4, 1);
        getPravo.addDefStudent("Віталій Корсунов", 4, 1);
        getLivo.addDefStudent("Їгор Лісовий", 4, 1);

    }

    /**
     * adds a teacher to the list of teachers
     */
    public void addTeacher() {
        Teacher[] newTeachers = new Teacher[teachers.length + 1];
        System.arraycopy(teachers, 0, newTeachers, 0, teachers.length);
        teacher = new Teacher();
        newTeachers[teachers.length] = teacher.createTeacher();
        this.teachers = newTeachers;
    }

    /**
     * deletes a student from the list of students
     */
    public void deleteStudent() {
        if (students.length == 0) {
            System.out.println("There are no students to delete.");
        } else {
            showStudents();
            int index;
            do {
                index = DataInput.getInt("Enter the index of the student you want to delete: ");
            } while (index < 0 || index >= students.length);
            Student[] newStudents = new Student[students.length - 1];
            for (int i = 0, j = 0; i < students.length; i++) {
                if (i != index) {
                    newStudents[j++] = students[i];
                }
            }
            this.students = newStudents;
        }
    }

    /**
     * deletes a teacher from the list of teachers
     */
    public void deleteTeacher() {
        if (teachers.length == 0) {
            System.out.println("There are no teachers to delete.");
        } else {
            showTeachers();
            int index;
            do {
                index = DataInput.getInt("Enter the index of the teacher you want to delete: ");
            } while (index < 0 || index >= teachers.length);
            Teacher[] newTeachers = new Teacher[teachers.length - 1];
            for (int i = 0, j = 0; i < teachers.length; i++) {
                if (i != index) {
                    newTeachers[j++] = teachers[i];
                }
            }
            this.teachers = newTeachers;
        }
    }

    /**
     * getter for students
     *
     * @return students
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * getter for teachers
     *
     * @return teachers
     */
    public Teacher[] getTeachers() {
        return teachers;
    }

    /**
     * edits a student from the list of students
     */
    public void editStudent() {
        if (students.length == 0) {
            System.out.println("There are no students to edit.");
        } else {
            int course;
            int group;
            int repeat;
            do {
                showStudents();
                int index;
                do {
                    index = DataInput.getInt("enter the index of the student you want to edit: ");
                } while (index < 0 || index >= students.length);
                String change;
                do {
                    change = DataInput.getString("enter what you want to change: ");
                }
                while (!change.equals("name") && !change.equals("course") && !change.equals("group"));
                switch (change) {
                    case "name":
                        String name = DataInput.getString("Enter pib: ");
                        this.students[index].setFullName(name);
                        break;
                    case "course":
                        do {
                            course = DataInput.getInt("enter the new course: ");
                        } while (course < 1 || course > 6);
                        this.students[index].setCourse(course);
                        break;
                    case "group":
                        group = DataInput.getInt("enter the new group: ");
                        this.students[index].setGroup(group);
                        break;
                }
                repeat = DataInput.getInt("press 0 to change something else, press anything else to continue: ");
                if (repeat != 0) break;
            } while (true);
        }

    }

    /**
     * edits a teacher from the list of teachers
     */
    public void editTeacher() {
        int repeat;
        do {
            showTeachers();
            int index;
            do {
                index = DataInput.getInt("enter the index of the teacher you want to edit: ");
            } while (index < 0 || index >= teachers.length);
            String change;
            do {
                change = DataInput.getString("enter what you want to change: ");
            }
            while (!change.equals("name") && !change.equals("discipline"));
            switch (change) {
                case "name":
                    String name = DataInput.getString("Enter pib: ");
                    this.teachers[index].setFullName(name);
                    break;
                case "discipline":
                    String discipline = DataInput.getString("Enter discipline: ");
                    this.teachers[index].setDiscipline(discipline);
                    break;
            }
            repeat = DataInput.getInt("press 0 to change something else, press anything else to continue: ");
            if (repeat != 0) break;
        } while (true);
    }


    public void showStudents() {
        System.out.println("list of students of " + name + ":\n");
        if (students.length != 0) {
            for (Student student : students) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("Unfortunately, there are no students.\n");
        }
    }

    public void showTeachers() {
        System.out.println("list of teachers of " + name + ":\n");
        if (teachers.length != 0) {
            for (Teacher teacher : teachers) {
                System.out.println(teacher.toString());
            }
        } else {
            System.out.println("Unfortunately, there are no teachers.\n");
        }
    }

    public Cathedra getCathedra() {
        return this;
    }

    @Override
    public String toString() {
        return name + "\n ";
    }
}
