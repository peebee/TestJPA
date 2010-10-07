
package fr.tuto.annuairejpa.daobasic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.Date;

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

import fr.tuto.annuairejpa.entity.basic.AdresseBasic;
import fr.tuto.annuairejpa.entity.basic.PersonneBasic;

/**
 * 
 * @author Pascal
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonneBasicDaoTest {

	final Logger logger = LoggerFactory.getLogger(PersonneBasicDao.class);
	@Autowired
	protected PersonneBasicDao personneDao = null;

	protected PersonneBasic pers1 = null;
	protected PersonneBasic pers2 = null;
	protected PersonneBasic pers3 = null;

	public PersonneBasicDaoTest() {
	}

	public void setPersonneDao(PersonneBasicDao personneDao) {
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

		pers2 = new PersonneBasic();
		// pers2.setId(22L);
		pers2.setCivilite(2);
		pers2.setCreation(new Date());
		pers2.setNom("DURANT");
		pers2.setPrenom("Giselle");
		pers2.setVersion(1);
		AdresseBasic adresse = new AdresseBasic("rue du boeuf", null, "Niort",
				"79000");
		pers2.setAdresse(adresse);
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
		PersonneBasic result = personneDao.findPersonneById(id);
		assertNotNull("Une personne au moins doit existée",personneDao);
		assertEquals("Le nom devrait être : ", "MARTIN", result.getNom());
		assertEquals("Le prénom devrait être : ", "Jules", result.getPrenom());
		logger.debug("Objet récupéré : " + result);
	}

	/**
	 * Test of readPersonnes method, of class PersonneBasicDao.
	 */
	@Test
	public void testReadPersonnes_0args() {
		logger.debug("readPersonnes");
		int expResult = 4;
		Collection<PersonneBasic> result = personneDao.readPersonnes();
		assertEquals(expResult, result.size());
		for (PersonneBasic personne : result) {
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
		Collection<PersonneBasic> result = personneDao.readPersonnes(
				startIndex, maxResults);
		assertEquals(expResult, result.size());
		for (PersonneBasic personne : result) {
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
		Collection<PersonneBasic> result = personneDao.findPersonneByNom(nom);
		assertEquals(expResult, result.size());
		for (PersonneBasic personne : result) {
			logger.debug("Personne :" + personne);
		}
	}

	/**
	 * Test of merge method, of class PersonneBasicDao.
	 */
	@Test
	public void testSave() {
		logger.debug("create Ajout");
		// initialise le nombre de personne de la base
		Collection<PersonneBasic> result = personneDao.readPersonnes();
		int expResult = result.size() + 1;  
		personneDao.create(pers2);
		result = personneDao.readPersonnes();
		assertEquals(expResult, result.size());
		for (PersonneBasic personne : result) {
			logger.debug("Personne :" + personne);
		}
	}

	/**
	 * Test of delete method, of class PersonneBasicDao.
	 */
	@Test
	public void testDelete() {
		logger.debug("delete");
		// initialise le nombre de personne de la base
		Collection<PersonneBasic> result = personneDao.readPersonnes();
		int expResult = result.size() - 1;  
		pers3 = personneDao.findPersonneById(3L);
		personneDao.delete(pers3);
		result = personneDao.readPersonnes();
		assertEquals(expResult, result.size());
		for (PersonneBasic personne : result) {
			logger.debug("Personne :" + personne);
		}
	}

	/**
	 * Test of update method, of class PersonneBasicDao.
	 */
	@Test
	public void testUpdate() {
		logger.debug("update");
		// initialise le nombre de personne de la base
		Collection<PersonneBasic> result = personneDao.readPersonnes();
		int expResult = result.size();  

		pers3=personneDao.findPersonneById(2L);
		pers3.setPrenom("Gwenaëlle");
		personneDao.update(pers3);
		result = personneDao.readPersonnes();
		assertEquals(expResult, result.size());
		for (PersonneBasic personne : result) {
			logger.debug("Personne :" + personne);
		}
	}
}
