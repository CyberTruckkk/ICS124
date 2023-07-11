/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WenlongLab01;

/**
 *this is for the test of Class Employee
 * toString() in super class Person has passed the test which provide info about surname givenName and id
 * @author C0527253
 */
public class TestForEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee("unit a","jack","lee");
        //expect:jack lee (ID#:0001) this.salary is  0  unit is: unit a
        //get:jack lee (ID#:0001) this.salary is  0  unit is: unit a
        //result:pass
        System.out.println(emp1.toString() + " this.salary is  "+ emp1.getAnnualSalary() + "  unit is: " + emp1.unit);
    }
    
}
