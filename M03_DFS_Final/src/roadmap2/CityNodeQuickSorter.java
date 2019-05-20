package roadmap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

public class CityNodeQuickSorter {
	public CityNode[] getSortedArray(Set<CityNode> nodes){
		CityNode[] nodeArray = new CityNode[nodes.size()];
		List<CityNode> nodeList = new ArrayList<CityNode>();
		for(CityNode n: nodes) nodeList.add(n);
	
		quickSort(nodeList, 0, nodeList.size() - 1);
		
		for(int i = 0; i < nodeList.size(); i++) nodeArray[i] = nodeList.get(i);

		return nodeArray;		
	}


	static void quickSort(List<CityNode> nodes, int lowerIndex, int higherIndex) {
		if (nodes == null || nodes.size() == 0) {
			return;
		}
		int low = lowerIndex;
		int high = higherIndex;
		CityNode pivot = nodes.get(lowerIndex + (higherIndex - lowerIndex) / 2);
		
		while (low <= high) {
			while (nodes.get(low).compareTo(pivot) < 0) {
				low++;
			}
			while (nodes.get(high).compareTo(pivot) > 0) {
				high--;
			}
			if (low <= high) {
				CityNode temp = nodes.get(low);
				nodes.set(low, nodes.get(high));
				nodes.set(high, temp);
				low++;
				high--;
			}
		}
		
		if (lowerIndex < high) {
			quickSort(nodes, lowerIndex, high);
		}
		if (low < higherIndex) {
			quickSort(nodes, low, higherIndex);
		}
		
	}

}
