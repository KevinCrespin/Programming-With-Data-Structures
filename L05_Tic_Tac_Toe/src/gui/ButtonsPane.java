package gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ButtonsPane extends GridPane{

	static VBox vBox;
	static Button undo;
	static Button redo;
	static Label space;
	
	public void setUpButtons() {
		
		undo = new Button("Undo");
		redo = new Button("Redo");
		space = new Label(" ");
		
		
		undo.setStyle("-fx-font: 24 computer;");
		redo.setStyle("-fx-font: 24 computer;");
		
		add(undo, 0, 0);
		add(space, 1, 0);
		add(redo, 2, 0);
		
		undo.setOnAction(e ->{
			 
		});
		
		redo.setOnAction(e ->{
			
		});
		
	}
	
	
}
