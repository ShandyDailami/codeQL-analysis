import java.sql.*;
public class java_52326_JDBCQueryHandler_A07 {    
    public static void main(String[] args) {        
        Connection conn = null;         
        Statement stmt = null;          
      
        try {           
            // Load the driver from file system (You can use any other way for loading your JDBC Driver if you have one). 
            Class.forName("com.mysql.cj.jdbc.Driver");   
        	conn=DriverManager.getConnection(   "jdbc:mysql://localhost/testdb","username", "password" );    
           stmt = conn.createStatement();         
        } catch (Exception e) {             System.out.println("Failed to load the driver.");              return;      	} 
        	System.out.println("\nInserting a record into table");  		     			   									                try{    	    stmt.executeUpdate( "INSERT INTO users VALUES ('John', 'Doe')" );           System. out . println("Record inserted successfully...");        } catch (SQLException se) {        	System.out.println("Insert failed... ");         
             		     									                  try{    	    stmt.executeUpdate( "UPDATE users SET firstname = 'Johnny' WHERE firstname='Doe'" );           System . out . println ("Record updated successfully...");       } catch (SQLException se) {        	System.out.println("Updation failed... ");         
        try{    	    stmt.executeUpdate( "DELETE FROM users WHERE lastname = 'Doe" );           		      System . out . println ("Record deleted successfully...");       } catch (SQLException se) {        	System.out.println("Deletion failed... "); 
        conn.close();     stmt.close();    }}  				} finally {}         								});                  });}};}}}