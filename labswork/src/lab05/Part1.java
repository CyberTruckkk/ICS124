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

    /**
     * Given a list of Rational objects, find the smallest valued element.
     * @param rationals a list of Rational objects
     * @return the smallest valued element
     */
    public static Rational minOne(List<Rational> rationals) {
        return Collections.min(rationals);
    }

    public static List<String> orderStr(List<String> list) {
        Collections.sort(list);
        return list;
    }

    /**
     * Given an array of Double values, find the maximum.
     * @param list array of Double values
     * @return the maximum
     */
    public static double maxOne(List<Double> list) {
        return Collections.max(list);
    }

    /**
     * Given a list of Person objects, objs them by surname in lexicographic order.
     * @param listPerson  a list of Person objects,
     * @return sortted list of person
     */
    public static List<Person> orderPerson(List<Person> listPerson) {
        Collections.sort(listPerson, new sortBySureName());
        return listPerson;
    }

    /**
     * @param listE Given a list of Employee objects, sort them by their salaries (lowest first),
     * @return and then sort groups of employees with the same salary by surname in lexicographic order.
     */
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

    /**
     * find a patient that does not have an assigned physician (ie. physician is null).
     * If there is more than one, return the one whose surname comes first in lexicographic order.
     * @param plist a list of patients
     * @return a sorted and filtered list of patients
     */
    public static List<Patient> nullPhysic(List<Patient> plist) {
//        List<Patient> nullp = plist.stream().filter(patient -> patient.physician==null).min(Comparator.comparing(Patient::getSureName));
        List<Patient> nullp = plist.stream().filter(patient -> patient.physician == null).collect(Collectors.toList());

        Collections.sort(nullp, new sortBySureName());
        return nullp;

    }

    /**
     * rearranges a List of Patient objects so that all the patients
     * that do not have an assigned physician are moved to the front of the list,
     * in ascending order by ID.
     * The order of the remainder of the list (where patients have a non-null physician) is irrelevant.
     * @param patientsList the list of patients to be been rearranged
     * @return the list of patients that has been rearranged
     */
    public static <T extends Patient> void customSort(List<T> patientsList) {
        List<T> listHead = new ArrayList<>();
        List<T> listTail = new ArrayList<>();
        for (T p : patientsList) {
            if (p.physician != null) {
                listHead.add(p);
            } else {
                listTail.add(p);
            }
//            Collections.sort(listHead,new sortByID());
        }
        bubbleSort(listHead);
        patientsList.clear();
        patientsList.addAll(listHead);
        patientsList.addAll(listTail);
    }

    /**
     * change the position of two element if the former is bigger than the later
     * @param list list of patients to be  sort by id
     */
    public static <T extends Patient> void bubbleSort(List<T> list) {
        int length = list.size();
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length - 1; k++) {
                if (list.get(k).ID > list.get(k + 1).ID) {
//                    swap(list.get(k), list.get(k + 1));
                    swap(list,k,k+1);
                }
            }
        }

    }

    public static <E extends Patient> void swap( List<E> list, int i, int k) {
//        System.out.println(obj1.toString()+obj2.toString());
//        E obj = obj1;
//        obj1 = obj2;
//        obj2 = obj;
        Collections.swap( list, i, k);
    }
}

class sortByID implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        return Integer.compare(o1.ID, o2.ID);
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
