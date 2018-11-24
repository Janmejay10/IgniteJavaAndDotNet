package com.bizruntime.IgniteDay3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_DEMO {
	public static void main(String arg[])
	{
	// Register JDBC driver
	
	// Populate City table
	try 
	{
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

		// Open JDBC connection
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
		PreparedStatement stmt =conn.prepareStatement("INSERT INTO City11 (id, Name) VALUES (?, ?)" );
		 
		
	    stmt.setLong(1, 19L);
	    stmt.setString(2, "Sainik farm");
	    stmt.executeUpdate();

	    stmt.setLong(1, 20L);
	    stmt.setString(2, "Aqua City");
	    stmt.executeUpdate();

	    stmt.setLong(1, 21L);
	    stmt.setString(2, "Green Apartments");
	    stmt.executeUpdate();
	    
	    
	    stmt.setLong(1, 22L);
	    stmt.setString(2, "John Doe");
	    stmt.setLong(3, 3L);
	    stmt.executeUpdate();
	    
	    stmt =conn.prepareStatement("INSERT INTO Person11 (id, name, city_id) VALUES (?, ?, ?)");

	    stmt.setLong(1, 5L);
	    stmt.setString(2, "Janmejay");
	    stmt.setLong(3, 2L);
	    stmt.executeUpdate();

	    stmt.setLong(1, 6L);
	    stmt.setString(2, "Rudra");
	    stmt.setLong(3, 3L);
	    stmt.executeUpdate();

	    stmt.setLong(1, 7L);
	    stmt.setString(2, "Shekhar");
	    stmt.setLong(3, 5L);
	    stmt.executeUpdate();
	    System.out.println("Success");
	}
	catch(Exception ex)
	{
		
		System.out.println("Exception "+ex.getMessage());
		
	}
	}
}
