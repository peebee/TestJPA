/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.tuto.annuairejpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * 
 * @author Pascal
 */
@Entity
@Table(name = "telephones")
public class Telephone {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	@Column(nullable = false)
	private int version;
	@ManyToOne
	@JoinColumn(name="OWNER_ID")
	private Personne owner;
	@Enumerated(EnumType.STRING)
	private TelephoneType telephone_type;
	@Column(nullable = false)
	private String numero;

	public Telephone() {
		super();
	}

	public Telephone(TelephoneType type, String numero) {
		this.telephone_type = type;
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Personne getOwner() {
		return owner;
	}

	public void setOwner(Personne owner) {
		this.owner = owner;
	}

	public TelephoneType getTelephone_type() {
		return telephone_type;
	}

	public void setTelephone_type(TelephoneType telephone_type) {
		this.telephone_type = telephone_type;
	}

	public int getVersion() {
		return version;
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

		final Telephone other = (Telephone) obj;

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
		sb.append("  numéro=").append(numero);
		sb.append("  type=").append(telephone_type);
		return sb.toString();
	}

}
