import model.Polynomial;
import model.PolynomialFloating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnitOperationsTest {
    private Polynomial poly1, poly2;
    private int[] poly1Coeff = {1, 3, -6};
    private int[] poly2Coeff = {3 -2, -9};

    @Test
    public void testAdd(){
        poly1 = new Polynomial(poly1Coeff);
        poly2 = new Polynomial(poly2Coeff);
        String result = poly1.add(poly2).toString();
        Assertions.assertEquals("1x^2+4x^1-15", result);
    }

    @Test
    public void testSubtract(){
        poly1 = new Polynomial(poly1Coeff);
        poly2 = new Polynomial(poly2Coeff);
        String result = poly1.subtract(poly2).toString();
        Assertions.assertEquals("1x^2+2x^1+3", result);
    }

    @Test
    public void testMultiply(){
        poly1 = new Polynomial(poly1Coeff);
        poly2 = new Polynomial(poly2Coeff);
        String result = poly1.multiply(poly2).toString();
        Assertions.assertEquals("1x^3-6x^2-33x^1+54", result);
    }

    @Test
    public void testDerive(){
        poly1 = new Polynomial(poly1Coeff);
        String result = poly1.derive().toString();
        Assertions.assertEquals("2x^1+3", result);
    }

    @Test
    public void testIntegrate(){
        float[] aCoeff = new float[poly1Coeff.length];
        for(int i=0; i<poly1Coeff.length; i++) {
            aCoeff[i] = (float) (poly1Coeff[i]);
        }
        PolynomialFloating a = new PolynomialFloating(aCoeff);
        String result = a.integrate().toString();
        Assertions.assertEquals("0.33x^3+1.5x^2-6", result);
    }

}
