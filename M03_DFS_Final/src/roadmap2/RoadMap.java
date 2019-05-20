package roadmap2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoadMap {
	private Set<CityNode> nodes = new HashSet<CityNode>();
	
	// create a new node
	public void addCity(String name) {
		nodes.add(new CityNode(name)); 		
	}
	
	// connect two nodes
	public void buildRoad(String first, String second) {
		CityNode firstNode = null;
		CityNode secondNode = null;
		for(CityNode c: nodes) {
			if(c.getCityName().equals(first)) firstNode = c;
			if(c.getCityName().equals(second)) secondNode = c;			
		}   
		
		if(firstNode != null && secondNode != null) {
			firstNode.addNeighbor(secondNode);
			secondNode.addNeighbor(firstNode);
		}
		
	}
	
	public int getSize() {return nodes.size();}
	
	// look up a node by city name and return a reference to the node
	public CityNode findCityNodeByName(String cityName) {
		for (CityNode c: nodes) 
			if(c.getCityName().equals(cityName)) return c;
		return null;
		
	}
	
	public void travel(String start, String finish){
		RoadMapDFTraversal t = new RoadMapDFTraversal(this);
		t.find(start, finish);		
	}
	
	public CityNode[] getSortedArrayOfNodes(){
		CityNodeQuickSorter s = new CityNodeQuickSorter();
		return s.getSortedArray(nodes);
	}


}
