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
public class ServiceRequest {

	@XmlElement
	private String serviceName;

	@XmlElement
	private String methodName;

	@XmlElement
	private Object[] params;

	public ServiceRequest() {

	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public Class<?>[] getParamTypes() {

		if (params == null || params.length == 0) {
			return new Class<?>[0];
		}

		Class<?>[] paramTypes = new Class<?>[params.length];

		for (int i = 0; i < params.length; i++) {
			paramTypes[i] = params[i].getClass();
		}

		return paramTypes;

	}

}
