import java.util.Scanner;

public class StringBuilderQuiz {
	static StringBuilder outString;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String inString = sc.nextLine();
		sc.close();
		
		System.out.println("Non-alphabetic chars: " + getNonAlpha(inString));
		System.out.println("[Uppercase] Alphabetics chars: " + getUpper(inString));
	}
	
	public static String getNonAlpha(String inString) {
		outString = new StringBuilder();
		
		for (int counter = 0; counter < inString.length(); counter++)
			 if (inString.toUpperCase().charAt(counter) < 64 || inString.toUpperCase().charAt(counter) > 91)
				 outString.append(inString.charAt(counter));

		return outString.toString();
	}
	
	public static String getUpper(String inString) {
		outString = new StringBuilder();
		for (int counter = 0; counter < inString.length(); counter++)
			 if (inString.toUpperCase().charAt(counter) > 65 && inString.toUpperCase().charAt(counter) < 91)
				 outString.append(inString.toUpperCase().charAt(counter));
		
		return outString.toString();
	}

}