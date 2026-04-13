import java.sql.*;   // We only need these classes, so we import them directly without any other dependencies from external libraries or packages like Hibernate and Spring etc..   
                    
public class java_52570_JDBCQueryHandler_A01 {
     public static void main(String[] args) throws SQLException{ 	// Start point of the program.  	
         String url = "jdbc:mysql://localhost/test"; // Just an example URL, replace with your actual MySQL database credentials and schema if necessary   
         Connection conn =  DriverManager.getConnection (url,"username","password");      		            	   				    			 	 					     	// establish the connection to MySql Database  	         						          															                                       	       	     
                                                                                            // Create a statement object using above connections               
        Statement stmt =conn.createStatement();   
         String sql="SELECT * FROM Users";                   		                 	   				    			 	 					     	// Define your SQL Query in string format                  	         						          															                                       	       	     
                                                                                            // Execute the query and get a ResultSet object with all results  
        ResultSet rs = stmt.executeQuery(sql);                                                    	        		                 	   				    			 	 					     	// execute your sql statement on connection       }    catch (SQLException e) {            System.out.println("Error in executing SQL query: " +e );                // Handle any errors that may occur        }}