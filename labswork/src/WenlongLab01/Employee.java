package WenlongLab01;

/*
 * This class defines common field and method of class Employee Doctor and Nurse
 * @author c0527253
 */
public class Employee extends Person {

    public String unit;
    protected int annualSalary;

    /**
     * @param unit it's the working department of Employee instance
     * @param givenName from class Person
     * @param sureName from class Person super( givenName, sureName) nesting
     * constructor from super class Person
     */
    public Employee(String unit, String givenName, String sureName) {
        super(givenName, sureName);
        this.unit = unit;
    }

    /**
     *
     * @return returns the annualSalary of each instance: Employee Doctor and
     * Nurse
     */
    public int getAnnualSalary() {
        return this.annualSalary;
    }
}
