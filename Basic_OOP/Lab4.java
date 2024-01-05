package ObjectOrientedProgramming;

public class Lab4 {	
}

/**
 * Class Rational that represents mathematical rational numbers of the form num/den
 * @author akulsareen
 * 
 */
class Rational {
    private int num;   
    private int den; 

	/**
	 * creates a rational number object that is equal to 1/1
	 */
	public Rational() {
		this.num = 1;
		this.den = 1;
    }
/**
 * creates a rational number object in its reduced form
 * by dividing num and denum by their gcd.
 * @param numerator
 * @param denominator
 */
    public Rational(int numerator, int denominator) {
    	int x;
    	if(numerator < denominator) {
    		x = numerator;
    	}
    	else {
    		x = denominator;
    	}
    	
    	int g = gcd(numerator , denominator);

    	if (denominator == 0)
    	{
    		this.num = 1;
    		this.den = 1;
    	}
    	else
    	{
    		this.num = numerator/g;
    		this.den = denominator/g;
    	}
    	
    }
    /**
     * Returns the numerator  of the rational number.
     * @return the numerator
     */
    public int getNum() {
		return this.num;
	}
    /**
     * Sets the numerator  of the rational number.
     * @param num the new value of the numerator.
     */
	public void setNum(int num) {
		this.num = num;
	}
	 /**
     * Returns the denominator  of the rational number.
     * @return the denominator
     */
	public int getDen() {
		return this.den;
	}
	/**
     * Sets the denominator  of the rational number.
     * @param den the new value of the denominator.
     */
	public void setDen(int den) {
		this.den = den;

	}
	/**
     * Computes the multiplication of this rational number with another rational number
     * @param b is the rational number to be multiplied by this rational number.
     * @return returns a new rational number of the multiplication result
     */
    public Rational times(Rational b) {
    	int new_num = this.num * b.getNum();
    	int new_den = this.den * b.getDen();

    	return new Rational(new_num , new_den);
    }
	/**
     * Computes the addition of this rational number with another rational number
     * @param b is the rational number to be added to this rational number.
     * @return returns a new rational number of the addition result
     */
    public Rational plus(Rational b) {
    	
    	int new_num1 = this.num * b.getDen();
    	int new_num2 = this.den * b.getNum();
    	int new_den = this.den * b.getDen();
        Rational s = new Rational(new_num1 + new_num2, this.den * b.getDen());
        return s;
    }
	
    
	/**
     * Computes the division of this rational number with another rational number
     * @param b is the rational number to divide this rational number.
     * @return returns a new rational number of the division result
     */
    
    public Rational divides(Rational b) {
    	int new_num = this.num * b.getDen();
    	int new_den = this.den * b.getNum();
    	return new Rational (new_num, new_den);
    }
    
    /**
     * Returns a string representation of the rational number as num/den, 
     * where num, and den are the components of the rational number 
     * @return a string representation of the rational number
     */
    
    public String toString() {
    	return this.num + "/"+this.den;
    }
    
    /**
     * Checks the equality of two rational numbers
     * @param b rational number to be compared with this rational number.
     * @return true if both rational numbers are equal, false otherwise
     */ 
    
    public boolean equals(Rational b) {
    	return (this.num == b.getNum() && this.den==b.getDen());
    }
    
    /**
     * Static method to calculate the gcd of two positive integers
     * @param m is the larger positive integer
     * @param n is the smaller positive integer
     * @return an integer which is the gcd of both m and n
     */
    
    public static int gcd(int m, int n) {
    	int g =1;
    	for(int i = 1; i <= m && i <= n; i++) {
    		if(m % i == 0 && n % i == 0) {
    			g = i;
    		}
   
    	}
    	return g;
    }
}

