package projet.akka.gestion.entity;

public enum TypeConge {
	CP("Congé payé"),CSS("Congé sans solde"),CA("Congé autorisé"),CJ("Congé justifié");
	private final String libelle;
	
	TypeConge(String libelle) {
		this.libelle=libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
