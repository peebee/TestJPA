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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.transaction.SystemException;

/**
 *
 * @author Pascal
 */
@Entity
@Table(name="Adresses")
@SequenceGenerator(name="ADRESSE_SEQ", sequenceName="ADRESSE_SEQ", initialValue=10)
public class Adresse implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1283366562122166961L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADRESSE_SEQ")
	@Column(name = "ID", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
    private Long id;
	
	@Version
	private Integer version;
	
    @Column(nullable=false)
	private String rue1;
    
    private String rue2;
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

	public Adresse(String rue1, String rue2, String ville, String cp) {

		this.id = new Long(12);
		this.rue1 = rue1;
		this.rue2 = rue2;
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

	public String getRue1() {
		return rue1;
	}

	public void setRue1(String rue1) {
		this.rue1 = rue1;
	}

	public String getRue2() {
		return rue2;
	}

	public void setRue2(String rue2) {
		this.rue2 = rue2;
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
    
    
}
