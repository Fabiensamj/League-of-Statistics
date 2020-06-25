package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Lecteur {
	
	final static int nbParties = 3;
	
	private String partieResume;
	private Joueur[][] tabJoueur = new Joueur[10][nbParties];//nb de joueurs - nb de Parties
	private Utilisateur utilisateur;
	private int numPartie = 0;
	private int cptJoueur;
	private boolean victoire;
	private String[] tabLignes;
	
	
	public Lecteur(String user)
	{
	    String ligne;
		try
		{ // ouverture
			InputStream ips;
			InputStreamReader ipsr;
			BufferedReader buffer;
			
			utilisateur = new Utilisateur(user);
			utilisateur.setNbParties(nbParties);
			while ( this.numPartie < nbParties)
			{
				this.cptJoueur = 0;
				this.victoire = false;
				ips = this.getClass().getResourceAsStream("/application/history/"+user+"/Partie"+(this.numPartie+1)+".txt");
				ipsr = new InputStreamReader(ips);
				buffer = new BufferedReader(ipsr);
				// traitement
				this.partieResume = null;
				while ((ligne = buffer.readLine()) != null)
				{
					this.partieResume += ligne + "\n";
				}
				// fermeture
				buffer.close();
				System.out.println("\n Affichage des Donnees de la partie n°"+ (this.numPartie+1));
				//Thread.sleep(1000);
				this.affecterDonnees();
				
			}
			System.out.println(utilisateur.toString());
		} catch (Exception exc)
		{
			System.out.println("Erreur fichier" + exc);
		}

		
	}
	
	public void affecterDonnees()
	{
		tabLignes = null;
		tabLignes = partieResume.split("\n");
		String[] decoup;
		//System.out.println(this.numPartie);
		for(int cpt=0; cpt < tabJoueur.length;cpt++)
		{
			//System.out.println(cpt);
			tabJoueur[cpt][this.numPartie]= new Joueur(cpt);
		}
		System.out.println(tabLignes.length);
		for (int cpt = 0; cpt < tabLignes.length; cpt++)
		{
			
			if (tabLignes[cpt].matches("^Resultat.*"))
			{
				decoup = tabLignes[cpt].split(":");
				if (decoup[1].trim().contentEquals("Victoire"))
				{
					System.out.println("C'est vrai car : " +decoup[1].trim());
					this.victoire = true;
				}
				if (decoup[1].trim().contentEquals("Defaite"))
				{
					System.out.println("C'est faux car : " +decoup[1].trim());
				}
			}
			
			if (tabLignes[cpt].matches("^Champion joue.*"))
			{
				decoup = tabLignes[cpt].split(":");
				System.out.println(decoup[1]);
			}
			
			if (tabLignes[cpt].matches("^	Champion.*"))
			{
				decoup = tabLignes[cpt].split(":");
				//System.out.println(cptJoueur);
				//System.out.println(this.numPartie);
				this.tabJoueur[cptJoueur][this.numPartie].setChampion(decoup[1].trim());
				
			}
			if (tabLignes[cpt].matches("^	Pseudonyme.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setPseudo(decoup[1].trim());
			}
			if (tabLignes[cpt].matches("^	Total Or.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setTotalOr(Integer.parseInt(decoup[1].trim()));
			}
			if (tabLignes[cpt].matches("^	Sbires tues.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setSbires(Integer.parseInt(decoup[1].trim()));
			}
			if (tabLignes[cpt].matches("^	Soins prodigues.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setSoins(Integer.parseInt(decoup[1].trim()));
			}
			if (tabLignes[cpt].matches("^	Tourelles detruites.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setTourelles(Integer.parseInt(decoup[1].trim()));
			}
			if (tabLignes[cpt].matches("^	Nombre d'eliminations.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setEliminations(Integer.parseInt(decoup[1].trim()));
			}
			if (tabLignes[cpt].matches("^	Nombre de morts.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setMorts(Integer.parseInt(decoup[1].trim()));
			}
			if (tabLignes[cpt].matches("^	Nombre d'assistances.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setAssistances(Integer.parseInt(decoup[1].trim()));
			}
			if (tabLignes[cpt].matches("^	Equipement.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setEquipement(Integer.parseInt(decoup[1].trim()));
				this.cptJoueur++;
			}
			//System.out.println(lignes[cpt]);
			if (cptJoueur == 10)
					this.cptJoueur = 0;
		}
		
		if(victoire)
			this.utilisateur.ajoutNbVictoires();
		else
			this.utilisateur.ajoutNbDefaites();
		
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
		
		Lecteur l = new Lecteur("Theh2zo");
	}
	
	public Joueur[][] getTabJoueur(){
		return this.tabJoueur;
	}
}




