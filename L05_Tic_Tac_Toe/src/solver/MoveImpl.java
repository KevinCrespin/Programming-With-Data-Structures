package solver;

import java.util.Stack;

import tictactoeFX.Game.Turn;

public class MoveImpl implements Move{
	
	Stack<Integer> stackRow = new Stack<>();
	Stack<Integer> stackCol = new Stack<>();
	Stack<Turn> stackTurn = new Stack<>();

	
	@Override
	public int getRow() {
		return stackRow.peek();
	}
	
	@Override
	public int getCol() {
		return stackCol.peek();
	}
	
	@Override
	public Turn getTurn() {
		return stackTurn.peek();
	}
	
	public void stackRow(int inRow) {
		stackRow.push(inRow);
	}
	
	public void stackCol(int inCol) {
		stackRow.push(inCol);
	}
	
	public void stackTurn(Turn inTurn) {
		stackTurn.push(inTurn);
	}

}
