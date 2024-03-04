/*
* Main class wih menu for working with university
*/
import UniStructure.*;
import Extends.*;

public class Main {
    static University university;
    //л
    public static void main(String[] args) {
         university = new University("NaUKMA");
        Faculty.addDef();
        Cathedra.addDef();
        System.out.println("\n\n~~~~~MAIN MENU~~~~~\n\n");
        int n = DataInput.getInt("""
                ~Press 1 if you want to work with faculty;
                ~Press 2 if you want to work with cathedra;
                ~Press 3 if you want to work with people;
                ~Press 4 to find person by name, course or group;
                ~Press 5 to show all students sorted by course;
                ~Press 6 to show students/teachers of faculty sorted by alphabet;
                ~Press 7 to show students of cathedra sorted by course;
                ~Press 8 to show students/teachers of cathedra sorted by alphabet;
                ~Press 9 to show all students of cathedra of specified course;
                ~Press 10 to show all students of cathedra of specified course sorted by alpphabet:
                """);

        while (n != 0) {
            switch (n) {
                case 1:
                    workingWithFaculty();
                    break;
                case 2:
                    workingWithCathedra();
                    break;
                case 3:
                    workingWithPeople();
                    break;
                case 4:
                    System.out.println("\n\n~~~~~SEARCHING~~~~~\n\n");
                    int rep =1;
                    while (rep!=0) {
                    System.out.println(university.findStudent());
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue searching - any number):\n");
                    }
                    break;
                case 5:
                    rep =1;
                    while (rep!=0) {
                        University.number5();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }
                    break;
                case 6:
                    rep =1;
                    while (rep!=0) {
                        University.number6();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }
                    break;
                case 7:
                    rep =1;
                    University.showAllStudents();
                    while (rep!=0) {
                        University.number7();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }
                    break;

                case 8:
                    rep =1;
                    while (rep!=0) {
                        University.number8();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }
                    break;
                case 9:
                    rep = 1;
                    while (rep != 0) {
                        University.task9();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue searching - any number):\n");
                    }
                    break;
                case 10:
                    rep = 1;
                    while (rep != 0){
                        University.task10();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }

                    break;
                default:
                    System.out.println("\n\n!!!Unknown command.Try one more time!!!\n\n");
                    n = DataInput.getInt("""
                            ~Press 1 if you want to work with faculty;
                            Press 2 if you want to work with cathedra;
                            Press 3 if you want to work with people;
                            Press 4 to find person by name, course or group;
                            Press 5 to show all students sorted by course;
                            Press 6 to show students/teachers of faculty sorted by alphabet;
                            Press 7 to show students of cathedra sorted by course;
                            Press 8 to show students/teachers of cathedra sorted by alphabet;
                            Press 9 to show all students of cathedra of specified course;
                            Press 10 to show all students of cathedra of specified course sorted by alpphabet:
                            """);
            }
            System.out.println("\n\n~~~~~MAIN MENU~~~~~\n\n");
            n = DataInput.getInt("""
                    ~Press 1 if you want to work with faculty;
                    ~Press 2 if you want to work with cathedra;
                    ~Press 3 if you want to work with people;
                    ~Press 4 to find person by name, course or group;
                    ~Press 5 to show all students sorted by course;
                    ~Press 6 to show students/teachers of faculty sorted by alphabet;
                    ~Press 7 to show students of cathedra sorted by course;
                    ~Press 8 to show students/teachers of cathedra sorted by alphabet;
                    ~Press 9 to show all students of cathedra of specified course;
                    ~Press 10 to show all students of cathedra of specified course sorted by alpphabet;
                    (Press 0 to stop program):
                    """);
        }


    }
    private static void workingWithFaculty(){
        System.out.println("\n\n~~~~~WORKING WITH FACULTIES~~~~~\n\n");
        int fac = DataInput.getInt("""
                ~Press 1 if you want to add faculty;
                ~Press 2 if you want to delete faculty;
                ~Press 3 if you want to edit faculty;
                ~Press 4 if you want to show faculty:
                """);
        while (fac !=0){
            switch (fac){
                case 1:
                    University.addFaculty();
                    University.showFaculties();
                    break;
                case 2:
                    University.deleteFaculty();
                    University.showFaculties();
                    break;
                case 3:
                    University.editFaculties();
                    University.showFaculties();
                    break;
                case 4:
                    University.showFaculties();
                    break;
                default:
                    System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                    fac = DataInput.getInt("""
                            ~Press 1 if you want to add faculty;
                            ~Press 2 if you want to delete faculty;
                            ~Press 3 if you want to edit faculty;
                            ~Press 4 if you want to show faculty:
                            """);
            }
            System.out.println("\n\n~~~~~WORKING WITH FACULTIES~~~~~\n\n");
            fac = DataInput.getInt("""
                    ~Press 1 if you want to add faculty;
                    ~Press 2 if you want to delete faculty;
                    ~Press 3 if you want to edit faculty;
                    ~Press 4 if you want to show faculty;
                    (Press 0 if you want to stop working with faculty and return to the main menu):
                    """);
        }
    }

    private static void workingWithCathedra() {
        System.out.println("\n\n~~~~~WORKING WITH CATHEDRAS~~~~~\n\n");
        int cath = DataInput.getInt("""
                ~Press 1 if you want to add cathedra;
                ~Press 2 if you want to delete cathedra;
                ~Press 3 if you want to edit cathedra;
                ~Press 4 if you want to show cathedra:
                """);
        while (cath != 0) {
            switch (cath) {
                case 1:
                    University.addCathedra();
                    break;
                case 2:
                    University.deleteCathedra();
                    break;
                case 3:
                    University.editCathedra();
                    break;
                case 4:
                    University.showCathedra();
                    break;
                default:
                    System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                    cath = DataInput.getInt("""
                            ~Press 1 if you want to add cathedra;
                            ~Press 2 if you want to delete cathedra;
                            ~Press 3 if you want to edit cathedra;
                            ~Press 4 if you want to show cathedra:
                            """);
            }
            System.out.println("\n\n~~~~~WORKING WITH CATHEDRAS~~~~~\n\n");
            cath = DataInput.getInt("""
                    ~Press 1 if you want to add cathedra;
                    ~Press 2 if you want to delete cathedra;
                    ~Press 3 if you want to edit cathedra;
                    ~Press 4 if you want to show cathedra;
                    (Press 0 if you want to stop working with cathedras and return to the main menu):
                    """);

        }
    }
    private static void workingWithPeople() {
        System.out.println("\n\n~~~~~WORKING WITH PEOPLE~~~~~\n\n");
        int people = DataInput.getInt("""
                ~Press 1 if you want to work with students;
                ~Press 2 if you want to work with teachers:
                """);
        while (people != 0) {
            switch (people) {
                case 1:
                    System.out.println("\n\n~~~~~WORKING WITH STUDENTS~~~~~\n\n");
                    int student = DataInput.getInt("""
                            ~Press 1 if you want to add student;
                            ~Press 2 if you want to delete student;
                            ~Press 3 if you want to edit student;
                            ~Press 4 if you want to show students:
                            """);
                    while (student != 0){
                        switch (student){
                            case 1:
                                University.addStudent();
                               // university.showAllStudents();
                                break;
                            case 2:
                                University.deleteStudent();
                              //  university.showAllStudents();
                                break;
                            case 3:
                                University.editStudent();
                              //  university.showAllStudents();
                                break;
                            case 4:
                                University.showStudents();

                                break;
                            default:
                                System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                                student = DataInput.getInt("""
                                        ~Press 1 if you want to add student;
                                        ~Press 2 if you want to delete student;
                                        ~Press 3 if you want to edit student;
                                        ~Press 4 if you want to show students:
                                        """);
                        }
                        System.out.println("\n\n~~~~~WORKING WITH STUDENTS~~~~~\n\n");
                        student = DataInput.getInt("""
                                ~Press 1 if you want to add student;
                                ~Press 2 if you want to delete student;
                                ~Press 3 if you want to edit student;
                                ~Press 4 if you want to show students;
                                (Press 0 if you want to stop working with students and return to working with people menu):
                                """);
                    }
                    break;
                case 2:
                    System.out.println("\n\n~~~~~WORKING WITH TEACHERS~~~~~\n\n");
                    int teacher = DataInput.getInt("""
                            ~Press 1 if you want to add teacher;
                            ~Press 2 if you want to delete teacher;
                            ~Press 3 if you want to edit teacher;
                            ~Press 4 if you want to show teachers:
                            """);
                    while (teacher != 0){
                        switch (teacher){
                            case 1:
                                University.addTeacher();
                               // university.showAllTeachers();
                                break;
                            case 2:
                                University.deleteTeacher();
                               // university.showAllTeachers();
                                break;
                            case 3:
                                University.editTeacher();
                                //university.showAllTeachers();
                                break;
                            case 4:
                                University.showTeachers();
                                break;
                            default:
                                System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                                teacher = DataInput.getInt("""
                                        ~Press 1 if you want to add teacher;
                                        ~Press 2 if you want to delete teacher;
                                        ~Press 3 if you want to edit teacher;
                                        ~Press 4 if you want to show teachers:
                                        """);
                        }
                        System.out.println("\n\n~~~~~WORKING WITH TEACHERS~~~~~\n\n");
                        teacher = DataInput.getInt("""
                                ~Press 1 if you want to add teacher;
                                ~Press 2 if you want to delete teacher;
                                ~Press 3 if you want to edit teacher;
                                ~Press 4 if you want to show teacher;
                                (Press 0 if you want to stop working with teachers and return to working with people menu):
                                """);
                    }
                    break;
                default:
                    System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                    people = DataInput.getInt("""
                            ~Press 1 if you want to work with students;
                            ~Press 2 if you want to work with teachers:
                            """);
            }
            System.out.println("\n\n~~~~~WORKING WITH PEOPLE~~~~~\n\n");
            people = DataInput.getInt("""
                    ~Press 1 if you want to work with students;
                    ~Press 2 if you want to work with teachers;
                    (Press 0 if you want to stop working with people and return to the main menu)
                    """);
        }
    }


}

