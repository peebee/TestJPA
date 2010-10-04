/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.macif.tuto.annuairejpa.entity.basic;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Pascal
 */
@Embeddable
public class AdresseBasic implements Serializable {

    @Column(nullable = false)
    private String adr1;
    private String adr2;
    @Column(nullable = false)
    private String ville;
    @Column(nullable = false)
    private String cp;

    public AdresseBasic() {
        super();
    }

    public AdresseBasic(String adr1, String adr2, String ville, String cp) {

        this.adr1 = adr1;
        this.adr2 = adr2;
        this.ville = ville;
        this.cp = cp;
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

}
