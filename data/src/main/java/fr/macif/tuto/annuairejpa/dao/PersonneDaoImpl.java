/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.macif.tuto.annuairejpa.dao;

import fr.macif.tuto.annuairejpa.entity.Personne;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Pascal
 */
@Repository
public class PersonneDaoImpl implements PersonneDao {

    private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public Personne findPersonneById(int id) {
        return em.find(Personne.class, id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public Collection<Personne> readPersonnes() {
        return em.createQuery("select p from Personne p order by p.nom, p.prenom").getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Collection<Personne> readPersonnes(int startIndex, int maxResults) {
        return em.createQuery("select p from Personne p order by p.nom, p.prenom").setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Collection<Personne> findPersonneByNom(String nom) {
        return em.createQuery("select p from Personne p where p.nom = :nom order by p.nom, p.prenom").getResultList();
    }

    @Override
    @Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
    public void save(Personne personne) {
    	personne.setDateModification(new Date());
        em.merge(personne);
    }

    @Override
    @Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
    public void delete(Personne personne) {
        em.remove(personne);
    }
}
