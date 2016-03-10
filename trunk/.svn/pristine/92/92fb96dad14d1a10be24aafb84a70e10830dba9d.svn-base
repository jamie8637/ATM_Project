package fromBusinesTeam;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mwilson
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceResponse {

	@XmlElement
	private Object result;

	public ServiceResponse() {

	}

	public Object getResult() throws Exception {
		if (result instanceof ExceptionContainer) {
			throw ((ExceptionContainer) result).toException();
		}
		return result;
	}

	public void setResult(Object result) {
		if (result instanceof Exception) {
			result = new ExceptionContainer((Exception) result);
		}
		this.result = result;
	}

}
