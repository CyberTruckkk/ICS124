package WenlongLab01;

/**
 * this class is subclass of Person
 * use constructor set Doctor instance to each patient instance
 * @author c0527253
 */

public class Patient extends Person {
    /**
     * @param physician is an instance of Class Doctor
     */
    public Doctor physician;

    /***
     * @param physician is an instance of class Doctor,set each patient's doctor
     */
    public Patient(String givenName, String sureName, Doctor physician) {
        super(givenName, sureName);
        this.physician = physician;
    }
}
