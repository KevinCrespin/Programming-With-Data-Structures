import java.util.List;

public class Transfer {
	public static void arrayToList(String[] array, List<String> list) {
		for (int i = 0; i < array.length - 1; i++) {
			list.add(i, array[i]);
		}
	}
	
	public static void listToArray(List<String> list, String[] array) {
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
	}
}
