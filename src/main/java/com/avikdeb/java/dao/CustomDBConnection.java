package com.avikdeb.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This is a singleton class - to be used to provide any DB connection
public class CustomDBConnection {
	
	//Connection parameters
	private static final String DB_DRIVER = "org.h2.driver";
	private static final String DB_CONNECTION = "jdbc:h2:C:/javalabdata";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";
	
	//Private constructor - to be called within getInstance() method
	private CustomDBConnection() {
		
	}
	
	public static CustomDBConnection getInstance() {
		CustomDBConnection instance = new CustomDBConnection();
		return instance;
	}
	
	public static Connection getConnection() {
		
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
	
}
