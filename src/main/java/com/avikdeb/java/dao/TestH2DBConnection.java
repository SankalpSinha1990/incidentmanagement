package com.avikdeb.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.h2.tools.DeleteDbFiles;

public class TestH2DBConnection {

	//Connection parameters
	private static final String DB_DRIVER = "org.h2.driver";
	private static final String DB_CONNECTION = "jdbc:h2:C:/javalabdata";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";
	
	//H2 SQL Prepared Statement example
	private static void insertWithPreparedStatement() throws SQLException {
		
		Connection connection = getDBConnection();
		
		PreparedStatement createPreparedStatement = null;
		PreparedStatement insertPreparedStatement = null;
		PreparedStatement selectPreparedStatement = null;
		
		String createQuery = "CREATE TABLE PERSON(id int primary key, name varchar(255))";
		String insertQuery = "INSERT INTO PERSON "+"(id, name) values "+"(?,?)";
		String selectQuery = "SELECT * FROM PERSON";
		
		try {
			
			connection.setAutoCommit(false);
			
			createPreparedStatement = connection.prepareStatement(createQuery);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			
			insertPreparedStatement = connection.prepareStatement(insertQuery);
			insertPreparedStatement.setInt(1, 1);
			insertPreparedStatement.setString(2, "Avik");
			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();
			
			selectPreparedStatement = connection.prepareStatement(selectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			System.out.println("H2 Database inserted through Prepared Statement");
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt(1)+" Name: "+rs.getString("name"));
			}
			selectPreparedStatement.close();
			connection.commit();
			
		} catch(SQLException e) {
			
			System.out.println("Exception Message "+ e.getLocalizedMessage());
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			
			connection.close();
		}
	}

	//H2 SQL Statement example
	private static void insertWithStatement() throws SQLException {
		
		Connection connection = getDBConnection();
		Statement stmt = null;
		
		try {
			
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			
			stmt.execute("CREATE TABLE PERSON (id int primary key, name varchar(255))");
			stmt.execute("INSERT INTO PERSON (id, name) VALUES (1, 'Avik')");
			stmt.execute("INSERT INTO PERSON (id, name) VALUES (2, 'Gurinder')");
			stmt.execute("INSERT INTO PERSON (id, name) VALUES (3, 'Ankit')");
			
			ResultSet rs = stmt.executeQuery("select * from PERSON");
			System.out.println("H2 Database inserted through Statement");
			
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt(1)+" Name: "+rs.getString("name"));
			}
			stmt.close();
			connection.commit();
			
		} catch(SQLException e) {
			
			System.out.println("Exception Message "+ e.getLocalizedMessage());
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			connection.close();
		}
		
	}
	
	private static Connection getDBConnection() {
		
		Connection dbConnection = null;
		
		try {
			
			Class.forName(DB_DRIVER);
			
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dbConnection;
	}
	
	public static void main(String[] args) throws Exception {
		
		try {
			
			//delete the H2 database named 'javalabdata' in the directory
			//DeleteDbFiles.execute("C:", "javalabdata", true);
			insertWithPreparedStatement();
			//DeleteDbFiles.execute("C:", "javalabdata", true);
			insertWithStatement();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
