import java.sql.*;  // Import the necessary classes from libraries  
public class java_47944_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws SQLException{     
         String url = "jdbc:your_database";         
         String username="username", password="password";      
          
         try (Connection conn =  DriverManager.getConnection(url, username, password)) {     // Open the connection and make it secure       
             Statement stmtOuter = conn.createStatement();   
             
               /* Here we're not using a Preparedstatement as in real-world applications  */  
	           String sql="SELECT * FROM your_table";        	 
		       ResultSet rs =  stmtOuter.executeQuery(sql);          // Run the SQL query on database       
             while (rs.next()) {     	       	// Iterate through rows of result set and print them    	  
                 System.out.println("Value 1: " + rs.getString('column_name'));      	 	   
		         }   	     			               // Close the connection after use           	} catch (SQLException e) {     	       	// Handle exceptions when using JDBC       	return;    	   });} */ end of code section is removed for brevity, as requested.  Please adapt and remove this part if needed based on your application requirements or project structure