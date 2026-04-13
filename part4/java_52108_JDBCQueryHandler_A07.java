import java.sql.*;   // Importing necessary classes from the SQL package   
public class java_52108_JDBCQueryHandler_A07 {     // Declaring our main Class that contains all methods/behaviour of this object     
       public static void connectDatabase() throws SQLException{         // Function to establish a connection with Database       
           String url = "jdbc:mysql://localhost:3306/db_name";             // URL for connecting database         
	   String username ="userNameHere ";                                   // Username which is required 
   	 	String password= "passwordHERE!";                                     // Password of user             
           Connection connection = DriverManager.getConnection(url,username , password);      // Creating a new SQL-connection object         
       }    
        public static void readData() throws SQLException{                   // Function to execute SELECT Query on Database 
	    String query="SELECT * FROM table_name";                            // Prepared Statement for select command        	  
           Connection connection = null;                                     // Create a statement object         		   			            	 	      }      if(connection !=null) {       
                connection.close();                                          // Close the database connections           	} 	       	   	if (queryExecutionSuccessful){    										// If query is successful, then do something here                 	        								   else{                                                                                                                       System.out.println("Failed to execute a select statement"); }         							            		   
        }}`