/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.tuto.annuairejpa.dao;

import fr.tuto.annuairejpa.entity.Personne;

import java.util.Collection;

/**
 *
 * @author Pascal
 */
public interface PersonneDao {

    /**
     * Recherche par ID
     */
    public Personne findPersonneById(Long id);

    /**
     * recup�ration de toutes les personnes
     */
     public Collection<Personne> readPersonnes();
     
     /**
      * Recherche une personnes depuis un index pour x enregistrements.
      */
     public Collection<Personne> readPersonnes(final int startIndex, final int maxResults);
     
     /**
      * Recherche sur le nom
      */
     public Collection<Personne> findPersonneByNom(final String nom);
     
     /**
      * Sauvegarde de la personne
     * @return TODO
      */
     public Personne create(Personne personne);
     
     /**
      * D�truire un enregistrement
      */
     public void delete(Personne personne);

     /**
      * mettre � jour un enregistrement
     * @return TODO
      */
	public Personne update(Personne personne);
     
}
