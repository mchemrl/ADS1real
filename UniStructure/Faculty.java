/*
    files: Student.java, Person.java, DataInput.java, Main.java

    this class extends Person class and has the following fields: course, group, specialty.
 */

package UniStructure;

import Extends.DataInput;

public class Faculty {

    private String name;
    public Cathedra[] cathedras;

    public Faculty(String name) {
        this.name = name;
        this.cathedras = new Cathedra[0];
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

    public static void addDef() {
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
        if (cathedras.length == 0) {
            System.out.println("There are no cathedras to delete");
        } else {
            showCathedra();
            int index;
            do {
                index = DataInput.getInt("Enter the index of the cathedra you want to delete: ");
            } while (index < 0 || index >= cathedras.length);
            Cathedra[] newCathedras = new Cathedra[cathedras.length - 1];
            for (int i = 0, j = 0; i < cathedras.length; i++) {
                if (i != index) {
                    newCathedras[j++] = cathedras[i];
                }
            }
            this.cathedras = newCathedras;
        }
    }


    //show cathedra from the array of Faculty
    public void showCathedra() {
        if (cathedras.length == 0) {
            System.out.println("There are no cathedras to show");
        } else {
            System.out.println("list of cathedra of " + name + ":");
            for (Cathedra cathedra : cathedras) {
                System.out.println(cathedra.toString());
            }
        }
    }

    //edit cathedra from the array of Faculty
    public void editCathedra() {
        if (cathedras.length == 0) {
            System.out.println("There are no cathedras to edit");
        } else {
            showCathedra();
            int index;
            do {
                index = DataInput.getInt("Enter the index of the cathedra you want to edit: ");
            } while (index < 0 || index >= cathedras.length);
            String name = DataInput.getString("enter the new name: ");
            cathedras[index].setName(name);
        }
    }

    public Cathedra selectCathedra() {
        showCathedra();
        if (cathedras.length == 0) {
            addCathedra();
        }
        int index;
        do {
            index = DataInput.getInt("enter the index of the cathedra you want to work with: ");
        } while (index < 0 || index >= cathedras.length);
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
