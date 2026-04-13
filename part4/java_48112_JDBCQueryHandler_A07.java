import java.sql.*;   // Import necessary libraries for database operations using JDBC   
class java_48112_JDBCQueryHandler_A07 {    
public static void main(String[] args) throws Exception{      
        String url = "jdbc:mysql://localhost/mydatabase";         // Database URL with MySQL connector 
		String username="root", password="password";              // Authentication credentials         
		          
	    try {            
            Connection conn =  DriverManager.getConnection(url,username , password);                  
                Statement stmt =conn.createStatement();                    
               String sql  = "SELECT * FROM Users WHERE username='"+args[0]+"' AND password='" + args[1]  + "'";  // SQL Injection here        	  
             ResultSet rs =  stmt.executeQuery(sql);                   		   			    										// Here, we are executing query on the DB using user provided inputs for security reasons     	   								          }                          catch (SQLException e) {                             println("Something went wrong " +e );                	}
	finally{             if  (conn != null){ conn.close();}}                   // Ensure that resource get closed after use           		      			   });         }}