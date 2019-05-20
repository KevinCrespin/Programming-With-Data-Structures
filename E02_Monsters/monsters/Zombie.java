package monsters;

public class Zombie implements Monster{

	private static int zombieCount;  // since zombieCount is static, we will get the same zombieCount from any Zombie
	private String name;
	private String location;	

	public Zombie(String location){
		this.name = "Zombie # " + String.valueOf(zombieCount);
		zombieCount++;			
		this.location=location;		 			
	}
	
	public void setName(String name) {
		this.name = name;		
	}	
	
	public String getName() {
		return name;
	}

	public void rampage() {
		System.out.println(name + " joins a herd of zombies who attack citizens of " + location + " and eat their brains");
	}

	public String getOriginStory() {
		return "former human being who was raised from the dead by a magical spell spread by the bite of "
				+ "other zombies.";
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
