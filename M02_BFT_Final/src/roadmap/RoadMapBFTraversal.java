package roadmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoadMapBFTraversal {
	private RoadMap c;

	public RoadMapBFTraversal(RoadMap c) {
		this.c = c;
	}
	
	
	public List<String> getTraversal(String home) {
		List<String> result = new ArrayList<String>();
		
		Queue<CityNode> queue = new LinkedList<CityNode>();
		
		CityNode city = new CityNode(home);

		queue.clear();
		queue.add(city);
		while(!queue.isEmpty()) {
			CityNode tempNode = queue.remove();
			result.add(tempNode.getCityName());
			List<CityNode> neighbours = tempNode.getNeighborNodes();
			for(int i =0; i < tempNode.getNeighborNodes().size() - 1; i++) {
				CityNode node = neighbours.get(i);
				if(node != null) {
					result.add(node.getCityName());
					queue.add(node);
				}
			}

		}
		return result;	
	}
}