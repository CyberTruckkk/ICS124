package lab05;

import WenlongLab01.Employee;
import WenlongLab01.Person;
import lab2.Rational;

import java.util.ArrayList;
import java.util.List;

public class TestForPart1<E> {
    List<E> list;

    public static void main(String[] args) {
        Rational r1 = new Rational(1, 1);
        Rational r2 = new Rational(1, 2);
        Rational r3 = new Rational(1, 3);
        List<Rational> list = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        list.add(r3);
//        list.forEach(System.out::println);
        loops(list);
        System.out.println("test for  Rational minOne ,minOne(),expect(0.3...) get: " + Part1.minOne(list).doubleValue());
        List<Double> dblist = new ArrayList<>();
        dblist.add(1.11);
        dblist.add(2.11);
        dblist.add(3.11);
        System.out.println("test for double maxOne,expect(3.11) get: " + Part1.maxOne(dblist));
        ArrayList<String> strList = new ArrayList<>();
        strList.add("banana");
        strList.add("cherry");
        strList.add("apple");
        System.out.println("test for double orderStr,expect[apple, banana, cherry] get: "+Part1.orderStr(strList));
        ArrayList<Person> ap = new ArrayList<>();
        ap.add(new Person("jack","smith"));
        ap.add(new Person("louis","vitton"));
        ap.add(new Person("elon","musk"));
        System.out.println("test for double orderStr,expect[elon musk (ID#:0003), jack smith (ID#:0001), louis vitton (ID#:0002)] get: "+Part1.orderPerson(ap));

        ArrayList<Employee>employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("a","jack","ma",888888));
        employeeArrayList.add(new Employee("a","elon","musk",99999999));
        employeeArrayList.add(new Employee("b","louis","vitton",6666));
        System.out.println(employeeArrayList);
        System.out.println("test for sortBysal + " + Part1.orderBysal(employeeArrayList));
    }

    public static void loops(List<Rational> list) {
        for (Rational r : list) {
            System.out.println(r.doubleValue());
        }
    }

    /**
     *         for (Rational r : list) {
     *             System.out.println(r.doubleValue());
     *         }
     */
}
