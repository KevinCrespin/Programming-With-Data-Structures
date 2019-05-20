import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Driver {
	static String[] victimsCode = {"A", "B", "C", "D", "E", "F", "G"};
	static int[] scape = {0, 1, 2};
	static int numberOfV = 7;
	static Victim[] victims; 
	static Stack<Victim> basement;
	static Queue<Victim> scapeQueue;
	
	public static void main(String[] args) throws InterruptedException {
		createVictims(numberOfV);
		enterBasement(numberOfV);
		emergeBasement(numberOfV);
		scapeRoutes();
	}

	public static void createVictims(int numberOfVictims) {
		victims = new Victim[numberOfVictims];
		
		for (int counter = 0; counter < numberOfVictims; counter++) {
			victims[counter] = new Victim(victimsCode[counter % victimsCode.length]);
		}
	}
	
	private static void enterBasement(int numberOfVictims) {
		basement = new Stack<Victim>();
		
		for (int counter  = 0; counter < numberOfVictims; counter++) {
			basement.push(victims[counter]);
		}
	}
	
	private static void emergeBasement(int numberOfVictims) {
		scapeQueue = new LinkedList<Victim>();
		
		for (int counter = 0; counter < numberOfVictims; counter++) {
			scapeQueue.add(basement.pop());
		}
	}

	private static void scapeRoutes() throws InterruptedException {
		int route = 0;
		while(!scapeQueue.isEmpty()) {
			System.out.println(scapeQueue.remove().getName() + " scapes by route " + scape[route % scape.length]);
			Thread.sleep(800);
			route++;
		}
	}

}