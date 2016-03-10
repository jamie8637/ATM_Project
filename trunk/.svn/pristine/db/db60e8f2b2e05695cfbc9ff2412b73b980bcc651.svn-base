package fromBusinesTeam;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * @author mwilson
 */
public class ServiceInvokingRequestProcessor implements RequestProcessor {

	private Map<String, ServiceSkeleton> serviceSkeletonsByName = new HashMap<String, ServiceSkeleton>();
	private Unmarshaller unmarshaller;
	private Marshaller marshaller;

	public ServiceInvokingRequestProcessor(Marshaller marshaller,
			Unmarshaller unmarshaller) {
		this.marshaller = marshaller;
		this.unmarshaller = unmarshaller;
	}

	public String createResponse(String request) {

		StringWriter writer = new StringWriter();

		try {
			ServiceRequest serviceRequest = parseRequest(request);

			ServiceSkeleton skeleton = serviceSkeletonsByName
					.get(serviceRequest.getServiceName());

			if (skeleton != null) {
				ServiceResponse serviceResponse = skeleton
						.processRequest(serviceRequest);
				marshaller.marshal(serviceResponse, writer);
			} else {
				System.err.println("invalid service name: "
						+ serviceRequest.getServiceName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return writer.toString();

	}

	private ServiceRequest parseRequest(String request) throws JAXBException {
		return (ServiceRequest) unmarshaller
				.unmarshal(new StringReader(request));
	}

	public void registerService(String serviceName, Object service) {
		serviceSkeletonsByName.put(serviceName, new ServiceSkeleton(service));
	}

}