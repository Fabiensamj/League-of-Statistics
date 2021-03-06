package application;

public class Joueur {
	
	int id, totalOr, sbires, soins, tourelles, eliminations, morts, assistances, equipement, degats;
	String pseudo, champion, kda;
	
	public Joueur(int id)
	{
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalOr() {
		return totalOr;
	}

	public void setTotalOr(int totalOr) {
		this.totalOr = totalOr;
	}

	public int getSbires() {
		return sbires;
	}

	public void setSbires(int sbires) {
		this.sbires = sbires;
	}

	public int getSoins() {
		return soins;
	}

	public void setSoins(int soins) {
		this.soins = soins;
	}
	
	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public int getTourelles() {
		return tourelles;
	}

	public void setTourelles(int tourelles) {
		this.tourelles = tourelles;
	}

	public int getEliminations() {
		return eliminations;
	}

	public void setEliminations(int eliminations) {
		this.eliminations = eliminations;
	}

	public int getMorts() {
		return morts;
	}

	public void setMorts(int morts) {
		this.morts = morts;
	}

	public int getAssistances() {
		return assistances;
	}

	public void setAssistances(int assistances) {
		this.assistances = assistances;
	}

	public int getEquipement() {
		return equipement;
	}

	public void setEquipement(int equipement) {
		this.equipement = equipement;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}

	public String getKda() {
		return kda;
	}

	public void setKda() {
		
		this.kda = ""+this.getEliminations()+"/"+this.getAssistances()+"/"+this.getMorts();
		
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", totalOr=" + totalOr + ", sbires=" + sbires + ", soins=" + soins + ", degats=" + degats+ ", tourelles="
				+ tourelles + ", eliminations=" + eliminations + ", morts=" + morts + ", assistances=" + assistances
				+ ", equipement=" + equipement + ", pseudo=" + pseudo + ", champion=" + champion + ", kda=" + kda + "]";
	}

}
