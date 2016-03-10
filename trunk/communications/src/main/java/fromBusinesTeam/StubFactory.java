package fromBusinesTeam;

import java.lang.reflect.Proxy;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author mwilson
 */
public class StubFactory {

	private TcpClient client;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public StubFactory(TcpClient client, Marshaller marshaller,
			Unmarshaller unmarshaller) {
		this.client = client;
		this.marshaller = marshaller;
		this.unmarshaller = unmarshaller;
	}

	@SuppressWarnings("unchecked")
	public <ServiceType> ServiceType createStub(Class<ServiceType> serviceType) {
		return (ServiceType) Proxy.newProxyInstance(serviceType
				.getClassLoader(), new Class[] { serviceType },
				new StubInvocationHandler(serviceType.getSimpleName(), client,
						marshaller, unmarshaller));
	}
}
