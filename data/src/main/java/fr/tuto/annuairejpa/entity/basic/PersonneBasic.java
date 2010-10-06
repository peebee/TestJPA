package fr.tuto.annuairejpa.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class PersonneBasic implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5685979299670223254L;
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
    @Embedded
    private AdresseBasic adresse;
    @Column(nullable = false)
    private int civilite;
    @Column(nullable = false, name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    public PersonneBasic() {
    }

    public PersonneBasic(String nom, String prenom, AdresseBasic adresse, int civilite) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.civilite = civilite;
        this.version = 1;
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public AdresseBasic getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseBasic adresse) {
        this.adresse = adresse;
    }

    public int getCivilite() {
        return civilite;
    }

    public void setCivilite(int civilite) {
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

        final PersonneBasic other = (PersonneBasic) obj;

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
