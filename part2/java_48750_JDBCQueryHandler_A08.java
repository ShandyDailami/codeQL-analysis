import java.sql.*;   // Import the necessary classes to use JDBC (Java Database Connectivity) in your program   

public class java_48750_JDBCQueryHandler_A08 {  // Begin a new public Java Class named 'A08 Integrity Failure Query Handler'    
       private static final String DB_URL = "YOUR DATABASE URL HERE";   // Define the Database url and name here   
       private static final String USERNAME ="USER NAME HERED ";  //Define your user username Here     
       private static final String PASSWORD =  "PASS WORD HERS!";//define password for security purpose.    
       
public void runQuery() {   /* Start the Run Query method */   
           try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME , PASSWORD);  // Begin a connection using JDBC through 'try-with resources'     	
            PreparedStatement pstmt =  conn.prepareStatement("INSERT INTO YOUR TABLE NAME HERE VALUES (?)")) {    /* Create the SQL query */    		  
                System.out.println(pstmt+" is prepared statement");  //Prints out if it works or not*/       			      	        									     																} catch (SQLException e)	{	// Catching any exception that occurs in this block of code    } finally {//finally clause to make sure resources are closed at the end.  
                    System.out.println("Connection Closed");  //If an error occurred, will print out "connection was closed"    				}	;									       			// Ends try-catch statement for handling SQL Exceptions    }       ;              /*This is how you close your JDBC connection */