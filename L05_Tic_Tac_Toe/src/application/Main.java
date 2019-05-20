package application;
	
import gui.ButtonsPane;
import gui.TicTacToePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TicTacToePane TicTacToe = new TicTacToePane();
			ButtonsPane buttons = new ButtonsPane();
			
			GridPane mainPane = new GridPane();
			
			mainPane.add(buttons, 0, 0);
			mainPane.add(TicTacToe, 0, 1);
			
			TicTacToe.startGame();
			buttons.setUpButtons();
			
			Scene scene = new Scene(mainPane, 200, 250);
			scene.getStylesheets().add("application/application.css");
			
			primaryStage.setTitle("[X][O]");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
