package application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class PageAcceuilController {
	
	private Stage stage;
	
	public static Model model1 = new Model();
	
	private int chapardage = 1;// Bloque les mises a jour des mouseMove sur les pane
	private int chapardage2 = 1;
	private int chapardage3 = 1;
	
	public static Lecteur lecteur;
	
	

	@FXML
	private ImageView ImgHistorique1;
	@FXML
	private Label KillHistorique1;
	@FXML
	private Label DeathHistorique1;
	@FXML
	private Label AssistHistorique1;
	@FXML
	private Label ResultHistorique1;
	@FXML
	private Label Date_Jour1;
	@FXML
	private Label Date_Mois1;
	@FXML
	private Label Date_Annee1;
	
	@FXML
	private ImageView ImgHistorique2;
	@FXML
	private Label KillHistorique2;
	@FXML
	private Label DeathHistorique2;
	@FXML
	private Label AssistHistorique2;
	@FXML
	private Label ResultHistorique2;
	@FXML
	private Label Date_Jour2;
	@FXML
	private Label Date_Mois2;
	@FXML
	private Label Date_Annee2;
	
	
	@FXML
	private ImageView ImgHistorique3;
	@FXML
	private Label KillHistorique3;
	@FXML
	private Label DeathHistorique3;
	@FXML
	private Label AssistHistorique3;
	@FXML
	private Label ResultHistorique3;
	@FXML
	private Label Date_Jour3;
	@FXML
	private Label Date_Mois3;
	@FXML
	private Label Date_Annee3;
	
	
	@FXML
	private ImageView ImgHistorique4;
	@FXML
	private Label KillHistorique4;
	@FXML
	private Label DeathHistorique4;
	@FXML
	private Label AssistHistorique4;
	@FXML
	private Label ResultHistorique4;
	@FXML
	private Label Date_Jour4;
	@FXML
	private Label Date_Mois4;
	@FXML
	private Label Date_Annee4;
	
	
	@FXML
	private ImageView ImgHistorique5;
	@FXML
	private Label KillHistorique5;
	@FXML
	private Label DeathHistorique5;
	@FXML
	private Label AssistHistorique5;
	@FXML
	private Label ResultHistorique5;
	@FXML
	private Label Date_Jour5;
	@FXML
	private Label Date_Mois5;
	@FXML
	private Label Date_Annee5;
	
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
			lecteur = new Lecteur(Nom.getText(), 3);
			System.out.printf("PSEUDO : " + lecteur.getUtilisateur().getPseudo());
			Parent home_p = FXMLLoader.load(getClass().getResource("Page1.fxml"));
			Scene home_s = new Scene(home_p);
			Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage.setScene(home_s);
			
			app_stage.show();
			
			
			
	}
	
	@FXML
	protected void PushReturn(MouseEvent e) throws IOException {
			Parent home_p = FXMLLoader.load(getClass().getResource("Page1.fxml"));
			Scene home_s = new Scene(home_p);
			Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			app_stage.setScene(home_s);
			app_stage.show();		
			
			
	}
	
	@FXML
	protected void PushDeconnexion(ActionEvent e)throws IOException {
		Parent home_p = FXMLLoader.load(getClass().getResource("PageAcceuil.fxml"));
		Scene home_s = new Scene(home_p);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(home_s);
		app_stage.show();
		chapardage = 1;
		chapardage2 = 1;
		chapardage3 = 1;
		
		model1.setImgHistorique1(null);
		model1.setKillHistorique1(null);
		model1.setDeathHistorique1(null);
		model1.setAssistHistorique1(null);
		model1.setResultHistorique1(null);
		model1.setDate_Jour1(null);
		model1.setDate_Mois1(null);
		model1.setDate_Annee1(null);
		
		model1.setImgHistorique2(null);
		model1.setKillHistorique2(null);
		model1.setDeathHistorique2(null);
		model1.setAssistHistorique2(null);
		model1.setResultHistorique2(null);
		model1.setDate_Jour2(null);
		model1.setDate_Mois2(null);
		model1.setDate_Annee2(null);
		
		model1.setImgHistorique3(null);
		model1.setKillHistorique3(null);
		model1.setDeathHistorique3(null);
		model1.setAssistHistorique3(null);
		model1.setResultHistorique3(null);
		model1.setDate_Jour3(null);
		model1.setDate_Mois3(null);
		model1.setDate_Annee3(null);
		
		model1.setImgHistorique4(null);
		model1.setKillHistorique4(null);
		model1.setDeathHistorique4(null);
		model1.setAssistHistorique4(null);
		model1.setResultHistorique4(null);
		model1.setDate_Jour4(null);
		model1.setDate_Mois4(null);
		model1.setDate_Annee4(null);
		
		model1.setImgHistorique5(null);
		model1.setKillHistorique5(null);
		model1.setDeathHistorique5(null);
		model1.setAssistHistorique5(null);
		model1.setResultHistorique5(null);
		model1.setDate_Jour5(null);
		model1.setDate_Mois5(null);
		model1.setDate_Annee5(null);
	}
	
	@FXML
	protected void PushHistorique(MouseEvent e)throws IOException {
		Parent home_p = FXMLLoader.load(getClass().getResource("Page2.fxml"));
		Scene home_s = new Scene(home_p);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(home_s);
		app_stage.show();
		numPartie = 0;
		chapardage = 1;
		chapardage2 = 1;
		chapardage3 = 1;
		
		
	}

	////////////////////Fonction nombre de fichiers dans un dossier//////////////////
	
	
	public int NbFichiers(String path) {
		
		File monRepertoire=new File(path);
		File[] f = monRepertoire.listFiles();
		int x = 0;
		for (int i = 0 ; i < f.length ; i++) {
		  if (f[i].isFile()) {
		    x++;
		  }
		}
		//x = monRepertoire.listFiles().length;
		return x;
		
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
			series.getData().add(new XYChart.Data<>(tab[i][numPartie].champion,tab[i][numPartie].totalOr));
			System.out.println(tab[i][numPartie].champion + " , " + tab[i][numPartie].totalOr);
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
			series.getData().add(new XYChart.Data<>(tab[i][numPartie].champion,tab[i][numPartie].sbires));
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
			series.getData().add(new XYChart.Data<>(tab[i][numPartie].champion,tab[i][numPartie].totalOr));
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
			series.getData().add(new XYChart.Data<>(tab[i][numPartie].champion,tab[i][numPartie].soins));
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
			series.getData().add(new XYChart.Data<>(tab[i][numPartie].champion,tab[i][numPartie].tourelles));
			
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
			series.getData().add(new XYChart.Data<>(tab[i][numPartie].champion,tab[i][numPartie].eliminations));
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
			series.getData().add(new XYChart.Data<>(tab[i][numPartie].champion,tab[i][numPartie].morts));
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
			series.getData().add(new XYChart.Data<>(tab[i][numPartie].champion,tab[i][numPartie].assistances));
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
        XYChart.Series<Integer,Integer> series = new XYChart.Series<Integer,Integer>();
        series.setName("Avantage or");
        //populating the series with data
        for(int i = 0; i<7;i++) {
        	
        	series.getData().add(new XYChart.Data(Integer.toString(i),Integer.parseInt(lecteur.getAlAvantageGold().get(i))));
        	System.out.println(lecteur.getAlAvantageGold().get(i));
        }
        
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
    		
    		///
			ImgHistorique6.setImage(model1.getImgHistorique1());
			KillHistorique6.setText(model1.getKillHistorique1());
			DeathHistorique6.setText(model1.getDeathHistorique1());
			AssistHistorique6.setText(model1.getAssistHistorique1());
			ResultHistorique6.setText(model1.getResultHistorique1());
			Date_Jour6.setText(model1.getDate_Jour1());
			Date_Mois6.setText(model1.getDate_Mois1());
			Date_Annee6.setText(model1.getDate_Annee1());
		
			ImgHistorique7.setImage(model1.getImgHistorique2());
			KillHistorique7.setText(model1.getKillHistorique2());
			DeathHistorique7.setText(model1.getDeathHistorique2());
			AssistHistorique7.setText(model1.getAssistHistorique2());
			ResultHistorique7.setText(model1.getResultHistorique2());
			Date_Jour7.setText(model1.getDate_Jour2());
			Date_Mois7.setText(model1.getDate_Mois2());
			Date_Annee7.setText(model1.getDate_Annee2());
		
			ImgHistorique8.setImage(model1.getImgHistorique3());
			KillHistorique8.setText(model1.getKillHistorique3());
			DeathHistorique8.setText(model1.getDeathHistorique3());
			AssistHistorique8.setText(model1.getAssistHistorique3());
			ResultHistorique8.setText(model1.getResultHistorique3());
			Date_Jour8.setText(model1.getDate_Jour3());
			Date_Mois8.setText(model1.getDate_Mois3());
			Date_Annee8.setText(model1.getDate_Annee3());
		
			ImgHistorique9.setImage(model1.getImgHistorique4());
			KillHistorique9.setText(model1.getKillHistorique4());
			DeathHistorique9.setText(model1.getDeathHistorique4());
			AssistHistorique9.setText(model1.getAssistHistorique4());
			ResultHistorique9.setText(model1.getResultHistorique4());
			Date_Jour9.setText(model1.getDate_Jour4());
			Date_Mois9.setText(model1.getDate_Mois4());
			Date_Annee9.setText(model1.getDate_Annee4());
		
			ImgHistorique10.setImage(model1.getImgHistorique5());
			KillHistorique10.setText(model1.getKillHistorique5());
			DeathHistorique10.setText(model1.getDeathHistorique5());
			AssistHistorique10.setText(model1.getAssistHistorique5());
			ResultHistorique10.setText(model1.getResultHistorique5());
			Date_Jour10.setText(model1.getDate_Jour5());
			Date_Mois10.setText(model1.getDate_Mois5());
			Date_Annee10.setText(model1.getDate_Annee5());
			///
    		
    		chapardage2 = 0;
    	}
    }
	
	@FXML
	protected void TauxVictoire(MouseEvent e) {
		if (chapardage ==1) {
			
			TextNomInvocateur.setText(lecteur.getUtilisateur().getPseudo());
			TextNombreDor.setText(Integer.toString(lecteur.getUtilisateur().getMoyenneOr()));
			TextNombreDeliminations.setText(Integer.toString(lecteur.getUtilisateur().getMoyenneEliminations()));
			TextNombreDeMorts.setText(Integer.toString(lecteur.getUtilisateur().getMoyenneMorts()));
			TextNombreDassistance.setText(Integer.toString(lecteur.getUtilisateur().getMoyenneAssistances()));
			TextSbiresTues.setText(Integer.toString(lecteur.getUtilisateur().getMoyenneSbires()));
			TextDegatsInfliges.setText(Integer.toString(lecteur.getUtilisateur().getMoyenneDegats()));
			TextSoinsProdigues.setText(Integer.toString(lecteur.getUtilisateur().getMoyenneSoins()));
			TextTourellesDetruites.setText(Integer.toString(lecteur.getUtilisateur().getMoyenneTourelles()));
			TextClassement.setText(lecteur.getUtilisateur().getElo());
			
			//faire l'image du classement

			
			
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
		
		if (chapardage3 == 1) {
			ImgHistorique1.setImage(model1.getImgHistorique1());
			KillHistorique1.setText(model1.getKillHistorique1());
			DeathHistorique1.setText(model1.getDeathHistorique1());
			AssistHistorique1.setText(model1.getAssistHistorique1());
			ResultHistorique1.setText(model1.getResultHistorique1());
			Date_Jour1.setText(model1.getDate_Jour1());
			Date_Mois1.setText(model1.getDate_Mois1());
			Date_Annee1.setText(model1.getDate_Annee1());
		
			ImgHistorique2.setImage(model1.getImgHistorique2());
			KillHistorique2.setText(model1.getKillHistorique2());
			DeathHistorique2.setText(model1.getDeathHistorique2());
			AssistHistorique2.setText(model1.getAssistHistorique2());
			ResultHistorique2.setText(model1.getResultHistorique2());
			Date_Jour2.setText(model1.getDate_Jour2());
			Date_Mois2.setText(model1.getDate_Mois2());
			Date_Annee2.setText(model1.getDate_Annee2());
		
			ImgHistorique3.setImage(model1.getImgHistorique3());
			KillHistorique3.setText(model1.getKillHistorique3());
			DeathHistorique3.setText(model1.getDeathHistorique3());
			AssistHistorique3.setText(model1.getAssistHistorique3());
			ResultHistorique3.setText(model1.getResultHistorique3());
			Date_Jour3.setText(model1.getDate_Jour3());
			Date_Mois3.setText(model1.getDate_Mois3());
			Date_Annee3.setText(model1.getDate_Annee3());
		
			ImgHistorique4.setImage(model1.getImgHistorique4());
			KillHistorique4.setText(model1.getKillHistorique4());
			DeathHistorique4.setText(model1.getDeathHistorique4());
			AssistHistorique4.setText(model1.getAssistHistorique4());
			ResultHistorique4.setText(model1.getResultHistorique4());
			Date_Jour4.setText(model1.getDate_Jour4());
			Date_Mois4.setText(model1.getDate_Mois4());
			Date_Annee4.setText(model1.getDate_Annee4());
		
			ImgHistorique5.setImage(model1.getImgHistorique5());
			KillHistorique5.setText(model1.getKillHistorique5());
			DeathHistorique5.setText(model1.getDeathHistorique5());
			AssistHistorique5.setText(model1.getAssistHistorique5());
			ResultHistorique5.setText(model1.getResultHistorique5());
			Date_Jour5.setText(model1.getDate_Jour5());
			Date_Mois5.setText(model1.getDate_Mois5());
			Date_Annee5.setText(model1.getDate_Annee5());
			
			chapardage3 = 0;
		}
		else {}
	}
	
	////////////////////////Generation Historique//////////////////////////////
	
	@FXML
	protected void Historique1(MouseEvent e) {
		
/*
 * =============================================================
 *       Méthode pour ouvrir l'explorateur de fichier
 * =============================================================
 */
        File folder = new File("C://Users/fabie/git/League-of-Statistics/src/application/history/"+lecteur.getUtilisateur().pseudo+"/");
        List<String> loadedFile = new ArrayList<String>();
        loadedFile.add("*.txt");
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Document texte",loadedFile));
        File f = fc.showOpenDialog(stage);
        
        if (f != null) {
            //Desktop dt = Desktop.getDesktop();
            //dt.open(f);
            if(!folder.exists()) {
                folder.mkdir();
                
                try {
                    File dest = new File("C://Users/fabie/git/League-of-Statistics/src/application/history/"+lecteur.getUtilisateur().pseudo+"/"+f.getName());
                    System.out.println(folder.getAbsolutePath());
                    Files.copy(f.toPath(), dest.toPath());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
            System.out.println(f.getAbsolutePath());
            
        }

        
		String champion = "Img/champion/Camille.jpg";
		String result = "Victory";
		
		String _kill = "9";
		String _death = "5";
		String _assist = "2";
		
		String date_Jour = "21";
		String date_Mois = "8";
		String date_Annee = "19";
		
		Class<?> clazz = this.getClass();
        InputStream champ = clazz.getResourceAsStream(champion);
		Image img_champ = new Image(champ);
		
		if (ImgHistorique1.getImage() != null) {
			if (ImgHistorique2.getImage() != null) {
				if (ImgHistorique3.getImage() != null) {
					if (ImgHistorique4.getImage() != null) {
						if (ImgHistorique5.getImage() != null) {//comparer date
							
							if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee1.getText())) {
								if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee2.getText())) {
									if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee3.getText())) {
										if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee4.getText())) {
											if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee5.getText())) { // comparer mois
												
												if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois1.getText())) {
													if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois2.getText())) {
														if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois3.getText())) {
															if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois4.getText())) {
																if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois5.getText())) {
																	
																	if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour1.getText())) {
																		if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour2.getText())) {
																			if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour3.getText())) {
																				if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour4.getText())) {
																					if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour5.getText())) { // Default
																						ImgHistorique1.setImage(img_champ);
																						model1.setImgHistorique1(img_champ);
																						KillHistorique1.setText(_kill);
																						model1.setKillHistorique1(_kill);
																						DeathHistorique1.setText(_death);
																						model1.setDeathHistorique1(_death);
																						AssistHistorique1.setText(_assist);
																						model1.setAssistHistorique1(_assist);
																						ResultHistorique1.setText(result);
																						model1.setResultHistorique1(result);
																						Date_Jour1.setText(date_Jour);
																						model1.setDate_Jour1(date_Jour);
																						Date_Mois1.setText(date_Mois);
																						model1.setDate_Mois1(date_Mois);
																						Date_Annee1.setText(date_Annee);
																						model1.setDate_Annee1(date_Annee);
																					}
																					else {
																						ImgHistorique5.setImage(img_champ);
																						model1.setImgHistorique5(img_champ);
																						KillHistorique5.setText(_kill);
																						model1.setKillHistorique5(_kill);
																						DeathHistorique5.setText(_death);
																						model1.setDeathHistorique5(_death);
																						AssistHistorique5.setText(_assist);
																						model1.setAssistHistorique5(_assist);
																						ResultHistorique5.setText(result);
																						model1.setResultHistorique5(result);
																						Date_Jour5.setText(date_Jour);
																						model1.setDate_Jour5(date_Jour);
																						Date_Mois5.setText(date_Mois);
																						model1.setDate_Mois5(date_Mois);
																						Date_Annee5.setText(date_Annee);
																						model1.setDate_Annee5(date_Annee);
																					}
																				}
																				else {
																					ImgHistorique4.setImage(img_champ);
																					model1.setImgHistorique4(img_champ);
																					KillHistorique4.setText(_kill);
																					model1.setKillHistorique4(_kill);
																					DeathHistorique4.setText(_death);
																					model1.setDeathHistorique4(_death);
																					AssistHistorique4.setText(_assist);
																					model1.setAssistHistorique4(_assist);
																					ResultHistorique4.setText(result);
																					model1.setResultHistorique4(result);
																					Date_Jour4.setText(date_Jour);
																					model1.setDate_Jour4(date_Jour);
																					Date_Mois4.setText(date_Mois);
																					model1.setDate_Mois4(date_Mois);
																					Date_Annee4.setText(date_Annee);
																					model1.setDate_Annee4(date_Annee);
																				}
																			}
																			else {
																				ImgHistorique3.setImage(img_champ);
																				model1.setImgHistorique3(img_champ);
																				KillHistorique3.setText(_kill);
																				model1.setKillHistorique3(_kill);
																				DeathHistorique3.setText(_death);
																				model1.setDeathHistorique3(_death);
																				AssistHistorique3.setText(_assist);
																				model1.setAssistHistorique3(_assist);
																				ResultHistorique3.setText(result);
																				model1.setResultHistorique3(result);
																				Date_Jour3.setText(date_Jour);
																				model1.setDate_Jour3(date_Jour);
																				Date_Mois3.setText(date_Mois);
																				model1.setDate_Mois3(date_Mois);
																				Date_Annee3.setText(date_Annee);
																				model1.setDate_Annee3(date_Annee);
																			}
																		}
																		else {
																			ImgHistorique2.setImage(img_champ);
																			model1.setImgHistorique2(img_champ);
																			KillHistorique2.setText(_kill);
																			model1.setKillHistorique2(_kill);
																			DeathHistorique2.setText(_death);
																			model1.setDeathHistorique2(_death);
																			AssistHistorique2.setText(_assist);
																			model1.setAssistHistorique2(_assist);
																			ResultHistorique2.setText(result);
																			model1.setResultHistorique2(result);
																			Date_Jour2.setText(date_Jour);
																			model1.setDate_Jour2(date_Jour);
																			Date_Mois2.setText(date_Mois);
																			model1.setDate_Mois2(date_Mois);
																			Date_Annee2.setText(date_Annee);
																			model1.setDate_Annee2(date_Annee);
																		}
																	}
																	else {
																		ImgHistorique1.setImage(img_champ);
																		model1.setImgHistorique1(img_champ);
																		KillHistorique1.setText(_kill);
																		model1.setKillHistorique1(_kill);
																		DeathHistorique1.setText(_death);
																		model1.setDeathHistorique1(_death);
																		AssistHistorique1.setText(_assist);
																		model1.setAssistHistorique1(_assist);
																		ResultHistorique1.setText(result);
																		model1.setResultHistorique1(result);
																		Date_Jour1.setText(date_Jour);
																		model1.setDate_Jour1(date_Jour);
																		Date_Mois1.setText(date_Mois);
																		model1.setDate_Mois1(date_Mois);
																		Date_Annee1.setText(date_Annee);
																		model1.setDate_Annee1(date_Annee);
																	}
																	
																}
																else {
																	ImgHistorique5.setImage(img_champ);
																	model1.setImgHistorique5(img_champ);
																	KillHistorique5.setText(_kill);
																	model1.setKillHistorique5(_kill);
																	DeathHistorique5.setText(_death);
																	model1.setDeathHistorique5(_death);
																	AssistHistorique5.setText(_assist);
																	model1.setAssistHistorique5(_assist);
																	ResultHistorique5.setText(result);
																	model1.setResultHistorique5(result);
																	Date_Jour5.setText(date_Jour);
																	model1.setDate_Jour5(date_Jour);
																	Date_Mois5.setText(date_Mois);
																	model1.setDate_Mois5(date_Mois);
																	Date_Annee5.setText(date_Annee);
																	model1.setDate_Annee5(date_Annee);
																}
															}
															else {
																ImgHistorique4.setImage(img_champ);
																model1.setImgHistorique4(img_champ);
																KillHistorique4.setText(_kill);
																model1.setKillHistorique4(_kill);
																DeathHistorique4.setText(_death);
																model1.setDeathHistorique4(_death);
																AssistHistorique4.setText(_assist);
																model1.setAssistHistorique4(_assist);
																ResultHistorique4.setText(result);
																model1.setResultHistorique4(result);
																Date_Jour4.setText(date_Jour);
																model1.setDate_Jour4(date_Jour);
																Date_Mois4.setText(date_Mois);
																model1.setDate_Mois4(date_Mois);
																Date_Annee4.setText(date_Annee);
																model1.setDate_Annee4(date_Annee);
															}
														}
														else {
															ImgHistorique3.setImage(img_champ);
															model1.setImgHistorique3(img_champ);
															KillHistorique3.setText(_kill);
															model1.setKillHistorique3(_kill);
															DeathHistorique3.setText(_death);
															model1.setDeathHistorique3(_death);
															AssistHistorique3.setText(_assist);
															model1.setAssistHistorique3(_assist);
															ResultHistorique3.setText(result);
															model1.setResultHistorique3(result);
															Date_Jour3.setText(date_Jour);
															model1.setDate_Jour3(date_Jour);
															Date_Mois3.setText(date_Mois);
															model1.setDate_Mois3(date_Mois);
															Date_Annee3.setText(date_Annee);
															model1.setDate_Annee3(date_Annee);
														}
													}
													else {
														ImgHistorique2.setImage(img_champ);
														model1.setImgHistorique2(img_champ);
														KillHistorique2.setText(_kill);
														model1.setKillHistorique2(_kill);
														DeathHistorique2.setText(_death);
														model1.setDeathHistorique2(_death);
														AssistHistorique2.setText(_assist);
														model1.setAssistHistorique2(_assist);
														ResultHistorique2.setText(result);
														model1.setResultHistorique2(result);
														Date_Jour2.setText(date_Jour);
														model1.setDate_Jour2(date_Jour);
														Date_Mois2.setText(date_Mois);
														model1.setDate_Mois2(date_Mois);
														Date_Annee2.setText(date_Annee);
														model1.setDate_Annee2(date_Annee);
													}
												}
												else {
													ImgHistorique1.setImage(img_champ);
													model1.setImgHistorique1(img_champ);
													KillHistorique1.setText(_kill);
													model1.setKillHistorique1(_kill);
													DeathHistorique1.setText(_death);
													model1.setDeathHistorique1(_death);
													AssistHistorique1.setText(_assist);
													model1.setAssistHistorique1(_assist);
													ResultHistorique1.setText(result);
													model1.setResultHistorique1(result);
													Date_Jour1.setText(date_Jour);
													model1.setDate_Jour1(date_Jour);
													Date_Mois1.setText(date_Mois);
													model1.setDate_Mois1(date_Mois);
													Date_Annee1.setText(date_Annee);
													model1.setDate_Annee1(date_Annee);
												}
												
											}
											else {
												ImgHistorique5.setImage(img_champ);
												model1.setImgHistorique5(img_champ);
												KillHistorique5.setText(_kill);
												model1.setKillHistorique5(_kill);
												DeathHistorique5.setText(_death);
												model1.setDeathHistorique5(_death);
												AssistHistorique5.setText(_assist);
												model1.setAssistHistorique5(_assist);
												ResultHistorique5.setText(result);
												model1.setResultHistorique5(result);
												Date_Jour5.setText(date_Jour);
												model1.setDate_Jour5(date_Jour);
												Date_Mois5.setText(date_Mois);
												model1.setDate_Mois5(date_Mois);
												Date_Annee5.setText(date_Annee);
												model1.setDate_Annee5(date_Annee);
											}
										}
										else {
											ImgHistorique4.setImage(img_champ);
											model1.setImgHistorique4(img_champ);
											KillHistorique4.setText(_kill);
											model1.setKillHistorique4(_kill);
											DeathHistorique4.setText(_death);
											model1.setDeathHistorique4(_death);
											AssistHistorique4.setText(_assist);
											model1.setAssistHistorique4(_assist);
											ResultHistorique4.setText(result);
											model1.setResultHistorique4(result);
											Date_Jour4.setText(date_Jour);
											model1.setDate_Jour4(date_Jour);
											Date_Mois4.setText(date_Mois);
											model1.setDate_Mois4(date_Mois);
											Date_Annee4.setText(date_Annee);
											model1.setDate_Annee4(date_Annee);
										}
									}
									else {
										ImgHistorique3.setImage(img_champ);
										model1.setImgHistorique3(img_champ);
										KillHistorique3.setText(_kill);
										model1.setKillHistorique3(_kill);
										DeathHistorique3.setText(_death);
										model1.setDeathHistorique3(_death);
										AssistHistorique3.setText(_assist);
										model1.setAssistHistorique3(_assist);
										ResultHistorique3.setText(result);
										model1.setResultHistorique3(result);
										Date_Jour3.setText(date_Jour);
										model1.setDate_Jour3(date_Jour);
										Date_Mois3.setText(date_Mois);
										model1.setDate_Mois3(date_Mois);
										Date_Annee3.setText(date_Annee);
										model1.setDate_Annee3(date_Annee);
									}
								}
								else {
									ImgHistorique2.setImage(img_champ);
									model1.setImgHistorique2(img_champ);
									KillHistorique2.setText(_kill);
									model1.setKillHistorique2(_kill);
									DeathHistorique2.setText(_death);
									model1.setDeathHistorique2(_death);
									AssistHistorique2.setText(_assist);
									model1.setAssistHistorique2(_assist);
									ResultHistorique2.setText(result);
									model1.setResultHistorique2(result);
									Date_Jour2.setText(date_Jour);
									model1.setDate_Jour2(date_Jour);
									Date_Mois2.setText(date_Mois);
									model1.setDate_Mois2(date_Mois);
									Date_Annee2.setText(date_Annee);
									model1.setDate_Annee2(date_Annee);
								}
							}
							else {
								ImgHistorique1.setImage(img_champ);
								model1.setImgHistorique1(img_champ);
								KillHistorique1.setText(_kill);
								model1.setKillHistorique1(_kill);
								DeathHistorique1.setText(_death);
								model1.setDeathHistorique1(_death);
								AssistHistorique1.setText(_assist);
								model1.setAssistHistorique1(_assist);
								ResultHistorique1.setText(result);
								model1.setResultHistorique1(result);
								Date_Jour1.setText(date_Jour);
								model1.setDate_Jour1(date_Jour);
								Date_Mois1.setText(date_Mois);
								model1.setDate_Mois1(date_Mois);
								Date_Annee1.setText(date_Annee);
								model1.setDate_Annee1(date_Annee);
							}
							
						}
						else {
							ImgHistorique5.setImage(img_champ);
							model1.setImgHistorique5(img_champ);
							KillHistorique5.setText(_kill);
							model1.setKillHistorique5(_kill);
							DeathHistorique5.setText(_death);
							model1.setDeathHistorique5(_death);
							AssistHistorique5.setText(_assist);
							model1.setAssistHistorique5(_assist);
							ResultHistorique5.setText(result);
							model1.setResultHistorique5(result);
							Date_Jour5.setText(date_Jour);
							model1.setDate_Jour5(date_Jour);
							Date_Mois5.setText(date_Mois);
							model1.setDate_Mois5(date_Mois);
							Date_Annee5.setText(date_Annee);
							model1.setDate_Annee5(date_Annee);
						}
					}
					else {
						ImgHistorique4.setImage(img_champ);
						model1.setImgHistorique4(img_champ);
						KillHistorique4.setText(_kill);
						model1.setKillHistorique4(_kill);
						DeathHistorique4.setText(_death);
						model1.setDeathHistorique4(_death);
						AssistHistorique4.setText(_assist);
						model1.setAssistHistorique4(_assist);
						ResultHistorique4.setText(result);
						model1.setResultHistorique4(result);
						Date_Jour4.setText(date_Jour);
						model1.setDate_Jour4(date_Jour);
						Date_Mois4.setText(date_Mois);
						model1.setDate_Mois4(date_Mois);
						Date_Annee4.setText(date_Annee);
						model1.setDate_Annee4(date_Annee);
					}
				}
				else {
					ImgHistorique3.setImage(img_champ);
					model1.setImgHistorique3(img_champ);
					KillHistorique3.setText(_kill);
					model1.setKillHistorique3(_kill);
					DeathHistorique3.setText(_death);
					model1.setDeathHistorique3(_death);
					AssistHistorique3.setText(_assist);
					model1.setAssistHistorique3(_assist);
					ResultHistorique3.setText(result);
					model1.setResultHistorique3(result);
					Date_Jour3.setText(date_Jour);
					model1.setDate_Jour3(date_Jour);
					Date_Mois3.setText(date_Mois);
					model1.setDate_Mois3(date_Mois);
					Date_Annee3.setText(date_Annee);
					model1.setDate_Annee3(date_Annee);
				}
			}
			
			else {
				ImgHistorique2.setImage(img_champ);
				model1.setImgHistorique2(img_champ);
				KillHistorique2.setText(_kill);
				model1.setKillHistorique2(_kill);
				DeathHistorique2.setText(_death);
				model1.setDeathHistorique2(_death);
				AssistHistorique2.setText(_assist);
				model1.setAssistHistorique2(_assist);
				ResultHistorique2.setText(result);
				model1.setResultHistorique2(result);
				Date_Jour2.setText(date_Jour);
				model1.setDate_Jour2(date_Jour);
				Date_Mois2.setText(date_Mois);
				model1.setDate_Mois2(date_Mois);
				Date_Annee2.setText(date_Annee);
				model1.setDate_Annee2(date_Annee);
			}
		}
		else { // Remplir la premiï¿½re case
			ImgHistorique1.setImage(img_champ);
			model1.setImgHistorique1(img_champ);
			KillHistorique1.setText(_kill);
			model1.setKillHistorique1(_kill);
			DeathHistorique1.setText(_death);
			model1.setDeathHistorique1(_death);
			AssistHistorique1.setText(_assist);
			model1.setAssistHistorique1(_assist);
			ResultHistorique1.setText(result);
			model1.setResultHistorique1(result);
			Date_Jour1.setText(date_Jour);
			model1.setDate_Jour1(date_Jour);
			Date_Mois1.setText(date_Mois);
			model1.setDate_Mois1(date_Mois);
			Date_Annee1.setText(date_Annee);
			model1.setDate_Annee1(date_Annee);
		}
	}
	
	@FXML
	private ImageView ImgHistorique6;
	@FXML
	private Label KillHistorique6;
	@FXML
	private Label DeathHistorique6;
	@FXML
	private Label AssistHistorique6;
	@FXML
	private Label ResultHistorique6;
	@FXML
	private Label Date_Jour6;
	@FXML
	private Label Date_Mois6;
	@FXML
	private Label Date_Annee6;
	
	@FXML
	private ImageView ImgHistorique7;
	@FXML
	private Label KillHistorique7;
	@FXML
	private Label DeathHistorique7;
	@FXML
	private Label AssistHistorique7;
	@FXML
	private Label ResultHistorique7;
	@FXML
	private Label Date_Jour7;
	@FXML
	private Label Date_Mois7;
	@FXML
	private Label Date_Annee7;
	
	
	@FXML
	private ImageView ImgHistorique8;
	@FXML
	private Label KillHistorique8;
	@FXML
	private Label DeathHistorique8;
	@FXML
	private Label AssistHistorique8;
	@FXML
	private Label ResultHistorique8;
	@FXML
	private Label Date_Jour8;
	@FXML
	private Label Date_Mois8;
	@FXML
	private Label Date_Annee8;
	
	
	@FXML
	private ImageView ImgHistorique9;
	@FXML
	private Label KillHistorique9;
	@FXML
	private Label DeathHistorique9;
	@FXML
	private Label AssistHistorique9;
	@FXML
	private Label ResultHistorique9;
	@FXML
	private Label Date_Jour9;
	@FXML
	private Label Date_Mois9;
	@FXML
	private Label Date_Annee9;
	
	
	@FXML
	private ImageView ImgHistorique10;
	@FXML
	private Label KillHistorique10;
	@FXML
	private Label DeathHistorique10;
	@FXML
	private Label AssistHistorique10;
	@FXML
	private Label ResultHistorique10;
	@FXML
	private Label Date_Jour10;
	@FXML
	private Label Date_Mois10;
	@FXML
	private Label Date_Annee10;
	
	@FXML
	protected void Historique2(MouseEvent e) {
		
		
        
		String champion = "Img/champion/Camille.jpg";
		String result = "Victory";
		
		String _kill = "9";
		String _death = "5";
		String _assist = "2";
		
		String date_Jour = "21";
		String date_Mois = "8";
		String date_Annee = "19";
		
		Class<?> clazz = this.getClass();
        InputStream champ = clazz.getResourceAsStream(champion);
		Image img_champ = new Image(champ);
		
		if (ImgHistorique6.getImage() != null) {
			if (ImgHistorique7.getImage() != null) {
				if (ImgHistorique8.getImage() != null) {
					if (ImgHistorique9.getImage() != null) {
						if (ImgHistorique10.getImage() != null) {//comparer date
							
							if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee6.getText())) {
								if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee7.getText())) {
									if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee8.getText())) {
										if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee9.getText())) {
											if (Integer.parseInt(date_Annee) < Integer.parseInt(Date_Annee10.getText())) { // comparer mois
												
												if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois6.getText())) {
													if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois7.getText())) {
														if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois8.getText())) {
															if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois9.getText())) {
																if (Integer.parseInt(date_Mois) < Integer.parseInt(Date_Mois10.getText())) {
																	
																	if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour6.getText())) {
																		if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour7.getText())) {
																			if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour8.getText())) {
																				if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour9.getText())) {
																					if (Integer.parseInt(date_Jour) < Integer.parseInt(Date_Jour10.getText())) { // Default
																						ImgHistorique6.setImage(img_champ);
																						model1.setImgHistorique1(img_champ);
																						KillHistorique6.setText(_kill);
																						model1.setKillHistorique1(_kill);
																						DeathHistorique6.setText(_death);
																						model1.setDeathHistorique1(_death);
																						AssistHistorique6.setText(_assist);
																						model1.setAssistHistorique1(_assist);
																						ResultHistorique6.setText(result);
																						model1.setResultHistorique1(result);
																						Date_Jour6.setText(date_Jour);
																						model1.setDate_Jour1(date_Jour);
																						Date_Mois6.setText(date_Mois);
																						model1.setDate_Mois1(date_Mois);
																						Date_Annee6.setText(date_Annee);
																						model1.setDate_Annee1(date_Annee);
																					}
																					else {
																						ImgHistorique10.setImage(img_champ);
																						model1.setImgHistorique5(img_champ);
																						KillHistorique10.setText(_kill);
																						model1.setKillHistorique5(_kill);
																						DeathHistorique10.setText(_death);
																						model1.setDeathHistorique5(_death);
																						AssistHistorique10.setText(_assist);
																						model1.setAssistHistorique5(_assist);
																						ResultHistorique10.setText(result);
																						model1.setResultHistorique5(result);
																						Date_Jour10.setText(date_Jour);
																						model1.setDate_Jour5(date_Jour);
																						Date_Mois10.setText(date_Mois);
																						model1.setDate_Mois5(date_Mois);
																						Date_Annee10.setText(date_Annee);
																						model1.setDate_Annee5(date_Annee);
																					}
																				}
																				else {
																					ImgHistorique9.setImage(img_champ);
																					model1.setImgHistorique4(img_champ);
																					KillHistorique9.setText(_kill);
																					model1.setKillHistorique4(_kill);
																					DeathHistorique9.setText(_death);
																					model1.setDeathHistorique4(_death);
																					AssistHistorique9.setText(_assist);
																					model1.setAssistHistorique4(_assist);
																					ResultHistorique9.setText(result);
																					model1.setResultHistorique4(result);
																					Date_Jour9.setText(date_Jour);
																					model1.setDate_Jour4(date_Jour);
																					Date_Mois9.setText(date_Mois);
																					model1.setDate_Mois4(date_Mois);
																					Date_Annee9.setText(date_Annee);
																					model1.setDate_Annee4(date_Annee);
																				}
																			}
																			else {
																				ImgHistorique8.setImage(img_champ);
																				model1.setImgHistorique3(img_champ);
																				KillHistorique8.setText(_kill);
																				model1.setKillHistorique3(_kill);
																				DeathHistorique8.setText(_death);
																				model1.setDeathHistorique3(_death);
																				AssistHistorique8.setText(_assist);
																				model1.setAssistHistorique3(_assist);
																				ResultHistorique8.setText(result);
																				model1.setResultHistorique3(result);
																				Date_Jour8.setText(date_Jour);
																				model1.setDate_Jour3(date_Jour);
																				Date_Mois8.setText(date_Mois);
																				model1.setDate_Mois3(date_Mois);
																				Date_Annee8.setText(date_Annee);
																				model1.setDate_Annee3(date_Annee);
																			}
																		}
																		else {
																			ImgHistorique7.setImage(img_champ);
																			model1.setImgHistorique2(img_champ);
																			KillHistorique7.setText(_kill);
																			model1.setKillHistorique2(_kill);
																			DeathHistorique7.setText(_death);
																			model1.setDeathHistorique2(_death);
																			AssistHistorique7.setText(_assist);
																			model1.setAssistHistorique2(_assist);
																			ResultHistorique7.setText(result);
																			model1.setResultHistorique2(result);
																			Date_Jour7.setText(date_Jour);
																			model1.setDate_Jour2(date_Jour);
																			Date_Mois7.setText(date_Mois);
																			model1.setDate_Mois2(date_Mois);
																			Date_Annee7.setText(date_Annee);
																			model1.setDate_Annee2(date_Annee);
																		}
																	}
																	else {
																		ImgHistorique6.setImage(img_champ);
																		model1.setImgHistorique1(img_champ);
																		KillHistorique6.setText(_kill);
																		model1.setKillHistorique1(_kill);
																		DeathHistorique6.setText(_death);
																		model1.setDeathHistorique1(_death);
																		AssistHistorique6.setText(_assist);
																		model1.setAssistHistorique1(_assist);
																		ResultHistorique6.setText(result);
																		model1.setResultHistorique1(result);
																		Date_Jour6.setText(date_Jour);
																		model1.setDate_Jour1(date_Jour);
																		Date_Mois6.setText(date_Mois);
																		model1.setDate_Mois1(date_Mois);
																		Date_Annee6.setText(date_Annee);
																		model1.setDate_Annee1(date_Annee);
																	}
																	
																}
																else {
																	ImgHistorique10.setImage(img_champ);
																	model1.setImgHistorique5(img_champ);
																	KillHistorique10.setText(_kill);
																	model1.setKillHistorique5(_kill);
																	DeathHistorique10.setText(_death);
																	model1.setDeathHistorique5(_death);
																	AssistHistorique10.setText(_assist);
																	model1.setAssistHistorique5(_assist);
																	ResultHistorique10.setText(result);
																	model1.setResultHistorique5(result);
																	Date_Jour10.setText(date_Jour);
																	model1.setDate_Jour5(date_Jour);
																	Date_Mois10.setText(date_Mois);
																	model1.setDate_Mois5(date_Mois);
																	Date_Annee10.setText(date_Annee);
																	model1.setDate_Annee5(date_Annee);
																}
															}
															else {
																ImgHistorique9.setImage(img_champ);
																model1.setImgHistorique4(img_champ);
																KillHistorique9.setText(_kill);
																model1.setKillHistorique4(_kill);
																DeathHistorique9.setText(_death);
																model1.setDeathHistorique4(_death);
																AssistHistorique9.setText(_assist);
																model1.setAssistHistorique4(_assist);
																ResultHistorique9.setText(result);
																model1.setResultHistorique4(result);
																Date_Jour9.setText(date_Jour);
																model1.setDate_Jour4(date_Jour);
																Date_Mois9.setText(date_Mois);
																model1.setDate_Mois4(date_Mois);
																Date_Annee9.setText(date_Annee);
																model1.setDate_Annee4(date_Annee);
															}
														}
														else {
															ImgHistorique8.setImage(img_champ);
															model1.setImgHistorique3(img_champ);
															KillHistorique8.setText(_kill);
															model1.setKillHistorique3(_kill);
															DeathHistorique8.setText(_death);
															model1.setDeathHistorique3(_death);
															AssistHistorique8.setText(_assist);
															model1.setAssistHistorique3(_assist);
															ResultHistorique8.setText(result);
															model1.setResultHistorique3(result);
															Date_Jour8.setText(date_Jour);
															model1.setDate_Jour3(date_Jour);
															Date_Mois8.setText(date_Mois);
															model1.setDate_Mois3(date_Mois);
															Date_Annee8.setText(date_Annee);
															model1.setDate_Annee3(date_Annee);
														}
													}
													else {
														ImgHistorique7.setImage(img_champ);
														model1.setImgHistorique2(img_champ);
														KillHistorique7.setText(_kill);
														model1.setKillHistorique2(_kill);
														DeathHistorique7.setText(_death);
														model1.setDeathHistorique2(_death);
														AssistHistorique7.setText(_assist);
														model1.setAssistHistorique2(_assist);
														ResultHistorique7.setText(result);
														model1.setResultHistorique2(result);
														Date_Jour7.setText(date_Jour);
														model1.setDate_Jour2(date_Jour);
														Date_Mois7.setText(date_Mois);
														model1.setDate_Mois2(date_Mois);
														Date_Annee7.setText(date_Annee);
														model1.setDate_Annee2(date_Annee);
													}
												}
												else {
													ImgHistorique6.setImage(img_champ);
													model1.setImgHistorique1(img_champ);
													KillHistorique6.setText(_kill);
													model1.setKillHistorique1(_kill);
													DeathHistorique6.setText(_death);
													model1.setDeathHistorique1(_death);
													AssistHistorique6.setText(_assist);
													model1.setAssistHistorique1(_assist);
													ResultHistorique6.setText(result);
													model1.setResultHistorique1(result);
													Date_Jour6.setText(date_Jour);
													model1.setDate_Jour1(date_Jour);
													Date_Mois6.setText(date_Mois);
													model1.setDate_Mois1(date_Mois);
													Date_Annee6.setText(date_Annee);
													model1.setDate_Annee1(date_Annee);
												}
												
											}
											else {
												ImgHistorique10.setImage(img_champ);
												model1.setImgHistorique5(img_champ);
												KillHistorique10.setText(_kill);
												model1.setKillHistorique5(_kill);
												DeathHistorique10.setText(_death);
												model1.setDeathHistorique5(_death);
												AssistHistorique10.setText(_assist);
												model1.setAssistHistorique5(_assist);
												ResultHistorique10.setText(result);
												model1.setResultHistorique5(result);
												Date_Jour10.setText(date_Jour);
												model1.setDate_Jour5(date_Jour);
												Date_Mois10.setText(date_Mois);
												model1.setDate_Mois5(date_Mois);
												Date_Annee10.setText(date_Annee);
												model1.setDate_Annee5(date_Annee);
											}
										}
										else {
											ImgHistorique9.setImage(img_champ);
											model1.setImgHistorique4(img_champ);
											KillHistorique9.setText(_kill);
											model1.setKillHistorique4(_kill);
											DeathHistorique9.setText(_death);
											model1.setDeathHistorique4(_death);
											AssistHistorique9.setText(_assist);
											model1.setAssistHistorique4(_assist);
											ResultHistorique9.setText(result);
											model1.setResultHistorique4(result);
											Date_Jour9.setText(date_Jour);
											model1.setDate_Jour4(date_Jour);
											Date_Mois9.setText(date_Mois);
											model1.setDate_Mois4(date_Mois);
											Date_Annee9.setText(date_Annee);
											model1.setDate_Annee4(date_Annee);
										}
									}
									else {
										ImgHistorique8.setImage(img_champ);
										model1.setImgHistorique3(img_champ);
										KillHistorique8.setText(_kill);
										model1.setKillHistorique3(_kill);
										DeathHistorique8.setText(_death);
										model1.setDeathHistorique3(_death);
										AssistHistorique8.setText(_assist);
										model1.setAssistHistorique3(_assist);
										ResultHistorique8.setText(result);
										model1.setResultHistorique3(result);
										Date_Jour8.setText(date_Jour);
										model1.setDate_Jour3(date_Jour);
										Date_Mois8.setText(date_Mois);
										model1.setDate_Mois3(date_Mois);
										Date_Annee8.setText(date_Annee);
										model1.setDate_Annee3(date_Annee);
									}
								}
								else {
									ImgHistorique7.setImage(img_champ);
									model1.setImgHistorique2(img_champ);
									KillHistorique7.setText(_kill);
									model1.setKillHistorique2(_kill);
									DeathHistorique7.setText(_death);
									model1.setDeathHistorique2(_death);
									AssistHistorique7.setText(_assist);
									model1.setAssistHistorique2(_assist);
									ResultHistorique7.setText(result);
									model1.setResultHistorique2(result);
									Date_Jour7.setText(date_Jour);
									model1.setDate_Jour2(date_Jour);
									Date_Mois7.setText(date_Mois);
									model1.setDate_Mois2(date_Mois);
									Date_Annee7.setText(date_Annee);
									model1.setDate_Annee2(date_Annee);
								}
							}
							else {
								ImgHistorique6.setImage(img_champ);
								model1.setImgHistorique1(img_champ);
								KillHistorique6.setText(_kill);
								model1.setKillHistorique1(_kill);
								DeathHistorique6.setText(_death);
								model1.setDeathHistorique1(_death);
								AssistHistorique6.setText(_assist);
								model1.setAssistHistorique1(_assist);
								ResultHistorique6.setText(result);
								model1.setResultHistorique1(result);
								Date_Jour6.setText(date_Jour);
								model1.setDate_Jour1(date_Jour);
								Date_Mois6.setText(date_Mois);
								model1.setDate_Mois1(date_Mois);
								Date_Annee6.setText(date_Annee);
								model1.setDate_Annee1(date_Annee);
							}
							
						}
						else {
							ImgHistorique10.setImage(img_champ);
							model1.setImgHistorique5(img_champ);
							KillHistorique10.setText(_kill);
							model1.setKillHistorique5(_kill);
							DeathHistorique10.setText(_death);
							model1.setDeathHistorique5(_death);
							AssistHistorique10.setText(_assist);
							model1.setAssistHistorique5(_assist);
							ResultHistorique10.setText(result);
							model1.setResultHistorique5(result);
							Date_Jour10.setText(date_Jour);
							model1.setDate_Jour5(date_Jour);
							Date_Mois10.setText(date_Mois);
							model1.setDate_Mois5(date_Mois);
							Date_Annee10.setText(date_Annee);
							model1.setDate_Annee5(date_Annee);
						}
					}
					else {
						ImgHistorique9.setImage(img_champ);
						model1.setImgHistorique4(img_champ);
						KillHistorique9.setText(_kill);
						model1.setKillHistorique4(_kill);
						DeathHistorique9.setText(_death);
						model1.setDeathHistorique4(_death);
						AssistHistorique9.setText(_assist);
						model1.setAssistHistorique4(_assist);
						ResultHistorique9.setText(result);
						model1.setResultHistorique4(result);
						Date_Jour9.setText(date_Jour);
						model1.setDate_Jour4(date_Jour);
						Date_Mois9.setText(date_Mois);
						model1.setDate_Mois4(date_Mois);
						Date_Annee9.setText(date_Annee);
						model1.setDate_Annee4(date_Annee);
					}
				}
				else {
					ImgHistorique8.setImage(img_champ);
					model1.setImgHistorique3(img_champ);
					KillHistorique8.setText(_kill);
					model1.setKillHistorique3(_kill);
					DeathHistorique8.setText(_death);
					model1.setDeathHistorique3(_death);
					AssistHistorique8.setText(_assist);
					model1.setAssistHistorique3(_assist);
					ResultHistorique8.setText(result);
					model1.setResultHistorique3(result);
					Date_Jour8.setText(date_Jour);
					model1.setDate_Jour3(date_Jour);
					Date_Mois8.setText(date_Mois);
					model1.setDate_Mois3(date_Mois);
					Date_Annee8.setText(date_Annee);
					model1.setDate_Annee3(date_Annee);
				}
			}
			
			else {
				ImgHistorique7.setImage(img_champ);
				model1.setImgHistorique2(img_champ);
				KillHistorique7.setText(_kill);
				model1.setKillHistorique2(_kill);
				DeathHistorique7.setText(_death);
				model1.setDeathHistorique2(_death);
				AssistHistorique7.setText(_assist);
				model1.setAssistHistorique2(_assist);
				ResultHistorique7.setText(result);
				model1.setResultHistorique2(result);
				Date_Jour7.setText(date_Jour);
				model1.setDate_Jour2(date_Jour);
				Date_Mois7.setText(date_Mois);
				model1.setDate_Mois2(date_Mois);
				Date_Annee7.setText(date_Annee);
				model1.setDate_Annee2(date_Annee);
			}
		}
		else { // Remplir la premiï¿½re case
			ImgHistorique6.setImage(img_champ);
			model1.setImgHistorique1(img_champ);
			KillHistorique6.setText(_kill);
			model1.setKillHistorique1(_kill);
			DeathHistorique6.setText(_death);
			model1.setDeathHistorique1(_death);
			AssistHistorique6.setText(_assist);
			model1.setAssistHistorique1(_assist);
			ResultHistorique6.setText(result);
			model1.setResultHistorique1(result);
			Date_Jour6.setText(date_Jour);
			model1.setDate_Jour1(date_Jour);
			Date_Mois6.setText(date_Mois);
			model1.setDate_Mois1(date_Mois);
			Date_Annee6.setText(date_Annee);
			model1.setDate_Annee1(date_Annee);
		}
	}
	

	
	
	
	
}
