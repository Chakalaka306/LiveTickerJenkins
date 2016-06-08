package de.LiveTicker.Online;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.LiveTicker.dto.*;

@RunWith(Arquillian.class)
public class RegisterUserTest {

	@EJB
	LiveTickerOnlineIntegration bean;

	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/LiveTicker")
               .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")               
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }

	@Test
	/**
	 * Prueft, ob ein neuer Kunde erfolgreich registriert werden kann.
	 */
	public void testRegistration() throws Exception {
	    UserLoginResponse loginResponse = bean.registerNewUser("peter", "email@test.de", "1234");
	    assertEquals(loginResponse.getReturnCode(), 0);
	 	
	    int sessionId = loginResponse.getSessionId();
		bean.logout(sessionId);
	}

}
