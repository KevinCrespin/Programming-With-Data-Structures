package roadmap2;

public class Driver {
	
	
	public static void main(String[] args) {
		RoadMap r = new RoadMap();
		r.addCity("A");
		r.addCity("V");
		r.addCity("S");
		r.addCity("P");
		r.addCity("N");
		
		r.buildRoad("A", "V");		
		r.buildRoad("A", "S");
		r.buildRoad("S", "P");
		r.buildRoad("S", "N");
	
		CityNode[] sorted = r.getSortedArrayOfNodes();
		
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getCityName() + " ");
		}
		r.travel("A", "P");

		System.out.println(r.findCityNodeByName("A").getNeighborNodes());
		System.out.println(r.getSize());
	}
		
}
