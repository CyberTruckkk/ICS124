package lab05;

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
        System.out.println("test for method1 ,minOne(),expect(0.3...) get: " + Part1.minOne(list).doubleValue());


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
