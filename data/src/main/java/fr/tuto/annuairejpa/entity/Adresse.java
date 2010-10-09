/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.tuto.annuairejpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
@Table(name="Adresses")
public class Adresse implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1283366562122166961L;
	
	@Id
	@GeneratedValue
    private Long id;
	@Version
	private Integer version;
    @Column(nullable=false)
	private String adr1;
    private String adr2;
    @Column(nullable=false)
    private String ville;
    @Column(nullable=false)
    private String cp;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created")
    private Date dateCreation;
        
	public Adresse() {
		super();
	}

	public Adresse(String adr1, String adr2, String ville, String cp) {
		this.adr1 = adr1;
		this.adr2 = adr2;
		this.ville = ville;
		this.cp = cp;
		this.dateCreation = new Date();
		this.version = new Integer(1);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getAdr1() {
		return adr1;
	}

	public void setAdr1(String adr1) {
		this.adr1 = adr1;
	}

	public String getAdr2() {
		return adr2;
	}

	public void setAdr2(String adr2) {
		this.adr2 = adr2;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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

		final Adresse other = (Adresse) obj;

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
		sb.append("  adr1=").append(adr1);
		sb.append("  adr2=").append(adr2);
		sb.append("  cp=").append(cp);
		sb.append("  ville=").append(ville);
		sb.append("  créé=").append(dateCreation);

		return sb.toString();
	}
}
