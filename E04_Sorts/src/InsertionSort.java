import java.util.List;

public class InsertionSort {
    static void insertionSortA(String[] words, int maxIndex) { 
    	if (maxIndex <= 1) {
			return;
		}
    	
    	insertionSortA(words, maxIndex - 1); 
    	
    	String pivot = words[maxIndex - 1]; 
    	int i = maxIndex - 2; 
    	
    	while ((i >= 0) && (words[i].compareToIgnoreCase(pivot) > 0)) {
    		words[i + 1] = words[i]; 
    		i--;
    	}
    	words[i + 1] = pivot;
    }
    
    static void insertionSortL(List<String> words, int maxIndex) { 
    	if (maxIndex <= 1) {
			return;
		}
    	
    	insertionSortL(words, maxIndex - 1); 
    	
    	String pivot = words.get(maxIndex - 1); 
    	int i = maxIndex - 2; 
    	
    	while ((i >= 0) && (words.get(i).compareToIgnoreCase(pivot) > 0)) {
    		words.set((i + 1), words.get(i));
    		i--;
    	}
    	words.set((i + 1), pivot);
    	
    	
    } 
  
}