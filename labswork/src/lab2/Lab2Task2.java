/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author c0527253
 */
public class Lab2Task2 {

    public static void main(String[] args) {
        Rational big = new Rational(33333333, 2);
        Rational org = new Rational(16, 2);
        Rational negativeBig = new Rational(-3, 1);
        Rational negativeSmall = new Rational(-3, 2);
        Rational proper = new Rational(-3, 5);
        System.out.println("test for method abs() exp: 3/1 outcome: " + negativeBig.abs());
        System.out.println("test for method  add(long 1)  exp -2/1 outcome:  " + negativeBig.add(1));
        System.out.println("test for method  add(double)  add 0.375 exp -21/8 outcome:  " + negativeBig.add(0.375));
        System.out.println("test for method  canonical()   exp 8/1 outcome:  " + org.canonical());
        System.out.println("test for method  compareTo(Rational val)  (7/8)  exp 1 outcome:  " + org.compareTo(new Rational(7, 8)));
        System.out.println("test for method  BigDecimal decimalValue()   exp -1.5  outcome:  " + negativeSmall.decimalValue());
        System.out.println("test for method  divide(double divisor)   exp 160/10   outcome:  " + org.divide(0.5));
        System.out.println("test for method  divide(long divisor)    exp 8/2 outcome:  " + org.divide(2));
        System.out.println("test for method  divide(rational divisor)    exp -3/-6  outcome:  " + negativeSmall.divide(negativeBig));
        System.out.println("test for method Rational add(Rational addend)     exp -9/2  outcome:  " + negativeSmall.add(negativeBig));
        System.out.println("test for method Rational divide(Rational divisor)    exp -3/-6 outcome:  " + negativeSmall.divide(negativeBig));
        System.out.println("test for method double doubleValue()  1/2   exp (-3.0 ) outcome:  " + negativeBig.doubleValue());
        System.out.println("test for method  boolean equals(Object other)  exp (false ) outcome:  " + negativeSmall.equals(negativeBig));
        System.out.println("test for method  float floatValue()  exp (-1.5) outcome:  " + negativeSmall.floatValue());
        System.out.println("test for method  BigInteger getDenominator() exp (2) outcome:  " + big.getDenominator());
        System.out.println("test for method  BigInteger getNumerator()  exp (33333333) outcome:  " + big.getNumerator());
        System.out.println("test for method  int hashCode()   exp (1033334286) outcome:  " + big.hashCode());
        System.out.println("test for method  int hashCode()   1/2     exp (1210) outcome:  " + org.hashCode());
        System.out.println("test for method  int intValue()     exp (8) outcome:  " + org.intValue());
        System.out.println("test for method  boolean isProper()     exp (false) outcome:  " + big.isProper());
        System.out.println("test for method  boolean isProper()     exp (false) outcome:  " + negativeSmall.isProper());
        System.out.println("test for method  boolean isProper()     exp (true) outcome:  " + proper.isProper());
        System.out.println("test for method  long longValue()        exp (16666666) outcome:  " + big.longValue());
        System.out.println("test for method  Rational multiply(Rational val)    exp (-48/10 ) outcome:  " + org.multiply(proper));
        System.out.println("test for method  Rational multiply(long val)     exp (-39/5 ) outcome:  " + proper.multiply(13));
        System.out.println("test for method  Rational multiply(double val)   exp (-15/50 ) outcome:  " + proper.multiply(0.5));
        System.out.println("test for method  Rational negate()     exp (3/5) outcome:  " + proper.negate());
        System.out.println("test for method  pow(int exponent)     exp (9/25 ) outcome:  " + proper.pow(2));
        System.out.println("test for method  Rational reciprocal()  exp (2/33333333 ) outcome:  " + big.reciprocal());
        System.out.println("test for method  int signum()  exp (-1 ) outcome:  " + proper.signum());
        System.out.println("test for method  int signum()   exp (1 ) outcome:  " + big.signum());
        System.out.println("test for method  Rational subtract(double subtrahend)  exp (-55/50) outcome:  " + proper.subtract(0.5));
        System.out.println("test for method  Rational subtract(long subtrahend)   exp (-8/5) outcome:  " + proper.subtract(1));
        System.out.println("test for method  Rational subtract(Rational subtrahend)exp (3/2) outcome:  " + negativeSmall.subtract(negativeBig));
        System.out.println("test for method  String toString()  exp -3/2) outcome:  " + negativeSmall.toString());
        System.out.println("test for method  Rational valueOf(double source)   exp 5/10  outcome:  " + Rational.valueOf(0.5));
        System.out.println("test for method  Rational valueOf(long source)  666   exp 666/1   outcome:  " + Rational.valueOf(666));
        System.out.println("test for method  boolean isReaptingDecimal()  exp false   outcome:  " + negativeBig.isReaptingDecimal());
        System.out.println("test for method  boolean isReaptingDecimal()    exp true   outcome:  " +negativeSmall.isReaptingDecimal());
        System.out.println("test for method  Rational valueOf(String source)   exp 10/1  outcome:  " +Rational.valueOf("10.1"));
        System.out.println("test for method  Rational doubleValue(String source)   exp 10/1  outcome:  " +Rational.valueOf("10.1"));


    }

}
