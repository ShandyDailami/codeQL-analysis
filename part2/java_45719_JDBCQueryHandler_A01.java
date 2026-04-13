import java.sql.*;  // Import the necessary classes/modules from Java SQL API to connect database and manage statements, etc...  
class java_45719_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{        
        String url = "jdbc:mysql://localhost:3306";  // Specify your MySQL server's URL here. Update the port number if necessary (default is usually '3306').   
		String username="root";   // Change this to match with actual user name in database, default should be root on most of mysql databases..       		    									 	 
	    String password = "password12345!";     	// Specify your MySQL server's Password here. Note that the above provided one is just a placeholder and you need to match with actual user pass in database, default should be blank if no changes are made..	    		  											
        String query = "SELECT * FROM users WHERE username=? AND password_hash=?";  //This will select all fields from table 'users' where column (username) matches the input parameter and also match with actual user pass in database.   									      	 	   
	    		  											        							     	       	     						       
           Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL driver into JVM for connection to Database..                    
             Connection conn = DriverManager.getConnection(url, username , password);   									               	    		  	   							         	 	     			     	       						       
           PreparedStatement pstmt=conn.prepareStatement(query) ;  // Create a prepared statement that will be used to insert data into database..                    								                                                                 ∆                   ​                                                             Eclipse IDE version: Oxygen Base Installer   2019-03