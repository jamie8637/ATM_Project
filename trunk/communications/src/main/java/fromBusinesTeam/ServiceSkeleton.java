package fromBusinesTeam;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


/**
 * @author mwilson
 */
public class ServiceSkeleton {

	private Object service;

	public ServiceSkeleton(Object service) {
		this.service = service;
	}

	public ServiceResponse processRequest(ServiceRequest request)
			throws NoSuchMethodException, SecurityException, Exception {

		ServiceResponse response = new ServiceResponse();

		Method method = service.getClass().getMethod(request.getMethodName(),
				request.getParamTypes());

		if (method == null) {
			throw new NullPointerException("No method with name: "
					+ request.getMethodName() + " and parameter types: "
					+ Arrays.asList(request.getParamTypes()));
		}

		try {
			response.setResult(method.invoke(service, request.getParams()));
		} catch (Exception e) {
			List<Class<?>> exceptionTypes = Arrays.asList(method
					.getExceptionTypes());

			if (exceptionTypes.contains(e.getClass())) {
				response.setResult(e);
			} else if (e.getCause() != null
					&& exceptionTypes.contains(e.getCause().getClass())) {
				response.setResult(e.getCause());
			} else {
				throw e;
			}
		}

		return response;

	}

}
