package anagramizer;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RecursiveAnagramizerGUI extends Application{
	static Button button;
	static TextField field;
	static Label label;
	static TextArea result;
	static String resulted;
	
	Stage waitingStage;
	Stage resultStage;
	
	static int spaces;
	static int counter;
	
	public void start(Stage primaryStage) throws Exception {
		label = new Label("Enter String:");
		button = new Button("\tFind Anagrams\t");
		field = new TextField();
		
		GridPane inputPane = new GridPane();
		inputPane.setHgap(10);
		inputPane.setVgap(5);
		inputPane.setPadding(new Insets(10,10,10,20));
		
		inputPane.add(label, 0, 0);
		inputPane.add(field, 0, 1);
		inputPane.add(button, 0, 2);
		
		GridPane mainPane = new GridPane();
		mainPane.add(inputPane, 0, 0);
		mainPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Scene mainScene = new Scene(mainPane, 190, 95);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
		button.setOnAction(e -> {
			// String is too long, pop warning window
			if (field.getText().trim().length() > 6) {
				warning();
				primaryStage.close();
			}
			else {
				process();
				primaryStage.close();
			}
		}
		);
	}
	
	// Backend implemented in the GUI
	public void process() {
		try {
			spaces = 0;
			counter = 0;
			resulted = "";
		
			// Check for number of spaces, store that value
			for (int i = 0; i < field.getText().trim().length(); i++) {
					if (field.getText().trim().charAt(i) == ' ') {
						spaces++;
					}
			}
			
			RecursiveAnagramizer.fileToList();
			RecursiveAnagramizer.anagramizerR(field.getText().trim(), "");
			RecursiveAnagramizer.filterAnagrams(spaces);
			
			// Store the valid anagrams in a String with format
			for (int i = 0; i < RecursiveAnagramizer.filteredAnagrams.size(); i++) {
				resulted += "\"" + RecursiveAnagramizer.filteredAnagrams.get(i) + "\"  ";
				counter++;
				if (counter == 7) {
					resulted += "\"" + RecursiveAnagramizer.filteredAnagrams.get(i) + "\"\n";
					counter = 0;
				}
			}
			
			resultWindow(resulted);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// Show valid anagrams
	public void resultWindow(String validAnagrams) {
		result = new TextArea(validAnagrams);
		
		GridPane resultPane = new GridPane();
		
		resultPane.setHgap(10);
		resultPane.setVgap(10);
		resultPane.setPadding(new Insets(10,10,10,10));
		
		resultPane.add(result, 0, 0);

		GridPane mainPane = new GridPane();
		mainPane.add(resultPane, 0, 0);
		mainPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Scene mainScene = new Scene(mainPane);
		resultStage = new Stage();
		
		resultStage.setTitle("Valid Anagrams");
		resultStage.setResizable(false);
		resultStage.setScene(mainScene);
		resultStage.show();
	}
	
	// Check if user wants to continue with the process
	public void warning() {
		Button continues = new Button("\t\t\tContinue\t\t\t\t");
		Label infoWarning = new Label("\t\t\t  Warning!\nHeavy CPU and memory usage is required\n");
		
		GridPane mainPane = new GridPane();
		
		mainPane.setHgap(10);
		mainPane.setVgap(10);
		mainPane.setPadding(new Insets(10,10,10,10));
		
		mainPane.add(infoWarning, 0, 0);
		mainPane.add(continues, 0, 1);
		mainPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Scene mainScene = new Scene(mainPane);
		waitingStage = new Stage();
		
		continues.setOnAction(e->{ 
			process();
		}
		);
		
		waitingStage.setTitle("WARNING!");
		waitingStage.setResizable(false);
		waitingStage.setScene(mainScene);
		waitingStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
