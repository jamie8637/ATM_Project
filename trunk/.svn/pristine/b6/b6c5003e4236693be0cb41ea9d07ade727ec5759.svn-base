package data;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import atm.business.api.model.Customer;

/**
 * 
 * @author Dave Lawnicki - 10/1/2013 Data access interface begins here.
 */
public interface CustomerDAO {
	List<Customer> getCustomerNames() throws SQLException, Exception;

	public Integer createCustomer(Customer customer) throws SQLException,
			Exception;

	public Boolean updateCustomer(Customer customer) throws SQLException,
			Exception;
}
