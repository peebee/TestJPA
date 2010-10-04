/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.macif.tuto.annuairejpa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.macif.tuto.annuairejpa.entity.Adresse;
import fr.macif.tuto.annuairejpa.entity.Civilite;
import fr.macif.tuto.annuairejpa.entity.Personne;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Pascal
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonneDaoTest {

	final Logger logger = LoggerFactory.getLogger(PersonneDaoTest.class);

	@Autowired
	protected PersonneDao personneDao = null;
	protected Civilite civ;

	@Before
	public void init() {
		civ = new Civilite();
		civ.setId(1L);
		civ.setLibelleCourt("Mr.");
	}

	@Test
	public void testHibernateTemplate() throws SQLException {
		assertNotNull("Personne DAO est nul.", personneDao);

		Personne personneNouvelle1 = new Personne("MARTIN","Jules",1);
		personneDao.save(personneNouvelle1);
		Personne personneNouvelle2 = new Personne("MARTIN","Juliette",2);
		personneDao.save(personneNouvelle2);
		Personne personneNouvelle3 = new Personne("DUPOND","Alfonse",1);
		personneDao.save(personneNouvelle3);
		Personne personneNouvelle4 = new Personne("LOUIGY","Julie",2);
		personneDao.save(personneNouvelle4);
		logger.debug("********"+ personneNouvelle1.getVersion() + "**********" + personneNouvelle1.toString());
		Adresse adresseNouvelle1 = new Adresse("Rue de la broche",null,"Niort","79000");
		personneNouvelle1.addAdresse(adresseNouvelle1);
		logger.debug("********"+ personneNouvelle1.getVersion() + "**********" + personneNouvelle1.toString());
		
		
		Collection<Personne> lPersonnes = personneDao.readPersonnes();

		int nbPersonnes = 4;

		assertNotNull("List des Personnes est vide.", lPersonnes);
		assertEquals("Le Nombre de Personnes devrait est " + nbPersonnes + ".", nbPersonnes, lPersonnes.size());

		Long firstId = new Long(1);
		// Long secondId = new Long(2);

		for (Personne personne : lPersonnes) {
			assertNotNull("Client is null.", personne);

			if (firstId.equals(personne.getId())) {
				String prenom = "Jules";
				String nom = "MARTIN";
				int nbAdresse = 2;

				assertEquals("Le pr�nom de la personne devrait �tre " + prenom + ".", prenom, personne.getPrenom());
				assertEquals("Le nom de la personne devrait �tre " + nom + ".", nom, personne.getNom());
				logger.debug(personne.toString());

				assertNotNull("La liste des adresse de la personne est nulle.", personne.getAdresses());
				assertEquals("Nombre d'adresse pour cette personne devrait �tre " + nbAdresse + ".", nbAdresse, personne
						.getAdresses().size());

				Long adresseId = new Long(1);
				String rue1 = "rue1";
				String ville = "Niort";
				String cp = "79000";

				for (Adresse adresse : personne.getAdresses()) {
					if (adresseId.equals(adresse.getId())) {
						assertNotNull("Adresse est null", adresse);

						assertEquals("L'identifiant de l'adresse devrait �tre '" + adresseId + "'.", adresseId, adresse.getId());
						assertEquals("La rue1 de l'adresse devrait �tre '" + rue1 + "'.", rue1, adresse.getRue1());

						assertEquals("La ville de l'adresse devrait �tre '" + ville + "'.", ville, adresse.getVille());
						assertEquals("le code postal de l'adresse devrait �tre '" + cp + "'.", cp, adresse.getCp());
					}
				}
				//Adresse adresseNouvelle = new Adresse("Rue de la broche",null,"Niort","79000");
				//personne.addAdresse(adresseNouvelle);
				//personneDao.save(personne);
//				Personne personneNouvelle = new Personne("nom","prenom",1);
//				personneDao.save(personneNouvelle);
//				System.out.println("**********" + personne.getVersion());
				
			}
		}
	}

}
