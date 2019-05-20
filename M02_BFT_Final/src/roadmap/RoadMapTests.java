package roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

class RoadMapTests {

	@Test
	void testMapCreated() {
		RoadMap r = new RoadMap();
		assertNotNull(r);
	}
	
	@Test
	void testSizeEmptyMap() {
		RoadMap r = new RoadMap();
		assertEquals(r.getSize(), 0);
	}
	
	@Test
	void testSizeOneCity() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		assertEquals(r.getSize(), 1);
	}
	
	@Test
	void testSizeTwoCities() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		assertEquals(r.getSize(), 2);
	}
	
	@Test
	void testNodeNeighborsEmpty() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().size(), 0);
	}

	@Test
	void testNodeNeighborsOneNeighbor() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles",  "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().size(), 1);
	}

	@Test
	void testNodeNeighborsFirstCorrectUsingNode() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles",  "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNodes().get(0).getCityName(), "San Diego");
	}

	@Test
	void testNodeNeighborsFirstCorrectUsingNames() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles",  "San Diego");
		assertEquals(r.findCityNodeByName("Los Angeles").getNeighborNames().get(0), "San Diego");
	}	

	@Test
	void testContains() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles",  "San Diego");
		assertTrue(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("San Diego"));
	}

	@Test
	void testNodeNeighborsSymmetric() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles",  "San Diego");
		assertTrue(r.findCityNodeByName("San Diego").getNeighborNames().contains("Los Angeles"));
	}

	
	@Test
	void testNodeNeighborsNotReflexive() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles",  "San Diego");
		assertFalse(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("Los Angeles"));
	}

	@Test
	void testNodeNeighborsNotTransitive() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		
		r.buildRoad("Los Angeles",  "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		assertFalse(r.findCityNodeByName("Los Angeles").getNeighborNames().contains("Phoenix"));
	}

	@Test
	void testNeighborsSizeIndirect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		
		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("Los Angeles", "Phoenix");
		assertEquals(r.findCityNodeByName("San Diego").getNeighborNodes().size(), 1);
	}

	
	@Test
	void testBFTSizeNoNeighbors() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		
		assertEquals(r.getBFTraversal("Los Angeles").size(), 1);
	}

	@Test
	void testBFTSizeOneNeighbor() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.buildRoad("Los Angeles",  "San Diego");
		
		assertEquals(r.getBFTraversal("Los Angeles").size(), 2);
	}

	@Test
	void testBFTSizeTwoNeighbors() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		
		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("Los Angeles", "Phoenix");
		
		assertEquals(r.getBFTraversal("Los Angeles").size(), 3);
	}
	
	@Test
	void testBFTSizeIndirect() {
		RoadMap r = new RoadMap();
		r.addCity("Los Angeles");
		r.addCity("Las Vegas");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		
		r.buildRoad("Los Angeles", "Las Vegas");		
		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		r.buildRoad("Phoenix", "Las Vegas");
				
		assertEquals(r.getBFTraversal("San Diego").size(), 4);
	}
	
	@Test
	void testConnectedNodesSameSizeTraversal() {
		RoadMap r = new RoadMap();

		r.addCity("Los Angeles");
		r.addCity("Las Vegas");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		r.addCity("Denver");
		
		r.buildRoad("Los Angeles", "Las Vegas");		
		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		r.buildRoad("Phoenix", "Las Vegas");
		r.buildRoad("Phoenix", "Denver");
		
		assertEquals(r.getBFTraversal("San Diego").size(), r.getBFTraversal("Las Vegas").size());
	}

	@Test
	void testDifferentOrderInputSameSizeTraversal() {

		RoadMap r = new RoadMap();

		r.addCity("Los Angeles");
		r.addCity("Las Vegas");
		r.addCity("San Diego");
		r.addCity("Phoenix");
		r.addCity("Denver");
		
		r.buildRoad("Los Angeles", "Las Vegas");		
		r.buildRoad("Los Angeles", "San Diego");
		r.buildRoad("San Diego", "Phoenix");
		r.buildRoad("Phoenix", "Las Vegas");
		r.buildRoad("Phoenix", "Denver");

		RoadMap s = new RoadMap();

		s.addCity("San Diego");
		s.addCity("Denver");
		s.addCity("Phoenix");
		s.addCity("Las Vegas");
		s.addCity("Los Angeles");
		
		s.buildRoad("Phoenix", "Denver");
		s.buildRoad("Los Angeles", "San Diego");
		s.buildRoad("San Diego", "Phoenix");
		s.buildRoad("Los Angeles", "Las Vegas");		
		s.buildRoad("Phoenix", "Las Vegas");
		
		assertEquals(r.getBFTraversal("San Diego").size(), s.getBFTraversal("San Diego").size());
	}

}
