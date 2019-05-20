package persistence1;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 4986105002043214274L;
	static public String name;
	static public Double GPA;

	public boolean equals(Student student) {
		
		if(GPA.equals(Student.GPA) && name.equals(Student.name)) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}

	}

	public String getName() {
		return name;
	}
	
	public Double getGPA() {
		return GPA;
	}

	public void setName(String name) {
		Student.name = name;
	}

	public void setGPA(Double gpa) {
		Student.GPA = gpa;
	}
	
}