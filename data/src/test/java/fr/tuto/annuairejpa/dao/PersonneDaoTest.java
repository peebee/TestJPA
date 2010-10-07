package fr.tuto.annuairejpa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.OptimisticLockException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.tuto.annuairejpa.entity.Adresse;
import fr.tuto.annuairejpa.entity.Personne;
import fr.tuto.annuairejpa.entity.Telephone;

/**
 * 
 * @author Pascal
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonneDaoTest {

	final Logger logger = LoggerFactory.getLogger(PersonneDao.class);

	@Autowired
	protected PersonneDao personneDao = null;

	protected Personne pers1 = null;
	protected Personne pers2 = null;
	protected Personne pers3 = null;

	public PersonneDaoTest() {
	}

	public void setPersonneDao(PersonneDao personneDao) {
		this.personneDao = personneDao;
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {

		pers2 = new Personne();
		pers2.setCivilite(2);
		pers2.setCreation(new Date());
		pers2.setNom("DURANT");
		pers2.setPrenom("Giselle");
		pers2.setVersion(1);
		Adresse adresse = new Adresse("rue du boeuf", null, "Niort", "79000");
		ArrayList<Adresse> al = new ArrayList<Adresse>();
		al.add(adresse);
		pers2.setAdresses(al);
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of findPersonneById method, of class PersonneBasicDao.
	 */
	@Test
	public void testFindPersonneById() {
		logger.debug("findPersonneById");
		Long id = 1L;
		Personne result = personneDao.findPersonneById(id);
		assertNotNull("Pas de personne avec l'ID " + id, result);
		assertEquals("Le nom devrait être : ", "MARTIN", result.getNom());
		assertEquals("Le prénom devrait être : ", "Jules", result.getPrenom());
//		assertEquals("Le nombre d'adresse devrait être :", 2, result
//				.getAdresses().size());
		logger.debug("Objet récupéré : " + result);
		List<Adresse> adresses = result.getAdresses();
		assertNotNull("Il devrait y avoir des adresses ", adresses);
		for (Adresse adresse : adresses) 
			logger.debug("  Adresse => " + adresse.toString());

		List<Telephone> telephones = result.getTelephones();
		assertNotNull("Il devrait y avoir des téléphones ", telephones);
		for (Telephone telephone : telephones)
			logger.debug("  Téléphone => " + telephone);

	}

	/**
	 * Test of readPersonnes method, of class PersonneBasicDao.
	 */
	@Test
	public void testReadPersonnes_0args() {
		logger.debug("readPersonnes");
		int expResult = 4;
		Collection<Personne> result = personneDao.readPersonnes();
		assertEquals(expResult, result.size());
		for (Personne personne : result) {
			logger.debug("Personne :" + personne);
		}
	}

	/**
	 * Test of readPersonnes method, of class PersonneBasicDao.
	 */
	@Test
	public void testReadPersonnes_int_int() {
		logger.debug("readPersonnes");
		int startIndex = 0;
		int maxResults = 2;
		int expResult = 2;
		Collection<Personne> result = personneDao.readPersonnes(startIndex,
				maxResults);
		assertEquals(expResult, result.size());
		for (Personne personne : result) {
			logger.debug("Personne :" + personne);
		}
	}

	/**
	 * Test of findPersonneByNom method, of class PersonneBasicDao.
	 */
	@Test
	public void testFindPersonneByNom() {
		logger.debug("findPersonneByNom");
		String nom = "GERMAN";
		int expResult = 1;
		Collection<Personne> result = personneDao.findPersonneByNom(nom);
		assertEquals(expResult, result.size());
		for (Personne personne : result) {
			logger.debug("Personne :" + personne);
		}
	}

	/**
	 * Test of create method, of class PersonneBasicDao.
	 */
	@Test
	public void testCreate() {
		logger.debug("create");
		pers2 = personneDao.create(pers2);
		logger.debug("ID généré pour la nouvelle personne: "+ pers2.getId());
		int expResult = 5;
		Collection<Personne> result = personneDao.readPersonnes();
		assertEquals(expResult, result.size());
		for (Personne personne : result) {
			logger.debug("Personne :" + personne);
		}
	}

	/**
	 * Test of delete method, of class PersonneBasicDao.
	 */
	@Test
	public void testDelete() {
		logger.debug("delete");
		pers3 = personneDao.findPersonneById(3L);
		personneDao.delete(pers3);
		int expResult = 4;
		Collection<Personne> result = personneDao.readPersonnes();
		assertEquals(expResult, result.size());
		for (Personne personne : result) {
			logger.debug("Personne :" + personne);
		}
	}

	/**
	 * Test of update method, of class PersonneBasicDao.
	 */
	@Test
	public void testUpdate() {
		logger.debug("update");
		pers3 = personneDao.findPersonneById(2L);
		pers3.setPrenom("Gwenaëlle");
		pers3 = personneDao.update(pers3);
		int expResult = 4;
		Collection<Personne> result = personneDao.readPersonnes();
		assertEquals(expResult, result.size());
		for (Personne personne : result) {
			logger.debug("Personne :" + personne);
		}

	}

	/**
	 * Test de Lock Optimiste
	 */
	@Test
	public void testLock() {
		logger.debug("Lock optimiste");
		Personne p1 = personneDao.findPersonneById(1L);
		Personne p2 = personneDao.findPersonneById(1L);
		p2.setPrenom("Louis");
		p2 = personneDao.update(p2);
		try {
			p1 = personneDao.update(p1);
			fail("Une OptimisticLockException est attendue");
		} catch (OptimisticLockException ole) {
			logger.debug("OptimisticLockException ça marche");
			logger.debug("Personne 1: " + p1);
			logger.debug("Personne 2: " + p2);
		}

	}
}
