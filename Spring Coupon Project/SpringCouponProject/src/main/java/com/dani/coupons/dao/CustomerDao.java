package com.dani.coupons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dani.coupons.Enums.ErrorType;
import com.dani.coupons.beans.Customer;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.utilities.DateUtils;
import com.dani.coupons.utilities.JdbcUtils;





@Repository
public class CustomerDao implements ICustomerDao {

	public void CustomerCoupon() {
		System.out.println("Hello");

	}

	public boolean login(String email, String password) throws ApplicationException {
			Collection<Customer> customers = getAllCustomers();
			try {
				for(Customer customer : customers) {
					if(customer.getEmail().equals(email)){
						if(customer.getPassword().equals(password)){
							
						}
						
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;
	}

	
	
	

	public void removeCustomer(long  customerID) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		//CompanyID is defined as a primary key and auto incremented
		String sqlStatement="DELETE FROM customers WHERE customerID = ?";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		preparedStatement.setLong(1,customerID);
	

		//Executing the update
		preparedStatement.executeUpdate();

		
		
		} catch (SQLException e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
		throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Failed to remove customer ",e);
			
		} 
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement);
		}
		

	}

	public void updateCustomer(Customer customer) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			//CompanyID is defined as a primary key and auto incremented
			String sqlStatement="UPDATE customers SET customer_name = ?, password = ?, email = ? WHERE customerID = ?";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setString(1,customer.getCustomer_name());
			preparedStatement.setString(2,customer.getPassword());
			preparedStatement.setString(3,customer.getEmail());
			preparedStatement.setLong(4,customer.getCustomerID());
			
			
			

			//Executing the update
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException(ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" update customer function has failed",e);
		} 
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	
	
	

	public void createCustomer(Customer customer) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		//CompanyID is defined as a primary key and auto incremented
		String sqlStatement="INSERT INTO customers (customer_name, password, email) VALUES(?,?,?)";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		//Replacing the question marks in the statement above with the relevant data
		preparedStatement.setString(1,customer.getCustomer_name());
		preparedStatement.setString(2,customer.getPassword());
		preparedStatement.setString(3,customer.getEmail());

		//Executing the update
		preparedStatement.executeUpdate();

	//	ResultSet resultSet = preparedStatement.getGeneratedKeys();
				return ;
		
		} catch (SQLException e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
		throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Create customer has failed ",e);
			
		} 
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	public Customer getCustomer(long customerID) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		Customer customer=new Customer();

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			String sqlStatement="SELECT * FROM customers WHERE customerID=?;";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setLong(1, customerID);

			//Executing the query and saving the DB response in the resultSet.
			result=preparedStatement.executeQuery();

			if (!result.next()) {
				return null;
			}
			customer=extractCustomerFromResultSet(result);

		} catch (SQLException e) {
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException(  ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" Get customer by ID has failed",e);
		}
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement, result);	
		}
		return customer;
	}

	public Collection<Customer> getAllCustomers() throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		List<Customer> customers = new ArrayList<Customer>();

		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		String sqlStatement="SELECT * FROM customers";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		

		//Executing the query and saving the DB response in the resultSet.
		result=preparedStatement.executeQuery();

		while(result.next()!=false) {
			Customer customer= extractCustomerFromResultSet(result);
			customers.add(customer);
		}
			if(customers.isEmpty()) {
				return null;
			}
		//if (!result.next()) {
		//return null;
		//}
	

		
		} catch (Exception e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
	throw new ApplicationException(  ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Get all customers has failed",e);
		}
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement, result); 
		}
		return customers;
		
	
	

		
		
	}

	
	public boolean isEmailExists(String email) throws ApplicationException {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
        ResultSet result =null;
		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		//CompanyID is defined as a primary key and auto incremented
		String sqlStatement="SELECT * FROM customers WHERE email = ?";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		preparedStatement.setString(1, email);
	

		//Executing the update
		result=preparedStatement.executeQuery();

		if(result.next()) {
			return true;
		}
		
		} catch (Exception e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
		throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Failed to find Email ",e);
			
		} 
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement,result);
		}
		
		
		return false;
	}
	
	

		
	

	public boolean isCustomerExistByID(long customerID) throws ApplicationException{
		//Turn on the connections
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			String sqlStatement="SELECT * FROM customers WHERE customerID=?;";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setLong(1,customerID);

			//Executing the query and saving the DB response in the resultSet.
			result=preparedStatement.executeQuery();

			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" Failed to get customer by ID",e);
		}
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement, result);
		}
		return false;
	}
	
	public boolean isCustomerExistByName(String customer_name) throws ApplicationException{
		//Turn on the connections
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			String sqlStatement="SELECT * FROM customers WHERE customer_name=?;";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setString(1,customer_name);

			//Executing the query and saving the DB response in the resultSet.
			result=preparedStatement.executeQuery();

			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" Failed to get customer by name",e);
		}
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement, result);
		}
		return false;
	}
	
	public long getIDByLogin(String companyName, String password) throws ApplicationException {
		//Turn on the connections
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			String sqlStatement="SELECT CompanyID FROM company WHERE companyName=? AND Password=?";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setString(1,companyName);
			preparedStatement.setString(2,password);

			//Executing the query and saving the DB response in the resultSet.
			result=preparedStatement.executeQuery();

			if (result.next()) {
				return result.getLong("CompanyID");
			}
		}
		catch (SQLException e) {
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" Failed to get company by ID",e);
		}
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement, result);	
		}
		return -1;
	}

	
	
	
	
	
	
	public static Customer extractCustomerFromResultSet(ResultSet result) throws SQLException{
		
		Customer customer = new Customer();
		
		customer.setCustomerID(result.getLong("customerID"));
		customer.setCustomer_name(result.getString("customer_name"));
		customer.setPassword(result.getString("password"));
		customer.setEmail(result.getString("email"));

		return customer;
	}

}

