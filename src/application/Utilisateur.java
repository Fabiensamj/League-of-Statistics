package application;

import java.util.ArrayList;

public class Utilisateur {
	
	String pseudo;
	int nbVictoires = 0;
	int nbDefaites = 0;
	int nbParties;
	double winrate;
	String elo = "D4 87LP";
	ArrayList<String> alChamp = new ArrayList<String>();
	String rune;
	
	int totalOr = 0, totalSbires = 0, totalDegats = 0, totalSoins = 0, totalTourelles = 0, totalEliminations = 0, totalMorts = 0, totalAssistances = 0;
	
	
	
	public Utilisateur (String pseudo)
	{
		this.pseudo = pseudo;
	}
	
	public String getRune()
	{
		return this.rune;
	}
	
	public void setRune(String rune)
	{
		this.rune = rune;
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
		//System.out.println("j'ai une victoire");
	}


	public int getNbDefaites() {
		return nbDefaites;
	}


	public void ajoutNbDefaites() {
		this.nbDefaites++;
	}


	public double getWinrate() {
		double result = ((double)this.getNbVictoires()/(double)this.getNbParties())*100 ;
		return (double) Math.round(result *100)/100;
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


	public void setAlChamp(String alChamp) {
		this.alChamp.add(alChamp);
	}
	
	public void ajoutOr(int or)
	{
		this.totalOr += or;
	}
	
	public void ajoutSbires(int sbires)
	{
		this.totalSbires += sbires;
	}
	
	public void ajoutDegats(int degats)
	{
		this.totalDegats+= degats;
	}
	
	public void ajoutSoins(int soins)
	{
		this.totalSoins += soins;
	}
	
	public void ajoutTourelles(int tourelles)
	{
		this.totalTourelles += tourelles;
	}
	
	public void ajoutEliminations(int eliminations)
	{
		this.totalEliminations += eliminations;
	}
	
	public void ajoutMorts(int morts)
	{
		this.totalMorts += morts;
	}
	
	public void ajoutAssistances(int assistances)
	{
		this.totalAssistances += assistances;
	}
	
	public int getMoyenneOr()
	{
		return (int) (this.totalOr / this.getNbParties());
	}
	
	public int getMoyenneSbires()
	{
		return (int) (this.totalSbires / this.getNbParties());
	}
	
	public int getMoyenneDegats()
	{
		return (int) (this.totalDegats / this.getNbParties());
	}
	
	public int getMoyenneSoins()
	{
		return (int) (this.totalSoins / this.getNbParties());
	}
	
	public int getMoyenneTourelles()
	{
		return (int) (this.totalTourelles / this.getNbParties());
	}
	
	public int getMoyenneEliminations()
	{
		return (int) (this.totalEliminations / this.getNbParties());
	}
	
	public int getMoyenneMorts()
	{
		return (int) (this.totalMorts / this.getNbParties());
	}
	
	public int getMoyenneAssistances()
	{
		return (int) (this.totalAssistances / this.getNbParties());
	}

	@Override
	public String toString() {
		return "\nUtilisateur [pseudo=" + pseudo + ", nbVictoires=" + nbVictoires + ", nbDefaites=" + nbDefaites
				+ ", nbParties=" + nbParties + ", winrate=" + this.getWinrate()+"%" + ", elo=" + elo + ", alChamp=" + alChamp + ", rune =" + rune
				+ ",\n totalOr=" + totalOr + ", totalSbires=" + totalSbires + ", totalDegats=" + totalDegats
				+ ", totalSoins=" + totalSoins + ", totalTourelles=" + totalTourelles + ", totalEliminations="
				+ totalEliminations + ", totalMorts=" + totalMorts + ", totalAssistances=" + totalAssistances 
				+ ",\n moyenneOr=" + this.getMoyenneOr()+ ", moyenneSbires=" + this.getMoyenneSbires() + ", moyenneDegats=" + this.getMoyenneDegats()
				+ ", moyenneSoins=" + this.getMoyenneSoins() + ", moyenneTourelles=" + this.getMoyenneTourelles() + ", moyenneEliminations="
				+ this.getMoyenneEliminations() + ", moyenneMorts=" + this.getMoyenneMorts() + ", moyenneAssistances=" + this.getMoyenneAssistances() + "]";
	}	

}

