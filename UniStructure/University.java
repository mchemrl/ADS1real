/*
 * This class is the main class of the program. It contains the main method and the main menu of the program.
 * The class has the following methods:
 * - addFaculty() - adds a faculty to the list of faculties
 * - deleteFaculty() - deletes a faculty from the list of faculties
 * - editFaculties() - edits a faculty from the list of faculties
 * - showFaculties() - shows the list of faculties
 * - addCathedra() - adds a cathedra to the list of cathedras
 * - deleteCathedra() - deletes a cathedra from the list of cathedras
 * - editCathedra() - edits a cathedra from the list of cathedras
 * - showCathedra() - shows the list of cathedras
 * - addStudent() - adds a student to the list of students
 * - deleteStudent() - deletes a student from the list of students
 * - editStudent() - edits a student from the list of students
 * - showStudents() - shows the list of students
 * - addTeacher() - adds a teacher to the list of teachers
 * - deleteTeacher() - deletes a teacher from the list of teachers
 * - editTeacher() - edits a teacher from the list of teachers
 * - showTeachers() - shows the list of teachers
 * - studentArray() - returns the list of students
 * - teacherArray() - returns the list of teachers
 * - showAllStudents() - shows the list of all students
 * - showAllTeachers() - shows the list of all teachers
 * - sortedByCourse() - sorts the list of students by course
 * - number5() - shows the list of students sorted by course
 * - number7() - shows the list of students sorted by course
 * - findStudent() - finds a student by name, course or group
 * - findStudentByName() - finds a student by name
 * - findStudentByCourse() - finds a student by course
 * - findStudentByGroup() - finds a student by group
 * - task9() - shows the list of students of a certain course
 * - task10() - shows the list of students of a certain course sorted by name

 */
package UniStructure;

import Extends.DataInput;
import Members.Student;
import Members.Teacher;

import java.util.Arrays;

public class University {
    public Student[] students;
    public Teacher[] teachers;
    public static String name;

    public University(String name) {
        this.name = name;
    }

    public static Faculty[] faculties = new Faculty[2];

    static {
        Faculty fi = new Faculty("FI");
        faculties[0] = fi;
        Faculty fpvn = new Faculty("FPVN");
        faculties[1] = fpvn;
    }

    //add faculty to the array of University
    public static void addFaculty() {
        String name = DataInput.getString("enter the name of the faculty: ");
        Faculty[] newFaculties = new Faculty[faculties.length + 1];
        System.arraycopy(faculties, 0, newFaculties, 0, faculties.length);
        Faculty faculty = new Faculty(name);
        newFaculties[faculties.length] = faculty;
        faculties = newFaculties;
    }

    //delete faculty from the array of University
    public static void deleteFaculty() {
        if (faculties.length == 0) {
            System.out.println("There are no faculties to delete");
        } else {
            showFaculties();
            int index;
            do {
                index = DataInput.getInt("Enter the index of the faculty you want to delete: ");
            } while (index < 0 || index >= faculties.length);
            Faculty[] newFaculties = new Faculty[faculties.length - 1];
            for (int i = 0, j = 0; i < faculties.length; i++) {
                if (i != index) {
                    newFaculties[j++] = faculties[i];
                }
            }
            faculties = newFaculties;
        }
    }

    //edit faculty from the array of University
    public static void editFaculties() {
        if (faculties.length == 0) {
            System.out.println("There are no faculties to edit");
        } else {
            showFaculties();
            int index;
            do {
                index = DataInput.getInt("enter the index of the faculty you want to edit: ");
            } while (index < 0 || index >= faculties.length);
            String name = DataInput.getString("enter the new name: ");
            faculties[index].setName(name);
        }
    }

    //select faculty
    public static Faculty selectFaculty() {
        if (faculties.length == 0) {
            System.out.println("There are no faculties to work with");
            return null;
        } else {
            showFaculties();
            int index;
            do {
                index = DataInput.getInt("enter the index of the faculty you want to work with: ");
            } while (index < 0 || index >= faculties.length);
            return faculties[index];
        }
    }

    //add cathedra
    public static void addCathedra() {
        selectFaculty().addCathedra();
    }

    //delete cathedra
    public static void deleteCathedra() {
        selectFaculty().deleteCathedra();
    }

    //edit cathedra
    public static void editCathedra() {
        selectFaculty().editCathedra();
    }

    //show the list of cathedras
    public static void showCathedra() {
        selectFaculty().showCathedra();
    }

    //add student
    public static void addStudent() {
        selectFaculty().selectCathedra().addStudent();
    }

    //delete student
    public static void deleteStudent() {
        selectFaculty().selectCathedra().deleteStudent();
    }

    //edit student
    public static void editStudent() {
        selectFaculty().selectCathedra().editStudent();
    }

    //show the list of students
    public static void showStudents() {
        selectFaculty().selectCathedra().showStudents();
    }

    //add teacher
    public static void addTeacher() {
        selectFaculty().selectCathedra().addTeacher();
    }

    //delete teacher
    public static void deleteTeacher() {
        selectFaculty().selectCathedra().deleteTeacher();
    }

    //edit teacher
    public static void editTeacher() {
        selectFaculty().selectCathedra().editTeacher();
    }

    //show the list of teachers
    public static void showTeachers() {
        selectFaculty().selectCathedra().showTeachers();
    }

    //return the list of students
    public static Student[] studentArray() {
        int totalStudents = 0;
        for (Faculty faculty : faculties) {
            totalStudents += studentsOfFaculty(faculty).length;
        }

        Student[] newArray = new Student[totalStudents];
        int index = 0;
        for (Faculty faculty : faculties) {
            Student[] students = studentsOfFaculty(faculty);
            System.arraycopy(students, 0, newArray, index, students.length);
            index += students.length;
        }
        return newArray;
    }

    //return the list of teachers
    public static Teacher[] teacherArray() {
        int totalTeachers = 0;
        for (Faculty faculty : faculties) {
            totalTeachers += teachersOfFaculty(faculty).length;
        }
        Teacher[] newArray = new Teacher[totalTeachers];
        int index = 0;
        for (Faculty faculty : faculties) {
            Teacher[] teachers = teachersOfFaculty(faculty);
            System.arraycopy(teachers, 0, newArray, index, teachers.length);
            index += teachers.length;
        }
        return newArray;
    }

    // make a new array of teachers from the array of faculties
    public static Teacher[] teachersOfFaculty(Faculty faculty) {
        int totalTeachers = 0;
        for (Cathedra cathedra : faculty.getCathedras()) {
            totalTeachers += cathedra.getTeachers().length;
        }
        Teacher[] newArray = new Teacher[totalTeachers];
        int index = 0;
        for (Cathedra cathedra : faculty.getCathedras()) {
            Teacher[] teachers = cathedra.getTeachers();
            System.arraycopy(teachers, 0, newArray, index, teachers.length);
            index += teachers.length;
        }
        return newArray;
    }

    // make a new array of students from the array of faculties
    public static Student[] studentsOfFaculty(Faculty faculty) {
        int totalStudents = 0;
        for (Cathedra cathedra : faculty.getCathedras()) {
            totalStudents += cathedra.getStudents().length;
        }
        Student[] newArray = new Student[totalStudents];
        int index = 0;
        for (Cathedra cathedra : faculty.getCathedras()) {
            Student[] students = cathedra.getStudents();
            System.arraycopy(students, 0, newArray, index, students.length);
            index += students.length;
        }
        return newArray;
    }


    //show the list of all students
    public static void showAllStudents() {
        Student[] students = studentArray();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    //show the list of all teachers
    public static void showAllTeachers() {
        Teacher[] teachers = teacherArray();
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }

    //show the list of students sorted by course
    public static void number5() {
        sortedByCourse(studentArray());
    }

    //sort the students by course
    public static void sortedByCourse(Student[] students) {
        for (int i = 0; i < studentArray().length - 1; i++) {
            for (int j = 0; j < studentArray().length - i - 1; j++) {
                int course1 = students[j].getCourse();
                int course2 = students[j + 1].getCourse();
                if (course1 > course2) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }


    }

    //show the list of students sorted by course
    public static void number7() {
        Student[] students = selectFaculty().selectCathedra().getStudents();
        sortedByCourse(students);
    }


    //find student by name, course or group
    public String findStudent() {
        //ask if you want to find student by name or by course, or group
        String choice;
        do {
            choice = DataInput.getString("do you want to find student by name, course or group?");
        }
        while (!choice.equals("name") && !choice.equals("course") && !choice.equals("group"));
        if (choice.equals("name")) {
            return findStudentByName();
        } else if (choice.equals("course")) {
            return findStudentByCourse();
        } else if (choice.equals("group")) {
            return findStudentByGroup();
        }
        return " ";
    }

    // this method is used to find a teacher by name or discipline
    public String findTeacher() {
        //ask if you want to find teacher by name or by discipline
        String choice;
        do {
            choice = DataInput.getString("do you want to find teacher by name or discipline?");
        }
        while (!choice.equals("name") && !choice.equals("discipline"));
        if (choice.equals("name")) {
            return findTeacherByName();
        } else if (choice.equals("discipline")) {
            return findTeacherByDiscipline();
        }
        return " ";
    }

    //find teacher by name
    public static String findTeacherByName() {
        String name = DataInput.getString("enter the name of the person you want to find: ");
        name = name.toLowerCase();
        boolean found = false;
        for (Faculty faculty : faculties) {
            for (Cathedra department : faculty.cathedras) {
                for (Teacher p : department.getTeachers()) {
                    if (name.equals(p.getFullName().toLowerCase())) {
                        System.out.println("faculty: " + faculty.getFaculty() + ", department: " + department.getCathedra() + ", name: " + p.getFullName() + ", discipline: " + p.getDiscipline());
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            return "unfortunately, there is no teacher with such name\n";
        } else return " ";
    }

    //find teacher by discipline
    public static String findTeacherByDiscipline() {
        boolean found = false;
        String discipline = DataInput.getString("enter the discipline of the person you want to find: ");
        for (Faculty faculty : faculties) {
            for (Cathedra department : faculty.cathedras) {
                for (Teacher p : department.getTeachers()) {
                    if (discipline.equals(p.getDiscipline())) {
                        System.out.println("faculty: " + faculty.getName() + ", department: " + department.getName() + "name: " + p.getFullName() + ", discipline: " + p.getDiscipline());
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            return "unfortunately, there is no teacher with such discipline\n";
        } else return " ";
    }

    //find student by name
    public static String findStudentByName() {
        String name = DataInput.getString("enter the name of the person you want to find: ");
        boolean found = false;
        name = name.toLowerCase();
        for (Faculty faculty : faculties) {
            for (Cathedra department : faculty.cathedras) {
                for (Student p : department.getStudents()) {
                    //case insensitive
                    if (name.equals(p.getFullName().toLowerCase())) {
                        System.out.println("faculty: " + faculty.getName() + ", department: " + department.getName() + ", name: " + p.getFullName() + ", course: " + p.getCourse() + ", group: " + p.getGroup());
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            found = false;
            return "unfortunately, there is no student with such name\n";
        } else return " ";
    }

    //find student by course
    public static String findStudentByCourse() {
        boolean found = false;
        int course = DataInput.getInt("enter the course of the person you want to find: ");
        for (Faculty faculty : faculties) {
            for (Cathedra department : faculty.cathedras) {
                for (Student p : department.getStudents()) {
                    if (course == p.getCourse()) {
                        System.out.println("faculty: " + faculty.getFaculty() + ", department: " + department.getCathedra() + "name: " + p.getFullName() + ", course: " + p.getCourse() + ", group: " + p.getGroup());

                        found = true;
                    }
                }
            }
        }
        if (!found) {
            return "unfortunately, there is no student with such course\n";
        } else return " ";
    }

    //find student by group
    public static String findStudentByGroup() {
        boolean found = false;
        int group = DataInput.getInt("enter the group of the person you want to find: ");
        for (Faculty faculty : faculties) {
            for (Cathedra department : faculty.cathedras) {
                for (Student p : department.getStudents()) {
                    if (group == p.getGroup()) {
                        System.out.println("faculty: " + faculty.getFaculty() + ", department: " + department.getCathedra() + "name: " + p.getFullName() + ", course: " + p.getCourse() + ", group: " + p.getGroup());
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            return "Unfortunately, there is no student with such group\n";
        } else return " ";
    }


    //show all the faculties
    public static void showFaculties() {
        System.out.println("\nList of faculties of " + name + ":");
        for (Faculty faculty : faculties) {
            System.out.println(faculty.toString());
        }

    }

    //show the list of students of a certain course
    public static void task9() {
        Student[] students = selectFaculty().selectCathedra().getStudents();
        boolean found = false;
        int course = DataInput.getInt("list of students of what course you are searching for?");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Unfortunately there are no students with these characteristics(");
            return;

        }


    }

    //output teachers of a certain faculty sorted by name
    public static void number6Teachers() {
        showFaculties();
        int index;
        do {
            index = DataInput.getInt("Enter the index of the faculty you want to work with: ");
        } while (index < 0 || index >= faculties.length);
        sortedTeachByAlphabet(teachersOfFaculty(faculties[index]));

    }
    //output students of a certain faculty sorted by name

    public static void number6Students() {
        showFaculties();
        int index;
        do {
            index = DataInput.getInt("Enter the index of the faculty you want to work with: ");
        } while (index < 0 || index >= faculties.length);
        sortedStudByAlphabet(studentsOfFaculty(faculties[index]));

    }


    //output teachers of a certain cathedra sorted by name
    public static void number8Teachers() {
        sortedTeachByAlphabet(selectFaculty().selectCathedra().getTeachers());

    }

    //output students of a certain cathedra sorted by name
    public static void number8Students() {
        sortedStudByAlphabet(selectFaculty().selectCathedra().getStudents());

    }

    //sort the students by name
    public static void sortedStudByAlphabet(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                String name1 = students[j].getFullName().toLowerCase();
                String name2 = students[j + 1].getFullName().toLowerCase();
                if (name1.compareTo(name2) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }


    //sort the teachers by name
    public static void sortedTeachByAlphabet(Teacher[] teachers) {
        for (int i = 0; i < teachers.length - 1; i++) {
            for (int j = 0; j < teachers.length - i - 1; j++) {
                String name1 = teachers[j].getFullName().toLowerCase();
                String name2 = teachers[j + 1].getFullName().toLowerCase();
                if (name1.compareTo(name2) > 0) {
                    Teacher temp = teachers[j];
                    teachers[j] = teachers[j + 1];
                    teachers[j + 1] = temp;
                }
            }
        }
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }

    //show the list of students of a certain course sorted by name
    public static void task10() {
        Student[] students = selectFaculty().selectCathedra().getStudents();
        boolean found = false;
        Student[] students2 = new Student[students.length];
        int course = DataInput.getInt("List of students of what course are you searching for?");
        int count = 0;
        for (Student student : students) {
            if (student.getCourse() == course) {
                students2[count++] = student;
                found = true;
            }
        }
        if (found) {
            int sorttype = DataInput.getInt("Press 1 if you want an ascending list and 2 if you want a descending one: ");
            while (sorttype != 1 && sorttype != 2) {
                sorttype = DataInput.getInt("Try again! Press 1 if you want an ascending list and 2 if you want a descending one: ");
            }
            sortStudentsNames(students2, sorttype, count);
            System.out.println("Sorted list of students:");
            for (Student sortedStudent : students2) {
                if (sortedStudent != null) {
                    System.out.println(sortedStudent.toString());
                }
            }

        } else {
            System.out.println("Unfortunately there are no students with these characteristics(");
            return;
        }
    }

    //sort the students names
    private static void sortStudentsNames(Student[] students, int sortDirection, int size) {
        if (size < 2) {
            return;
        }
        int middleIndex = size / 2;
        Student[] leftHalf = new Student[middleIndex];
        Student[] rightHalf = new Student[size - middleIndex];
        for (int i = 0; i < middleIndex; i++) {
            leftHalf[i] = students[i];
        }
        for (int i = middleIndex; i < size; i++) {
            rightHalf[i - middleIndex] = students[i];
        }
        sortStudentsNames(leftHalf, sortDirection, middleIndex);
        sortStudentsNames(rightHalf, sortDirection, size - middleIndex);
        mergeStudentsNames(students, leftHalf, rightHalf, sortDirection);
    }

    //merge the students names
    private static void mergeStudentsNames(Student[] students, Student[] leftHalf, Student[] rightHalf, int sortDirection) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (sortDirection == 1) { // Ascending
                if (leftHalf[i].getFullName().toLowerCase().compareTo(rightHalf[j].getFullName().toLowerCase()) <= 0) {
                    students[k] = leftHalf[i];
                    i++;
                } else {
                    students[k] = rightHalf[j];
                    j++;
                }
            } else { // Descending
                if (leftHalf[i].getFullName().toLowerCase().compareTo(rightHalf[j].getFullName().toLowerCase()) >= 0) {
                    students[k] = leftHalf[i];
                    i++;
                } else {
                    students[k] = rightHalf[j];
                    j++;
                }
            }
            k++;
        }
        while (i < leftSize) {
            students[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            students[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
