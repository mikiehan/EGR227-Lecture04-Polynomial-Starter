import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mhan on 1/23/2017.
 * Exponents should be decreasing order
 */
public class Polynomial {
    private Term first;

    /**
     * IMPLEMENT THIS METHOD!!
     * Constructor for building empty polynomial
     */
    public Polynomial(){
        //write your code here
    }

    /**
     * CODE GIVEN. DO NOT CHANGE THIS CODE!!
     * Constructor for building polynomial with given coefficients and exponents
     * @param coefs array of non-zero coefficients
     * @param exps array of exponents in strictly descending order (no two terms has the same exponent)
     * @throws IllegalArgumentException if any coefficient is zero or exponents are not in strictly descending order
     */
    public Polynomial(double[] coefs, int[] exps) {
        if (coefs.length != exps.length)
            throw new IllegalArgumentException("Two arrays for coefficient and exponents should have the same length");

        Term current = first;
        for(int i = 0 ; i < coefs.length ; i++){
            if(coefs[i] == 0){
                throw new IllegalArgumentException("Coefficient should not be zero");
            }
            if (i > 0 && exps[i-1] <= exps[i])
                throw new IllegalArgumentException("Exponents has to be in strictly descending order");
            if(first == null){
                first = new Term(coefs[i], exps[i]);
                current = first;
            } else {
                current.next = new Term(coefs[i],exps[i]);
                current = current.next;
            }
        }
    }

    /**
     * IMPLEMENT THIS METHOD!!
     * @return the number of terms in this polynomial
     */
    public int size() {
        int count = 0;
        //Write your code here
        return count;
    }

    /**
     * IMPLEMENT THIS METHOD!!
     * Given the value of x, evaluate the polynomial and return the result
     * @param x the value to evaluate the polynomial with
     * @return the evaluated result of the polynomial given x
     * For example, if you have P(x) = 3.0 x^2 + 2.0 x^1 + 1.0 then you are asked to do p.evaluate(10)
     * you need to calculate P(10), which is 3.0 * 100 + 2.0 * 10 + 1.0 = 321.0
     */
    public double evaluate(double x){
        double result = 0;
        //Write your code here
        return result;
    }

    /**
     * IMPLEMENT THIS METHOD!!
     * @return a string representing this polynomial
     * For example, if the polynomial is (3.0, 3) -> (4.0, 1) -> (5.5, 0)
     * it should return "3.0 x^3 + 4.0 x^1 + 5.5 x^0"
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Write your code here
        return sb.toString();
    }

    /**
     * IMPLEMENT THIS METHOD!!
     * this method only takes Polynomial type as the parameter
     * @param other, the other polynomial that you are comparing against this polynomial with
     * @return true, if this and other has the same set of terms
     * note that this polynomial and other polynomial could be different length (in this case should return false)
     */
    private boolean equals(Polynomial other){
        Term current = first;
        Term otherCurrent = other.first;

        //Write your code here
        return false; // change this code
    }

    /**
     * IMPLEMENT THIS METHOD
     *  remove the term that has given exponent
     * if none do not remove any term
     * @param exp
     */
    public void remove(int exp){
        //Part 1: take care of empty list
        //Write your code here

        //Part 2: take care remove first
        //Write your code here

        //Part 3: take care remove non-first
        //Write your code here
    }

    /**
     * IMPLEMENT THIS METHOD.
     * This method adds a term to this polynomial and saves the result in this polynomial
     * @param termToAdd
     * You must add termToAdd to the correct position observing class invariant
     * You must not alter termToAdd
     * If a coef becomes zero after adding, you need to remove the term with 0-coef to preserve the class invariants
     */
    public void add(Term termToAdd){
        if (termToAdd == null || termToAdd.coef == 0) return;

        //PART 1 : take care of adding termToAdd to the first
        //Write your code here

        //PART 2: take care of first exp and termToAdd exp is the same
        //Write your code here

        //Part 3: take care of adding to non-first
        //Write your code here
    }

    /**
     * IMPLEMENT THIS METHOD
     * This method adds other polynomial from this polynomial and saves the result in this polynomial
     * Hint: you can use add(term) as helper method for this method
     * @param other
     * You must leave other polynomial unaltered. only change this polynomial
     */
    public void add(Polynomial other){
        //WRITE YOUR CODE HERE
    }

    /**
     * IMPLEMENT THIS METHOD
     * This method substracts other polynomial from this polynomial and saves the result in this polynomial
     * Hint: you can use subtract(term) as helper method for this method
     * @param other
     * You must leave other polynomial unaltered. only change this polynomial
     */
    public void subtract(Polynomial other){
        //WRITE YOUR CODE HERE
    }

    /**
     * IMPLEMENT THIS METHOD
     * When this method runs
     * this polynomial should contain new set of coefficients and exponents which is the result of
     * multiplying this polynomial with other polynomial given
     * MUST leave termToMult unaltered. You are allowed to change only this polynomial
     * @param termToMult
     */
    // Assume the parameter termToMult will never be null
    public void multiply(Term termToMult){
        if(termToMult == null || termToMult.coef == 0 ) {
            throw new IllegalArgumentException(
                    "term to multiply should not be null or the coefficient of the term should not be zero");
        }
        //WRITE YOUR CODE HERE
    }

    /**
     * IMPLEMENT THIS METHOD
     * When this method runs
     * this polynomial should contain new set of coefficients and exponents which is the result of
     * multiplying this polynomial with other polynomial given
     * @param other the polynomial given to multiply this polynomial with
     * MUST leave other unaltered. You are allowed to change only this polynomial
     */
    public void multiply(Polynomial other){
        Polynomial newPoly = new Polynomial(); // it is best to declare a new polynomial to store the result

        //WRITE YOUR CODE HERE

        first = newPoly.first; //simply reset first to newPoly's first, Java's GC will automatically kick-in
    }


    /**
     * CODE GIVEN. DO NOT CHANGE THIS CODE
     * Subtracts termToSubtract from this polynomial and saves the result in this polynomial
     * @param termToSubtract
     */
    public void subtract(Term termToSubtract){
        add(new Term(termToSubtract.coef * -1.0, termToSubtract.exp));
    }

    /**
     * CODE GIVEN. DO NOT CHANGE THIS CODE.
     * Provided for test purpose
     * @param coefs array of non-zero coefficients
     * @param exps array of exponents that is strictly descending
     * @return true if this polynomial has matching coefs and exps as the parameters
     * @throws IllegalArgumentException if coefficients and exponents has different length,
     * if any coefficient is zero, or exponents are not in strictly descending order
     */
    public boolean equals(double[] coefs, int[] exps) {
        if (coefs.length != exps.length)
            throw new IllegalArgumentException("Two arrays for coefficient and exponents should have the same length");

        if (coefs.length != size()){
            return false;
        }
        Term current = first;
        int i = 0;
        while (current != null){
            if(coefs[i] == 0)
                throw new IllegalArgumentException("coefficient should not be zero");
            if(current.coef != coefs[i] || current.exp != exps[i]) return false;
            current = current.next;
            i++;
        }
        return true;
    }

    /**
     * CODE GIVEN DO NOT CHANGE THIS CODE
     * This method takes any type obj and compares obj with this polynomial
     * @param obj
     * @return true in case obj is Polynomial type and has the same set of coefficients and exponents as this polynomial
     * , false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj != null && getClass() == obj.getClass()) {
            Polynomial other = (Polynomial) obj;
            return equals(other);
        }
        return false;
    }

    /**
     * CODE GIVEN. DO NOT CHANGE THIS CODE.
     * It is best practice to override hashCode when you override equals and vice versa
     * @return hashcode for this polynomial
     */
    @Override
    public int hashCode() {
        if (first == null) return 0;
        int result = 1;
        Term current = first;
        while (current != null ){
            result = 37 * result + current.hashCode();
        }
        return result;
    }
}
