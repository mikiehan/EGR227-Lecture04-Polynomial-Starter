import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mhan on 1/23/2017.
 */
public class PolynomialTest {
    public static final int[] EMPTY_EXP = new int[0];
    public static final double[] EMPTY_COEF = new double[0];

    @Test
    public void equalsWithArrayTest(){
        Polynomial p = new Polynomial();
        Assert.assertTrue(p.equals(EMPTY_COEF, EMPTY_EXP));
    }

    @Test
    public void equalsTest(){
        int[] expArray = {3, 2, 1};
        double[] coefArray = {5.0, 3.0, 5.0};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        int[] expArray2 = {3, 2, 1, 0};
        double[] coefArray2 = {5.0, 3.0, 5.0, 3.0};
        Polynomial p2 = new Polynomial(coefArray2, expArray2);

        Assert.assertFalse(p1 + " is not equal to " + p2, p1.equals(p2));
        Assert.assertFalse(p2 + " is not equal to " + p1, p2.equals(p1));
    }

    @Test
    public void addTermTest1() {
        Polynomial p = new Polynomial();
        p.add(new Term(1.5, 3));
        int[] expArray = {3};
        double[] coefArray = {1.5};
        Assert.assertTrue(p.equals(coefArray, expArray)); //testing add first when p.first is null

    }

    @Test
    public void addTermTest2() {
        int[] expArray = {3};
        double[] coefArray = {1.5};
        Polynomial p = new Polynomial(coefArray, expArray);

        p.add(new Term(4.8, 5));
        int[] expArray2 = {5, 3};
        double[] coefArray2 = {4.8, 1.5};
        Assert.assertTrue(p.equals(coefArray2, expArray2)); //testing add first when p.first is non-null

    }

    @Test
    public void addTermTest3() {
        int[] expArray2 = {5, 3};
        double[] coefArray2 = {4.8, 1.5};
        Polynomial p = new Polynomial(coefArray2, expArray2);
        p.add(new Term(9.6, 4));
        int[] expArray3 = {5, 4, 3};
        double[] coefArray3 = {4.8, 9.6, 1.5};
        Assert.assertTrue(p.equals(coefArray3, expArray3)); //testing add in the middle
    }

    @Test
    public void addTermTest4() {
        int[] expArray3 = {5, 4, 3};
        double[] coefArray3 = {4.8, 9.6, 1.5};
        Polynomial p = new Polynomial(coefArray3, expArray3);
        p.add(new Term(9.6, 4));
        int[] expArray4 = {5, 4, 3};
        double[] coefArray4 = {4.8, 9.6 + 9.6, 1.5};
        Assert.assertTrue(p.equals(coefArray4, expArray4)); //testing add in the middle with the same coefficient

    }

    @Test
    public void addTermTest5() {
        int[] expArray4 = {5, 4, 3};
        double[] coefArray4 = {4.8, 9.6 + 9.6, 1.5};
        Polynomial p = new Polynomial(coefArray4, expArray4);
        p.subtract(new Term(9.6 + 9.6, 4));
        int[] expArray5 = {5, 3};
        double[] coefArray5 = {4.8, 1.5};
        Assert.assertTrue(p.equals(coefArray5, expArray5)); //testing add in the middle resulting 0 coefficient

    }

    @Test
    public void addTermTest6() {
        int[] expArray5 = {5, 3};
        double[] coefArray5 = {4.8, 1.5};
        Polynomial p = new Polynomial(coefArray5, expArray5);
        p.add(new Term(-3.3, 0));
        int[] expArray6 = {5, 3, 0};
        double[] coefArray6 = {4.8, 1.5, -3.3};
        Assert.assertTrue(p.equals(coefArray6, expArray6)); //testing add last
    }

    @Test
    public void addTermTest7(){
        Polynomial p = new Polynomial();
        p.add(new Term(1.1, 3));
        p.add(new Term(6.11, 3));
        int [] expArray = {3};
        double [] coefArray = { 1.10 + 6.11 };
        Assert.assertTrue(p.toString(), p.equals(coefArray, expArray)); //testing add first with the same coefficient
    }

    @Test
    public void addTermTest8(){
        Polynomial p = new Polynomial();
        p.add(new Term(1.1, 3));
        p.add(new Term(-1.1, 3));
        Assert.assertTrue(p.toString(), p.equals(EMPTY_COEF, EMPTY_EXP)); //testing add first resulting in 0 coefficient
    }

    @Test
    public void subtractTermTest(){
        Polynomial p = new Polynomial();
        p.subtract(new Term(1.1, 3));
        p.subtract(new Term(6.11, 3));
        int [] expArray = {3};
        double [] coefArray = { (1.10 + 6.11) * -1.0 };
        Assert.assertTrue(p.toString(), p.equals(coefArray, expArray)); //testing add first with the same coefficient
    }

    @Test
    public void evaluateTest(){
        int[] expArray = {5, 3, 0};
        double[] coefArray = {4.8, 1.5, -3.3};
        Polynomial p = new Polynomial(coefArray, expArray);
        Assert.assertTrue( 4.8 * Math.pow(1.2, 5) + 1.5 * Math.pow(1.2, 3) -3.3 == p.evaluate(1.2));
    }

    @Test
    public void subtractPolynomialTest(){
        int[] expArray = {5, 3, 0};
        double[] coefArray = {4.8, 1.5, -3.3};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        int[] expArray2 = {5, 3, 0};
        double[] coefArray2 = {4.8, 1.5, -3.3};
        Polynomial p2 = new Polynomial(coefArray, expArray);

        p1.subtract(p2);
        Assert.assertTrue(p1.toString(), p1.equals(EMPTY_COEF, EMPTY_EXP));
    }

    @Test
    public void subtractPolynomialTest2(){
        int[] expArray = {5, 3, 0};
        double[] coefArray = {5.5, 3.5, -0.5};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        int[] expArray2 = {7, 4, 2, 0};
        double[] coefArray2 = {7.5, 4.5, -2.5, 3};
        Polynomial p2 = new Polynomial(coefArray2, expArray2);

        p1.subtract(p2);

        int[] expArray3 = {7, 5, 4, 3, 2, 0};
        double[] coefArray3 = {-7.5, 5.5, -4.5, 3.5, 2.5, -0.5 - 3};

        Assert.assertTrue(p1.toString(), p1.equals(coefArray3, expArray3));
    }

    @Test
    public void addPolynomialTest3(){
        int[] expArray = {5, 3};
        double[] coefArray = {5.5, 3.5};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        int[] expArray2 = {5, 4};
        double[] coefArray2 = {-5.5, 4.5};
        Polynomial p2 = new Polynomial(coefArray2, expArray2);

        p1.add(p2);

        int[] expArray3 = {4, 3};
        double[] coefArray3 = {4.5, 3.5};

        Assert.assertTrue(p1.toString(), p1.equals(coefArray3, expArray3));
    }

    @Test
    public void addPolynomialTest4(){
        int[] expArray = {5, 3, 1};
        double[] coefArray = {5.5, 3.5, 1.5};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        int[] expArray2 = {4, 3, 0};
        double[] coefArray2 = {-4.5, -3.5, 2.7};
        Polynomial p2 = new Polynomial(coefArray2, expArray2);

        p1.add(p2);

        int[] expArray3 = {5, 4, 1, 0};
        double[] coefArray3 = {5.5, -4.5, 1.5, 2.7};

        Assert.assertTrue(p1.toString(), p1.equals(coefArray3, expArray3));
    }

    @Test
    public void removeExpTest(){
        int[] expArray = {5, 3, 1};
        double[] coefArray = {5.5, 3.5, 1.5};
        Polynomial p1 = new Polynomial(coefArray, expArray);
        p1.remove(5);
        int[] expArray2 = {3, 1};
        double[] coefArray2 = {3.5, 1.5};
        Assert.assertTrue(p1.toString(), p1.equals(coefArray2, expArray2));
    }

    @Test
    public void removeExpTest2(){
        int[] expArray = {5, 3, 1};
        double[] coefArray = {5.5, 3.5, 1.5};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        p1.remove(3);

        int[] expArray2 = {5, 1};
        double[] coefArray2 = {5.5, 1.5};

        Assert.assertTrue(p1.toString(), p1.equals(coefArray2, expArray2));
    }

    @Test
    public void removeExpTest3(){
        int[] expArray = {5, 3, 1};
        double[] coefArray = {5.5, 3.5, 1.5};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        p1.remove(1);

        int[] expArray2 = {5, 3};
        double[] coefArray2 = {5.5, 3.5};

        Assert.assertTrue(p1.toString(), p1.equals(coefArray2, expArray2));
    }

    @Test
    public void removeExpTest4(){
        int[] expArray = {5, 3, 1};
        double[] coefArray = {5.5, 3.5, 1.5};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        p1.remove(11);
        Assert.assertTrue(p1.toString(), p1.equals(coefArray, expArray));
    }

    @Test
    public void removeExpTest5(){
        int[] expArray = {10, 9, 8, 7, 6, 5, 3, 1};
        double[] coefArray = {5.5, 3.5, 1.5, 3, 3, 3, 3, 1.0};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        p1.remove(0);
        Assert.assertTrue(p1.toString(), p1.equals(coefArray, expArray));
    }

    @Test
    public void multiplyTest5(){
        int[] expArray = {3, 2, 0};
        double[] coefArray = {5.0, 3.0, 2.0};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        p1.multiply(new Term(6.0, 2));
        int[] expArray2 = {5, 4, 2};
        double[] coefArray2 = {30.0, 18.0, 12.0};

        Assert.assertTrue(p1.toString(), p1.equals(coefArray2, expArray2));
    }

    @Test
    public void multiplyTest6(){
        int[] expArray = {3, 2, 0};
        double[] coefArray = {5.0, 3.0, 2.0};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        p1.multiply(new Term(3.0, 0));
        int[] expArray2 = {3, 2, 0};
        double[] coefArray2 = {15.0, 9.0, 6.0};

        Assert.assertTrue(p1.toString(), p1.equals(coefArray2, expArray2));
    }

    @Test
    public void multiplyTest7(){
        int[] expArray = {3, 2, 0};
        double[] coefArray = {5.0, 3.0, 2.0};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        int[] expArray2 = {3, 0};
        double[] coefArray2 = {3.0, -5.0};
        Polynomial p2 = new Polynomial(coefArray2, expArray2);

        int [] expArray3 = {6, 5, 3, 2, 0};
        double[] coefArray3 = {15.0, 9.0, -19.0, -15.0, -10.0 };

        p1.multiply(p2);
        Assert.assertTrue(p1.toString(), p1.equals(coefArray3, expArray3));
    }

    @Test
    public void multiplyTest8(){
        int[] expArray = {3, 2, 0};
        double[] coefArray = {5.0, 3.0, 5.0};
        Polynomial p1 = new Polynomial(coefArray, expArray);

        int[] expArray2 = {3, 0};
        double[] coefArray2 = {5.0, -5.0};
        Polynomial p2 = new Polynomial(coefArray2, expArray2);

        int [] expArray3 = {6, 5, 2, 0};
        double[] coefArray3 = {25.0, 15.0, -15.0, -25.0 };

        p1.multiply(p2);
        Assert.assertTrue(p1.toString(), p1.equals(coefArray3, expArray3));
    }
}
