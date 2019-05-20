package L08;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI_PDFBox extends Application {
	
	GridPane mainPane;
	GridPane inputPane;
	GridPane buttonPane;
	
	Button button;
	Label label;
	static TextField textField;

	@Override
	public void start(Stage primaryStage) throws Exception {
		label = new Label("Enter the path of the .pdf file: ");
		label.setFont(new Font("Dialoge", 13));
		
		button = new Button("Go: ");
		button.setFont(new Font("Dialoge", 13));
		button.setMinSize(280, 10);
		
		textField = new TextField();
		textField.setFont(new Font("Dialoge", 13));
		textField.setMinSize(280, 10);
		
		inputPane = new GridPane();
		inputPane.setPadding(new Insets(5,10,5,20));
		
		inputPane.add(label, 0, 0);
		inputPane.add(textField, 0, 1);
		
		buttonPane = new GridPane();
		buttonPane.setPadding(new Insets(5,10,5,20));
		
		buttonPane.add(button, 0, 1);
		
		mainPane = new GridPane();
		mainPane.add(inputPane, 0, 0);
		mainPane.add(buttonPane, 0, 1);
		
		button.setOnAction(e-> { 
			Handeler handeler = new Handeler();
			handeler.Extractor(textField.getText());
			primaryStage.close();
		});
		
		Scene mainScene = new Scene(mainPane, 325, 100);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("PDFBox");
		primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
