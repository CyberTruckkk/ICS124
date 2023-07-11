package WenlongLab01;

/**
 * This class is used to define the common fields of class Employee doctor nurse
 * and patient
 *
 * @author c0527253
 */
public class Person {

    /**
     * @param givenName Is the givenName of each instance of Person and its
     * subclass
     * @param sureName Is the sureName of each instance of Person and its
     * subclass
     * @param ID this field was decorated by final means it won't be changed
     * after set
     * @param counter static counter will add with each instance is created
     * automatically
     */
    protected static int counter = 0;
    public final int ID;
    public String givenName;
    public String sureName;

    public Person(String givenName, String sureName) {
        this.givenName = givenName;
        this.sureName = sureName;
        counter++;
        // parse counter to final ID means it's unique  when an instance is created
        this.ID = counter;
    }

    /**
     *
     * @return person's information include: this.givenName + " " +
     * this.sureName + " (ID# " + this.ID + " )";
     */
    @Override
    public String toString() {

        return this.givenName + " " + this.sureName + String.format(" (ID#:%04d)", this.ID);
    }
}
