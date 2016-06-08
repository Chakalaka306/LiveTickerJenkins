package de.LiveTicker.Online;

import javax.jms.*;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class OutputRequesterBean {

	  @Resource(mappedName="java:/JmsXA")
	  private ConnectionFactory jmsFactory;
	  
	  @Resource(mappedName="java:/jms/queue/LiveTickerOutput")
	  private Queue outputQueue;
	  
	  /**
	   * Sends a Message with the letter text to the output queue,
	   * assuming that this causes the letter to be processed and printed.
	   * @param letter
	   */
	  public void printLetter(String letter) {
		try (JMSContext context = jmsFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)){
			TextMessage message = context.createTextMessage();
			message.setStringProperty("DocType", "Letter");
			message.setText(letter);
			context.createProducer().send(outputQueue, message);
		}
		catch (JMSException e) {
			throw new EJBException(e);
		}  
	  }
}
