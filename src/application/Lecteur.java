package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Lecteur {
	
	private String partieResume;
	private Joueur[][] tabJoueur = new Joueur[10][2];//nb de joueurs - nb de Parties
	private int numPartie = 0;
	private int cptJoueur;
	
	public Lecteur()
	{
	    String ligne;
		try
		{ // ouverture
			InputStream ips;
			InputStreamReader ipsr;
			BufferedReader buffer;
			
			while ( this.numPartie < 2)
			{
				this.cptJoueur = 0;
				ips = this.getClass().getResourceAsStream("/application/history/Theh2zo/Partie"+(this.numPartie+1)+".txt");
				ipsr = new InputStreamReader(ips);
				buffer = new BufferedReader(ipsr);
				// traitement
				while ((ligne = buffer.readLine()) != null)
				{
					this.partieResume += ligne + "\n";
				}
				// fermeture
				buffer.close();
				System.out.println("Affichage des Données de la partie n°"+ (this.numPartie+1));
				//Thread.sleep(1000);
				this.affecterDonnees();
				
			}
		} catch (Exception exc)
		{
			System.out.println("Erreur fichier" + exc);
		}

		
	}
	
	public void affecterDonnees()
	{
		String[] lignes = partieResume.split("\n");
		String[] decoup;
		
		System.out.println(this.numPartie);
		for(int cpt=0; cpt < tabJoueur.length;cpt++)
		{
			//System.out.println(cpt);
			tabJoueur[cpt][this.numPartie]= new Joueur(cpt);
		}
		for (int cpt = 0; cpt < lignes.length; cpt++)
		{
			if (lignes[cpt].matches("^	Champion.*"))
			{
				decoup = lignes[cpt].split(":");
				//System.out.println(cptJoueur);
				//System.out.println(this.numPartie);
				this.tabJoueur[cptJoueur][this.numPartie].setChampion(decoup[1].trim());
				
			}
			if (lignes[cpt].matches("^	Pseudonyme.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setPseudo(decoup[1].trim());
			}
			if (lignes[cpt].matches("^	Total Or.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setTotalOr(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Sbires tués.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setSbires(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Soins prodigués.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setSoins(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Tourelles détruites.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setTourelles(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Nombre d'éliminations.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setEliminations(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Nombre de morts.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setMorts(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Nombre d'assistances.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setAssistances(Integer.parseInt(decoup[1].trim()));
			}
			if (lignes[cpt].matches("^	Equipement.*"))
			{
				decoup = lignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setEquipement(Integer.parseInt(decoup[1].trim()));
				this.cptJoueur++;
			}
			//System.out.println(lignes[cpt]);
			if (cptJoueur == 10)
					cptJoueur = 0;
		}
		
		for (int cpt = 0; cpt < 10; cpt ++)
		{
			this.tabJoueur[cpt][this.numPartie].setKda();
			System.out.println(this.tabJoueur[cpt][this.numPartie].toString());
		}
		this.numPartie++;
		/*( Joueur joueur : tabJoueur[this.numPartie])
		{
			joueur.setKda();
			System.out.println(joueur.toString());
		}*/
	}
	public static void main(String[] args) {
		
		Lecteur l = new Lecteur();
	}
}




