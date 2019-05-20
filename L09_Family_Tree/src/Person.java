import java.util.GregorianCalendar;

public class Person implements Comparable<Person>{
	String firstName;
	String lastName;
	private GregorianCalendar dateOfBirth;
	private GregorianCalendar dateOfDeath;
	
	@Override
	public int compareTo(Person p) {
		int last = this.lastName.compareTo(p.lastName);
		return last == 0 ? this.firstName.compareTo(p.firstName) : last;
	}
	
	public boolean equals(Person p1, Person p2) {
		if(p1.equals(p2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "First name: " + this.firstName + " Last name: " + this.lastName + "Birth: " + this.dateOfBirth + "Death: " + this.dateOfDeath;
	}
	
	public Person(String firstName, String lastName, GregorianCalendar dateOfBirth, GregorianCalendar dateOfDeath) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDateOfBirth(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	public void setDateOfDeath(GregorianCalendar dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}
	
	public GregorianCalendar getDateOfDeath() {
		return dateOfDeath;
	}

}
