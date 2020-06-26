package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lecteur {
		
	private String partieResume;
	private Joueur[][] tabJoueur ;//nb de joueurs - nb de Parties
	private Utilisateur utilisateur;
	private int numPartie = 0;
	private int cptJoueur;
	private boolean victoire;
	private String[] tabLignes;
	private int nbParties;
	
	private ArrayList<String> alDate;
	private ArrayList<String> alDuree;
	private ArrayList<String> alAvantageGold;
	
	private ArrayList<ArrayList<String>> stockageAvantageGold;
	
	public Lecteur(String user, int nbParties)
	{
	    String ligne;
	    this.nbParties = nbParties;
	    this.tabJoueur = new Joueur[10][nbParties];
	    this.alDate = new ArrayList<String>();
	    this.alDuree = new ArrayList<String>();
	    this.alAvantageGold = new ArrayList<String>();
	    this.stockageAvantageGold = new ArrayList<ArrayList<String>>();
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
				System.out.println("Durée de la partie : "+this.getAlDuree(this.numPartie));
				System.out.println("Date  de la partie : "+this.getAlDate(this.numPartie));
				System.out.println("Avantage de gold : " + this.getAlAvantageGold(this.numPartie));
				System.out.println("Avantage de gold à la minute 10 : " + this.getAlAvantageGoldPrecis(this.numPartie, 10));
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
		
		for (int cpt = 0; cpt < tabLignes.length; cpt++)
		{
			
			if (tabLignes[cpt].matches("^Resultat.*"))
			{
				decoup = tabLignes[cpt].split(":");
				if (decoup[1].trim().contentEquals("Victoire"))
				{
					//System.out.println("C'est vrai car : " +decoup[1].trim());
					this.victoire = true;
				}				
			}
			
			if (tabLignes[cpt].matches("^Duree de la partie .*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.alDuree.add(decoup[1].trim()+decoup[2].trim());
			}
			if (tabLignes[cpt].matches("^Date .*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.alDate.add(decoup[1].trim());
			}
			
			if (tabLignes[cpt].matches("^Champion joue.*"))
			{
				decoup = tabLignes[cpt].split(":");
				//System.out.println(decoup[1]);
				this.utilisateur.setAlChamp(decoup[1].trim());
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
				if (decoup[1].trim().equals(utilisateur.getPseudo()))
				{
					decoup = tabLignes[cpt+1].split(":");
					utilisateur.ajoutOr(Integer.parseInt(decoup[1].trim()));
					decoup = tabLignes[cpt+2].split(":");
					utilisateur.ajoutSbires(Integer.parseInt(decoup[1].trim()));
					decoup = tabLignes[cpt+3].split(":");
					utilisateur.ajoutSoins(Integer.parseInt(decoup[1].trim()));
					decoup = tabLignes[cpt+4].split(":");
					utilisateur.ajoutDegats(Integer.parseInt(decoup[1].trim()));
					decoup = tabLignes[cpt+5].split(":");
					utilisateur.ajoutTourelles(Integer.parseInt(decoup[1].trim()));
					decoup = tabLignes[cpt+6].split(":");
					utilisateur.ajoutEliminations(Integer.parseInt(decoup[1].trim()));
					decoup = tabLignes[cpt+7].split(":");
					utilisateur.ajoutMorts(Integer.parseInt(decoup[1].trim()));
					decoup = tabLignes[cpt+8].split(":");
					utilisateur.ajoutAssistances(Integer.parseInt(decoup[1].trim()));
				}
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
			if (tabLignes[cpt].matches("^	Degats infliges.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.tabJoueur[cptJoueur][this.numPartie].setDegats(Integer.parseInt(decoup[1].trim()));
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
			if (tabLignes[cpt].matches("^	Rune principale.*"))
			{
				decoup = tabLignes[cpt].split(":");
				this.utilisateur.setRune(Integer.parseInt(decoup[1].trim()));
			}
			
			if (tabLignes[cpt].matches("^	Avantage Total .*"))
			{
				decoup = tabLignes[cpt].split(":");
				String gold[] = decoup[1].split("/");
				this.alAvantageGold.clear(); //On vide l'arraylist avant utilisation
				for(int i=0; i < gold.length; i++)
				{
					this.alAvantageGold.add(gold[i].trim());
				}
				System.out.println(this.alAvantageGold);
				this.stockageAvantageGold.add(this.alAvantageGold);
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
	
	public Joueur[][] getTabJoueur(){
        return this.tabJoueur;
    }
	
	public ArrayList<String> getAlAvantageGold(int id)
	{
		return this.stockageAvantageGold.get(id-1);
	}
	
	public ArrayList<String> getAlAvantageGold()
	{
		return this.alAvantageGold;
	}
	
	public String getAlAvantageGoldPrecis(int idNumPartie, int minute)
	{
		return this.stockageAvantageGold.get(idNumPartie-1).get(minute/5);
	}
	
	public ArrayList<String> getAlDate()
	{
		return this.alDate;
	}
	
	public String getAlDate(int numPartie)
	{
		return this.alDate.get(numPartie-1);
	}
	
	public ArrayList<String> getAlDuree()
	{
		return this.alDuree;
	}
	
	public String getAlDuree(int numPartie)
	{
		return this.alDuree.get(numPartie-1);
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	/*public static void main(String[] args) {
		
		Lecteur l = new Lecteur("Theh2zo", 3);
	}*/
}




