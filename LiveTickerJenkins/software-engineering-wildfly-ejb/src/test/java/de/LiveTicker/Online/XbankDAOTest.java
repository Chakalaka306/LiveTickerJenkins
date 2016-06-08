package de.LiveTicker.Online;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.LiveTicker.dao.*;
import de.LiveTicker.entities.*;

@RunWith(Arquillian.class)
public class XbankDAOTest {


	@EJB
	LiveTickerDAOLocal dao;

	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/LiveTicker")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	/**
	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
	 */
	@Test
	public void test1() throws Exception {
		User emma = dao.findUserByName("emma");
		assert emma!=null : "Emma nicht gefunden.";
		assert emma.getPassword().equals("emma1") : "Emmas Passwort ist falsch.";
	}
	
	/**
	 * Testet, ob Sessions unterschiedliche IDs bekommen.
	 */
	@Test
	public void test2() throws Exception {
		User emma = dao.findUserByName("emma");
		int session1 = dao.createSession(emma);
		int session2 = dao.createSession(emma);
		assert session1 != session2 : "Session-IDs nicht unterschiedlich!";
	}
	
}












