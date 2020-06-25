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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
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
	
	private Lecteur lecteur = new Lecteur("Theh2zo");

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
	 @FXML
    private LineChart<Integer,Integer> linechart;
	
	
	
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

	
	/*=================================================================
	 * Graphes en barre de la section graphique
	 * ================================================================
	 */
	@FXML
	protected void PushOr(ActionEvent e)throws IOException {
		
		Joueur[][] tab= lecteur.getTabJoueur();
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		for(int i = 0; i<10;i++) {
			series.getData().add(new XYChart.Data<>(tab[i][1].champion,tab[i][1].totalOr));
			System.out.println(tab[i][1].champion + " , " + tab[i][1].totalOr);
		}
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(180);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);
	}
    @FXML
    void PushSbire(ActionEvent event) {
    	Joueur[][] tab= lecteur.getTabJoueur();
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		for(int i = 0; i<10;i++) {
			series.getData().add(new XYChart.Data<>(tab[i][1].champion,tab[i][1].sbires));
		}
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(180);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);

    }
    @FXML
    void PushDegat(ActionEvent event) {
    	Joueur[][] tab= lecteur.getTabJoueur();
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		for(int i = 0; i<10;i++) {
			series.getData().add(new XYChart.Data<>(tab[i][1].champion,tab[i][1].totalOr));
		}
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(180);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);

    }
    @FXML
    void PushSoin(ActionEvent event) {
    	Joueur[][] tab= lecteur.getTabJoueur();
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		for(int i = 0; i<10;i++) {
			series.getData().add(new XYChart.Data<>(tab[i][1].champion,tab[i][1].soins));
		}
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(180);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);

    }
    @FXML
    void PushTourelle(ActionEvent event) {
    	Joueur[][] tab= lecteur.getTabJoueur();
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		for(int i = 0; i<10;i++) {
			series.getData().add(new XYChart.Data<>(tab[i][1].champion,tab[i][1].tourelles));
			
		}
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(180);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);

    }
    @FXML
    void PushKill(ActionEvent event) {
    	Joueur[][] tab= lecteur.getTabJoueur();
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		for(int i = 0; i<10;i++) {
			series.getData().add(new XYChart.Data<>(tab[i][1].champion,tab[i][1].eliminations));
		}
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(180);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);

    }
    @FXML
    void PushDeath(ActionEvent event) {
    	Joueur[][] tab= lecteur.getTabJoueur();
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		for(int i = 0; i<10;i++) {
			series.getData().add(new XYChart.Data<>(tab[i][1].champion,tab[i][1].morts));
		}
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(180);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);

    }
	
	@FXML
    void PushAssist(ActionEvent event) {
		Joueur[][] tab= lecteur.getTabJoueur();
		barchart.getData().clear();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		for(int i = 0; i<10;i++) {
			series.getData().add(new XYChart.Data<>(tab[i][1].champion,tab[i][1].assistances));
		}
		barchart.getData().add(series);
		barchart.getXAxis().setTickLabelRotation(180);
		barchart.getYAxis().setTickLabelsVisible(false);
	    barchart.getYAxis().setOpacity(0);

    }

	/*
	 * Graphe en courbe de la partie avantage
	 */
	@FXML
    void pushAvantage(ActionEvent event) {
		linechart.getData().clear();
		//defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Avantage or");
        //populating the series with data
        series.getData().add(new XYChart.Data("1", 23));
        series.getData().add(new XYChart.Data("2", 14));
        series.getData().add(new XYChart.Data("3", 15));
        series.getData().add(new XYChart.Data("4", -24));
        series.getData().add(new XYChart.Data("5", 34));
        series.getData().add(new XYChart.Data("6", 36));
        series.getData().add(new XYChart.Data("7", 22));
        series.getData().add(new XYChart.Data("8", 45));
        series.getData().add(new XYChart.Data("9", -43));
        series.getData().add(new XYChart.Data("10", 17));
        series.getData().add(new XYChart.Data("11", 29));
        series.getData().add(new XYChart.Data("12", 25));
        
        linechart.getData().add(series);
        
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
