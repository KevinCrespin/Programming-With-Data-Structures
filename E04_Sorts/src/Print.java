import java.util.List;

public class Print {
	
	public static void print(String[] words) {
		for (int i = 0; i < words.length - 1; i++) {
			System.out.print(words[i] + " ");
		}
		System.out.println("");
	}
	
	public static void print(List<String> words) {
		for (int i =0; i< words.size(); i++) {
			System.out.print(words.get(i) + " ");
		}
		System.out.println("");
	}
}
