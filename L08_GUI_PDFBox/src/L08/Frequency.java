package L08;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Frequency {
	
	static Map<String, Integer> words_counter;
	static String word;
	static List<String> frequencyK;
	static List<Integer> frequencyV;
	static Integer position;
	static Integer counter = 0;
	
	@SuppressWarnings("unchecked")
	public static void Frequent(String[] text) {
		
		// Store words and apparitions in HashMap
		words_counter = new HashMap<String, Integer>(2);
		for(int counter = 0; counter < text.length; counter++) {
		     word = text[counter];
		     
		     if(words_counter.keySet().contains(word)) {
		          position = words_counter.get(word) + 1;
		          words_counter.put(word, position);
		     }
		     else
		    	 words_counter.put(word, 1);
		}

		// Sort by values DESC
		Map<String, Integer> sorted_words_counter= words_counter.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	    
	    // Graph JavaFX Stage
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Word");
		yAxis.setLabel("Frequency");
		
		final BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

		@SuppressWarnings("rawtypes")
		XYChart.Series series = new XYChart.Series();
	    
	    // Show 10 most frequent in a BarChart
		for (Map.Entry<String, Integer> entry : sorted_words_counter.entrySet()) {
			counter++;
			if (counter <= 10) {
				System.out.println("The word: \"" + entry.getKey().toString() + "\" is used " + entry.getValue().toString() + " times");
				series.getData().add(new XYChart.Data<String, Integer>(entry.getKey(), entry.getValue()));
			}
			else {
				break;
			}
		}
	    
		barChart.getData().add(series);
		barChart.backgroundProperty();
		barChart.setLegendVisible(false);
		
		Scene graphScene = new Scene(barChart, 400, 400);
		Stage graphStage = new Stage();
		graphStage.setScene(graphScene);
		graphStage.setTitle("Frequency of Word Usage");
		graphStage.initStyle(StageStyle.UTILITY);
		graphStage.show();
	}
	
}