package lab05;

import lab2.Rational;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Part1<E> implements Comparator<Rational> {

    public static Rational minOne(List<Rational> rationals) {
        System.out.println("test for method minOne ");
        return Collections.min(rationals);
    }

    @Override
    public int compare(Rational o1, Rational o2) {
        return o1.compareTo(o2);
    }
}
