package application;

import java.util.ArrayList;

public class Utilisateur {
	
	String pseudo;
	int nbVictoires = 0;
	int nbDefaites = 0;
	int nbParties;
	double winrate;
	String elo = "D4 87LP";
	ArrayList<String> alChamp;
	
	
	public Utilisateur (String pseudo)
	{
		this.pseudo = pseudo;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public int getNbParties() {
		return nbParties;
	}


	public void setNbParties(int nbParties) {
		this.nbParties = nbParties;
	}


	public int getNbVictoires() {
		return nbVictoires;
	}


	public void ajoutNbVictoires() {
		this.nbVictoires++;
		System.out.println("j'ai une victoire");
	}


	public int getNbDefaites() {
		return nbDefaites;
	}


	public void ajoutNbDefaites() {
		this.nbDefaites++;
	}


	public double getWinrate() {
		return ((double)this.getNbVictoires()/(double)this.getNbParties())*100;
	}


	public void setWinrate(double winrate) {
		this.winrate = winrate;
	}


	public String getElo() {
		return elo;
	}


	public void setElo(String elo) {
		this.elo = elo;
	}


	public ArrayList<String> getAlChamp() {
		return alChamp;
	}


	public void setAlChamp(ArrayList<String> alChamp) {
		this.alChamp = alChamp;
	}


	@Override
	public String toString() {
		return "Utilisateur [pseudo=" + pseudo + ", nbVictoires=" + nbVictoires + ", nbDefaites=" + nbDefaites
				+ ", nbParties=" + nbParties + ", winrate=" + this.getWinrate()+"%" + ", elo=" + elo + ", alChamp=" + alChamp + "]";
	}	

}

