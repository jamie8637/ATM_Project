package atm.business.api.services;

import java.util.List;

import atm.business.api.model.Customer;

public interface CustomerService {

	/**
	 * Returns a list of Customer objects populated with ids and names.
	 * 
	 * @return
	 * @throws BankServiceException
	 */
	List<Customer> getCustomerNames() throws BankServiceException;

	Integer createCustomer(Customer customer) throws BankServiceException;

	Boolean updateCustomer(Customer customer) throws BankServiceException;
}
