package application;

import javafx.scene.control.TextArea;
import javafx.scene.image.Image;

public class Model {

	private TextArea Nom;
	
	public void setNom(TextArea _nom) {
		this.Nom = _nom;
	}
	
	public String getNom() {
		return this.Nom.getText();
	}
	
	private Image _ImgHistorique1 = null;
	private String _KillHistorique1 = null;
	private String _DeathHistorique1 = null;
	private String _AssistHistorique1 = null;
	private String _ResultHistorique1= null;
	private String _Date_Jour1 = null;
	private String _Date_Mois1 = null;
	private String _Date_Annee1 = null;
	private String Nom_partie1 = null;
	
	private Image _ImgHistorique2= null;
	private String _KillHistorique2= null;
	private String _DeathHistorique2= null;
	private String _AssistHistorique2= null;
	private String _ResultHistorique2= null;
	private String _Date_Jour2= null;
	private String _Date_Mois2= null;
	private String _Date_Annee2= null;
	private String Nom_partie2 = null;
	
	
	private Image _ImgHistorique3= null;
	private String _KillHistorique3= null;
	private String _DeathHistorique3= null;
	private String _AssistHistorique3= null;
	private String _ResultHistorique3= null;
	private String _Date_Jour3= null;
	private String _Date_Mois3;
	private String _Date_Annee3;
	private String Nom_partie3 = null;
	
	
	private Image _ImgHistorique4= null;
	private String _KillHistorique4= null;
	private String _DeathHistorique4= null;
	private String _AssistHistorique4= null;
	private String _ResultHistorique4= null;
	private String _Date_Jour4= null;
	private String _Date_Mois4= null;
	private String _Date_Annee4= null;
	private String Nom_partie4 = null;
	
	
	private Image _ImgHistorique5= null;
	private String _KillHistorique5= null;
	private String _DeathHistorique5= null;
	private String _AssistHistorique5= null;
	private String _ResultHistorique5= null;
	private String _Date_Jour5= null;
	private String _Date_Mois5= null;
	private String _Date_Annee5= null;
	private String Nom_partie5 = null;
	
	public void setImgHistorique1(Image im) {this._ImgHistorique1 = im;}
	public Image getImgHistorique1() {return _ImgHistorique1;}
	public void setKillHistorique1(String ki) {this._KillHistorique1 = ki;}
	public String getKillHistorique1() {return _KillHistorique1;}
	public void setDeathHistorique1(String de) {this._DeathHistorique1 = de; }
	public String getDeathHistorique1() {return _DeathHistorique1;}
	public void setAssistHistorique1(String ass) {this._AssistHistorique1 = ass;}
	public String getAssistHistorique1() {return _AssistHistorique1;}
	public void setResultHistorique1(String res) {this._ResultHistorique1 = res;}
	public String getResultHistorique1() {return _ResultHistorique1;}
	public void setDate_Jour1(String dj) {this._Date_Jour1 = dj;}
	public String getDate_Jour1() {return _Date_Jour1;}
	public void setDate_Mois1(String dm) {this._Date_Mois1 = dm;}
	public String getDate_Mois1() {return _Date_Mois1;}
	public void setDate_Annee1(String da) {this._Date_Annee1 = da;}
	public String getDate_Annee1() {return _Date_Annee1;}
	public void setNom_partie1(String n) {this.Nom_partie1 = n;}
	public String getNom_partie1() {return Nom_partie1;}
	
	public void setImgHistorique2(Image im) {this._ImgHistorique2 = im;}
	public Image getImgHistorique2() {return _ImgHistorique2;}
	public void setKillHistorique2(String ki) {this._KillHistorique2 = ki;}
	public String getKillHistorique2() {return _KillHistorique2;}
	public void setDeathHistorique2(String de) {this._DeathHistorique2 = de; }
	public String getDeathHistorique2() {return _DeathHistorique2;}
	public void setAssistHistorique2(String ass) {this._AssistHistorique2 = ass;}
	public String getAssistHistorique2() {return _AssistHistorique2;}
	public void setResultHistorique2(String res) {this._ResultHistorique2 = res;}
	public String getResultHistorique2() {return _ResultHistorique2;}
	public void setDate_Jour2(String dj) {this._Date_Jour2 = dj;}
	public String getDate_Jour2() {return _Date_Jour2;}
	public void setDate_Mois2(String dm) {this._Date_Mois2 = dm;}
	public String getDate_Mois2() {return _Date_Mois2;}
	public void setDate_Annee2(String da) {this._Date_Annee2 = da;}
	public String getDate_Annee2() {return _Date_Annee2;}
	public void setNom_partie2(String n) {this.Nom_partie2 = n;}
	public String getNom_partie2() {return Nom_partie2;}
	
	public void setImgHistorique3(Image im) {this._ImgHistorique3 = im;}
	public Image getImgHistorique3() {return _ImgHistorique3;}
	public void setKillHistorique3(String ki) {this._KillHistorique3 = ki;}
	public String getKillHistorique3() {return _KillHistorique3;}
	public void setDeathHistorique3(String de) {this._DeathHistorique3 = de; }
	public String getDeathHistorique3() {return _DeathHistorique3;}
	public void setAssistHistorique3(String ass) {this._AssistHistorique3 = ass;}
	public String getAssistHistorique3() {return _AssistHistorique3;}
	public void setResultHistorique3(String res) {this._ResultHistorique3 = res;}
	public String getResultHistorique3() {return _ResultHistorique3;}
	public void setDate_Jour3(String dj) {this._Date_Jour3 = dj;}
	public String getDate_Jour3() {return _Date_Jour3;}
	public void setDate_Mois3(String dm) {this._Date_Mois3 = dm;}
	public String getDate_Mois3() {return _Date_Mois3;}
	public void setDate_Annee3(String da) {this._Date_Annee3 = da;}
	public String getDate_Annee3() {return _Date_Annee3;}
	public void setNom_partie3(String n) {this.Nom_partie3 = n;}
	public String getNom_partie3() {return Nom_partie3;}
	
	public void setImgHistorique4(Image im) {this._ImgHistorique4 = im;}
	public Image getImgHistorique4() {return _ImgHistorique4;}
	public void setKillHistorique4(String ki) {this._KillHistorique4 = ki;}
	public String getKillHistorique4() {return _KillHistorique4;}
	public void setDeathHistorique4(String de) {this._DeathHistorique4 = de; }
	public String getDeathHistorique4() {return _DeathHistorique4;}
	public void setAssistHistorique4(String ass) {this._AssistHistorique4 = ass;}
	public String getAssistHistorique4() {return _AssistHistorique4;}
	public void setResultHistorique4(String res) {this._ResultHistorique4 = res;}
	public String getResultHistorique4() {return _ResultHistorique4;}
	public void setDate_Jour4(String dj) {this._Date_Jour4 = dj;}
	public String getDate_Jour4() {return _Date_Jour4;}
	public void setDate_Mois4(String dm) {this._Date_Mois4 = dm;}
	public String getDate_Mois4() {return _Date_Mois4;}
	public void setDate_Annee4(String da) {this._Date_Annee4 = da;}
	public String getDate_Annee4() {return _Date_Annee4;}
	public void setNom_partie4(String n) {this.Nom_partie4 = n;}
	public String getNom_partie4() {return Nom_partie4;}
	
	public void setImgHistorique5(Image im) {this._ImgHistorique5 = im;}
	public Image getImgHistorique5() {return _ImgHistorique5;}
	public void setKillHistorique5(String ki) {this._KillHistorique5 = ki;}
	public String getKillHistorique5() {return _KillHistorique5;}
	public void setDeathHistorique5(String de) {_DeathHistorique5 = de; }
	public String getDeathHistorique5() {return _DeathHistorique5;}
	public void setAssistHistorique5(String ass) {this._AssistHistorique5 = ass;}
	public String getAssistHistorique5() {return _AssistHistorique5;}
	public void setResultHistorique5(String res) {this._ResultHistorique5 = res;}
	public String getResultHistorique5() {return _ResultHistorique5;}
	public void setDate_Jour5(String dj) {this._Date_Jour5 = dj;}
	public String getDate_Jour5() {return _Date_Jour5;}
	public void setDate_Mois5(String dm) {this._Date_Mois5 = dm;}
	public String getDate_Mois5() {return _Date_Mois5;}
	public void setDate_Annee5(String da) {this._Date_Annee5 = da;}
	public String getDate_Annee5() {return _Date_Annee5;}
	public void setNom_partie5(String n) {this.Nom_partie5 = n;}
	public String getNom_partie5() {return Nom_partie5;}
	
	
}
