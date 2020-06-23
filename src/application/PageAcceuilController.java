package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class PageAcceuilController {
	
	private Stage stage;
	
	private Model model1;
	
	private int chapardage = 1;

	@FXML
	private PieChart TauxVictoire;
	
	@FXML
	private Polygon GraphDiagram;

	
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
			//Bug parceque le graph pas initialiser ?, Initialiser toute les scene au début puis faire que des .show() ?
			app_stage.show();
			
			
			/*model1.setNom(Nom);
			
			TextNomInvocateur.setText(model1.getNom());
			System.out.printf(model1.getNom());
			//TauxVictoire(75.0);
			//GraphChange(600,200,200)
			 */
	}
	
	@FXML
	protected void PushDeconnexion(ActionEvent e)throws IOException {
		Parent home_p = FXMLLoader.load(getClass().getResource("PageAcceuil.fxml"));
		Scene home_s = new Scene(home_p);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(home_s);
		app_stage.show();
		chapardage = 1;
	}
	
	@FXML
	protected void PushHistorique(MouseEvent e)throws IOException {
		Parent home_p = FXMLLoader.load(getClass().getResource("Page2.fxml"));
		Scene home_s = new Scene(home_p);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(home_s);
		app_stage.show();
		chapardage = 1;
	}

	@FXML
	protected void PushGraphe(ActionEvent e)throws IOException {
		
		
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
	@FXML
	protected void TauxVictoire(MouseEvent e) {
		if (chapardage ==1) {
		double Victoire = 75;
		double Defaite = (100-Victoire);
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList( 
				   new PieChart.Data("Victoire", Victoire), 
				   new PieChart.Data("Defaite", Defaite));		   
		TauxVictoire.setData(pieChartData);
		chapardage =0;
		/////////////////////////////////////////////////////////////////////////////////////

		int degats = 2500;
		int soin = 4800;
		int tanker = 100;

		GraphDiagram.getPoints().clear();

		if (degats <= 1000 && soin <=1000 && tanker <= 1000) {//Valeur a régler sur ceux des games
			GraphDiagram.getPoints().addAll(new Double[] {
				-12.0,5.0,//Heal
				-1.0,3.0,//Tank
				-7.0,-10.0,//DPS
			});
		}
		else if (degats>1000 && degats <= 2000 && soin <=1000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin <=1000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin <=1000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-38.0,//DPS
				});
		}


		else if (degats <= 1000 && soin > 1000 && soin<=2000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin > 1000 && soin<=2000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin > 1000 && soin<=2000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin > 1000 && soin<=2000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-38.0,//DPS
				});
		}



		else if (degats <= 1000 && soin > 2000 && soin<=4000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin > 2000 && soin<=4000  && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin > 2000 && soin<=4000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin > 2000 && soin<=4000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-38.0,//DPS
				});
		}



		else if (degats <= 1000 &&  soin>4000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin>4000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin>4000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin>4000 && tanker <= 1000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					-1.0,3.0,//Tank
					-7.0,-38.0,//DPS
				});
		}
		////
		else if (degats <= 1000 && soin <=1000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					5.0,10.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin <=1000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					5.0,10.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin <=1000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					5.0,10.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin <=1000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					5.0,10.0,//Tank
					-7.0,-38.0,//DPS
				});
		}


		else if (degats <= 1000 && soin > 1000 && soin<=2000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					5.0,10.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin > 1000 && soin<=2000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					5.0,10.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin > 1000 && soin<=2000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					5.0,10.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin > 1000 && soin<=2000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					5.0,10.0,//Tank
					-7.0,-38.0,//DPS
				});
		}



		else if (degats <= 1000 && soin > 2000 && soin<=4000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					5.0,10.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin > 2000 && soin<=4000  && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					5.0,10.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin > 2000 && soin<=4000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					5.0,10.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin > 2000 && soin<=4000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					5.0,10.0,//Tank
					-7.0,-38.0,//DPS
				});
		}



		else if (degats <= 1000 &&  soin>4000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					5.0,10.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin>4000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					5.0,10.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin>4000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					5.0,10.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin>4000 && tanker > 1000 && tanker <= 2000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					5.0,10.0,//Tank
					-7.0,-38.0,//DPS
				});
		}
		////
		else if (degats <= 1000 && soin <=1000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					9.0,17.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin <=1000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					9.0,17.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin <=1000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					9.0,17.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin <=1000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					9.0,17.0,//Tank
					-7.0,-38.0,//DPS
				});
		}


		else if (degats <= 1000 && soin > 1000 && soin<=2000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					9.0,17.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin > 1000 && soin<=2000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					9.0,17.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin > 1000 && soin<=2000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					9.0,17.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin > 1000 && soin<=2000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					9.0,17.0,//Tank
					-7.0,-38.0,//DPS
				});
		}



		else if (degats <= 1000 && soin > 2000 && soin<=4000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					9.0,17.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin > 2000 && soin<=4000  && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					9.0,17.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin > 2000 && soin<=4000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					9.0,17.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin > 2000 && soin<=4000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					9.0,17.0,//Tank
					-7.0,-38.0,//DPS
				});
		}



		else if (degats <= 1000 &&  soin>4000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					9.0,17.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin>4000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					9.0,17.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin>4000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					9.0,17.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin>4000 && tanker > 2000 && tanker <= 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					9.0,17.0,//Tank
					-7.0,-38.0,//DPS
				});
		}
		////
		else if (degats <= 1000 && soin <=1000 && tanker > 4000 ) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					13.0,23.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin <=1000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					13.0,23.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin <=1000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					13.0,23.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin <=1000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-12.0,5.0,//Heal
					13.0,23.0,//Tank
					-7.0,-38.0,//DPS
				});
		}


		else if (degats <= 1000 && soin > 1000 && soin<=2000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					13.0,23.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin > 1000 && soin<=2000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					13.0,23.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin > 1000 && soin<=2000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					13.0,23.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin > 1000 && soin<=2000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-17.0,12.0,//Heal
					13.0,23.0,//Tank
					-7.0,-38.0,//DPS
				});
		}



		else if (degats <= 1000 && soin > 2000 && soin<=4000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					13.0,23.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin > 2000 && soin<=4000  && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					13.0,23.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin > 2000 && soin<=4000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					13.0,23.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin > 2000 && soin<=4000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-22.0,17.0,//Heal
					13.0,23.0,//Tank
					-7.0,-38.0,//DPS
				});
		}



		else if (degats <= 1000 &&  soin>4000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					13.0,23.0,//Tank
					-7.0,-10.0,//DPS
				});
		}
		else if (degats>1000 && degats <= 2000 && soin>4000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					13.0,23.0,//Tank
					-7.0,-18.0,//DPS
				});
		}
		else if (degats >2000 && degats <= 4000 && soin>4000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					13.0,23.0,//Tank
					-7.0,-28.0,//DPS
				});
		}
		else if (degats >4000 && soin>4000 && tanker > 4000) {
			GraphDiagram.getPoints().addAll(new Double[] {
					-27.0,25.0,//Heal
					13.0,23.0,//Tank
					-7.0,-38.0,//DPS
				});
		}
		}
		else {}
	}

	
	
	
	
	
	
}
