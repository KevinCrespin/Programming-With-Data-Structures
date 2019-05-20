import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		String[] wordArrayQ = {"I", "B", "C", "S", "T", "A", "L", "O", "M", "G", "R", "E", "U", "Y", "Z"};
		String[] wordArrayI = new String[wordArrayQ.length];
		List<String> wordListQ = new ArrayList<String>();
		List<String> wordListI = new ArrayList<String>();
		
		Transfer.arrayToList(wordArrayQ, wordListQ);
		Transfer.listToArray(wordListQ, wordArrayI);
		Transfer.arrayToList(wordArrayI, wordListI);
		
		Print.print(wordArrayQ);
		Print.print(wordListQ);
		Print.print(wordArrayI);
		Print.print(wordListI);
		
		QuickSort.quickSort(wordArrayQ, 0, wordArrayQ.length - 1);
		QuickSort.quickSort(wordListQ, 0, wordListQ.size() - 1);
		
		System.out.println("\nQuick Sort\n");
		Print.print(wordArrayQ);
		Print.print(wordListQ);
		
		InsertionSort.insertionSortA(wordArrayI, wordArrayI.length - 1);
		InsertionSort.insertionSortL(wordListI, wordListI.size());
		
		System.out.println("\nInsertion Sort\n");
		Print.print(wordArrayI);
		Print.print(wordListI);
	}

}
