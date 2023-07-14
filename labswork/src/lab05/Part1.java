package lab05;

import WenlongLab01.Employee;
import WenlongLab01.Patient;
import WenlongLab01.Person;
import lab2.Rational;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Employee> orderBysalAndName(List<Employee> listE) {
        Collections.sort(listE, new sortBysalAndName());
        return listE;
    }

    @Override
    public int compare(Rational o1, Rational o2) {
        return o1.compareTo(o2);
    }

    /**
     * Given a list of Employee objects, find the one with the highest salary.
     * In case of a tie, return the one whose surname comes first in lexicographic order.
     */
    public static Employee highestAndSurename(List<Employee> list) {
        Employee highest = Collections.max(list, Comparator.comparing(Employee::getAnnualSalary));
        List<Employee> highestEmp = list.stream().filter(employee -> employee.getAnnualSalary() == highest.getAnnualSalary()).collect(Collectors.toList());
        return highestEmp.stream().sorted(Comparator.comparing(Employee::getSureName)).findFirst().orElse(null);
    }

    public static List<Patient> nullPhysic(List<Patient> plist) {
//        List<Patient> nullp = plist.stream().filter(patient -> patient.physician==null).min(Comparator.comparing(Patient::getSureName));
        List<Patient> nullp = plist.stream().filter(patient -> patient.physician==null).collect(Collectors.toList());

         Collections.sort(nullp,new sortBySureName());
         return  nullp;

    }
}

class sortBySureName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.sureName.compareTo(o2.sureName);
    }
}

class sortBysalAndName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getAnnualSalary() != o2.getAnnualSalary()) {
            return Integer.compare(o1.getAnnualSalary(), o2.getAnnualSalary());
        } else {
            return o1.sureName.compareTo(o2.sureName);
        }

    }
}
//class sortByPhysicAndNAME implements Comparator<Patient>{
//
//    @Override
//    public int compare(Patient o1, Patient o2) {
//        return 0;
//    }
//}
//class highestSal implements Comparator<Employee>{
//
//    @Override
//    public int compare(Employee o1, Employee o2) {
//        return Collections.max();
//    }
//}