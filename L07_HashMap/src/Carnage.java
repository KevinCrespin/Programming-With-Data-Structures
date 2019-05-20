import java.util.Comparator;
import java.util.PriorityQueue;

public class Carnage implements Comparator<Victim> {
	
	public enum Monster {
		Zombie , Vampire 
	};

	static int number;
	static Monster monster;

	@Override
	public int compare(Victim victim1, Victim victim2) {
		if (monster == Monster.Vampire) {
			if(victim1.appearanceScore < victim2.appearanceScore) {
				return 1;
			}
			else if(victim1.appearanceScore > victim2.appearanceScore) {
				return -1;
			}
			return 0;
		}
		
		if (monster == Monster.Zombie) {
			if(victim1.iQ < victim2.iQ) {
				return 1;
			}
			else if(victim1.iQ > victim2.iQ) {
				return -1;
			}
			return 0;
		}
		else return 0;
	
	}
	
	void monsterAttack(PriorityQueue<Victim> dinner, int numberOfM, Monster monstertype) throws InterruptedException{
		int[] zombieCode = new int[numberOfM];
		for (int counter = 0; counter < numberOfM; counter++) {
			zombieCode[counter] = counter + 1;
		}
		
		number = 0;
		while(!dinner.isEmpty()) {
			System.out.println(dinner.remove().toSting() + " | is eaten by " + monster + " " + zombieCode[number % zombieCode.length]);
			Thread.sleep(800);
			number++;
		}
	}
	
}