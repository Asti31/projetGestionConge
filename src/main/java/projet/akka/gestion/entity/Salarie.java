package projet.akka.gestion.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "salarie")
@SequenceGenerator(name = "seqSalarie", sequenceName = "seq_salarie", initialValue = 10, allocationSize = 1)
public class Salarie implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSalarie")
	protected Integer id;
	@NotEmpty
	@Column(unique=true)
	protected String mail;
	@NotEmpty(message = "password,nom,prenom obligatoire")
	protected String password,nom,prenom;
	@NotNull
	@ManyToOne
	protected Service service;
	@NotNull
	private Role role;
	@Version
	protected int version;
@ManyToOne
	private Salarie manager;
	@OneToMany
	private List<Salarie> manage = new ArrayList<Salarie>();


	public Salarie() {
	}



	public Salarie(@NotEmpty String mail, @NotEmpty(message = "password,nom,prenom obligatoire") String password,
			@NotEmpty(message = "password,nom,prenom obligatoire") String nom,
			@NotEmpty(message = "password,nom,prenom obligatoire") String prenom, @NotNull Service service,
			@NotNull Role role, Salarie manager, List<Salarie> manage) {
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.service = service;
		this.role = role;
		this.manager = manager;
		this.manage = manage;
	}
	public Salarie(@NotEmpty String mail, @NotEmpty(message = "password,nom,prenom obligatoire") String password,
			@NotEmpty(message = "password,nom,prenom obligatoire") String nom,
			@NotEmpty(message = "password,nom,prenom obligatoire") String prenom, @NotNull Service service,
			@NotNull Role role) {
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.service = service;
		this.role = role;

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



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Service getService() {
		return service;
	}



	public void setService(Service service) {
		this.service = service;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((manage == null) ? 0 : manage.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Salarie other = (Salarie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (manage == null) {
			if (other.manage != null)
				return false;
		} else if (!manage.equals(other.manage))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}




}
