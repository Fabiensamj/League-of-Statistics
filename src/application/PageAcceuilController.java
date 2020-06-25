package application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class PageAcceuilController {
	
	private Stage stage;
	
	private Model model1;
	
	private int chapardage = 1;
	
	private int chapardage2 = 1;
	
	static public Lecteur lecteur;
	
	///// Page Accueil /////

	@FXML
	private TextArea Nom;
	
	///// Page 1 /////
	
	@FXML
	private Label TextNombreDor;

	@FXML
	private Label TextSbiresTues;

	@FXML
	private Label TextDegatsInfliges;
	
	@FXML
	private Label TextSoinsProdigues;
	
	@FXML
	private Label TextTourellesDetruites;
	
	@FXML
	private Label TextNombreDeliminations;
	
	@FXML
	private Label TextNombreDeMorts;
	
	@FXML
	private Label TextNombreDassistance;
	
	@FXML
	private PieChart TauxVictoire;
	
	@FXML
	private Polygon GraphDiagram;

	@FXML
	private Label TextNomInvocateur;

	@FXML
	private Label TextClassement;
	
	@FXML
    private BarChart<String, Integer> barchart;
	
	@FXML
    private LineChart<Integer,Integer> linechart;
	
	///// Page 2 /////
	
	static int numPartie = 0;
	
	@FXML
	private Label NomE1C1, NomE1C2, NomE1C3, NomE1C4, NomE1C5, NomE2C1, NomE2C2, NomE2C3, NomE2C4, NomE2C5;
	
	@FXML
	private Label KillE1C1, KillE1C2, KillE1C3, KillE1C4, KillE1C5, KillE2C1, KillE2C2, KillE2C3, KillE2C4, KillE2C5;
	
	@FXML
	private Label DeathE1C1, DeathE1C2, DeathE1C3, DeathE1C4, DeathE1C5, DeathE2C1, DeathE2C2, DeathE2C3, DeathE2C4, DeathE2C5;
	
	@FXML
	private Label AssistE1C1, AssistE1C2, AssistE1C3, AssistE1C4, AssistE1C5, AssistE2C1, AssistE2C2, AssistE2C3, AssistE2C4, AssistE2C5;
	
	@FXML
	private Label DetailsNom, DetailsSbires, DetailsKill, DetailsDeath, DetailsAssist;
	
	@FXML
	private ImageView DetailsItem, DetailsRunes, DetailsLogo;
	
	@FXML
	private ImageView ImgE1C1, ImgE1C2, ImgE1C3, ImgE1C4, ImgE1C5, ImgE2C1, ImgE2C2, ImgE2C3, ImgE2C4, ImgE2C5;
	
	///// Fonctions /////
	 
	@FXML
	protected void PushConnexion(ActionEvent e) throws IOException {
			lecteur = new Lecteur(Nom.getText());
			Parent home_p = FXMLLoader.load(getClass().getResource("Page1.fxml"));
			Scene home_s = new Scene(home_p);
			Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage.setScene(home_s);
			//Bug parceque le graph pas initialiser ?, Initialiser toute les scene au dÃ©but puis faire que des .show() ?
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
		numPartie = 0;
		chapardage2 = 1;
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
    void initPage2(MouseEvent event) {
    	//System.out.printf("Insertion des données Page 2");
    	if(chapardage2 == 1){
    		System.out.printf("Insertion des données Page 2 \n");
    		
    		TextNomInvocateur.setText(lecteur.getUtilisateur().getPseudo());
    		
    		///// Resume /////
    		
    		NomE1C1.setText(lecteur.getTabJoueur()[0][numPartie].getPseudo());
    		KillE1C1.setText(Integer.toString(lecteur.getTabJoueur()[0][numPartie].getEliminations()));
    		DeathE1C1.setText(Integer.toString(lecteur.getTabJoueur()[0][numPartie].getMorts()));
    		AssistE1C1.setText(Integer.toString(lecteur.getTabJoueur()[0][numPartie].getAssistances()));
    		
    		NomE1C2.setText(lecteur.getTabJoueur()[1][numPartie].getPseudo());
    		KillE1C2.setText(Integer.toString(lecteur.getTabJoueur()[1][numPartie].getEliminations()));
    		DeathE1C2.setText(Integer.toString(lecteur.getTabJoueur()[1][numPartie].getMorts()));
    		AssistE1C2.setText(Integer.toString(lecteur.getTabJoueur()[1][numPartie].getAssistances()));
    		
    		NomE1C3.setText(lecteur.getTabJoueur()[2][numPartie].getPseudo());
    		KillE1C3.setText(Integer.toString(lecteur.getTabJoueur()[2][numPartie].getEliminations()));
    		DeathE1C3.setText(Integer.toString(lecteur.getTabJoueur()[2][numPartie].getMorts()));
    		AssistE1C3.setText(Integer.toString(lecteur.getTabJoueur()[2][numPartie].getAssistances()));
    		
    		NomE1C4.setText(lecteur.getTabJoueur()[3][numPartie].getPseudo());
    		KillE1C4.setText(Integer.toString(lecteur.getTabJoueur()[3][numPartie].getEliminations()));
    		DeathE1C4.setText(Integer.toString(lecteur.getTabJoueur()[3][numPartie].getMorts()));
    		AssistE1C4.setText(Integer.toString(lecteur.getTabJoueur()[3][numPartie].getAssistances()));
    		
    		NomE1C5.setText(lecteur.getTabJoueur()[4][numPartie].getPseudo());
    		KillE1C5.setText(Integer.toString(lecteur.getTabJoueur()[4][numPartie].getEliminations()));
    		DeathE1C5.setText(Integer.toString(lecteur.getTabJoueur()[4][numPartie].getMorts()));
    		AssistE1C5.setText(Integer.toString(lecteur.getTabJoueur()[4][numPartie].getAssistances()));
    		
    		NomE2C1.setText(lecteur.getTabJoueur()[5][numPartie].getPseudo());
    		KillE2C1.setText(Integer.toString(lecteur.getTabJoueur()[5][numPartie].getEliminations()));
    		DeathE2C1.setText(Integer.toString(lecteur.getTabJoueur()[5][numPartie].getMorts()));
    		AssistE2C1.setText(Integer.toString(lecteur.getTabJoueur()[5][numPartie].getAssistances()));
    		
    		NomE2C2.setText(lecteur.getTabJoueur()[6][numPartie].getPseudo());
    		KillE2C2.setText(Integer.toString(lecteur.getTabJoueur()[6][numPartie].getEliminations()));
    		DeathE2C2.setText(Integer.toString(lecteur.getTabJoueur()[6][numPartie].getMorts()));
    		AssistE2C2.setText(Integer.toString(lecteur.getTabJoueur()[6][numPartie].getAssistances()));
    		
    		NomE2C3.setText(lecteur.getTabJoueur()[7][numPartie].getPseudo());
    		KillE2C3.setText(Integer.toString(lecteur.getTabJoueur()[7][numPartie].getEliminations()));
    		DeathE2C3.setText(Integer.toString(lecteur.getTabJoueur()[7][numPartie].getMorts()));
    		AssistE2C3.setText(Integer.toString(lecteur.getTabJoueur()[7][numPartie].getAssistances()));
    		
    		NomE2C4.setText(lecteur.getTabJoueur()[8][numPartie].getPseudo());
    		KillE2C4.setText(Integer.toString(lecteur.getTabJoueur()[8][numPartie].getEliminations()));
    		DeathE2C4.setText(Integer.toString(lecteur.getTabJoueur()[8][numPartie].getMorts()));
    		AssistE2C4.setText(Integer.toString(lecteur.getTabJoueur()[8][numPartie].getAssistances()));
    		
    		NomE2C5.setText(lecteur.getTabJoueur()[9][numPartie].getPseudo());
    		KillE2C5.setText(Integer.toString(lecteur.getTabJoueur()[9][numPartie].getEliminations()));
    		DeathE2C5.setText(Integer.toString(lecteur.getTabJoueur()[9][numPartie].getMorts()));
    		AssistE2C5.setText(Integer.toString(lecteur.getTabJoueur()[9][numPartie].getAssistances()));
    		
    		Class<?> clazz = this.getClass();
    		InputStream input;
    		Image image;
    		
    		/*
    		String logo1 = "/application/Img/champion/" + lecteur.getTabJoueur()[0][numPartie].getChampion() + ".jpg";
    		String logo2 = "/application/Img/champion/" + lecteur.getTabJoueur()[1][numPartie].getChampion() + ".jpg";
    		String logo3 = "/application/Img/champion/" + lecteur.getTabJoueur()[2][numPartie].getChampion() + ".jpg";
    		String logo4 = "/application/Img/champion/" + lecteur.getTabJoueur()[3][numPartie].getChampion() + ".jpg";
    		String logo5 = "/application/Img/champion/" + lecteur.getTabJoueur()[4][numPartie].getChampion() + ".jpg";
    		String logo6 = "/application/Img/champion/" + lecteur.getTabJoueur()[5][numPartie].getChampion() + ".jpg";
    		String logo7 = "/application/Img/champion/" + lecteur.getTabJoueur()[6][numPartie].getChampion() + ".jpg";
    		String logo8 = "/application/Img/champion/" + lecteur.getTabJoueur()[7][numPartie].getChampion() + ".jpg";
    		String logo9 = "/application/Img/champion/" + lecteur.getTabJoueur()[8][numPartie].getChampion() + ".jpg";
    		String logo10 = "/application/Img/champion/" + lecteur.getTabJoueur()[9][numPartie].getChampion() + ".jpg";
    		
    		input = clazz.getResourceAsStream(logo1);
    		image = new Image(input);   		
    		ImgE1C1.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo2);
    		image = new Image(input);   		
    		ImgE1C2.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo3);
    		image = new Image(input);   		
    		ImgE1C3.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo4);
    		image = new Image(input);   		
    		ImgE1C4.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo5);
    		image = new Image(input);   		
    		ImgE1C5.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo6);
    		image = new Image(input);   		
    		ImgE2C1.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo7);
    		image = new Image(input);   		
    		ImgE2C2.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo8);
    		image = new Image(input);   		
    		ImgE2C3.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo9);
    		image = new Image(input);   		
    		ImgE2C4.setImage(image);
    		
    		input = clazz.getResourceAsStream(logo10);
    		image = new Image(input);   		
    		ImgE2C5.setImage(image);
    		*/
    		
    		///// Details /////
    		int lienPersJoueur = 0;
    		
    		for(int i = 0; i < 10; i++){
    			if(lecteur.getTabJoueur()[i][numPartie].getPseudo().equals(lecteur.getUtilisateur().getPseudo())){
    				lienPersJoueur = i;
    			}
    		}
    		
    		DetailsNom.setText(lecteur.getUtilisateur().getPseudo());
    		DetailsKill.setText(Integer.toString(lecteur.getTabJoueur()[lienPersJoueur][numPartie].getEliminations()));
    		DetailsDeath.setText(Integer.toString(lecteur.getTabJoueur()[lienPersJoueur][numPartie].getMorts()));
    		DetailsAssist.setText(Integer.toString(lecteur.getTabJoueur()[lienPersJoueur][numPartie].getAssistances()));
    		DetailsSbires.setText(Integer.toString(lecteur.getTabJoueur()[lienPersJoueur][numPartie].getSbires()));
    		
    		
    		String imgEquipement = "/application/Img/Items/ItemsSet" + lecteur.getTabJoueur()[lienPersJoueur][numPartie].getEquipement() + ".png";
    		System.out.printf("Image : " + imgEquipement);
    		input = clazz.getResourceAsStream(imgEquipement);
    		image = new Image(input);

    		DetailsItem.setImage(image);
    		
    		/*
    		String imgLogo = "/application/Img/champion/" + lecteur.getTabJoueur()[lienPersJoueur][numPartie].getChampion() + ".jpg";
    		input = clazz.getResourceAsStream(imgLogo);
    		image = new Image(input);
    		
    		DetailsLogo.setImage(image);
    		*/
    		
    		
    		chapardage2 = 0;
    	}
    }
	
	@FXML
	protected void TauxVictoire(MouseEvent e) {
		if (chapardage ==1) {
			
			TextNomInvocateur.setText(lecteur.getUtilisateur().getPseudo());
			
			/////////////////////////////////////////////////////////////////////////////////////
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
	
			if (degats <= 1000 && soin <=1000 && tanker <= 1000) {//Valeur a rÃ©gler sur ceux des games
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
