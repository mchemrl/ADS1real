/*
    files: Student.java, Person.java, DataInput.java, Main.java
    this abstract class has the following field: full name.
    it contains setters, getters, a toString method.
 */

package Members;

public abstract class Person {

    String fullName;

    /*
     * constructor for a person
     */
    public Person(String fullName) {
        this.fullName = fullName;
    }

    /*
     * default constructor
     */
    public Person() {
        this("undefined name");
    }

    public abstract String toString();

    /*
     * getter for full name
     * @return full name
     */
    public String getFullName() {
        return fullName;
    }

    /*
     * setter for full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
