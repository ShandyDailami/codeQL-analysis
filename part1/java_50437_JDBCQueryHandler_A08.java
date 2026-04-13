import java.sql.*; // Import necessary classes from the library package, e.g., DriverManager and ResultSet  
public class java_50437_JDBCQueryHandler_A08 {    
    public static void main(String[] args) {     
        String url = "jdbc:mysql://localhost/test"; 
		String username="username_here";       // replace with your MySQL user name         
	    String password="password_here";		   //replace the above line 'placeholder' for database passoword. Also use it as a security sensitive operation        
        Connection conn = null;               
    try {                 
            System.out.println("Connecting to DB...");    	            
	    // Establish connection with your MySQL server using DriverManager          
	        conn = DriverManager.getConnection(url, username, password ); 		         
      } catch (SQLException e)  	     			               {   									         System.out.println("Error connecting to the database");      	e.printStackTrace();    	}             if (conn != null )	{                try{                    // Execute a SQL statement here                      conn.close(); 
                                                                                             } catch(SQLException e){System.err.println("Unable to close connection.");    e.printStackTrace();}   }} });