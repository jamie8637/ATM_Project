package atm.business.server.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import atm.business.api.model.Customer;
import atm.business.api.services.BankServiceException;
import atm.business.api.services.CustomerService;
import data.CustomerDAO;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDao;
	private Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	public CustomerDAO getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getCustomerNames() throws BankServiceException {
		try {
			return customerDao.getCustomerNames();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("SQL Exception Occurred "
					+ e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred "
					+ e.getMessage());
		}
	}

	@Override
	public Integer createCustomer(Customer customer)
			throws BankServiceException {
		try {
			return customerDao.createCustomer(customer);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("SQL Exception Occurred "
					+ e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred "
					+ e.getMessage());
		}
	}

	@Override
	public Boolean updateCustomer(Customer customer)
			throws BankServiceException {
		try {
			return customerDao.updateCustomer(customer);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("SQL Exception Occurred "
					+ e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred "
					+ e.getMessage());
		}
	}

}
