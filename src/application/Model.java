package application;

import javafx.scene.control.TextArea;

public class Model {

	private TextArea Nom;
	
	public void setNom(TextArea _nom) {
		this.Nom = _nom;
	}
	
	public String getNom() {
		return this.Nom.getText();
	}
}
