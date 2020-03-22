package model;

import java.text.DecimalFormat;

/*
 *Model class used to implement operations on polynomials with the result containing floating point coefficients.
 * Methods implemented:
  -integrate: has no parameters. It performs the integration operation on the polynomial object it is called on.
              The result is a new polynomial with the degree equal to the first polynomial degree, plus one.
  -toString: has no parameters. It is used to build a String from the polynomial attributes 'degree' and 'coeff'.
            The result is displayed in the user interface, as the operation output.
  -getters for the two attributes of the class: degree and coeff.
 */

public class PolynomialFloating {

    private int degree;
    private float[] coeff = new float[20];

    public PolynomialFloating() {
    }

    public PolynomialFloating(float[] coeff) {
        this.coeff = coeff;
        this.degree = this.getDegree();
    }

    public PolynomialFloating(int number) {
        this.degree = this.getDegree();
        this.coeff = new float[number + 1];
    }

    public int getDegree() {
        return this.coeff.length - 1;
    }

    public float[] getCoeff() {
        return this.coeff;
    }

    //integrate method
    public PolynomialFloating integrate() {
        PolynomialFloating a = this;
        int size = a.getDegree() + 2;
        float[] cCoeff = new float[size];
        PolynomialFloating c = new PolynomialFloating(cCoeff);
        for (int i = 0; i < a.getDegree() + 1; i++) {
            c.coeff[i] = (float) (a.getCoeff()[i]) / (float) (a.degree - i + 1);
        }
        return c;
    }

    //toString method is used to convert the representation of polynomials (degree and array of coefficients)
    //into a string that is readable for the user. It is used to show the result of operations in the user interface.
    //DecimalFormat is used to represent the floating values with only two digits after '.'
    DecimalFormat df = new DecimalFormat("#.##");

    public String toString() {
        PolynomialFloating a = this;
        String result = "";
        int pwr = this.getDegree();
        if (this.degree == 0) {
            return result + df.format(this.coeff[0]);
        }
        for (int i = 0; i <= this.degree; i++) {     //test < .. +1
            if (this.coeff[i] < 0) {
                result = result + df.format(this.coeff[i]);
            } else {
                if (this.coeff[i] > 0) {
                    result += "+" + df.format(this.coeff[i]);
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
        result = result.substring(0, result.length() - 3);

        return result;
    }


}

