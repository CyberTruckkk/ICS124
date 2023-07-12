package WenlongLab01;
/**
 * This is a subclass of Employee 
 * @author c0527253
 */
public class Doctor extends Employee {
    public String specialty;

    /**
     * 
     * @param unit  it is the department of doctor
     * @param specialty it is the special skills or major of doctor
     * default annualSalary of each Doctor instance is set to 250000
     * super(unit,  givenName, sureName) nesting constructor from Super class Employee
     */

    public Doctor(String unit, String specialty, String givenName, String sureName,int sal) {
        super(unit,  givenName, sureName,sal);
        this.specialty = specialty;
        this.annualSalary = 250000;
    }
/**
 * @return it represents the information of this person includes family and first name 
 * , ID,specialty
 */
    @Override
    public String toString() {
        return "Dr. " + super.toString() + "( " + this.specialty + " )";
    }
}
