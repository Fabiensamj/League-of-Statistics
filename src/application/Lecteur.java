package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Lecteur {
	
	private String partieResume;
	private Joueur[] tabJoueur = new Joueur[10]; 
	
	public Lecteur()
	{
	    String ligne;
		try
		{ // ouverture
			InputStream ips = this.getClass().getResourceAsStream("/application/history/Partie2-Theh2zo-02-06-2020.txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader buffer = new BufferedReader(ipsr);
			// traitement
			while ((ligne = buffer.readLine()) != null)
			{
				this.partieResume += ligne + "\n";
			}
			// fermeture
			buffer.close();
		} catch (Exception exc)
		{
			System.out.println("Erreur fichier" + exc);
		}

		this.affecterDonnees();
	}
	
	public void affecterDonnees()
	{
		String[] lignes = partieResume.split("\n");
		String[] decoup;
		int cptJoueur = 0; //Ce compteur eprmet de savoir à quel joueur nous sommes. 
		
		for(int cpt=0; cpt < tabJoueur.length;cpt++)
		{
			tabJoueur[cpt]= new Joueur(cpt);
		}
		
		for (int cpt = 0; cpt < lignes.length; cpt++)
		{
			
			if (lignes[cpt].matches("^	Champion.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setChampion(decoup[1].trim());
				
			}
			if (lignes[cpt].matches("^	Pseudonyme.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setPseudo(decoup[1].trim());
			}
			if (lignes[cpt].matches("^	Total Or.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setTotalOr(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Sbires tués.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setSbires(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Soins prodigués.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setSoins(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Tourelles détruites.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setTourelles(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Nombre d'éliminations.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setEliminations(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Nombre de morts.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setMorts(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Nombre d'assistances.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setAssistances(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Equipement.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur].setEquipement(Integer.parseInt(decoup[1].trim()));
				cptJoueur++;
			}
		}
		
		for( Joueur joueur : tabJoueur)
		{
			joueur.setKda();
			System.out.println(joueur.toString());
		}
	}
	public static void main(String[] args) {
		
		Lecteur l = new Lecteur();
	}
}




