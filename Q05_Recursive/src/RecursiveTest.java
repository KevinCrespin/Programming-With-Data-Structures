import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecursiveTest {
		
	RecursiveProbs recursive = new RecursiveProbs();
	
	@Test
	void testEmptyStringAll() {
		assertTrue(recursive.recursiveAllCharacterSame(""));
	}

	@Test
	void testTrueAll() {
		assertTrue(recursive.recursiveAllCharacterSame("aaaaaaaaaa"));
	}
	
	@Test
	void testFalseAll() {
		assertFalse(recursive.recursiveAllCharacterSame("aaaaaaaoaa"));
	}
	
	@Test
	void testEmptyStringHead() {
		assertEquals(recursive.recursiveHead(0, ""), "");
	}
	
	@Test
	void testTrueHead() {
		assertEquals(recursive.recursiveHead(4, "string"), "stri");
	}
	
	@Test
	void testIntMoreThanHead() {
		assertEquals(recursive.recursiveHead(15, "string"), "");
	}
	
	@Test
	void testNegativeIntHead() {
		assertEquals(recursive.recursiveHead(-15, "string"), "");
	}
	
}
