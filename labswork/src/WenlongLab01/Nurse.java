package WenlongLab01;

/**
 * This is a subclass of Employee  ,define shift of each instance 
 * set annualSalary of each nurse by setShift method
 * @author c0527253
 */

public class Nurse extends Employee {
    public final static int SHIFT_A = 5;
    public final static int SHIFT_B = 6;
    public final static int SHIFT_C = 7;
    private int shift;

    /**
     * each nurse's shift is set when it's created
     */
    public Nurse(String unit, String givenName, String sureName,int sal) {
        super(unit, givenName, sureName,sal);
        this.shift = SHIFT_A;// set shift by parsing static varieables
    }
    
/**
 * 
 * @return  return each nurse's shift value it's an integer
 */
    public int getShift() {
        return shift;
    }

    /**
     * set each nurse's shift by parsing static shift_A ,B or C value 
     * with the nesting if comparison set each nurse's annualSalary ,cause we are not allowed to use set method ;
     */
    public void setShift(int SHIFT_ABC) {       
        this.shift = SHIFT_ABC;
        if (this.shift == SHIFT_A) {
            this.annualSalary = 80000;
        } else if (this.shift == SHIFT_B) {
            this.annualSalary = 85000;
        } else if (this.shift == SHIFT_C) {
            this.annualSalary = 90000;
        }
    }

    /**
     * 
     * @return the information of each nurse instance:surname giveName unit shift(using getShift method
     */
    @Override
    public String toString() {
        return super.toString() + "( " + this.unit + "  shift is " + this.getShift() + " )";
    }
}
