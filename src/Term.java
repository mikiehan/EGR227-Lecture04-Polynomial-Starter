/**
 * Created by mhan on 1/23/2017.
 * Represents a term in polynomial (ListNode)
 */
public class Term {
    //note that fields are public!
    public double coef; //coefficient
    public int exp; //exponent
    public Term next;

    /**
     * Constructor for Term
     * @param coef, this coef should set to param coef
     * @param exp, this exp should set to param exp
     * @param next, this next should set to next given (this.next and param next should be the same reference)
     */
    public Term(double coef, int exp, Term next){
        //fill this code
    }

    /**
     * Constructor for Term
     * next should be set to null
     * @param coef, this coef should set to param coef
     * @param exp, this exp should set to param exp
     */
    public Term(double coef, int exp) {
        //fill this code
    }

    /**
     * Constructor for Term
     * this and t should not be the same reference
     * @param t, this should be set to a new object that has the same value as t's fields
     */
    public Term (Term t){
        //fill this code
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && getClass() == obj.getClass()) {
            Term other = (Term) obj;
            return coef == other.coef && exp == other.exp ; //I do not care about next
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1 ;
        result = 37 * result + new Integer(exp).hashCode();
        result = 37 * result + new Double(coef).hashCode();
        return result;
    }
}
