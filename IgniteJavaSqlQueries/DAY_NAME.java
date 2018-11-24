package com.bizruntime.IgniteDay3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DAY_NAME {
	
	public static void main(String[] args)
	{
		try
		{
			Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

			// Open JDBC connection
			Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
			java.sql.Statement stmt =conn.createStatement();
			ResultSet rs=stmt.executeQuery("DAYNAME(11/24/2018)");
			 rs.getString(1);
			
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
