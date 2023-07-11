/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WenlongLab01;

/**
 *this is for the test of Class Doctor
 * @author C0527253
 */
public class TestForDoctor {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("unit a","surgury","Ripley","Clark");
        // expect:this.annualsalary is 250000  this .specialty is surgury  Dr. Ripley Clark (ID#:0001)( surgury )
        //output:this.annualsalary is 250000  this .specialty is surgury  Dr. Ripley Clark (ID#:0001)( surgury )
        //result:pass
        System.out.println("this.annualsalary is "+ d1.getAnnualSalary() + "  this .specialty is " + d1.specialty +"  "+ d1.toString());
    }
    
}
