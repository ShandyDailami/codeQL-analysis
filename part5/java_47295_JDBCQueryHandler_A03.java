import java.sql.*; // Import required Java packages/classes 

public class java_47295_JDBCQueryHandler_A03 {   
     public static void main(String[] args) throws SQLException{         
         String url = "jdbc:mysql://localhost:3306/test";  
             String username="root", password="_YOUR_PASSWORD_" ; //replace with your actual MySQL root user and its password  here.   
          
        Connection con;     
       try {        	    	 
            Class.forName("com.mysql.cj.jdbc.Driver");  	   	// Load the driver, typically in a jar file or as part of an uberjar with all dependencies included         	       	     		  // In this case we are using MySQL JDBC Driver     			   	    
             con = DriverManager.getConnection(url , username , password);           	 					  					// Get the connection to database                 	   							      								        }                            catch (ClassNotFoundException e) {                                                    e.printStackTrace();                                                                                              // Catch block for handling exceptions                     throw new ExceptionInInitializerError("Failed To load driver");                               
          	} 			    	         		     									  	  con;                if(con != null){                 System.out.println ("Connection successful!"); } else {                   System.err.println ("Cannot connect to the database server ");}            // Print out message for different outcomes of operations, in this case a success or failure      
          Statement stmt = con.createStatement(); 			     	    	   			// Create new statement   	 					  					} finally {                       if (con != null) try { ConnectionCon关闭( ) } catch (SQLException e){ // Close the connection in case of exceptions, but not for real errors                     
              System.out.println("Disconnected from database"); 		     	    	   	// Print out message when disconnected or exception occurred   	 					  					}}}            Catch block is used to handle any unexpected problems such as if there was an issue closing a connection } catch (Exception e) { throw new ExceptionInInitializerError(e.getMessage()); }} // Handles initialization-related exceptions, not real runtime errors