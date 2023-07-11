/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WenlongLab01;

/**
 * this is the test for Class Patient
 *doctor is parsed into the Constructor
 * @author C0527253
 */
public class TestForPatient {

    public static void main(String[] args) {
        Doctor doctor_0 = new Doctor("ChildrenCare", "Neurology", "Brenda", "Freeman");
        Patient patient0 = new Patient("Spencer", "Kelly", doctor_0);
        // expect :patient0 information and doctor0's information 
        //output:Spencer Kelly (ID#:0002) doctor is  Dr. Brenda Freeman (ID#:0001)( Neurology )
        //result:pass
        System.out.println(patient0.toString() + " doctor is  " + patient0.physician.toString());
    }
}
