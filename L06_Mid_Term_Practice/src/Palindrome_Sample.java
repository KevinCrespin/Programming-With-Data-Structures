import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome_Sample {
	static Scanner sc;
	static String inString;
	static StringBuilder trimedString;
	static Stack<Character> stack;
	static Queue<Character> queue;
	static int numberOfMatches;
	static boolean isPalindrome;

	
	public static void main(String[] args) {
		isPalindrome = isPalindrome(trimString(userInput()));
		
		if (isPalindrome) {
			System.out.println("\"" + inString + "\" is a Palindrome");
		}
		else {
			System.out.println("\"" + inString + "\" is NOT a Palindrome");
		}
	}
	
	public static String userInput() {
		sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		inString = sc.nextLine();
		return inString;
	}
	
	public static String trimString(String inString) {
		trimedString = new StringBuilder();
		for (int counter = 0; counter < inString.length(); counter++) {
				 if (inString.toUpperCase().charAt(counter) > 65 && inString.toUpperCase().charAt(counter) < 91) {
					 trimedString.append(inString.toLowerCase().charAt(counter));
				 }
		}
					
		return trimedString.toString();
	}
	
	public static Boolean isPalindrome(String trimedString) {
		stack = new Stack<>();
		queue = new LinkedList<Character>();
		numberOfMatches = 0;
		
		for (int counter = 0; counter < trimedString.length(); counter++) {
			stack.push(trimedString.charAt(counter));
			queue.add(trimedString.charAt(counter));
		}
		
		for (int counter = 0; counter < trimedString.length(); counter++) {
			if (stack.peek() == queue.peek()) {
				numberOfMatches++;
			}
		}
		
		if (numberOfMatches == trimedString.length()) {
			return true;
		}
		
		return false;
	}

}