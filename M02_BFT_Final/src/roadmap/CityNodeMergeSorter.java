package roadmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CityNodeMergeSorter {
	public List<CityNode> getSortedList(Set<CityNode> nodes){
		List<CityNode> nodeList = new LinkedList<CityNode>();
		nodeList.addAll(nodes);
		
		if(nodes.size() > 1) {
			mergeSort(nodeList, 0, nodeList.size());
			return nodeList;
		}
		return null;
	}
	
	void merge(List<CityNode> nodeList, int start, int mid, int end) { 
	    int i, j, k; 
	    int n1 = mid - start + 1; 
	    int n2 =  end - mid; 
	  
	    List<CityNode> L =  new ArrayList<CityNode>();
	    List<CityNode> R =  new ArrayList<CityNode>(); 
	  
	    for (i = 0; i < n1; i++) 
	        L.set(i, nodeList.get(start + i));
	    for (j = 0; j < n2; j++) 
	        R.set(j, nodeList.get(mid + 1 + j)); 
	
	    i = 0;
	    j = 0;
	    k = start;
	    
	    while (i < n1 && j < n2) { 
	        if ((L.get(i).getCityName().compareTo((R.get(j).getCityName()))) == 1) { 
	            nodeList.set(k, L.get(i)); 
	            i++; 
	        } 
	        else { 
	            nodeList.set(k, R.get(j)); 
	            j++; 
	        } 
	        k++; 
	    } 
	  
	    while (i < n1) { 
	        nodeList.set(k, L.get(i)); 
	        i++; 
	        k++; 
	    } 

	    while (j < n2) { 
	        nodeList.set(k, R.get(j)); 
	        j++; 
	        k++; 
	    }
	}

	void mergeSort(List<CityNode> nodeList, int start, int end) { 
	    if (start < end) { 
	        int mid = start+(end-start)/2; 
	  
	        mergeSort(nodeList, start, mid); 
	        mergeSort(nodeList, mid + 1, end); 
	        merge(nodeList, start, mid, end); 
	    } 
	} 

}
