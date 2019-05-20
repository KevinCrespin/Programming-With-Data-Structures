package binary;

import java.util.List;

public class Search {

	public static int binarySearch(String[] words, String word, int low, int high) {
		if (low > high) {
			return -1;
		}
		
		int middle = (low + high) / 2;

		if (words[middle].equals(word)) {
			return middle;
		} else if (words[middle].compareToIgnoreCase(word) > 0) {
			return binarySearch(words, word, low, middle - 1);
		} else {
			return binarySearch(words, word, middle + 1, high);
		}
	}
	
	public static int binarySearch(List<String> words, String word, int low, int high) {
		if (low > high) {
			return -1;
		}
		
		int middle = (low + high) / 2;

		if (words.get(middle).equals(word)) {
			return middle;
		} else if (words.get(middle).compareToIgnoreCase(word) > 0) {
			return binarySearch(words, word, low, middle - 1);
		} else {
			return binarySearch(words, word, middle + 1, high);
		}
	}
}