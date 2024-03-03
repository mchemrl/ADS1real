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
        int n = DataInput.getInt("~Press 1 if you want to work with faculty;\n" +
                "~Press 2 if you want to work with cathedra;\n" +
                "~Press 3 if you want to work with people;\n" +
                "~Press 4 to find person by name, course or group;\n" +
                "~Press 5 to show all students sorted by course;\n" +
                "~Press 6 to show students/teachers of faculty sorted by alphabet;\n" +
                "~Press 7 to show students of cathedra sorted by course;\n" +
                "~Press 8 to show students/teachers of cathedra sorted by alphabet;\n" +
                "~Press 9 to show all students of cathedra of specified course;\n" +
                "~Press 10 to show all students of cathedra of specified course sorted by alpphabet:\n");

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
                        university.number5();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }
                    break;
                case 6:
                    rep =1;
                    university.showAllStudents();
                    while (rep!=0) {
                        university.number6Students();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }
                    break;
                case 7:
                    rep =1;
                    university.showAllStudents();
                    while (rep!=0) {
                        university.number7();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }
                    break;

                case 8:
                    rep =1;
                    university.showAllStudents();
                    while (rep!=0) {
                        university.number8Students();;
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }
                    break;
                case 9:
                    rep = 1;
                    while (rep != 0) {
                        university.task9();
                        rep = rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue searching - any number):\n");
                    }
                    break;
                case 10:
                    rep = 1;
                    while (rep != 0){
                        university.task10();
                        rep = DataInput.getInt("Enter 0 if you want to return to main menu(else if you want to continue sorting - any number):\n");
                    }

                    break;
                default:
                    System.out.println("\n\n!!!Unknown command.Try one more time!!!\n\n");
                    n = DataInput.getInt("~Press 1 if you want to work with faculty;\n" +
                            "Press 2 if you want to work with cathedra;\n" +
                            "Press 3 if you want to work with people;\n" +
                            "Press 4 to find person by name, course or group;\n" +
                            "Press 5 to show all students sorted by course;\n" +
                            "Press 6 to show students/teachers of faculty sorted by alphabet;\n" +
                            "Press 7 to show students of cathedra sorted by course;\n" +
                            "Press 8 to show students/teachers of cathedra sorted by alphabet;\n" +
                            "Press 9 to show all students of cathedra of specified course;\n" +
                            "Press 10 to show all students of cathedra of specified course sorted by alpphabet:\n");
            }
            System.out.println("\n\n~~~~~MAIN MENU~~~~~\n\n");
            n = DataInput.getInt("~Press 1 if you want to work with faculty;\n" +
                    "~Press 2 if you want to work with cathedra;\n" +
                    "~Press 3 if you want to work with people;\n" +
                    "~Press 4 to find person by name, course or group;\n" +
                    "~Press 5 to show all students sorted by course;\n" +
                    "~Press 6 to show students/teachers of faculty sorted by alphabet;\n" +
                    "~Press 7 to show students of cathedra sorted by course;\n" +
                    "~Press 8 to show students/teachers of cathedra sorted by alphabet;\n" +
                    "~Press 9 to show all students of cathedra of specified course;\n" +
                    "~Press 10 to show all students of cathedra of specified course sorted by alpphabet;\n" +
                    "(Press 0 to stop program):\n");
        }


    }
    private static void workingWithFaculty(){
        System.out.println("\n\n~~~~~WORKING WITH FACULTIES~~~~~\n\n");
        int fac = DataInput.getInt("~Press 1 if you want to add faculty;\n" +
                "~Press 2 if you want to delete faculty;\n" +
                "~Press 3 if you want to edit faculty;\n" +
                "~Press 4 if you want to show faculty:\n");
        while (fac !=0){
            switch (fac){
                case 1:
                    university.addFaculty();
                    university.showFaculties();
                    break;
                case 2:
                    university.deleteFaculty();
                    university.showFaculties();
                    break;
                case 3:
                    university.editFaculties();
                    university.showFaculties();
                    break;
                case 4:
                    university.showFaculties();
                    break;
                default:
                    System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                    fac = DataInput.getInt("~Press 1 if you want to add faculty;\n" +
                            "~Press 2 if you want to delete faculty;\n" +
                            "~Press 3 if you want to edit faculty;\n" +
                            "~Press 4 if you want to show faculty:\n");
            }
            System.out.println("\n\n~~~~~WORKING WITH FACULTIES~~~~~\n\n");
            fac = DataInput.getInt("~Press 1 if you want to add faculty;\n" +
                    "~Press 2 if you want to delete faculty;\n" +
                    "~Press 3 if you want to edit faculty;\n" +
                    "~Press 4 if you want to show faculty;\n" +
                    "(Press 0 if you want to stop working with faculty and return to the main menu):\n");
        }
    }

    private static void workingWithCathedra() {
        System.out.println("\n\n~~~~~WORKING WITH CATHEDRAS~~~~~\n\n");
        int cath = DataInput.getInt("~Press 1 if you want to add cathedra;\n" +
                "~Press 2 if you want to delete cathedra;\n" +
                "~Press 3 if you want to edit cathedra;\n" +
                "~Press 4 if you want to show cathedra:\n");
        while (cath != 0) {
            switch (cath) {
                case 1:
                    university.addCathedra();
                    break;
                case 2:
                    university.deleteCathedra();
                    break;
                case 3:
                    university.editCathedra();
                    break;
                case 4:
                    university.showCathedra();
                    break;
                default:
                    System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                    cath = DataInput.getInt("~Press 1 if you want to add cathedra;\n" +
                            "~Press 2 if you want to delete cathedra;\n" +
                            "~Press 3 if you want to edit cathedra;\n" +
                            "~Press 4 if you want to show cathedra:\n");
            }
            System.out.println("\n\n~~~~~WORKING WITH CATHEDRAS~~~~~\n\n");
            cath = DataInput.getInt("~Press 1 if you want to add cathedra;\n" +
                    "~Press 2 if you want to delete cathedra;\n" +
                    "~Press 3 if you want to edit cathedra;\n" +
                    "~Press 4 if you want to show cathedra;\n" +
                    "(Press 0 if you want to stop working with cathedras and return to the main menu):\n");

        }
    }
    private static void workingWithPeople() {
        System.out.println("\n\n~~~~~WORKING WITH PEOPLE~~~~~\n\n");
        int people = DataInput.getInt("~Press 1 if you want to work with students;\n" +
                "~Press 2 if you want to work with teachers:\n");
        while (people != 0) {
            switch (people) {
                case 1:
                    System.out.println("\n\n~~~~~WORKING WITH STUDENTS~~~~~\n\n");
                    int student = DataInput.getInt("~Press 1 if you want to add student;\n" +
                            "~Press 2 if you want to delete student;\n" +
                            "~Press 3 if you want to edit student;\n" +
                            "~Press 4 if you want to show students:\n");
                    while (student != 0){
                        switch (student){
                            case 1:
                                university.addStudent();
                               // university.showAllStudents();
                                break;
                            case 2:
                                university.deleteStudent();
                              //  university.showAllStudents();
                                break;
                            case 3:
                                university.editStudent();
                              //  university.showAllStudents();
                                break;
                            case 4:
                                university.showStudents();

                                break;
                            default:
                                System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                                student = DataInput.getInt("~Press 1 if you want to add student;\n" +
                                        "~Press 2 if you want to delete student;\n" +
                                        "~Press 3 if you want to edit student;\n" +
                                        "~Press 4 if you want to show students:\n");
                        }
                        System.out.println("\n\n~~~~~WORKING WITH STUDENTS~~~~~\n\n");
                        student = DataInput.getInt("~Press 1 if you want to add student;\n" +
                                "~Press 2 if you want to delete student;\n" +
                                "~Press 3 if you want to edit student;\n" +
                                "~Press 4 if you want to show students;\n" +
                                "(Press 0 if you want to stop working with students and return to working with people menu):\n");
                    }
                    break;
                case 2:
                    System.out.println("\n\n~~~~~WORKING WITH TEACHERS~~~~~\n\n");
                    int teacher = DataInput.getInt("~Press 1 if you want to add teacher;\n" +
                            "~Press 2 if you want to delete teacher;\n" +
                            "~Press 3 if you want to edit teacher;\n" +
                            "~Press 4 if you want to show teachers:\n");
                    while (teacher != 0){
                        switch (teacher){
                            case 1:
                                university.addTeacher();
                               // university.showAllTeachers();
                                break;
                            case 2:
                                university.deleteTeacher();
                               // university.showAllTeachers();
                                break;
                            case 3:
                                university.editTeacher();
                                //university.showAllTeachers();
                                break;
                            case 4:
                                university.showTeachers();
                                break;
                            default:
                                System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                                teacher = DataInput.getInt("~Press 1 if you want to add teacher;\n" +
                                        "~Press 2 if you want to delete teacher;\n" +
                                        "~Press 3 if you want to edit teacher;\n" +
                                        "~Press 4 if you want to show teachers:\n");
                        }
                        System.out.println("\n\n~~~~~WORKING WITH TEACHERS~~~~~\n\n");
                        teacher = DataInput.getInt("~Press 1 if you want to add teacher;\n" +
                                "~Press 2 if you want to delete teacher;\n" +
                                "~Press 3 if you want to edit teacher;\n" +
                                "~Press 4 if you want to show teacher;\n" +
                                "(Press 0 if you want to stop working with teachers and return to working with people menu):\n");
                    }
                    break;
                default:
                    System.out.println("\n\n!!!Unknown command. Try one more time!!!\n\n");
                    people = DataInput.getInt("~Press 1 if you want to work with students;\n" +
                            "~Press 2 if you want to work with teachers:\n");
            }
            System.out.println("\n\n~~~~~WORKING WITH PEOPLE~~~~~\n\n");
            people = DataInput.getInt("~Press 1 if you want to work with students;\n" +
                    "~Press 2 if you want to work with teachers;\n" +
                    "(Press 0 if you want to stop working with people and return to the main menu)\n");
        }
    }


}

