package com.presentation.service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import atm.business.api.model.Customer;
import atm.business.api.services.BankServiceException;
import atm.business.api.services.CustomerService;
import fromBusinesTeam.JAXBContextFactory;
import fromBusinesTeam.StubFactory;
import fromBusinesTeam.TcpClient;

// TODO: Auto-generated Javadoc
/**
 * The Class BankSystemService.
 */
public class CustomerSystemService {

	private static StubFactory stubFactory;
	private static TcpClient tcpClient;

	/**
	 * Connect.
	 * 
	 * @return true, if successful
	 * @throws JAXBException
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static boolean connect() throws JAXBException, UnknownHostException,
			IOException {
		JAXBContext jaxb = JAXBContextFactory.createContext();
		tcpClient = new TcpClient("comm.staging.brokerlogic.com", 4242);
		stubFactory = new StubFactory(tcpClient, jaxb.createMarshaller(),
				jaxb.createUnmarshaller());
		return true;
	}

	/**
	 * Disconnect.
	 * 
	 * @return true, if successful
	 */
	public static void disconnect() {
		if (tcpClient != null)
			tcpClient.disconnect();
	}

	/**
	 * Determine if the connection already exists
	 * 
	 * @return
	 */
	public static boolean isClosed() {
		if (tcpClient != null)
			return tcpClient.isConnected();
		else
			return true;
	}

	public static List<Customer> getCustomerNames() throws BankServiceException {

		if (!isClosed()) {
			CustomerService service = stubFactory
					.createStub(CustomerService.class);
			return service.getCustomerNames();
		} else {
			throw new BankServiceException("problem getting customer names");
		}
	}

	public static Boolean updateCustomer(Customer customer)
			throws BankServiceException {

		if (!isClosed()) {
			CustomerService service = stubFactory
					.createStub(CustomerService.class);
			return service.updateCustomer(customer);
		} else {
			throw new BankServiceException("problem updating the customer");
		}
	}

	public static Integer createCustomer(Customer customer)
			throws BankServiceException {

		if (!isClosed()) {
			CustomerService service = stubFactory
					.createStub(CustomerService.class);
			return service.createCustomer(customer);
		} else {
			throw new BankServiceException("problem creating a customer");
		}
	}
}
