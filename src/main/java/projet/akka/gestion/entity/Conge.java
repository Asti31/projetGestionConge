package projet.akka.gestion.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;


import projet.akka.gestion.validator.FinishDate;

@Entity
@Table(name = "conge")
@SequenceGenerator(name = "seqConge", sequenceName = "seq_conge", initialValue = 10, allocationSize = 1)
public class Conge implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConge")
	private Integer id;
	@NotEmpty
	@ManyToOne
	private Salarie salarie;
	@NotEmpty
	private TypeConge typeConge;
	@FutureOrPresent
	@Column(columnDefinition = "DATE")
	private LocalDate dateDebut;
	//@FinishDate(dateDebut = this.dateDebut.toString())
	@Column(columnDefinition = "DATE")
	private LocalDate dateFin;    
	
	@Column(columnDefinition = "DATE")
	private LocalDate dateDemande=LocalDate.now();
	@NotEmpty(message = "nbJour obligatoire")
	private Integer nbJour;
	private String motif;
	private String etat = "ATTENTE";
	
	@Version
	private int version;
	
	
	public Conge() {
	}


	public Conge(Integer id, Salarie salarie, TypeConge typeConge, LocalDate dateDebut, LocalDate dateFin, String motif) {
		this.id = id;
		this.salarie = salarie;
		this.typeConge = typeConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.motif = motif;
	}

	
	public Conge(Salarie salarie, TypeConge typeConge, LocalDate dateDebut, LocalDate dateFin, String motif) {
		this.salarie = salarie;
		this.typeConge = typeConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbJour = calculeNbJour();
		this.motif = motif;
	}


	public void Valider() {
		this.setEtat("VALIDE");
	}
	
	public void Refuser(String motifRefus) {
		this.setEtat("REFUSE");
		this.motif=this.motif+"\n Motif refus:\n"+motifRefus;
	}
	
	public int calculeNbJour() {
		int days = (int) ChronoUnit.DAYS.between(this.dateDebut, this.dateFin);
		return days;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Salarie getSalarie() {
		return salarie;
	}

	public void setSalarie(Salarie salarie) {
		this.salarie = salarie;
	}

	public TypeConge getTypeConge() {
		return typeConge;
	}

	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public LocalDate getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(LocalDate dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Integer getNbJour() {
		return nbJour;
	}

	public void setNbJour(Integer nbJour) {
		this.nbJour = nbJour;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateDemande == null) ? 0 : dateDemande.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conge other = (Conge) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateDemande == null) {
			if (other.dateDemande != null)
				return false;
		} else if (!dateDemande.equals(other.dateDemande))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	




	
	
}
