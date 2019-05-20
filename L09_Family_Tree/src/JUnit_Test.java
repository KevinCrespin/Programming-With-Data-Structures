import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class JUnit_Test {

	@Test
	public void testGetPersonById() {
		Person adam = new Person("Johnson", "Adam", new GregorianCalendar(0,
				01, 01), new GregorianCalendar(100, 12, 31));
		Person eve = new Person("Johnson", "Eve", new GregorianCalendar(1,
				01, 02), new GregorianCalendar(100, 1, 31));
		Person cain = new Person("Johnson", "Cain", new GregorianCalendar(
				21, 6, 30), new GregorianCalendar(38, 6, 30));

		FamilyTree t = new FamilyTreeImpl(adam, eve);
		t.add(cain, 1, 2);
		assertEquals(t.getPersonById(3).getFirstName(), "Cain");
	}

}
