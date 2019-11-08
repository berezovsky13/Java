package com.dani.coupons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dani.coupons.Enums.CouponType;
import com.dani.coupons.Enums.ErrorType;
import com.dani.coupons.beans.Company;
import com.dani.coupons.beans.Coupon;
import com.dani.coupons.exceptions.ApplicationException;
import com.dani.coupons.utilities.DateUtils;
import com.dani.coupons.utilities.JdbcUtils;
//import com.sun.xml.internal.ws.org.objectweb.asm.Type;
import java.sql.*;
import java.util.*;



@Repository
public class CouponDao  implements ICouponDao {

	public void createCoupon(Coupon coupon) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			//CompanyID is defined as a primary key and auto incremented
			String sqlStatement="INSERT INTO coupons (title,amount,price,start_date,end_date,message,image,type,companyID) VALUES(?,?,?,?,?,?,?,?,?)";

			//Combining between the syntax and our connection
			
			//preparedStatement=connection.prepareStatement(sqlStatement,preparedStatement.RETURN_GENERATED_KEYS);
			
			preparedStatement=connection.prepareStatement(sqlStatement);
			
			//Replacing the question marks in the statement above with the relevant data
			
			preparedStatement.setString(1, coupon.getTitle());
			preparedStatement.setInt(2,coupon.getAmount());
			preparedStatement.setDouble(3, coupon.getPrice());
			preparedStatement.setString(4,coupon.getStartDate());
			preparedStatement.setString(5, coupon.getEndDate());
			preparedStatement.setString(6,coupon.getMessage());
			preparedStatement.setString(7, coupon.getImage());
			preparedStatement.setString(8,coupon.getType().name());
			preparedStatement.setLong(9, coupon.getCompanyID());
			

			//Executing the update
			preparedStatement.executeUpdate();
			
			//ResultSet resultSet = preparedStatement.getGeneratedKeys();
			
//			if(resultSet.next()) {
//				return resultSet.getLong(1);
//			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" Create coupon has failed",e);
		} 
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement);
		}
		
		
	}
	

	public void updateCoupon(Coupon coupon) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();
		

			//Creating the SQL query
			//CompanyID is defined as a primary key and auto incremented
			
			String sqlStatement="UPDATE coupons SET  title = ?, start_date = ?,end_date = ?,amount = ?,price = ?,message = ?,image = ?,type = ?,companyID = ? WHERE couponID = ?  ";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setLong(1,coupon.getCouponID());
			preparedStatement.setString(2, coupon.getTitle());
			preparedStatement.setString(3,coupon.getStartDate());
			preparedStatement.setString(4, coupon.getEndDate());
			preparedStatement.setInt(5, coupon.getAmount());
			preparedStatement.setDouble(6, coupon.getPrice());
			preparedStatement.setString(7,coupon.getMessage());
			preparedStatement.setString(8, coupon.getImage());
			preparedStatement.setString(9,coupon.getType().name());
			preparedStatement.setLong(10, coupon.getCompanyID());

			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" Failed to update coupon ",e);
		} 
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	

	}

	public void removeCoupon(long couponID) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		//CompanyID is defined as a primary key and auto incremented
		String sqlStatement="DELETE FROM coupons WHERE couponID = ? ";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		preparedStatement.setLong(1,couponID);
	

		//Executing the update
		preparedStatement.executeUpdate();

		
		
		} catch (SQLException e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
		throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Failed to remove Coupon",e);
			
		} 
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement);
		}
		

	}

	
	
public void purchaseCoupon(long couponID,long customerID) throws ApplicationException  {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
      
		try {
		
			
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			//CompanyID is defined as a primary key and auto incremented
			String sqlStatement="INSERT INTO coupons (couponID,customerID) VALUES(?,?)";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setLong(1,couponID);
			preparedStatement.setLong(2, customerID);
			
			
			

			//Executing the update
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
         	throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" The Purchase of The Coupon has failed ",e);
		} 
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	
}

	public Collection<Coupon> getAllCouponsByType(CouponType type) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		List<Coupon> coupons = new ArrayList<Coupon>();

		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		String sqlStatement="SELECT * FROM coupons WHERE type = ? ";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		

		//Executing the query and saving the DB response in the resultSet.
		result=preparedStatement.executeQuery();

		while(result.next()!=false) {
			Coupon coupon= extractCouponFromResultSet(result);
			coupons.add(coupon);
		}
			if(coupons.isEmpty()) {
				return null;
			}
	//	if (!result.next()) {
		//return null;
		//}
	

		
		} catch (Exception e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
	  throw new ApplicationException(  ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Failde to get coupons by type ",e);
		}
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement, result); 
		}
		return coupons;
		
	}

	public Collection<Coupon> getAllCoupons() throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		List<Coupon> coupons = new ArrayList<Coupon>();

		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		String sqlStatement="SELECT * FROM coupons";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		

		//Executing the query and saving the DB response in the resultSet.
		result=preparedStatement.executeQuery();

		while(result.next()!=false) {
			Coupon coupon= extractCouponFromResultSet(result);
			coupons.add(coupon);
		}
			if(coupons.isEmpty()) {
				return null;
			}
	//	if (!result.next()) {
		//return null;
		//}
	

		
		} catch (Exception e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
	  throw new ApplicationException(  ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Failed to get all coupons ",e);
		}
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement, result); 
		}
		return coupons;
		
	}

	public Collection<Coupon> getAllPurchasedCouponsByType(CouponType type) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		List<Coupon> coupons = new ArrayList<Coupon>();

		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		String sqlStatement="SELECT * FROM coupons";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		

		//Executing the query and saving the DB response in the resultSet.
		result=preparedStatement.executeQuery();

		while(result.next()!=false) {
			Coupon coupon= extractCouponFromResultSet(result);
			coupons.add(coupon);
		}
			if(coupons.isEmpty()) {
				return null;
			}
		if (!result.next()) {
		return null;
		}
	

		
		} catch (Exception e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
	throw new ApplicationException(  ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Failed to get purchased coupons by type ",e);
		}
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement, result); 
		}
		return coupons;
		
	}

	
	public boolean isCouponExistsByTitle(String title) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
       ResultSet result =null;
		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		//CompanyID is defined as a primary key and auto incremented
		String sqlStatement="SELECT * FROM coupons WHERE title = ? ";

//		Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

        preparedStatement.setString(1,title);
	

//		Executing the update
		result=preparedStatement.executeQuery();

	if(result.next()) {
			return true;
		}
		
		} catch (Exception e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
		throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
		+" Failed to find coupon by title",e);
		
		} 
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement,result);
		}
		
		
		return false;
		
	}

	public boolean isCouponExists(long couponID) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			String sqlStatement="SELECT * FROM coupons WHERE couponID=?;";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setLong(1,couponID);

			//Executing the query and saving the DB response in the resultSet.
			result=preparedStatement.executeQuery();

			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" Failed to get coupon by ID",e);
		}
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement, result);
		}
		return false;
	}
	

      
	
	
	

	
	


	
	
	
	
	
	
	public static Coupon extractCouponFromResultSet(ResultSet result) throws SQLException{
		Coupon coupon = new Coupon();
		
		coupon.setCouponID(result.getLong("couponID"));
		coupon.setTitle(result.getString("title"));
		coupon.setAmount(result.getInt("amount"));
		coupon.setPrice(result.getFloat("price"));
		coupon.setStartDate(result.getString("start_date"));
		coupon.setEndDate(result.getString("end_date"));
		coupon.setMessage(result.getString("message"));
		coupon.setImage(result.getString("image"));
		coupon.setCompanyID(result.getLong("companyID"));
		
		
		
	
	
	return coupon;
	}


	





	public void removeOldCoupon(String date) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();

		//Creating the SQL query
		//CompanyID is defined as a primary key and auto incremented
		String sqlStatement="DELETE FROM coupons WHERE end_date < date";

		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);

		preparedStatement.setString(1,date);
	

		//Executing the update
		preparedStatement.executeUpdate();

		
		
		} catch (SQLException e) {
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
		e.printStackTrace();
			
		} 
		finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement);
		}
		

		
	}




	


	public Coupon getCouponByCouponID(long couponID) throws ApplicationException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		Coupon coupon=new Coupon();

		try {
			//Establish a connection from the connection manager
			connection=JdbcUtils.getConnection();

			//Creating the SQL query
			String sqlStatement="SELECT * FROM coupons WHERE couponID=?";

			//Combining between the syntax and our connection
			preparedStatement=connection.prepareStatement(sqlStatement);

			//Replacing the question marks in the statement above with the relevant data
			preparedStatement.setLong(1,couponID);

			//Executing the query and saving the DB response in the resultSet.
			result=preparedStatement.executeQuery();

			if (!result.next()) {
				return null;
			}
			coupon=extractCouponFromResultSet(result );


		} catch (Exception e) {
			//If there was an exception in the "try" block above, it is caught here and notifies a level above.
			throw new ApplicationException( ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime()
					+" Unabled to get the coupon with it's ID" , e);
		}
		finally {
			//Closing the resources
			JdbcUtils.closeResources(connection, preparedStatement, result); 
		}
		return coupon;
	}


	

public Collection<Coupon> getAllPurchasedCoupons() throws ApplicationException {
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet result=null;
	List<Coupon> coupons=new ArrayList<Coupon>();

	try {
		//Establish a connection from the connection manager
		connection=JdbcUtils.getConnection();
		//Creating the SQL query
		String sqlStatement="SELECT couponID  FROM  couponsproject.customerscoupons  ";
		//Combining between the syntax and our connection
		preparedStatement=connection.prepareStatement(sqlStatement);
		//Executing the query and saving the DB response in the resultSet.
		result=preparedStatement.executeQuery();

		// Extract coupons from the result set and add to our array list.
		while(result.next()!=false ) {
			
		//	Coupon coupon=extractCouponFromResultSet(result);
			
			coupons.add(getCouponByCouponID(result.getLong("couponID")));
		}
		if(coupons.isEmpty()) {
			return null;
		}
		return coupons;

	}
	catch (SQLException e) {
		e.printStackTrace();
		//If there was an exception in the "try" block above, it is caught here and notifies a level above.
		throw new ApplicationException(ErrorType.GENERAL_ERROR ,DateUtils.getCurrentDateAndTime()+ "coupons does not exist",e );
	}
	finally {
		//Closing the resources
		JdbcUtils.closeResources(connection, preparedStatement, result); 
	}
}



	





	
	
}

