package com.dani.coupons.dao;



	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dani.coupons.Enums.ErrorType;
	import com.dani.coupons.beans.Company;
	import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.utilities.DateUtils;
import com.dani.coupons.utilities.JdbcUtils;
    @Repository
	public class CompanyDao implements ICompanyDao  {

    	
    	@PersistenceContext(unitName="coupons__project")
    	private EntityManager entityManager;
    	
		public CompanyDao(){
		}

		
		
		
		

		public void createCompany(Company company) throws ApplicationException {
			//Turn on the connections
			Connection connection=null;
			PreparedStatement preparedStatement=null;

			try {
				//Establish a connection from the connection manager
				connection=JdbcUtils.getConnection();

				//Creating the SQL query
				//CompanyID is defined as a primary key and auto incremented
				String sqlStatement="INSERT INTO companies (company_name, password, email) VALUES(?,?,?)";

				//Combining between the syntax and our connection
				preparedStatement=connection.prepareStatement(sqlStatement);

				//Replacing the question marks in the statement above with the relevant data
				preparedStatement.setString(1,company.getCompany_name());
				preparedStatement.setString(2,company.getPassword());
				preparedStatement.setString(3,company.getEmail());

				//Executing the update
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				//If there was an exception in the "try" block above, it is caught here and notifies a level above.
				throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
						+" Create company failed" , e);
			} 
			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement);
			}

		}





		//Turn on the connections
		public Company getCompanyByCompanyID(long companyID) throws ApplicationException {
			//Turn on the connections
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet result=null;
			Company company=new Company();

			try {
				//Establish a connection from the connection manager
				connection=JdbcUtils.getConnection();

				//Creating the SQL query
				String sqlStatement="SELECT * FROM companies WHERE companyID=?";

				//Combining between the syntax and our connection
				preparedStatement=connection.prepareStatement(sqlStatement);

				//Replacing the question marks in the statement above with the relevant data
				preparedStatement.setLong(1,companyID);

				//Executing the query and saving the DB response in the resultSet.
				result=preparedStatement.executeQuery();

				if (!result.next()) {
					return null;
				}
				company=extractCompanyFromResultSet(result );


			} catch (Exception e) {
				//If there was an exception in the "try" block above, it is caught here and notifies a level above.
				throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
						+" Unabled to get the company with it's ID" , e);
			}
			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement, result); 
			}
			return company;
		}
//
//
//
//
//
//
//
//
//
		public void updateCompany(Company company) throws ApplicationException{
			// TODO Auto-generated method stub
			Connection connection=null;
			PreparedStatement preparedStatement=null;

			try {
				//Establish a connection from the connection manager
				connection=JdbcUtils.getConnection();

				//Creating the SQL query
				//CompanyID is defined as a primary key and auto incremented
				String sqlStatement="UPDATE companies SET company_name = ?, password = ?, email = ? WHERE companyID = ?";

				//Combining between the syntax and our connection
				preparedStatement=connection.prepareStatement(sqlStatement);

				//Replacing the question marks in the statement above with the relevant data
				preparedStatement.setString(1,company.getCompany_name());
				preparedStatement.setString(2,company.getPassword());
				preparedStatement.setString(3,company.getEmail());
				preparedStatement.setLong(4,company.getCompanyID());




				//Executing the update
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				
				//If there was an exception in the "try" block above, it is caught here and notifies a level above.
							throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
								+" Failed  to update company",e);
			} 
			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement);
			}
		}


		public void removeCompany(long companyID)  throws ApplicationException{

			Connection connection=null;
			PreparedStatement preparedStatement=null;

			try {
				//Establish a connection from the connection manager
				connection=JdbcUtils.getConnection();

				//Creating the SQL query
				//CompanyID is defined as a primary key and auto incremented
				String sqlStatement="DELETE FROM companies WHERE companyID =?";

				//Combining between the syntax and our connection
				preparedStatement=connection.prepareStatement(sqlStatement);

				preparedStatement.setLong(1,companyID);


				//Executing the update
				preparedStatement.executeUpdate();



			} catch (SQLException e) {
				//If there was an exception in the "try" block above, it is caught here and notifies a level above.
				throw new ApplicationException(ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
						+" Failed to remove company" , e);
			} 

			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement);
			}

		}




		



		public Collection<Company> getAllCompanies()  throws ApplicationException{
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet result=null;
			List<Company> companies = new ArrayList<Company>();

			try {
				//Establish a connection from the connection manager
				connection=JdbcUtils.getConnection();

				//Creating the SQL query
				String sqlStatement="SELECT * FROM couponsproject.companies";

				//Combining between the syntax and our connection
				preparedStatement=connection.prepareStatement(sqlStatement);



				//Executing the query and saving the DB response in the resultSet.
				result=preparedStatement.executeQuery();

				while(result.next()!=false) {
					//Company company= extractCompanyFromResultSet(result);
					companies.add(extractCompanyFromResultSet(result));
				}
				if(companies.isEmpty()) {
					return null;
				}
			/*	if (!result.next()) {
					return null;
				} */
			} catch (Exception e) {
				//If there was an exception in the "try" block above, it is caught here and notifies a level above.
				throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
						+"Failed to get all the companies" , e);
			}
			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement, result); 
			}
			return companies;

		}


		

		public	Company getCompanyByCompanyEmail(String email) throws ApplicationException {
			//Turn on the connections
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet result=null;
			//Company company=new Company();

			try {
				//Establish a connection from the connection manager
				connection=(Connection) JdbcUtils.getConnection();

				//Creating the SQL query
				String sqlStatement="SELECT * FROM companies WHERE email=?";

				//Combining between the syntax and our connection
				preparedStatement=((java.sql.Connection) connection).prepareStatement(sqlStatement);

				//Replacing the question marks in the statement above with the relevant data
				preparedStatement.setString(1, email);

				//Executing the query and saving the DB response in the resultSet.
				result=preparedStatement.executeQuery();

				if (result.next()) {
					Company company = extractCompanyFromResultSet(result);
					return company;
				}


			} catch (Exception e) {
				//If there was an exception in the "try" block above, it is caught here and notifies a level above.
				throw new ApplicationException(ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
						+" Failed to get company by email" , e);
			}
			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement, result); 
			}
			return null;
		}
		
		public boolean login(String email, String password)  throws ApplicationException{
			Collection<Company> companies = getAllCompanies();
			try {
				for(Company company : companies) {
					if(company.getEmail().equals(email)){
						if(company.getPassword().equals(password)){

						}

					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		
		
		public static Company extractCompanyFromResultSet(ResultSet result) throws SQLException{
			Company company = new Company();

			try {
				company.setCompanyID(result.getLong("companyID"));
				company.setCompany_name(result.getString("company_name"));
				company.setPassword(result.getString("password"));
				company.setEmail(result.getString("email"));
			}catch (Exception e) {
				e.printStackTrace();
			}


			return company;

		}






		


	


		public boolean isCompanyExistByName(String company_name) throws ApplicationException {
		
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet result=null;

			try {
				//Establish a connection from the connection manager
				connection=JdbcUtils.getConnection();

				//Creating the SQL query
				String sqlStatement="SELECT * FROM companies WHERE company_name=?";

				//Combining between the syntax and our connection
				preparedStatement=connection.prepareStatement(sqlStatement);

				//Replacing the question marks in the statement above with the relevant data
				preparedStatement.setString(1,company_name);

				//Executing the query and saving the DB response in the resultSet.
				result=preparedStatement.executeQuery();

				if (result.next()) {
					return true;
				}

			} catch (SQLException e) {
				//If there was an exception in the "try" block above, it is caught here and notifies a level above.
				throw new ApplicationException(ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
						+" Failed to get company by it's name" , e);
			}
			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement, result);
			}
			return false;
		}
		




		


		
		


		public boolean isCompanyExistsByCompanyID(long companyID) throws ApplicationException {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet result=null;

			try {
				//Establish a connection from the connection manager
				connection=JdbcUtils.getConnection();

				//Creating the SQL query
				String sqlStatement="SELECT * FROM companies WHERE companyID=?;";

				//Combining between the syntax and our connection
				preparedStatement=connection.prepareStatement(sqlStatement);

				//Replacing the question marks in the statement above with the relevant data
				preparedStatement.setLong(1,companyID);

				//Executing the query and saving the DB response in the resultSet.
				result=preparedStatement.executeQuery();

				if (result.next()) {
					return true;
				}

			} catch (SQLException e) {
				//If there was an exception in the "try" block above, it is caught here and notifies a level above.
				throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
						+" Failed to get company by ID",e);
			}
			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement, result);
			}
			return false;
		}


		public long getIDByLogin(String company_name, String password) throws ApplicationException {
			//Turn on the connections
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet result=null;

			try {
				//Establish a connection from the connection manager
				connection=JdbcUtils.getConnection();

				//Creating the SQL query
				String sqlStatement="SELECT companyID FROM companies WHERE company_name=? AND password=?";

				//Combining between the syntax and our connection
				preparedStatement=connection.prepareStatement(sqlStatement);

				//Replacing the question marks in the statement above with the relevant data
				preparedStatement.setString(1,company_name);
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
						+" Failed to find ID by login ",e);
			}
			finally {
				//Closing the resources
				JdbcUtils.closeResources(connection, preparedStatement, result);	
			}
			return -1;
		}
		
		
		
		


	
		






	}

	
	
	

