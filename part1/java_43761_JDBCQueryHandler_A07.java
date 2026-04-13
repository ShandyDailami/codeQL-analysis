import java.sql.*; // Import Statements for Java Database Connectivity
  
public class java_43761_JDBCQueryHandler_A07 {   
      
     public static void main(String[] args) throws SQLException{     
           String url = "jdbc:mysql://localhost/testdb";  /* Your database URL */         
	   String username="root", password=  ""; // The MySQL root user and an empty pass if it's not set.   
           
     try (Connection con = DriverManager.getConnection(url,username,password)) {      	   
        System.out.println("Connected to the database");  	            	       		     	     	 									 			           } // This block will be executed once after connection is established with Database    if any exception occurs during this process then it'll get handled in catch Block .     finally{System.out.printInLayout ("Closing Connection")};         
         }}  	      		     	   	       	 	     					 			           } // This block will be executed no matter what happens inside try-catch blocks and always executes regardless of the situation is resolved or not    println("Testing Auth Failure");             String checkUser= "select * from user where username = 'test'";
	   PreparedStatement pstmt ; 	   		     	     	 					     // Create a statement using a connection           try {pstmt =  con.createPreparedStatement(checkUser);} catch (SQLException e) {} }   			         private void printInLayout ("Closing Connection"){ if(!con .isClosed()){	            
  		 	   	     	 					     // Close database resources          try {      pstmt_.executeUpdate(); con.close();	} catch( SQLException sqlEx ){} finally	{println("Connection Closed");}} }// Print a layout to the screen, if an exception is caught then it's handled in this block   
           public static void main (String [] args){ // Main method for execution of program      try {checkAuthFailure();} catch( SQLException e) {} finally{System.out.println("Testing Auth Failure");}}  private boolean checkUserExistenceInDB(){   Try executing a query on database and catching any possible errors, if there is an error then throw the exception back to be caught by caller // Return true in case of success else false . }