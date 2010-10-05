/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.macif.tuto.annuairejpa.dao.basic;

import fr.macif.tuto.annuairejpa.entity.basic.PersonneBasic;
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
public class PersonneBasicDaoImpl implements PersonneBasicDao {

    private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public PersonneBasic findPersonneById(Long id) {
        return em.find(PersonneBasic.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<PersonneBasic> readPersonnes() {
        return em.createQuery("select p from PersonneBasic p order by p.nom, p.prenom").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<PersonneBasic> readPersonnes(int startIndex, int maxResults) {
        return em.createQuery("select p from PersonneBasic p order by p.nom, p.prenom").setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<PersonneBasic> findPersonneByNom(String nom) {
        return em.createQuery("select p from PersonneBasic p where p.nom = :nom order by p.nom, p.prenom").setParameter("nom", nom).getResultList();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public PersonneBasic save(PersonneBasic personne) {
        return em.merge(personne);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(PersonneBasic personne) {
        em.remove(em.merge(personne));
    }

	@Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public PersonneBasic update(PersonneBasic personne) {
        personne.setDateModification(new Date());
        return em.merge(personne);		
	}
}
