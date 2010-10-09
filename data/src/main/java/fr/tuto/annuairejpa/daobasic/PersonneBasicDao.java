package fr.tuto.annuairejpa.daobasic;


import fr.tuto.annuairejpa.entity.basic.PersonneBasic;

import java.util.Collection;

/**
 *
 * @author Pascal
 */
public interface PersonneBasicDao {

    /**
     * Recherche par ID
     */
    public PersonneBasic findPersonneById(Long id);

    /**
     * recupération de toutes les personnes
     */
     public Collection<PersonneBasic> readPersonnes();
     
     /**
      * Recherche une personnes depuis un index pour x enregistrements.
      */
     public Collection<PersonneBasic> readPersonnes(final int startIndex, final int maxResults);
     
     /**
      * Recherche sur le nom
      */
     public Collection<PersonneBasic> findPersonneByNom(final String nom);
     
     /**
      * modification de la personne
      */
     public PersonneBasic update(PersonneBasic personne);
     
     /**
      * Sauvegarde de la personne
      */
     public PersonneBasic create(PersonneBasic personne);
     
     /**
      * Détruire un enregistrement
      */
     public void delete(PersonneBasic personne);
 
}