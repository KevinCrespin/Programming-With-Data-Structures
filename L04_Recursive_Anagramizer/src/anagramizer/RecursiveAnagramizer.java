package anagramizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RecursiveAnagramizer {
	static File validWordsFile = new File("validWords.txt");
	
	static Scanner sc;
	
	static String line;
	static String inString;
	
	static List<String> validWords = new ArrayList<String>();
	static List<String> anagrams = new ArrayList<String>();
	static List<String> filteredAnagrams = new ArrayList<String>();
	static String[] splitWords;
	static char[] chars;
	
	//  Store all valid words in memory
	public static void fileToList() throws IOException {
		try (
			    InputStream fileIStream = new FileInputStream(validWordsFile);
			    InputStreamReader inputSReader = new InputStreamReader(fileIStream);
			    BufferedReader bufferedReader = new BufferedReader(inputSReader);
			) {
			    while ((line = bufferedReader.readLine()) != null) {
			    	validWords.add(line);
			    }
			}
	}
	
	// Create and storage all possible anagrams
	public static void anagramizerR(String inString, String temp) {
		if(inString.length() == 0)    {
			anagrams.add(temp);
		}
		
		for(int i = 0; i < inString.length(); i++) {
			anagramizerR(inString.substring(0, i) + inString.substring(i + 1, inString.length()), inString.charAt(i) + temp);
		}
	}

	// Filter, by storing valid anagrams only
	public static void filterAnagrams(int spaces) {
		splitWords = new String[spaces + 1];
		int counter = 0;
		
		for (int i = 0; i < anagrams.size(); i++) {
			
			// Check sentences (String with one or more spaces) 
			if (anagrams.get(i).trim().contains(" ")) {
				// Split String into an Array with size of the number of words in the sentence
				for (int k = 0; k < spaces + 1; k++) {
					splitWords = anagrams.get(i).trim().split(" ", spaces + 1);
				}
				
				// Check if all words in the sentence is a valid word
				for (int j = 0; j < spaces + 1; j++) {
					// Use a counter for the number of valid words in the sentence
					if (validWords.contains(splitWords[j])) {
						counter++;
					}
					// If all words in the sentence are valid, reset counter and add that sentence to the valid anagram List
					if (counter == spaces + 1) {
						counter = 0;
						filteredAnagrams.add(anagrams.get(i).trim());
					}
				}
				// Counter resets every word checked
				counter = 0;
			}
			
			// Check words (Strings with NO spaces)
			// If the word is valid, add the word to the valid anagram List
			if (validWords.contains(anagrams.get(i).trim())) {
				filteredAnagrams.add(anagrams.get(i).trim());
			}
		}
		
		// Copy all valid anagrams found to a HashSet (HashSet eliminates repeated values)
		Set<String> temp = new HashSet<>();
		temp.addAll(filteredAnagrams);
		filteredAnagrams.clear();
		// Copy non repeated valid anagram to its original list
		filteredAnagrams.addAll(temp);
	}
	
}
