package demos;

public class E01_Borg {
	
	private String name;
	private static int borgCount;
	
	public E01_Borg(String nameIn) {
		name = nameIn;
		borgCount += 1;
	}
	
	public void stateName() {
		System.out.println(name + " of  " + borgCount);
	}
	
	public static void main(String[] args) {
		int max = 9;
		borgCount = 0;
		E01_Borg[] borgs = new E01_Borg[max];
		
		for (int counter = 0; counter < max; counter++) {
			String name = String.valueOf(counter + 1);
			borgs[counter] = new E01_Borg(name);
		}

		for (int counter = 0; counter < max; counter++) {
			borgs[counter].stateName();
		}
	}
}