package ObjectOrientedProgramming;
import java.util.List;
import java.util.ArrayList;

/**
 * This class contains a number of methods that 
 * work on a wide range of data types. 
 */

/* This is a parameterized class. You should decide 
* what the parameter should look like in order to 
* pass all the test cases. 
*/

// you might want to change the parameter of this class to something more appropriate. 
public class Utility <T extends Comparable<T>> {
	
	List<T> list = new ArrayList<T>();
	
	//Default Constructor
	public Utility() {
		
	}
	
	//Parameterized Constructor
	public Utility(List<T> myList) {
		for(int i = 0; i < myList.size(); i++) {
			this.list.add(myList.get(i));
		}
	}


	public int linearSearch(T element) {
		int position = -1;
		for(int i = 0; i < list.size(); i++) {
			if(element.compareTo(list.get(i)) == 0) {
				position = i;
				break;
			}
		}
		return position;
	}

	public boolean containList(List<T> list) {
		boolean answer = false;
		if (this.list.containsAll(list)) {
			this.list = new ArrayList<T>(); 
			for (T obj: this.list) 
				this.list.add(obj);
			answer = true;
		}
		else {
			answer = false;
		}
		return answer;
	}

	public void removeMultipleOf10(List<? extends MyInteger> list) {
		for (int i = 0; i < list.size(); i++) {
			if (MyInteger.isMultipleOf10(list.get(i))) {
				list.remove(i);
				i--;
			}
				
		}
		
	}

	public void mergeList(List<? super T> list) {
		for (T obj: this.list)
			list.add(obj);	
	}
}


/**
 * This class implements a 2D points. 
 */
class Point implements Comparable<Point>{
	double x; 
	double y; 
	public Point(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	
	//For the sake of testing, comparison is not implemented as the conventional 
	//coordinates comparison
	@Override 
	public int compareTo(Point p) {
		if (this.x == p.x && this.y == p.y) return 0;
		else if (this.x == p.x) return 1;
		else return -1;	
	}
}

/**
 * This class represents an Integer number. 
 */
class MyInteger implements Comparable<MyInteger>{
	int x; 
	public MyInteger() {
		this.x = 0; 
	}
	public MyInteger(int x) {
		this.x = x; 
	}
	public static boolean isMultipleOf10(MyInteger input) {
		return (input.x %10) == 0; 
	}
	@Override
	public int compareTo(MyInteger input) {
		if (this.x == input.x ) return 0;
		else if (this.x < input.x) return -1;
		else return 1;	
	}
}
/**
 * This class represents a subset of integer numbers that are natural numbers. 
 */
class NaturalNumber extends MyInteger{
	public NaturalNumber(int x) {
		super(x);
	}
}
/**
 * This class represents the odd natural numbers. 
 */

class OddNumber extends NaturalNumber{
	public OddNumber(int x) {
		super(x);
	}
	
}
/**
 * This class represents the even natural numbers. 
 */
class EvenNumber extends NaturalNumber{
	public EvenNumber(int x) {
		super(x);
	}
}