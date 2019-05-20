import java.util.List;

public class QuickSort {
	static void quickSort(String[] words, int lowerIndex, int higherIndex) {
		if (words == null || words.length == 0) {
			return;
		}
		int low = lowerIndex;
		int high = higherIndex;
		String pivot = words[lowerIndex + (higherIndex - lowerIndex) / 2];
		
		while (low <= high) {
			while (words[low].compareToIgnoreCase(pivot) < 0) {
				low++;
			}
			while (words[high].compareToIgnoreCase(pivot) > 0) {
				high--;
			}
			if (low <= high) {
				String temp = words[low];
				words[low] = words[high];
				words[high] = temp;
				low++;
				high--;
			}
		}
		
		if (lowerIndex < high) {
			quickSort(words, lowerIndex, high);
		}
		if (low < higherIndex) {
			quickSort(words, low, higherIndex);
		}
		
	}
	
	static void quickSort(List<String> words, int lowerIndex, int higherIndex) {
		if (words == null || words.size() == 0) {
			return;
		}
		int low = lowerIndex;
		int high = higherIndex;
		String pivot = words.get(lowerIndex + (higherIndex - lowerIndex) / 2);
		
		while (low <= high) {
			while (words.get(low).compareToIgnoreCase(pivot) < 0) {
				low++;
			}
			while (words.get(high).compareToIgnoreCase(pivot) > 0) {
				high--;
			}
			if (low <= high) {
				String temp = words.get(low);
				words.set(low, words.get(high));
				words.set(high, temp);
				low++;
				high--;
			}
		}
		
		if (lowerIndex < high) {
			quickSort(words, lowerIndex, high);
		}
		if (low < higherIndex) {
			quickSort(words, low, higherIndex);
		}
		
	}
	
}