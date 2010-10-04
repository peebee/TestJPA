package fr.macif.tuto.annuairejpa.dao.basic;


import fr.macif.tuto.annuairejpa.entity.basic.PersonneBasic;
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
      * Sauvegarde de la personne
      */
     public PersonneBasic merge(PersonneBasic personne);
     
     /**
      * Détruire un enregistrement
      */
     public void delete(PersonneBasic personne);
 
}