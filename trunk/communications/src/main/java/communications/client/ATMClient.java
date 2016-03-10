package communications.client;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import communications.Session;

/**
 * This class interfaces with the ATM side of the banking system. It attempts to communicate via TCP to the banking subsystem.
 * @author Adrian Rhodd
 */
public class ATMClient extends Session{
	
	private JAXBContext jaxbContext;
	private Marshaller beanMarshaller;
	private Unmarshaller beanUnmarshaller;
	private TransactionMessageBean request;
	static Logger logger = Logger.getLogger("org.apache.log4j.PatternLayout");
	
	
	public ATMClient(TransactionMessageBean msgBean){
		request = msgBean;
		
		try{
			jaxbContext = JAXBContext.newInstance(TransactionMessageBean.class);
			beanMarshaller = jaxbContext.createMarshaller();
			beanUnmarshaller = jaxbContext.createUnmarshaller();
		}catch (JAXBException e) {
			logger.error("JAXBException Exception: Class:ATMClient constructor");
			System.err.println(e);
		}	
	}
	
	public ATMClient(){
		
		try{
			jaxbContext = JAXBContext.newInstance(TransactionMessageBean.class);
			beanMarshaller = jaxbContext.createMarshaller();
			beanUnmarshaller = jaxbContext.createUnmarshaller();
		}catch(JAXBException e){
			logger.error("JAXBException Exception: Class:ATMClient noargs constructor");
 			System.err.println(e);
		}
	}
	
	/**
	 * This method will do the Java -> XML conversion and then write it to the OutputStream.
	 * @param request - TransactionMessageBean
	 * @see TransactionMessageBean
	 */
	public void sendRequest(TransactionMessageBean request){
		StringWriter msgOut = new StringWriter();
			
			try{
				beanMarshaller.marshal(request, msgOut);
				super.write(msgOut.toString());
			}catch (JAXBException e) {
				logger.error("JAXBException Exception: Class:ATMClient sendRequest");
				e.printStackTrace();
			}
	}
	
	/**
	 * This method will do the Java -> XML conversion and then write it to the OutputStream.
	 */
	public void sendRequest(){
		StringWriter msgOut = new StringWriter();
			
			try{
				beanMarshaller.marshal(request, msgOut);
				super.write(msgOut.toString());
			}catch (JAXBException e) {
				logger.error("JAXBException Exception: Class:ATMClient noargs sendRequest");
				System.err.println(e);;
			}
	}
	
	
	/**
	 * This method will read in from the InputStream and do the XML -> Java conversion. 
	 * @return TransactionMessageBean
	 * @see TransactionMessageBean
	 */
	public TransactionMessageBean getResponse(){
			String msgIn = super.read();
			TransactionMessageBean response = null;
			
			try{
				response = (TransactionMessageBean) beanUnmarshaller.unmarshal(new StringReader(msgIn));
			}catch (JAXBException e) {
				logger.error("JAXBException Exception: Class:ATMClient getResponse");
				System.err.println(e);
			}
		return response;
	}
}
