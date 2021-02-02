package projet.akka.gestion.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "salarie")
@SequenceGenerator(name = "seqSalarie", sequenceName = "seq_salarie", initialValue = 10, allocationSize = 1)
public class Salarie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSalarie")
	protected Integer id;
	@NotEmpty
	@Column(unique=true)
	protected String mail;
	@NotEmpty(message = "password,nom,prenom obligatoire")
	protected String password,nom,prenom;
	@NotEmpty
	@ManyToOne
	protected Service service;
	@NotEmpty
	private Role role;
	@Version
	protected int version;

	private Salarie manager;
	private List<Salarie> manage = new ArrayList<Salarie>();


	public Salarie() {
	}



	public Salarie(@NotEmpty String mail, @NotEmpty(message = "password,nom,prenom obligatoire") String password,
			@NotEmpty(message = "password,nom,prenom obligatoire") String nom,
			@NotEmpty(message = "password,nom,prenom obligatoire") String prenom, @NotEmpty Service service,
			@NotEmpty Role role, Salarie manager, List<Salarie> manage) {
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.service = service;
		this.role = role;
		this.manager = manager;
		this.manage = manage;
	}



	public Salarie getManager() {
		return manager;
	}

	public void setManager(Salarie manager) {
		this.manager = manager;
	}

	public List<Salarie> getManage() {
		return manage;
	}

	public void setManage(List<Salarie> manage) {
		this.manage = manage;
	}


}
