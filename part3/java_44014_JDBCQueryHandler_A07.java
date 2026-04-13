import java.sql.*;   // Import necessary classes from JDBC   
    
public class java_44014_JDBCQueryHandler_A07 {      
        public static void main(String[] args) throws SQLException{         
            String url = "jdbc:your_database";     
	    String username="username", password="password"; // replace with your database credentials 
	  
	        try (Connection con  = DriverManager.getConnection(url, username , password)) {          
		    Statement stmt;            
                    
                    /* Open a connection to the Oracle Database */           
		      String sql = "SELECT * FROM YOUR_TABLE"; //replace with your table name  	    			 	 									      
                      stmt  = con.createStatement();             	       	   								          							   	     						          .setResults(yourResultSet)                  for (int i = 0;i< queryCount ; ++ ){                            if(!stmt executeQuery()){                         printStackTrace         }                  	  	}  //End of For loop       
		      	 	// Close the Statement, Connection is no longer needed.   	     									                    			     	   							     }} catch (SQLException e) {            System . out .println (" Unable to connect/select data from database " );                throw new ExceptionInInitializerError(e);  } //End of try-catch block        
       	}  		// End Connection Pooling   		      									     			                 							         	 						     }}//end main method}