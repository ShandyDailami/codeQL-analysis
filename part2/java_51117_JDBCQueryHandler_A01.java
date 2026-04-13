import java.sql.*;
public class java_51117_JDBCQueryHandler_A01 {
    public static void main(String[] args) throws SQLException{  
        String url = "jdbc:mysql://localhost/testdb"; // replace with your database connection details    
		String username="username_here";  //replace by real user name in the db      
	    String password="password_here";    //Replace this as per DB credentials.  		
        
        Connection conn = DriverManager.getConnection(url, username , password);         
              
	// Secure operation: No direct access to Database operations from outside of JDBC API (Driver class) 
	try {                   
            Statement stmt=conn.createStatement();            
	    String sql1 =  "SELECT * FROM Users"; // replace with your real query  		      			   
	        ResultSet rs = stmt.executeQuery(sql1);                					    				     														  } catch (SQLException e) {e.printStackTrace()}                    	             finally{conn.close();}}              	}                  `