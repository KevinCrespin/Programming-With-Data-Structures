package persistence2;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 4986105002043214274L;
	static public String fName;
	static public String lName;
	static public Double GPA;

	public boolean equals(Student student) {
		
		if(GPA.equals(Student.GPA) && fName.equals(Student.fName) && lName.equals(Student.lName)) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
	}

	public String getFirstName() {
		return fName;
	}
	
	public String getLastName() {
		return lName;
	}
	
	public Double getGPA() {
		return GPA;
	}

	public void setName(String first, String last) {
		Student.fName = first;
		Student.lName = last;
	}

	public void setGPA(Double gpa) {
		Student.GPA = gpa;
	}
	
}