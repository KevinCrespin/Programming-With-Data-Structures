package persistence1;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
	
	private static final long serialVersionUID = -1045688477175609886L;
	static public String name;
	static public ArrayList<Student> students;

	public boolean equals(Course course) {
		
		if(students.equals(Course.students) && name.equals(Course.name)) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
	}
	
	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setName(String name) {
		Course.name = name;
	}

	public void setStudents(ArrayList<Student> newStudents) {
		students = newStudents;
	}

}