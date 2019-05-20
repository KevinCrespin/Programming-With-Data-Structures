package solver;

import tictactoeFX.Game.Turn;

public interface Move {

	public int getRow();

	public int getCol();

	public Turn getTurn();
	
	public void stackRow(int row);

	public void stackCol(int col);

	public void stackTurn(Turn turn);

}
