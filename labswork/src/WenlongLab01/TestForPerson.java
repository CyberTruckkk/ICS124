/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WenlongLab01;

/**
 * This is for the test of Class Person
 *
 * @author C0527253
 */
public class TestForPerson {

    public static void main(String[] args) {
        Person person1 = new Person("Kelly", "Eden");
        /**
         * first instance of Person is created ,and print out the infomation of the person1
         * ID is assigned automatically from static count which was set to 0 and add to 1 once an instance is created
         */
        System.out.println("person1 info: " + person1.givenName + "  " + person1.sureName + "ID:   " + person1.ID);
        // EXPECT: "Kelly EdenID#:0001";
        //GOT :Kelly EdenID#:0001
        // PASS
        System.out.println(person1.toString());
        Person person2 = new Person("Macdonald", "Skyler");
        // EXPECT: "Macdonald SkylerID#:0002";
        //GOT :Macdonald SkylerID#:0002
        // PASS
        System.out.println(person2.toString());
        // EXPECT: "ID#:0003";
        //GOT :ID#:0003
        // PASS
        Person person3 = new Person("", "");
        System.out.println(person3.toString());
    }

}
