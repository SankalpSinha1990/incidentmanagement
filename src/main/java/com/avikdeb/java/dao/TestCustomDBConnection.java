package com.avikdeb.java.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestCustomDBConnection {

	
	public static void main(String[] args) {
		
		Connection conn = CustomDBConnection.getConnection();
		if(conn!=null) {
			System.out.println("Connection to H2 Database is successful");
		}
		
		try{
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
