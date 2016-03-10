package fromBusinesTeam;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mwilson
 */
@XmlRootElement(name = "Exception")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExceptionContainer {

	@XmlElement
	private Class<? extends Exception> type;

	@XmlElement
	private String message;

	public ExceptionContainer() {
	}

	public ExceptionContainer(Exception e) {
		type = e.getClass();
		message = e.getMessage();
	}

	public Class<? extends Exception> getType() {
		return type;
	}

	public void setType(Class<? extends Exception> type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception toException() {
		try {
			return type.getConstructor(String.class).newInstance(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
