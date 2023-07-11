/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WenlongLab01;

/**
 * test for class Nurse
 *nurse salary comes from method setShift;SHIFT_A>>80000;SHIFT_B>>85000;SHIFT_C>>90000
 * @author C0527253
 */
public class TestForNurse {

    public static void main(String[] args) {
        Nurse nurse_0 = new Nurse("ChildrenCare", "Martha", "McGee");
        nurse_0.setShift(Nurse.SHIFT_A);
        //expect:Martha McGee (ID#:0001)( ChildrenCare  shift is 5 ) salary is,  80000
        //output:Martha McGee (ID#:0001)( ChildrenCare  shift is 5 ) salary is,  80000
        //result:pass
        System.out.println(nurse_0.toString() + " salary is,  " + nurse_0.getAnnualSalary());
        Nurse nurse_1 = new Nurse("PhysicalCure", "Alice", "Lee");
        nurse_1.setShift(Nurse.SHIFT_B);
        //expect:Alice Lee (ID#:0002)( PhysicalCure  shift is 6 ) salary is,  85000
        //output:Alice Lee (ID#:0002)( PhysicalCure  shift is 6 ) salary is,  85000
        //result:pass
        System.out.println(nurse_1.toString() + " salary is,  " + nurse_1.getAnnualSalary());
        Nurse nurse_2 = new Nurse("Emergency", "Donald", "Kim");
        nurse_2.setShift(Nurse.SHIFT_C);
        //expect:Donald Kim (ID#:0003)( Emergency  shift is 7 ) salary is,  90000
        //output:Donald Kim (ID#:0003)( Emergency  shift is 7 ) salary is,  90000
        //result:pass
        System.out.println(nurse_2.toString() + " salary is,  " + nurse_2.getAnnualSalary());
    }
}
