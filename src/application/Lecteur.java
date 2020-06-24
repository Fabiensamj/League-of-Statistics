package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Lecteur {
	
	private String partie;
	
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
				this.partie += ligne + "\n";
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
		System.out.println(this.partie);
	}
	public static void main(String[] args) {
		
		Lecteur l = new Lecteur();
	}
}




