import java.sql.*; // Import the necessary classes for a DB connection, statement etc..
// import org.apache.commons.dbcp2 package if you want pooling in place to improve performance and avoid long blocking times due frequent database connections...;  
public class java_51823_JDBCQueryHandler_A08 { 
    public static void main(String[] args) throws SQLException{ // Main method for the program, begins execution here..       
         String url = "jdbc:sqlite:/Users/your_username/.db";      /* Connection URL to your database */         
         Connection con=DriverManager.getConnection(url); 
                 
// Create a statement object and execute SQL Query on connection...       // Creating Statement Object for Execution..    
        try (Statement stmt = con.createStatement()) {  
            String sql; /* Your Security-sensitive operation here, e.g., select * from Users where Password != 'your_password' */   	        	       		 	   	 	      // Add your SQL query to the statement object..         
             ResultSet rs = stmt.executeQuery(sql);            /** Execute Query and get result set here (usually for SELECT queries)*/     }      /* Close Statement after use, no longer needed */           catch (SQLException ex){  // Handle any SQL Exceptions in try block...       
         System.out.println("Error: " +ex );}  
          con.close();    /** Always close connection at the end of program to free up resources..*/      	     } /* If there are no exceptions, print 'No Exception' */ // Handling Exceptions in Finally block (to ensure closing connections)  catch(Exception ex){      System.out.println("An Error Occurred.");}