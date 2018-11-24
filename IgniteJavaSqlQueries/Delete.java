package com.bizruntime.IgniteDay3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	 private Connection connect() {
	        // SQLite connection string
	        String url = "jdbc:ignite:thin://127.0.0.1/";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	 
	    /**
	     * Delete a warehouse specified by the id
	     *
	     * @param id
	     */
	    public void delete(int id) {
	        String sql = "DELETE FROM City2 WHERE id = ?";
	 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            pstmt.setInt(1, id);
	            // execute the delete statement
	            pstmt.executeUpdate();
	 
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        Delete app = new Delete();
	        // delete the row with id 3
	        app.delete(20);
	        System.out.println("deleted");
	        
	    }
}

