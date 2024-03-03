/*
    files: Student.java, Person.java, DataInput.java, Main.java

    this class extends Person class and has the following fields: course, group, specialty.
 */

package UniStructure;

import Extends.DataInput;

import java.util.Arrays;

public class Faculty {

    private String name;
    public Cathedra[] cathedras;

    public Faculty(String name) {
        this.name = name;
        this.cathedras = new Cathedra[0];
    }

    public Faculty() {
        this("undefined name");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //add cathedra to the array of Faculty
    public void addCathedra() {
        String name = DataInput.getString("enter the name of the cathedra: ");
        Cathedra[] newCathedra = new Cathedra[cathedras.length + 1];
        System.arraycopy(cathedras, 0, newCathedra, 0, cathedras.length);
        newCathedra[cathedras.length] = new Cathedra(name);
        this.cathedras = newCathedra;
    }

    public void addDefCathedra(String name) {
        Cathedra[] newCathedra = new Cathedra[cathedras.length + 1];
        System.arraycopy(cathedras, 0, newCathedra, 0, cathedras.length);
        newCathedra[cathedras.length] = new Cathedra(name);
        this.cathedras = newCathedra;
    }

    public static void addDef(){
        Faculty getFI = University.faculties[0];
        getFI.addDefCathedra("Math");
        getFI.addDefCathedra("Programming");
        getFI.addDefCathedra("Dushno");

        Faculty getFPVN = University.faculties[1];
        getFPVN.addDefCathedra("Pravo");
        getFPVN.addDefCathedra("Livo");
    }


    //delete cathedra from the array of Faculty
    public void deleteCathedra() {
        System.out.println(Arrays.toString(cathedras));

        int index = DataInput.getInt("Enter the index of the cathedra you want to delete: ");
        Cathedra[] newCathedras = new Cathedra[cathedras.length - 1];
        for (int i = 0, j = 0; i < cathedras.length; i++) {
            if (i != index) {
                newCathedras[j++] = cathedras[i];
            }
        }
        this.cathedras = newCathedras;
    }


    //show cathedra from the array of Faculty
    public void showCathedra() {
        System.out.println("list of cathedra of " + name + ":");
        for (Cathedra cathedra : cathedras) {
            System.out.println(cathedra.toString());
        }
    }

    //edit cathedra from the array of Faculty
    public void editCathedra() {
        System.out.println(Arrays.toString(cathedras));
        int index = DataInput.getInt("enter the index of the cathedra you want to edit: ");
        String name = DataInput.getString("enter the new name: ");
        cathedras[index].setName(name);
    }

    public Cathedra selectCathedra() {
        showCathedra();
        if (cathedras.length == 0){
            addCathedra();
        }
        int index = DataInput.getInt("enter the index of the cathedra you want to work with: ");

        while (index>(cathedras.length- 1)){
            index = DataInput.getInt("try to enter the index of the cathedra you want to work with again: ");
        }

            return cathedras[index];


    }

    public Faculty getFaculty() {
        return this;
    }

    public Cathedra[] getCathedras() {
        return cathedras;
    }

    @Override
    public String toString() {
        return name;
    }
}
