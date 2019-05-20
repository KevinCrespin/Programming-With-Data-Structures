import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane mainPane = new Pane();
		Scene mainScene = new Scene(mainPane, 400, 400);
		
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Minesweeper");
		primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Grid minesweeper = new Grid();
		
		minesweeper.make2DArray(5, 5);
		launch(args);
	}

}
