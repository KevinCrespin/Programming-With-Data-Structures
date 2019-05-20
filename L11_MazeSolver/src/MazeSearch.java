import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MazeSearch extends Application {
	
	static StackPane mainPane;
	static GridPane mazePane;
	static StackPane controlPane;
	
	static Button solveBtn;
	
	static Label solved = new Label("Maze Solved");
	static Label noSolution = new Label("No Solution");
	
	static GraphicsContext gc;
	
	static Maze maze = new Maze();
	static RecursiveDFSSolverStrategy solver = new RecursiveDFSSolverStrategy(maze);

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		solveBtn = new Button("   Solve   ");
		solveBtn.setFont(new Font("Dialoge", 13));
		solveBtn.setPadding(new Insets(5,5,5,5));
		
		mazePane = new GridPane();
		mazePane.setPadding(new Insets(10,10,10,10));
		
		controlPane = new StackPane();
		controlPane.getChildren().add(solveBtn);
		StackPane.setAlignment(solveBtn, Pos.BOTTOM_CENTER);
		StackPane.setMargin(solveBtn, new Insets(10, 10, 10, 10));
		
		mainPane = new StackPane();
		mainPane.getChildren().add(mazePane);
		mainPane.getChildren().add(controlPane);
		
		solveBtn.setOnAction(e->{
			solveMazeBtn();
		});
		
		Scene mainScene = new Scene(mainPane, 325, 100);
		
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Maze");
		primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

	public static void solveMazeBtn() {
	
		solved.setFont(new Font("Dialoge", 13));
		noSolution.setFont(new Font("Dialoge", 13));
		
		if (solver.solve(0, 0)) {
			maze.printMaze();
			controlPane.getChildren().add(solved);
			StackPane.setAlignment(solved, Pos.TOP_CENTER);
			StackPane.setMargin(solved, new Insets(10, 10, 10, 10));
			solveBtn.setVisible(false);
		}
		else {
			maze.printMaze();
			controlPane.getChildren().add(noSolution);
			StackPane.setAlignment(noSolution, Pos.TOP_CENTER);
			StackPane.setMargin(noSolution, new Insets(10, 10, 10, 10));
			solveBtn.setVisible(false);
		}
	}

}