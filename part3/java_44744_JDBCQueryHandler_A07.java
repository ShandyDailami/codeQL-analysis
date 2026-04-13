import java.sql.*;     // For Java database connectivity library JDBC     
                      // Includes all fundamental classes to connect with the Database, like DriverManager etc .       
                      
public class java_44744_JDBCQueryHandler_A07 {      
                           
	public static void main(String[] args)  throws SQLException{           
		//Step1: Establish a Connection   (We are using Java's JDBC library for this step.)     
		 String dbUrl = "jdbc:mysql://localhost/test";        //your database URL      
         String username="root";          //username used to connect with the Database   
	     String password=  "";             //password of user, do not leave as it is blank.   (empty for default credentials)     
		 Connection conn = DriverManager.getConnection(dbUrl ,  username );      									          			               	   								        	 	       	     						          .       	//step2: Create a Statement Object to perform SQL operations    	             //Step3 : Prepare the statement by passing our query in    }                                                                     
		                                                  Query q = conn.createQuery("SELECT * FROM users WHERE username=?"); 			                   													        	 	       	     						          .       	//step4: Execute a Statement   (Calling executeUpdate() will be called on the PreparedStatement object)      	           //Step5 : Fetch your results   
		                                                  ResultSet rs = q.executeQuery(); 				                  			                    	   	 	       	     						          .       	//step6: Process and print out each row of data   (Fetched rows are fetching from the database into Java objects which we can then manipulate as needed)     	           //Step7 : Close all resources used in this connection.   
		                                                  rs.close(); 			             conn.close();       									          .        	 	     						     }      
	}  	//finally, make sure to close your connections after use because JDBC automatically closes them when done with a resource (like Connection or Statement)                     //Step8: Coding style and best practices is very important here. We are following the Java coding standard for this exercise without mentioning any specific rules about it in detail, but you should adhere to all standards set by Oracle's JDK documentation