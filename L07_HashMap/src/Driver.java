import java.util.PriorityQueue;
import java.util.Scanner;

public class Driver {
	static String[] victimsNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "O", "P"};
	static Integer[] victimsIQ = {1100, 105, 110, 198, 95, 70, -84, 66, 55, 78, 97, 140, 150, 160, 188};
	static Integer[] victimsAS = {2, 6, 6, 5, -3, 100, 9, 5, 3, 4, 6, 7, 1, 8, 7};
	static Victim[] victims;
	static Scanner sc;
	static Integer numberOfV = 15;
	static int numberOfM;
	static String monsterType;
	static PriorityQueue<Victim> dinner;
	static Carnage carnage = new Carnage();;
	
	public static void main (String[] args) throws InterruptedException {
		do {
			System.out.println();
			userInput();
			createVictims(numberOfV);
			carnage.monsterAttack(fillQueue(numberOfV), numberOfM, Carnage.monster);
			System.out.print("\nExit? [YES] [NO] : ");
		} while (!(sc.nextLine().equalsIgnoreCase("YES")));
		
	}
	
	public static void userInput() {
		sc = new Scanner(System.in);
		
		System.out.print("Enter the number of monsters eating: ");
		
		while(!sc.hasNextInt()) {
		    sc.next();
		    System.out.print("Enter the [Number] of monsters eating: ");
		}
		
		numberOfM = sc.nextInt();
		monsterType = null;
		sc.nextLine(); System.out.println();
		
		while(!("ZOMBIES".equalsIgnoreCase(monsterType)) && !("VAMPIRES".equalsIgnoreCase(monsterType))) {
			System.out.print("Enter the type of monster [Zombies] or [Vampires]: ");
			monsterType = sc.nextLine();
		} 
		
		System.out.println();
		
		if (monsterType.equalsIgnoreCase("ZOMBIES")) {
			Carnage.monster = Carnage.Monster.Zombie;
		}
		if (monsterType.equalsIgnoreCase("VAMPIRES")) {
			Carnage.monster = Carnage.Monster.Vampire;
		}
	}
	
	public static void createVictims(int numberOfVictims) {
		victims = new Victim[numberOfVictims];
		
		for (int counter = 0; counter < numberOfVictims; counter++) {
			victims[counter] = new Victim(victimsNames[counter % victimsNames.length],
										  victimsIQ[counter % victimsIQ.length],
										  victimsAS[counter % victimsAS.length]);
		}
	}
	
	public static PriorityQueue<Victim> fillQueue(int numberOfVictims) {
		dinner = new PriorityQueue<Victim>(numberOfV, new Carnage());
		
		for (int counter = 0; counter < numberOfVictims; counter++) {
			dinner.add(victims[counter]);
		}
		return dinner;
	}

}
