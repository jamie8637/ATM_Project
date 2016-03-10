package fromBusinesTeam;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * @author mwilson
 */
public class StubInvocationHandler implements InvocationHandler {

	private String serviceName;
	private TcpClient client;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public StubInvocationHandler(String serviceName, TcpClient client,
			Marshaller marshaller, Unmarshaller unmarshaller) {
		this.serviceName = serviceName;
		this.client = client;
		this.marshaller = marshaller;
		this.unmarshaller = unmarshaller;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		ServiceRequest requestObject = createRequest(method, args);
		String requestString = marshalRequest(requestObject);
		String responseString = client.submitRequest(requestString);
		ServiceResponse responseObject = unmarshalResponse(responseString);

		return responseObject.getResult();
	}

	private ServiceRequest createRequest(Method method, Object[] args) {
		ServiceRequest request = new ServiceRequest();

		request.setServiceName(serviceName);
		request.setMethodName(method.getName());
		request.setParams(args);

		return request;
	}

	private String marshalRequest(ServiceRequest request) throws JAXBException {
		StringWriter writer = new StringWriter();
		marshaller.marshal(request, writer);
		return writer.toString();
	}

	private ServiceResponse unmarshalResponse(String responseString)
			throws JAXBException {
		return (ServiceResponse) unmarshaller.unmarshal(new StringReader(
				responseString));
	}

}
