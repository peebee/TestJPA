/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tuto.annuairejpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * 
 * @author Pascal
 */
@Entity
@Table(name = "Personnes")
@SequenceGenerator(name="PERSONNE_SEQ", sequenceName="PERSONNE_SEQ", initialValue=10)
public class Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5685979299670223254L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONNE_SEQ")
	@Column(name = "ID", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	private Long id;

	@Version
	@Column(nullable = false)
	private int version;

	@Column(nullable = false, length = 30)
	private String nom;

	@Column(nullable = false, length = 30)
	private String prenom;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "PERSONNE_ADRESSE", joinColumns = @JoinColumn(name = "personneId"), inverseJoinColumns = @JoinColumn(name = "adresseId"))
	private List<Adresse> adresses = new ArrayList<Adresse>();

	// @OneToOne
	// @JoinColumn(name = "civilite", nullable = false)
	// private Civilite civilite;
	private Integer civilite;

	// @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	// private List<Phone> phones = new ArrayList<Phone>();

	@Column(nullable = false, name = "CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;

	@Column(name = "MODIFY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModification;

	public Personne() {
	}

	public Personne(String nom, String prenom, int civilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.version = new Integer(1);
		this.dateCreation = new Date();
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Integer getCivilite() {
		return civilite;
	}

	public void setCivilite(Integer civilite) {
		this.civilite = civilite;
	}

	// public Civilite getCivilite() {
	// return civilite;
	// }
	//
	// public void setCivilite(Civilite civilite) {
	// this.civilite = civilite;
	// }

	public Date getCreation() {
		return dateCreation;
	}

	public void setCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// public List<Phone> getPhones() {
	// return phones;
	// }
	//
	// public void setPhones(List<Phone> phones) {
	// this.phones = phones;
	// }

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public boolean addAdresse(Adresse adresse) {
		return this.adresses.add(adresse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Personne other = (Personne) obj;

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName()).append("-");
		sb.append("  id=").append(id);
		sb.append("  nom=").append(nom);
		sb.append("  pr�nom=").append(prenom);
		sb.append("  cr�e=").append(dateCreation);

		return sb.toString();
	}
}
