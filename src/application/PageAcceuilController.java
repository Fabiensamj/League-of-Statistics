package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class PageAcceuilController {
	
	private Stage stage;
	
	private Model model1;
	
	@FXML
	private Label TextNomInvocateur;
	
	@FXML
	private TextArea Nom;
	@FXML
    private BarChart<String, Integer> barchart;
	/* @FXML
    private LineChart<Integer,Integer> linechart;*/
	
	
	
	@FXML
	protected void PushConnexion(ActionEvent e) throws IOException {
			Parent home_p = FXMLLoader.load(getClass().getResource("Page1.fxml"));
			Scene home_s = new Scene(home_p);
			Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage.setScene(home_s);
			app_stage.show();
			
			
			/*model1.setNom(Nom);
			
			TextNomInvocateur.setText(model1.getNom());
			System.out.printf(model1.getNom());*/
	}
	
	@FXML
	protected void PushDeconnexion(ActionEvent e)throws IOException {
		Parent home_p = FXMLLoader.load(getClass().getResource("PageAcceuil.fxml"));
		Scene home_s = new Scene(home_p);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(home_s);
		app_stage.show();
	}
	
	@FXML
	protected void PushHistorique(MouseEvent e)throws IOException {
		Parent home_p = FXMLLoader.load(getClass().getResource("Page2.fxml"));
		Scene home_s = new Scene(home_p);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(home_s);
		app_stage.show();
	}

	@FXML
	protected void PushGraphe(ActionEvent e)throws IOException {
		
		/*CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Programming Language");
 
        NumberAxis yAxis = new NumberAxis();
          
        yAxis.setLabel("Percent");
 
        // Create a BarChart
        BarChart<Number, String> barchart = new BarChart<Number, String>(yAxis, xAxis);
		*/
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		series.getData().add(new XYChart.Data<>("test 1", 100));
		series.getData().add(new XYChart.Data<>("test 2", 10));
		series.getData().add(new XYChart.Data<>("test 3", 200));
		series.getData().add(new XYChart.Data<>("test 4", 50));
		series.getData().add(new XYChart.Data<>("test 5", 220));
		series.getData().add(new XYChart.Data<>("test 6", 100));
		series.getData().add(new XYChart.Data<>("test 7", 10));
		series.getData().add(new XYChart.Data<>("test 8", 200));
		series.getData().add(new XYChart.Data<>("test 9", 50));
		series.getData().add(new XYChart.Data<>("test 10", 220));
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(-90);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);
		
		
		
		
	}
	
	
	
	
	
	
}
