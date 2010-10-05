/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.tuto.annuairejpa.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Pascal
 */
@Entity
@Table(name="phones")
class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Enumerated (EnumType.STRING)
    private PhoneType type;
    
    private String numero;

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
