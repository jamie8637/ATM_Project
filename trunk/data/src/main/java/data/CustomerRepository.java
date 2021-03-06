package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import atm.business.api.model.Customer;

public class CustomerRepository implements CustomerDAO {

	/*
	 * Hold an instance of Repository as a singleton.
	 */
	private static CustomerRepository instance = new CustomerRepository();

	/**
	 * The Repository class is intended to be a singleton. As such, the
	 * constructor is private.
	 */
	private CustomerRepository() {

	}

	/*
	 * 
	 */
	public static CustomerRepository getInstance() {
		return instance;
	}

	@Override
	public List<Customer> getCustomerNames() throws SQLException, Exception {
		Connection connection = DataUtils.connect();
		List<Map<String, Object>> result = DataUtils
				.selectData(
						"SELECT customerid, CustomerFirst, CustomerLast FROM customer ORDER BY customerid",
						connection);
		connection.close();

		List<Customer> customers = new ArrayList<>();
		for (Map<String, Object> row : result) {
			Customer customer = new Customer();
			customer.setCustomerId((String) row.get("customerid"));
			customer.setCustomerFirst((String) row.get("CustomerFirst"));
			customer.setCustomerFirst((String) row.get("CustomerLast"));
			customers.add(customer);
		}

		return customers;
	}

	public Integer createCustomer(Customer customer) throws SQLException,
			Exception {

		Integer customerId = 0;

		try {
			Connection connection = DataUtils.connect();

			// use the customer object getters to build the query
			
			String createCustomer = "INSERT INTO  `ATMDB`.`customer` ("
					+ "`CustomerId` ," + "`CustomerFirst` ,"
					+ "`CustomerLast` ," + "`Username` ," + "`Password` ,"
					+ "`Address` ," + "`City` ," + "`State` ," + "`Postal` ,"
					+ "`Phone` ," + "`Email`" + ")" + " VALUES (" + "NULL, '"
					+ customer.getCustomerFirst() + "', '"
					+ customer.getCustomerLast() + "', '"
					+ customer.getUsername() + "', '" + customer.getPassword()
					+ "', '" + customer.getAddress() + "', '"
					+ customer.getCity() + "', '" + customer.getState()
					+ "', '" + customer.getPostal() + "', '"
					+ customer.getPhone() + "', '" + customer.getEmail()
					+ "');";
			customerId = DataUtils.processStatementGetId(createCustomer,
					connection, false);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			customerId = 0;
		}

		// should return the customerId of the new customer;
		return customerId;
	}

	public Boolean updateCustomer(Customer customer) throws SQLException,
			Exception {

		Boolean updateSuccess = false;

		try {
			Connection connection = DataUtils.connect();
			// use the customer object getters to build the query
			String updateCustomer = "UPDATE `customer` ("
					+ "`CustomerFirst` = '"
					+ customer.getCustomerFirst()
					+ "', '"
					+ "`CustomerLast` = '"
					+ customer.getCustomerLast()
					+ "', '"
					+ "`Username` = '"
					+ customer.getUsername()
					+ "', '"
					+ "`Password` = '"
					+ customer.getPassword()
					+ "', '"
					+ "`Address` = '"
					+ customer.getAddress()
					+ "', '"
					+ "`City` = '"
					+ customer.getCity()
					+ "', '"
					+ "`State` = '"
					+ customer.getState()
					+ "', '"
					+ "`Postal` = '"
					+ customer.getPostal()
					+ "', '"
					+ "`Phone` = '"
					+ customer.getPhone()
					+ "', '"
					+ "`Email` = '"
					+ customer.getEmail()
					+ "'"
					+ " WHERE `CustomerId = " + customer.getCustomerId() + ";";

			int rowsAffected = DataUtils.processStatement(updateCustomer,
					connection, false);
			if (rowsAffected == 1) {
				updateSuccess = true;
			} else {
				updateSuccess = false;
				connection.rollback();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			updateSuccess = false;
		}

		// should return a boolean value representing the update
		return updateSuccess;
	}

}
