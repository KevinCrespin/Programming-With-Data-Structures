package persistence1;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

public class PersisterTest <T> {

	Student student1 = new Student();
	Student student2 = new Student();
	Student student3 = new Student();
	
	Course course1 = new Course();
	Course course2 = new Course();
	Course course3 = new Course();
	
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Course> courses = new ArrayList<>();

	File fOStudent = new File("FOStudent.dat");
	File fLStudent = new File("FLStudent.dat");
	File fOCourse = new File("FOCourse.dat");
	File fLCourse = new File("FLCourse.dat");
	
	@Test
	void testSaveReadStudentFile() {
		PersisterImpl<Student> p = new PersisterImpl<Student>();
		PersisterImpl<Student> p2 = new PersisterImpl<Student>();
		
		student1.setGPA(3.5);
		student1.setName("Kevin Crespin");
		
		p.saveObjectToFile(fOStudent, student1);

		assertTrue(student1.equals(p2.readObjectFromFile(fOStudent)));
	}
	
	@Test
	void testSaveReadCourseFile() {
		PersisterImpl<Course> p = new PersisterImpl<Course>();
		PersisterImpl<Course> p2 = new PersisterImpl<Course>();
		
		student1.setGPA(3.5);
		student1.setName("Kevin Crespin");
		
		course1.setName("MATH 2030");
		course1.addStudent(student1);
		
		p.saveObjectToFile(fOCourse, course1);
		
		assertTrue(course1.equals(p2.readObjectFromFile(fOCourse)));
	}
	
	@Test
	void testSaveReadListStudentFile() {
		PersisterImpl<Student> p = new PersisterImpl<Student>();
		PersisterImpl<Student> p2 = new PersisterImpl<Student>();
		
		student1.setGPA(3.5);
		student1.setName("Kevin Crespin");
		
		student2.setGPA(3.5);
		student2.setName("Miguel Ruiz");
		
		student3.setGPA(4.0);
		student3.setName("Jose Rodriguez");
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		p.saveListToFile(fLStudent, students);
		
		for (int i= 0; i < students.size(); i++) {
			assertTrue(students.get(i).equals((p2.readListFromFile(fLStudent)).get(i)));
		}
		
	}
	
	@Test
	void testSaveListCourseToFile() {
		PersisterImpl<Course> p = new PersisterImpl<Course>();
		PersisterImpl<Course> p2 = new PersisterImpl<Course>();
		
		student1.setGPA(3.5);
		student1.setName("Kevin Crespin");
		students.add(student1);
		
		course1.setName("MATH 2030");
		course1.setStudents(students);
		
		student2.setGPA(3.5);
		student2.setName("Miguel Ruiz");
		students.add(student2);
		
		course2.setName("CS 2030");
		course2.setStudents(students);
		
		student3.setGPA(4.0);
		student3.setName("Jose Rodriguez");
		students.add(student3);
		
		course3.setName("PHYS 2030");
		course3.setStudents(students);
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		p.saveListToFile(fLCourse, courses);

		for (int i= 0; i < courses.size(); i++) {
			assertTrue(courses.get(i).equals((p2.readListFromFile(fLCourse)).get(i)));
		}
	}

}