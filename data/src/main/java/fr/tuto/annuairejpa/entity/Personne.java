package fr.tuto.annuairejpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author Pascal
 */
@Entity
@Table(name = "Personnes")
public class Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539295821569597057L;
	@Id
	@GeneratedValue
	private Long id;
	@Version
	@Column(nullable = false)
	private int version;
	@Column(nullable = false, length = 30)
	private String nom;
	@Column(nullable = false, length = 30)
	private String prenom;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PERSONNE_ADRESSE", joinColumns = @JoinColumn(name = "personneId"), inverseJoinColumns = @JoinColumn(name = "adresseId"))
	private List<Adresse> adresses;
	// @OneToOne
	// @JoinColumn(name = "civilite", nullable = false)
	// private Civilite civilite;
	private Integer civilite;
	
	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<Telephone> telephones;

	@Column(nullable = false, name = "CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	@Column(name = "MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModification;

	public Personne() {
	}

	public Personne(String nom, String prenom, int civilite) {
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.version = new Integer(1);
		this.dateCreation = new Date();
	}

	public Integer getCivilite() {
		return civilite;
	}

	public void setCivilite(Integer civilite) {
		this.civilite = civilite;
	}

	public Date getCreation() {
		return dateCreation;
	}

	public void setCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Long getId() {
		return id;
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

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	public boolean addTelephones(Telephone telephone) {
		return this.telephones.add(telephone);
	}

	public boolean addAdresse(Adresse adresse) {
		return this.adresses.add(adresse);
	}

	public List<Adresse> getAdresses() {
		return adresses;
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
		sb.append("  version=").append(version);
		sb.append("  nom=").append(nom);
		sb.append("  prénom=").append(prenom);
		sb.append("  créé=").append(dateCreation);
		if (dateModification != null) {
			sb.append("  mofifié=").append(dateModification);
		}

		return sb.toString();
	}
}
