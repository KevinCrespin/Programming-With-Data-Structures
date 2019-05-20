package roadmap2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RoadMapDFTraversal {
	private RoadMap c;
	private List<CityNode> visited = new LinkedList<CityNode>();

	
	public RoadMapDFTraversal(RoadMap c) {
		this.c = c;
	}
	
	public void find(String home, String target) {
		
		CityNode start = c.findCityNodeByName(home);
		CityNode finish = c.findCityNodeByName(target);
		findRecursive(start, finish);		
	}
	
	public void findRecursive(CityNode start, CityNode finish) {
		
		System.out.println("visiting " + start.getCityName());
		
		visited.add(start);
		
			if(start.equals(finish)) {
				System.out.println("DONE!"); 
				return;
			}
			if ((start.getNeighborNodes().get(0) != null) && (visited.contains(start.getCityName()))) {
				
				findRecursive(start.getNeighborNodes().get(0), finish);
			}
			else if (start.getNeighborNodes().get(1) != null && (visited.contains(start.getCityName()))) {
			
				findRecursive(start.getNeighborNodes().get(1), finish);
			}
	}

}

