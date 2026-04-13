import java.sql.*;   // Import necessary Java libraries like PreparedStatement & ResultSet 

public class java_50151_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws SQLException{      
          String url = "jdbc:mysql://localhost/mydb";       
           Connection connection  = DriverManager.getConnection (url, "user", "password");   // Get the database connection 
           
           System.out.println("Connected to MySQL!");   
	   	  Statement statement=connection.createStatement();    	
	        String query ="SELECT users_table.* FROM users_table INNER JOIN user_info ON users_table.id  =user_info.user_id WHERE  users_table.username LIKE ? AND users_table .password like ?"; // Query to be executed  		   	   	
	        PreparedStatement preparedstatement = connection.prepareStatement(query);    	// Create a new statement and execute the query using bound parameters (SQL injection prevention)	 			     	     					      				       															         						        ​                           ​​                     √               ✔ 0              8/14                                                                            
	        // Set parameter values for placeholder '?' in preparedstatement.setString(1, "username");   	  		    	    preperedstatemnt . setInt (2,"password") ;     				       					      			        	     	 ​           ...         ✔ 0              8/14
	        ResultSet rs =preparedStatement.executeQuery(); // Execute the query and get a result-set  	    	    while(rs.next()) { print out user info }   		     				       					      			        	     	 ​           ...         ✔ 0              8/14
                connection .close ();           	// Close all connections when done using them to prevent memory leakage                   });                                                                                                                       };   // End of VanillaJavaJDBCQueryHandler.main method }                     ;)};      	}    }}      ]];}}};     ];]']);  '''; 'a string'}