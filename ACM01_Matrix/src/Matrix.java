
public class Matrix {
	static int[][] matrix;
	static int[] colPos;
	static int[] rowPos;
	static int counter;
	
	public static void main(String[] args) {
		matrix = new int[5][5];
		colPos = new int[25];
		rowPos = new int[25];
		matrix[1][1] = 1;
		matrix[4][3] = 1;
		
		printArray();
		changeArray();
		printArray();
		 
	}
	
	public static void printArray() {
		counter = 0;
		for(int row = 0; row < matrix.length; row++) {

			for(int column = 0; column < matrix.length; column++) {
				if (matrix[row][column] == 1) {
					colPos[counter] = column;
					rowPos[counter] = row;
					counter++;
				}
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	public static void changeArray() {
		System.out.println();
		for(int count = 0; count < counter; count++) {
			
			for(int row = 0; row < matrix.length; row++) {
				matrix[rowPos[count]][row] = 1;
			}
			
			for(int col = 0; col < matrix.length; col++) {
				matrix[col][colPos[count]] = 1;
			}
		}
	}
	

}
