/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.macif.tuto.annuairejpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Pascal
 */
@Entity
@Table(name="Civilites")
public class Civilite implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5411214622679865441L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="libelle_court")
	private String libelleCourt;

    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLibelleCourt() {
		return libelleCourt;
	}
	public void setLibelleCourt(String libelleCourt) {
		this.libelleCourt = libelleCourt;
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

        final Civilite other = (Civilite) obj;

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
		sb.append("  nom=").append(libelleCourt);

		return sb.toString();
    }
    
}
