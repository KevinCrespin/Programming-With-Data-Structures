package persistence2;

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
	
	public Course() {
		super();
	}
	
	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}
	
	public double meanGPA(ArrayList<Student> students) {
		double gpaSum = 0;
		double mean = 0;
		for (int i = 0; i < students.size(); i++) {
			gpaSum =+ students.get(i).getGPA();
			mean = gpaSum / students.size();
		}
		return mean;
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