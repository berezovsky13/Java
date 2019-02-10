package com.dani.coupons.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
	static {
		try { ///CouponsProjectWeb/WebContent/WEB-INF/lib/mysql-connector-java-8.0.12.jar
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coupons_project?useSSL=false&serverTimezone=GMT", "root", "1234");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/couponsproject?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root",
				"Da0505719903");
		return connection;
	}

	public static void closeResources(Connection connection, PreparedStatement preparedStatement) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		closeResources(connection, preparedStatement);
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

