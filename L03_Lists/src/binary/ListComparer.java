package binary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListComparer {
	
	static String line;
	static String[] wordsArray;
	static List<String> wordsArrayList = new ArrayList<>();
	static LinkedList<String> wordsLinkedList = new LinkedList<>();
	static File textFile = new File("text.txt");
	private static StopWatch s = new StopWatch();
	
	public static void main(String[] args) throws IOException {
		readTextFile();
		sortExercise();
		binarySearchExercise(userInput());

	}

	private static String userInput() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("\nSearch for word: ");
		return sc.nextLine();
	}

	public static void sortExercise() {

		s.reset();
		s.start();
		Sort.quickSort(wordsArray, 0, wordsArray.length - 1);
		s.stop();
		System.out.println("Sorting Array took "
				+ s.getElapsedTime() + " ms");

		s.reset();
		s.start();
		Sort.quickSort(wordsArrayList, 0, wordsArrayList.size() - 1);
		s.stop();
		System.out.println("Sorting ArrayList took "
				+ s.getElapsedTime() + " ms");
		
		s.reset();
		s.start();
		Sort.quickSort(wordsLinkedList, 0, wordsLinkedList.size() - 1);
		s.stop();
		System.out.println("Sorting LinkedList took "
				+ s.getElapsedTime() + " ms");
	}
	
	public static void binarySearchExercise(String word) {

		s.reset();
		s.start();
		System.out.println();
		int index1 =  Search.binarySearch(wordsArray, word, 0, wordsArray.length - 1);
		System.out.println(index1 != -1 ? "Element is present in index " + index1: "Element Not Found"); 
		s.stop();
		System.out.println("Binary Search in Array took "
				+ s.getElapsedTime() + " ms");

		s.reset();
		s.start();
		System.out.println();
		int index2 = Search.binarySearch(wordsArrayList, word, 0, wordsArrayList.size() - 1);
		System.out.println(index2 != -1 ? "Element is present in index " + index2: "Element Not Found");
		s.stop();
		System.out.println("Binary Search in ArrayList took "
				+ s.getElapsedTime() + " ms");
		
		s.reset();
		s.start();
		System.out.println();
		int index3 = Search.binarySearch(wordsLinkedList, word, 0, wordsLinkedList.size() - 1);
		System.out.println(index3 != -1 ? "Element is present in index " + index3: "Element Not Found"); 
		s.stop();
		System.out.println("Binary Search in LinkedList took "
				+ s.getElapsedTime() + " ms");

	}
	
	public static void readTextFile() throws IOException{
		try (
			    InputStream fileIStream = new FileInputStream(textFile);
			    InputStreamReader inputSReader = new InputStreamReader(fileIStream);
			    BufferedReader bufferedReader = new BufferedReader(inputSReader);
			) {
			    while ((line = bufferedReader.readLine()) != null) {
			    	// Save individual words into an ArrayList
			    	wordsArrayList = Arrays.asList(line.split(" "));
			    }
			    // Create Array with ArrayList.size()
			    wordsArray = new String[wordsArrayList.size()];
			    // Clone ArrayList to LinkedList & Array
			    for (int counter = 0; counter < wordsArrayList.size(); counter++) {
					wordsLinkedList.add(counter, wordsArrayList.get(counter));
					wordsArray[counter] = wordsArrayList.get(counter);
				}
			}
	}
	
}
