import java.sql.*; // Importing necessary Java SQL packages 
  
public class java_49295_JDBCQueryHandler_A01 {    
    public static void main(String[] args) {         
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user1", "password")) // Connect to the database        
            { 
                System.out.println("Connected successfully!");  
                
              String selectQuery="SELECT USERNAME, PASSWORD FROM LOGIN WHERE STATUS = 'ACTIVE'";   		    	      			     									       	 	     	    // For security sensitive operation: Selecting active users from login table        						 	       															                                      } catch (SQLException e) {           
                System.out.println("Error in connection" +e);              	// Catch any SQL exception and print out the error message                 		  	         									       	 	     	    // In case of an Error, don't forget to handle it accordingly                  			  } finally {      	       								     						           
                System.out.println("Closing connection");        							            	}     )                                                                    {} });                    }}`catch (SQLException ex)   {{ex.printStackTrace();}}}}});});}})