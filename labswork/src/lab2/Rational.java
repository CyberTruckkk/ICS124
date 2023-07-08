package lab2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Objects;

/**
 * @author c0527253
 * public boolean isReaptingDecimal(),not yet 0603
 */
public class Rational extends Number implements Comparable<Rational> {

    /**
     * numerator ,represents numb
     */
    final BigInteger numerator;
    final BigInteger denominator;

    public Rational(BigInteger numerator, BigInteger denominator) {
        if (numerator == null || denominator == null) {
            throw new NullPointerException("Numerator and denominator cannot be null");
        }
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("denominator25 can not be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational(long n, long d) {
        this.numerator = BigInteger.valueOf(n);
        this.denominator = BigInteger.valueOf(d);
        this.canonical();
    }

    /**
     * @return A abs |rational|,make sure both numerator and denominator positive or negative at sametime
     */
    public Rational abs() {
        if (this.doubleValue() < 0) {
            return new Rational(this.numerator.negate(), this.denominator);
        } else return this;
    }//pass -8/6 > 8/6

    /**
     * @param addend - a Rational value to add
     * @return this + val
     * a new rational obj which is the result of this and addend
     * Rational add(Rational addend)   (6/8)  +  1/8   exp 7/8  outcome:  7/8
     */
    public Rational add(Rational addend) {
        BigInteger sub = this.denominator.multiply(addend.denominator);
        return new Rational(this.numerator.multiply(addend.denominator).add(addend.numerator.multiply(this.denominator)), sub);
    }

    /**
     * @param val long value to be added
     *            convert to bigInteger,using BigInteger.valueOf(long val)
     * @return a rational instance
     */
    public Rational add(long val) {
        Rational r1 = new Rational(BigInteger.valueOf(val), BigInteger.ONE);
        return this.add(r1);
    }// pass

    /**
     * using Rational.valueOf(douuble val) convert double to a new tational obj
     * then use rational.add(rational val) return a new rational;
     *
     * @param val
     * @return
     */
    public Rational add(double val) {
        Rational r1 = Rational.valueOf(val);
        return this.add(r1);
    }//pass

    /**
     * this method is used to justify the fractional format rational ,like 8/6 > 4/3
     * an equivalent Rational value in canonical form.
     *
     * @return an equivalent Rational value in canonical form.
     */
    public Rational canonical() {
        try {
            BigInteger b1 = this.numerator.gcd(this.denominator);
            return new Rational(this.numerator.divide(b1), this.denominator.divide(b1));
        } catch (Exception e) {
            return this;
        }


    }// this method has passed the test,works well

    /**
     * Compares this Rational value to another for natural ordering.
     *
     * @param val the object to be compared.
     * @return if this < val return -1,equals return 0 ,else return 1;
     */
    @Override
    public int compareTo(Rational val) {
        double s1 = this.numerator.doubleValue() / this.denominator.doubleValue();
        double s2 = val.numerator.doubleValue() / val.denominator.doubleValue();
        int s;
        if (s1 < s2) {
            return s = -1;
        } else if (s1 == s2) {
            return s = 0;
        } else {
            return s = 1;
        }
    }//pass

    /**
     * an equivalent BigDecimal value
     *
     * @return an equivalent BigDecimal value
     */
    public BigDecimal decimalValue() {
        if (this.isReaptingDecimal()) {
            throw new ArithmeticException("ArithmeticException\u200B(String s)");
        }
        BigDecimal b1 = new BigDecimal(this.numerator, MathContext.DECIMAL32);
        BigDecimal b2 = new BigDecimal(this.denominator, MathContext.DECIMAL32);
        return b1.divide(b2);
    }//pass 6/8 >0.75

    /**
     * Computes the value of this Rational divided by the given number.
     *
     * @param divisor - a number to divide by.
     * @return a new rational 6/8 . 0.5 > 3/2 this / val
     */
    public Rational divide(double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("divisor can not be zero");
        }
        Rational r1 = Rational.valueOf(divisor);
        Rational r = this.divide(r1);
        return r;
//        return new Rational(this.numerator.divide(r1.numerator), this.denominator.divide(r1.denominator));
    }//pass 6/8 . 0.5 > 3/2

    /**
     * Computes the value of this Rational divided by the given number.
     *
     * @param divisor - a number to divide by.
     * @return this / val
     */
    public Rational divide(long divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("divisor can not be zero");
        }
        return new Rational(this.numerator.divide(BigInteger.valueOf(divisor)), this.denominator.divide(BigInteger.ONE));
    }//pass

    /**
     * @param divisor - a Rational value to divide by
     * @return this / val
     */
    public Rational divide(Rational divisor) {
        if (divisor.numerator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("divisor can not be zero");
        }
        return new Rational(this.numerator.multiply(divisor.denominator), this.denominator.multiply(divisor.numerator));
    }

    /**
     * Converts this Rational value to a double. If the value has too great a magnitude to be represented as a double,
     * it will be converted to Double.NEGATIVE_INFINITY or Double.POSITIVE_INFINITY as appropriate.
     * This is a narrowing conversion and may result in loss of precision, even if the result is finite.
     *
     * @return valueOf(double source)  0.5   exp 1/2   outcome:  1/2
     */
    public double doubleValue() {
        BigDecimal b1 = new BigDecimal(this.numerator, MathContext.DECIMAL32);
        BigDecimal b2 = new BigDecimal(this.denominator, MathContext.DECIMAL32);
        return b1.divide(b2, MathContext.DECIMAL32).doubleValue();
    }//pass

    /**
     * whether this Rational is equivalent to the given object.
     * Returns true if and only if other is a Rational that represents the same value as this.
     *
     * @return this == other
     * boolean equals(Object other)  1/2  and 3/6   exp (true ) outcome:  true
     */
    public boolean equals(Object other) {
        if (other instanceof Rational) {
            return this.numerator.multiply(((Rational) other).denominator)
                    .equals(this.denominator.multiply(((Rational) other).numerator));
        } else {
            return false;
        }
    }//pass

    /**
     * Converts this Rational value to a float. If the value has too great a magnitude to be represented as a float,
     * it will be converted to Float.NEGATIVE_INFINITY or Float.POSITIVE_INFINITY as appropriate.
     * This is a narrowing conversion and may result in loss of precision, even if the result is finite.
     *
     * @return float floatValue()  1/2     exp (0.5f) outcome:  0.5 ,has to print out before return the float or it will be "1/2"
     */
    public float floatValue() {
        float f = (new BigDecimal(this.numerator, MathContext.DECIMAL32).
                divide(new BigDecimal(this.denominator, MathContext.DECIMAL32))).floatValue();
        System.out.println(f);
        return f;
    }//pass

    /**
     * Get the Denominator part of this Rational number's fractional form.
     *
     * @return the Denominator part of this Rational number's fractional form.
     */
    public BigInteger getDenominator() {
        return this.denominator;
    } //pass

    /**
     * Get the numerator part of this Rational number's fractional form.
     *
     * @return the Numerator part of this Rational number's fractional form.
     * BigInteger getNumerator()   1/2     exp (1) outcome:  1
     */
    public BigInteger getNumerator() {
        return this.numerator;
    }

    /**
     * Returns the hash code for this Rational.
     *
     * @return hash code for this Rational
     * test for method  int hashCode()   1/2     exp (1) outcome:  994
     * test for method  int hashCode()   1/2     exp (1) outcome:  1056
     * test for method  int hashCode()   1/2     exp (1) outcome:  994
     */
    public int hashCode() {
        Rational h1 = this.canonical();
        return Objects.hash(h1.numerator, h1.denominator);
    } //pass

    /**
     * Converts this Rational value to an int. This is a narrowing conversion that will discard any fractional part of the value (rounded down)
     * and can lose information about the overall magnitude of the value as well as return a result with the opposite sign.
     * int intValue()    3/2     exp (1) outcome:  1
     *
     * @return an approximately equivalent integral value
     */
    public int intValue() {
        return (this.numerator.divide(this.denominator)).intValue();
    }//pass

    /**
     * Returns true if this is a proper fraction.
     *
     * @return true if the absolute value of the numerator is less than the absolute value of the denominator; false otherwise.
     * test for method  boolean isProper()    3/2     exp (false) outcome:  false
     * test for method  boolean isProper()    3/5     exp (true) outcome:  true
     */
    public boolean isProper() {
        if ((this.numerator.abs().divide(this.denominator.abs())).doubleValue() < Double.valueOf("1")) {
            return true;
        }
        return false;
    }//passed

    /**
     * test for method  boolean isReaptingDecimal()  1/3    exp true   outcome:  true
     * Returns true if this value has a non-terminating decimal expansion.
     *
     * @return true is one rational is non-terminating,false otherwise;
     */
    public boolean isReaptingDecimal() {
        BigDecimal b1 = new BigDecimal(this.numerator);
        BigDecimal b2 = new BigDecimal(this.denominator);
        try {
            BigDecimal b3 = b1.divide(b2);
        } catch (Exception e) {
            return true;
        }
        return false;
    }//pass

    /**
     * Converts this Rational value to a long. This is a narrowing conversion that will discard any fractional part of the value (rounded down)
     * and can lose information about the overall magnitude of the value as well as return a result with the opposite sign.
     *
     * @return * test for method  long longValue()    50/3     exp (16) outcome:  16
     * * test for method  long longValue()    51/3     exp (17) outcome:  17
     */
    @Override
    public long longValue() {
        return this.numerator.divide(this.denominator).longValue();
    }//pass

    /**
     * Computes the value of this Rational multiplied by the given other Rational.
     *
     * @param val - a Rational value to multiply by
     * @return this * val
     * Rational multiply(Rational val)   1/3  * 5/2    exp (5/6 ) outcome:  5/6
     */
    public Rational multiply(Rational val) {
        return new Rational((this.numerator.multiply(val.numerator)), this.denominator.multiply(val.denominator));
    }//pass

    /**
     * @param val - a number to divide by
     * @return Rational multiply(long val)   1/3  * 13    exp (13/3 ) outcome:  13/3
     */
    public Rational multiply(long val) {
        BigInteger b1 = new BigInteger(String.valueOf(val));
        return new Rational(this.numerator.multiply(b1), this.denominator);
    }// passed ok

    /**
     * Computes the value of this Rational divided by the given number.
     *
     * @param val - a number to divide by
     * @return rational objects represent  a rational obj comes from the value of a double val and their product outcome
     */
    public Rational multiply(double val) {
        Rational r1 = valueOf(val);
        return new Rational(this.numerator.multiply(r1.numerator), this.denominator.multiply(r1.denominator));
    }

    /**
     * Returns a Rational that is the additive inverse of this value.
     *
     * @return this * -1
     * * Rational negate()   - 1/3      exp (1/3 ) outcome:  1/3
     */
    public Rational negate() {
        return new Rational(this.numerator.negate(), this.denominator);
    }


    /**
     * Computes the value of this Rational raised to the power of the given exponent.
     *
     * @param exponent - exponent to raise this value by
     * @return this ^ exponent
     * test for method  Rational pow(int exponent)   - 1/3 ^2     exp (1/9 ) outcome:  1/9
     */
    public Rational pow(int exponent) {
        if (this.numerator.equals(BigInteger.ZERO) || exponent < 0) {
            throw new ArithmeticException(" this value is zero and a negative exponent is given.");
        } else {
            return new Rational(this.numerator.pow(exponent), this.denominator.pow(exponent));
        }
    }//pass

    /**
     * Returns a Rational that is the multiplicative inverse of this value.
     *
     * @return this ^ -1
     * * Rational reciprocal()    2/3      exp (3/2 ) outcome:  3/2
     */
    public Rational reciprocal() {
        if (this.numerator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("this can't be zero");
        } else {
            return new Rational(this.denominator, this.numerator);
        }
    }//pass

    /**
     * Returns the sign of this value.
     *
     * @return -1 if this value is negative, +1 if positive, or 0 if exactly zero.
     * test for method  int signum()    2/3      exp (1 ) outcome:  1
     * test for method  int signum()    -2/3      exp (-1 ) outcome:  -1
     */
    public int signum() {
        int s1 = this.numerator.signum();
        int s2 = this.denominator.signum();
        if (s1 == 0 || s2 == 0) {
            return 0;
        } else if (s1 == s2) {
            return 1;
        } else {
            return -1;
        }
    }//pass

    /***
     * Computes the value of this Rational minus the given number.
     * @param subtrahend  subtrahend - a number to subtract
     * @return this - val
     * test for method  Rational subtract(double subtrahend)  2/3  -   0.5      exp (1/6  ) outcome:  1/6
     */
    public Rational subtract(double subtrahend) {
        Rational r1 = valueOf(subtrahend);
        return this.subtract(r1);
    }//pass

    /**
     * Computes the value of this Rational minus the given number.
     *
     * @param subtrahend subtrahend - a number to subtract
     * @return this - val
     */
    public Rational subtract(long subtrahend) {
        Rational r1 = new Rational(BigInteger.valueOf(subtrahend), BigInteger.ONE);
        return new Rational(this.denominator.multiply(r1.numerator).negate().add(this.numerator.multiply(r1.denominator)), this.denominator.multiply(r1.denominator));
    }//pass

    /***
     *Computes the value of this Rational minus the given other Rational.
     * @param subtrahend
     * @return this - val
     */
    public Rational subtract(Rational subtrahend) {
        return new Rational(this.denominator.multiply(subtrahend.numerator).negate().add(this.numerator.multiply(subtrahend.denominator)), this.denominator.multiply(subtrahend.denominator));
    }//pass

    /**
     * @return Rational valueOf(double source)  0.5   exp 1/2   outcome:  1/2
     */
    public String toString() {
        return numerator + "/" + denominator;
//        return this.numerator.longValue() + "/" + this.denominator.longValue();
    } //pass

    /**
     * Translates the given double into an equivalent Rational value.
     * Note that the results of this method may be confusing if invoked with a literal floating-point value that is not exactly representable by Java.
     * In all cases, the returned Rational will be equivalent to the actual binary value of source (for example,
     * calling Rational.valueOf(0.1) will not result in a value of 1/10). For more intuitively predictable results, use the valueOf(String) method instead.
     *
     * @param source - a value to convert
     * @return test for method  Rational valueOf(double source)  0.5   exp 1/2   outcome:  1/2
     * test for method  Rational valueOf(long source)  666   exp 666/1   outcome:  666/1
     * test for method  Rational valueOf(String source)  0.5   exp 1/2   outcome:  1/2
     */
    public static Rational valueOf(double source) {
        BigDecimal decimal = new BigDecimal(source);
        BigInteger unscaled = decimal.unscaledValue();
        int scale = decimal.scale();
        BigInteger b = BigInteger.TEN.pow(scale);
        return new Rational(unscaled, b);
//        BigInteger b1 = BigDecimal.valueOf(source).toBigInteger();
    } //PASSED

    /***
     * Translates the given long into an equivalent Rational value.
     * @param source - a value to convert
     * @return the given value as a Rational instance
     */
    public static Rational valueOf(long source) {
        return new Rational(BigInteger.valueOf(source), BigInteger.ONE);
    }

    /**
     * Translates the given String into an equivalent Rational value.
     * The source value may be given in the form "a / b" where a and b are integral values and b is non-zero, or as a decimal number.
     *
     * @param source - fractional or numeric value to convert
     * @return the given value as a Rational instance
     */
    public static Rational valueOf(String source) {
        if (source.contains("/") && source.contains(".")) {
            throw new NumberFormatException("NumberFormat error");
        }
        try {
            new BigDecimal(source);
        } catch (Exception e) {
            throw new NumberFormatException("This strign can't be convert to Bigdecimal");
        }
//        BigInteger b1 = new BigInteger(source);
        BigDecimal b1 = new BigDecimal(source);
        return new Rational(b1.toBigInteger(), BigInteger.ONE);

    }
}



























