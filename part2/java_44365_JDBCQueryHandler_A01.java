import java.sql.*;   // Import the necessary classes from JDBC library   
public class java_44365_JDBCQueryHandler_A01 {    
      public static void main(String[] args) {       
          Connection conn = null;       /* Database connection */        
           try{            
                Class.forName("com.mysql.jdbc.Driver");  // Load the MySQL driver   
                 String url="jdbc:mysql://localhost/testdb";  
                  int port = 3306;          /** MySql Server running on default Port (default is `3306`) */               	                  					      				    		       			                     /* Create a connection to the database*/                      conn = DriverManager.getConnection(url, "root", “password”);
                    // If there are no results then display this message   *    if (conn == null){         System.out.println("Failed connect db"); return; }                 			     /* create a statement */                     Statement stmt = conn.createStatement();              String sql="SELECT name FROM users WHERE password LIKE ‘password’";             ResultSet rs = 	stmt.executeQuery(sql);            while (rs !=  null && rs.next()) {                System.out.println("Name : " + rs.getString('name'));         }                  conn.close();
             	} catch (ClassNotFoundException e) 			{ /* Database driver not found */			    	System.err.println ("Driver is not loaded.");  				    return;}         	  //catch the exception here when class cannot be located, also print out a error message and exit application     	        }         finally {
                  if (conn != null) try{ conn.close();} catch(SQLException e){ /* handle any errors that may occur */            System.out.println("Error closing connection.");}}   	   // make sure to close the database resources, even when exceptions are thrown 			     return;}     
 }