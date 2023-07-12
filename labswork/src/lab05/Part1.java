package lab05;

import WenlongLab01.Employee;
import WenlongLab01.Person;
import lab2.Rational;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Part1<E> implements Comparator<Rational> {
    public static Rational minOne(List<Rational> rationals) {
        return Collections.min(rationals);
    }

    public static List<String> orderStr(List<String> list) {
        ArrayList<String> str = new ArrayList<>();
        for (String c : list) {
            str.add(c);
        }
        Collections.sort(str);
        return str;
    }

    public static double maxOne(List<Double> list) {
        return Collections.max(list);
    }

    public static List<Person> orderPerson(List<Person> listPerson) {
         Collections.sort(listPerson, new sortBySureName());
         return listPerson;
    }
    public static List<Employee> orderBysal(List<Employee> listE){
        Collections.sort(listE,new sortBysal());
        return listE;
    }


    @Override
    public int compare(Rational o1, Rational o2) {
        return o1.compareTo(o2);
    }
}

class sortBySureName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.sureName.compareTo(o2.sureName);
    }
}
class sortBySal implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAnnualSalary()-(o2.getAnnualSalary());
    }
}