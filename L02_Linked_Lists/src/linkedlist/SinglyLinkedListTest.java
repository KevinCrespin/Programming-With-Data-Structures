package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {
	
	Node<String> node1;
	Node<String> node2;
	Node<String> node3;
	Node<String> node4;
	SinglyLinkedList<String> linkedList;
	
	@Test
	void testEmptyLinkedList() {
		linkedList = new SinglyLinkedList<String>();		
		
		// If linked list is empty, linkedList.size() should return 0
		assertEquals(linkedList.size(), 0);
	}
	
	@Test
	void testCyclelessNodeList() {
		linkedList = new SinglyLinkedList<String>();
		node1 = new Node<String>();
		node2 = new Node<String>();
		node3 = new Node<String>();
		
		String testString1 = "test1";
		node1.setElement(testString1);
		String testString2 = "test2";
		node2.setElement(testString2);
		String testString3 = "test3";
		node3.setElement(testString3);
		
		linkedList.add(node1);
		linkedList.add(node2);
		linkedList.add(node3);
		
		// If linked list is cycle-less, last node reference @ index [l.size()] should be null
		assertEquals(linkedList.get((int) linkedList.size()), null);
	}
	
	@Test
	void testSigleCycleNodeList() {
		linkedList = new SinglyLinkedList<String>();
		node1 = new Node<String>();
		
		String testString1 = "test1";
		node1.setElement(testString1);
		
		linkedList.addToCreateCycle(node1);
		
		Node<String> slow = linkedList.getNode(0);
		Node<String> fast = linkedList.getNode(0);
		
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				System.out.println("Cycle 1 found");
				break;
			}
		}
		
		// If linked list contains a cycle, fast and slow references should be the same at some point
		assertEquals(fast,slow);
	}
	
	@Test
	void testOddNodeList() {
		linkedList = new SinglyLinkedList<String>();
		node1 = new Node<String>();
		node2 = new Node<String>();
		node3 = new Node<String>();
		
		String testString1 = "test1";
		node1.setElement(testString1);
		String testString2 = "test2";
		node2.setElement(testString2);
		String testString3 = "test3";
		node3.setElement(testString3);
		
		linkedList.add(node1);
		linkedList.add(node2);
		linkedList.addToCreateCycle(node3);
		
		Node<String> slow = linkedList.getNode(0);
		Node<String> fast = linkedList.getNode(0);
		assertEquals(fast,slow);
		
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				System.out.println("Cycle 2 found");
				break;
			}
		}
		
		// If linked list contains a cycle, fast and slow references should be the same at some point
		assertEquals(fast,slow);
	}
	
	@Test
	void testEvenNodeList() {
		linkedList = new SinglyLinkedList<String>();
		node1 = new Node<String>();
		node2 = new Node<String>();
		node3 = new Node<String>();
		node4 = new Node<String>();
		
		String testString1 = "test1";
		node1.setElement(testString1);
		String testString2 = "test2";
		node2.setElement(testString2);
		String testString3 = "test3";
		node3.setElement(testString3);
		String testString4 = "test4";
		node4.setElement(testString4);
		
		linkedList.add(node1);
		linkedList.add(node2);
		linkedList.add(node3);
		linkedList.addToCreateCycle(node4);
		
		Node<String> slow = linkedList.getNode(0);
		Node<String> fast = linkedList.getNode(0);
		assertEquals(fast,slow);
		
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				System.out.println("Cycle 3 found");
				break;
			}
		}
		
		// If linked list contains a cycle, fast and slow references should be the same at some point
		assertEquals(fast,slow);
	}

}
