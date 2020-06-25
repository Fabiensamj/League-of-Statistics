package application;

import java.util.ArrayList;

public class Utilisateur {
	
	String pseudo;
	int nbVictoire;
	int nbDefaites;
	double winrate;
	String elo = "D4 87LP";
	ArrayList<String> alChamp;
	
	
	public Utilisateur (String pseudo)
	{
		this.pseudo = pseudo;
	}
	
	
}
