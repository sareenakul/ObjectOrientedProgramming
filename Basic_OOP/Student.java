package ObjectOrientedProgramming;
import java.util.*;


/* when you implement Comparable, it is possible that a warning
 * is given, which you should ignore for now, until we discuss Generics. 
 */
public abstract class Student implements Comparable {
	protected int id;
	// add the rest of attributes here
	protected String name;
	protected ArrayList<Course> courses = new ArrayList<Course>();
	
	
	/**
	 * This method adds <code> course </code> to this student list of courses.
	 * @param course is the course that is added 
	 * @throws Exception This methods may throw either <code> RegistrationException </code> or
	 * <code> PrerequisiteException </code>.
	 */
	public abstract void addCourse (Course course) throws Exception;
	
	
	/**
	 * This method removes <code> course </code> from this student's list of courses.
	 * If the course is not in the list of courses of the student, no action is needed.
	 * @param course is the course that is to be removed. 
	 */
	public abstract void dropCourse(Course course);

	/**
	 * This is the accessor method for <code> id </code>
	 * @return It returns the id of this student.
	 */
	//insert your code here
	
	public int getId() {
		return this.id;
	}
	
	
	/**
	 * This is the accessor method for <code> name </code>
	 * @return It returns the name of the student.
	 */
	//insert your code here
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * This is the accessor method for <code> courses </code>
	 * @return It returns all the courses a student has taken and currently taking.
	 */
	//insert your code here
	public ArrayList<Course> getCourses() {
		return this.courses;
	}
	

	/**
	 * This method compares two students. If the two students have the same values
	 * for all the instance variables, they are considered, equal and this 
	 * method returns 0. If two objects were not equal, the student whose id is less, 
	 * is the smaller object so this method returns -1. Otherwise it returns 1.
	 * @param obj is an object of type student.
	 * @return<pre> It returns 0, if the two objects are equal. 
	 * It returns -1, if this object is less than the object that is passed as a parameter into the method. 
	 * It returns 1, if this object is greater than the object that is passed as a parameter into the method<pre>. 
	 */
	@Override
	//insert your code here
	public int compareTo(Object obj) {
		Student student = (Student) obj;
		if(this.id == student.id) {
			return 0;
		}
		if(this.id < student.id) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
}

class RegisteredStudent extends Student{
	
	//insert your code here
	public RegisteredStudent(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public void addCourse(Course course) throws RegistrationException, PrerequisiteException {
		
		if(course.offered == false) {
			throw new RegistrationException("Course is not offered");
		}
		if(course.getPrerequisite() != null && !this.courses.contains(course.getPrerequisite())) {
			throw new PrerequisiteException("no Prerequisite");
		}
		
		this.courses.add(course);
	}
	
	public void dropCourse(Course course) {
		if(this.courses.size() != 0 && this.courses.contains(course))
		this.courses.remove(course);
	}
	
	@Override
	public boolean equals(Object obj) {
		Student student = (Student) obj;
		
		if(obj == null || !this.name.equals(student.getName()) || this.id != student.getId() || !this.courses.equals(student.getCourses())) {
			return false;
		}
		else {
			return true;
		}
		
	}
		@Override
		public int hashCode() {
			return (int) (id * name.hashCode());
		}
	
}

class Course {
	//add the protected fields
	protected String name;
	protected Course prerequisite;
	protected boolean offered;
	
	
	//insert code for constructor(s)
	public Course() {
		this.name = "";
		this.prerequisite = null;
		this.offered = false;
		
	}
	
	public Course(String name, boolean offered) {
		this.name = name;
		this.offered = offered;
		this.prerequisite = null;
	}
	
	public Course(String name, Course prerequisite, boolean offered) {
		this.name = name;
		this.prerequisite = prerequisite;
		this.offered = offered;
	}
	
	//insert code for setters and getters
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setPrerequisite(Course prerequisite) {
		this.prerequisite = prerequisite;
	}
	public void setOffered(boolean offered) {
		this.offered = offered;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	public Course getPrerequisite() {
		return this.prerequisite;
	}
	public boolean getOffered() {
		return this.offered;
	}
	
	
	
	//override the equals method
	public boolean equals(Course course) {
		if(course == null || getClass() != course.getClass() || this.offered != course.offered) {
			return false;
		}
		else {
			return true;
		}
	}
	
}

/**
 * This class is a user defined Exception used 
 * when adding a course not offered, is not allowed.
 */
	// insert your code here
class RegistrationException extends Exception{
	public RegistrationException () {
		super();
	}
	public RegistrationException (String message) {
		super(message);
	}
}

/**
 * This is a user defined exception used
 * when adding a course whose prerequisite is not taken/registered is not allowed.
 */
	// insert your code here
class PrerequisiteException extends Exception{
	public PrerequisiteException () {
		super();
	}
	public PrerequisiteException (String message) {
		super(message);
	}
}
