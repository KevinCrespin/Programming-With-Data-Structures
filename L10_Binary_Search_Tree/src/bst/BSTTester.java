package bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class BSTTester {

	@Test
	void testBSTCreated() {
		BST <String> b = new BST<String>();
		assertNotNull(b);
	}
	
	@Test
	void testisEmptyTrue() {
		BST <String>b = new BST<String>();
		assertTrue(b.isEmpty());
	}

	@Test
	void testisEmptyFalse() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		assertFalse(b.isEmpty());
	}

	@Test
	void testisEmptyAfterClear() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		b.clear();
		assertTrue(b.isEmpty());
	}	
	
	@Test
	void testBSTSizeEmpty() {
		BST <String> b = new BST <String>();
		assertEquals(b.getSize(), 0);
	}
	
	@Test
	void testBSTSizeOneNode() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		assertEquals(b.getSize(), 1);
	}

	@Test
	void testBSTSizeThreeNodes() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		b.insert("Beatrice");
		b.insert("Carl");
		assertEquals(b.getSize(), 3);
	}

	@Test
	void testBSTSizeAfterDelete() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		b.insert("Beatrice");
		b.insert("Carl");
		b.delete("Beatrice");
		assertEquals(b.getSize(), 2);
	}
	
	@Test
	void testSearchValuePresentOneNodeTree() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		assertTrue(b.search("Arthur"));
	}
	
	@Test
	void testSearchValueNotPresentOneNodeTree() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		assertFalse(b.search("Beatrice"));
	}
	
	@Test
	void testInorder() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		b.insert("Beatrice");
		b.insert("Carl");
		
		Iterator <String> i = b.iterator();
		assertEquals(i.next(), "Arthur");
		assertEquals(i.next(), "Beatrice");
		assertEquals(i.next(), "Carl");
		
	}
	
	@Test
	void testInorderAfterDelete() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		b.insert("Beatrice");
		b.insert("Carl");
		b.insert("Dagmar");

		b.delete("Beatrice");
		Iterator <String> i = b.iterator();
		assertEquals(i.next(), "Arthur");
		assertEquals(i.next(), "Carl");
		assertEquals(i.next(), "Dagmar");
		
	}
	
	@Test
	void testMaxHeightEmptyTree() {
		BST <String>b = new BST<String>();
		assertEquals(b.getMaxHeight(), 0);
	}
	
	@Test
	void testMaxHeightOneNodeTree() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		assertEquals(b.getMaxHeight(), 1);
	}
	
	@Test
	void testMaxHeightTwoNodeTree() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		b.insert("Beatrice");
		assertEquals(b.getMaxHeight(), 2);
	}
	
	@Test
	void testMaxHeightThreeNodeTreeUnbalanced() {
		BST <String>b = new BST<String>();
		b.insert("Arthur");
		b.insert("Beatrice");
		b.insert("Carl");
		assertEquals(b.getMaxHeight(), 3);
	}
	
	@Test
	void testMaxHeightThreeNodeTreeBalanced() {
		BST <String>b = new BST<String>();
		b.insert("Beatrice");
		b.insert("Arthur");		
		b.insert("Carl");
		assertEquals(b.getMaxHeight(), 2);
	}
	
	@Test
	void testMaxHeightThreeNodeTreeAfterDeleteRoot() {
		BST <String>b = new BST<String>();
		b.insert("Beatrice");
		b.insert("Arthur");		
		b.insert("Carl");
		b.delete("Beatrice");
		assertEquals(b.getMaxHeight(), 2);
	}

}
