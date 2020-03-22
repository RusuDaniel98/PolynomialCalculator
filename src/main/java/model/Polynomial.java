package model;

/*
*Model class used to implement operations on polynomials with the result containing integer coefficients.
* Methods implemented:
 - add: used to add the polynomial received as parameter to the polynomial the method is called on (this).
        It returns a new polynomial with the degree equal to maximum btw. first and second polynomial,
        and the coefficients array corresponding to the sum of the two polynomials.
 -subtract: similar to the 'add' method; It performs the subtraction of two polynomials.
 -multiply: similar to the 'add' and 'subtract' methods; The result polynomial has the degree equal to
            the sum of first and second polynomials degree.
 -derive: method that has no parameters, it performs the operation on the polynomial object it was called on.
          The result is a new polynomial with the degree equal to the first polynomial degree, minus one.
 -toString: has no parameters. It is used to build a String from the polynomial attributes 'degree' and 'coeff'.
            The result is displayed in the user interface, as the operation output.
 -getters for the two attributes of the class: degree and coeff.
 */

public class Polynomial {

    private int degree;
    private int[] coeff = new int[20];

    public Polynomial() {
    }

    public Polynomial(int[] coeff) {
        this.coeff = coeff;
        this.degree = this.getDegree();
    }

    public Polynomial(int number) {
        this.degree = this.getDegree();
        this.coeff = new int[number + 1];
    }

    public int getDegree() {
        return this.coeff.length - 1;
    }

    public int[] getCoeff() {
        return this.coeff;
    }

    //add method
    public Polynomial add(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(Math.max(a.getDegree(), b.getDegree()));
        c.degree = Math.max(a.degree, b.degree);
        if (a.degree == b.degree) {
            for (int i = 0; i <= a.degree; i++) {
                c.coeff[i] = a.coeff[i] + b.coeff[i];
            }
        } else {
            if (a.degree > b.degree) {
                for (int i = 0; i < a.degree - b.degree; i++) {
                    c.coeff[i] = a.coeff[i];
                }
                for (int i = a.degree - b.degree; i <= a.degree; i++) {
                    c.coeff[i] = a.coeff[i] + b.coeff[i - (a.degree - b.degree)];
                }
            } else {
                for (int i = 0; i < b.degree - a.degree; i++) {
                    c.coeff[i] = b.coeff[i];
                }
                for (int i = b.degree - a.degree; i <= b.degree; i++) {
                    c.coeff[i] = b.coeff[i] + a.coeff[i - (b.degree - a.degree)];
                }
            }
        }
        return c;
    }

    //subtract method
    public Polynomial subtract(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(Math.max(a.getDegree(), b.getDegree()));
        c.degree = Math.max(a.degree, b.degree);
        if (a.degree == b.degree) {
            for (int i = 0; i <= c.degree; i++) {
                c.coeff[i] = a.coeff[i] - b.coeff[i];
            }
        } else {
            if (a.degree > b.degree) {
                for (int i = 0; i < a.degree - b.degree; i++) {
                    c.coeff[i] = a.coeff[i];
                }
                for (int i = a.degree - b.degree; i <= c.degree; i++) {
                    c.coeff[i] = a.coeff[i] - b.coeff[i - (a.degree - b.degree)];
                }
            } else {
                for (int i = 0; i < b.degree - a.degree; i++) {
                    c.coeff[i] = b.coeff[i];
                }
                for (int i = b.degree - a.degree; i <= c.degree; i++) {
                    c.coeff[i] = b.coeff[i] - a.coeff[i - (b.degree - a.degree)];
                }
            }
        }
        return c;
    }

    //multiply method
    public Polynomial multiply(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(a.degree + b.degree);
        c.degree = a.getDegree() + b.getDegree();
        for (int i = 0; i <= a.degree; i++) {
            for (int j = 0; j <= b.degree; j++) {
                c.coeff[i + j] += a.coeff[i] * b.coeff[j];
            }
        }
        return c;
    }

    //derive method
    public Polynomial derive() {
        Polynomial a = this;
        Polynomial c = new Polynomial(a.degree - 1);

        for (int i = 0; i <= a.degree - 1; i++) {
            c.coeff[i] = a.coeff[i] * (a.degree - i);
        }
        c.degree = c.getDegree();
        return c;
    }

    //method used to output the polynomial nicely, as a string (conventionally named 'toString')
    //will override the 'toString' method that already exists in Java Object class
    @Override
    public String toString() {
        Polynomial a = this;
        String result = "";
        int pwr = this.getDegree();
        if (this.degree == 0) {
            return result + this.coeff[0];
        }
        for (int i = 0; i <= this.degree; i++) {     //test < .. +1
            if (this.coeff[i] < 0) {
                result = result + this.coeff[i];
            } else {
                if (this.coeff[i] > 0) {
                    result += "+" + this.coeff[i];
                } else {
                    continue;
                }
            }
            result += "x^" + pwr;
            pwr--;
        }
        if (result.startsWith("+")) {
            result = result.substring(1);
        }
        if (result.toLowerCase().contains("x^0".toLowerCase())) {
            result = result.substring(0, result.length() - 3);
        }

        return result;
    }


}


