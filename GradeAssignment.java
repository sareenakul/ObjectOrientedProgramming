package ObjectOrientedProgramming;

/**
 * Objective: Assigning grades to students using conditionals
 * @author akulsareen
 */

public class GradeAssignment {
	/**
	 * This method returns the student ID
	 * @return returns the  students number, which should be 9 digits long
	 */
	public static String getMyID(){
		return "12345";
	}
	/**
	 * This method gets a decimal grade value and returns its corresponding letter grade value.
	 * @param grade is a double number that represent a grade
	 * @return returns a letter grade equivalent of the input grade.
	 */
	public static String getLetterGrade(double grade) {
		if(grade < 45 && grade >= 0){
			return("F");
		}
		else if(grade <50 && grade >= 45){
			return("E");
		}
		else if(grade >=50 && grade <55){
			return("D");
		}
		else if(grade >=55 && grade <60){
			return("D+");
		}
		else if(grade >=60 && grade <65){
			return("C");
		}
		else if(grade >=65 && grade <70){
			return("C+");
		}
		else if(grade >=70 && grade <75){
			return("B");
		}
		else if(grade >=75 && grade <80){
			return("B+");
		}
		else if(grade >=80 && grade <90){
			return("A");
		}
		else {
			return("A+");
		}
	}
}

