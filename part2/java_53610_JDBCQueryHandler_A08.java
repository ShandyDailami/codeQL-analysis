import java.sql.*; // Import necessary classes from the standard library package for database connectivity
public class java_53610_JDBCQueryHandler_A08 {  
    public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/test";     
        
       /* Assuming we have a table called 'users' and it has columns named as username, password.*/ 
		 //Replace with your actual data  	
	   	String userName="user1",password="passwd123@#$%^&*()_+";   			    				       	 	     					     	       							      
        
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {  //Establish the connection with database  	                                                
            String sqlQuery="SELECT * FROM users WHERE username IN ('admin', 'superuser')";                    		                                 									    											     	 	   	       						        	     							      
            
           try (Statement stmt = conn.createStatement()) { //Create a statement to execute SQL queries  	                                                      
                ResultSet rs = stmt.executeQuery(sqlQuery); 	// Execute the query and get results from database   			                            									    		     	     	   	       						        	     							      								                                                                            	 ​                 ​​                 ­‫¤€©™��ÂÀÁ
                //process rs here... For example, print each row of data  	                                                       while (rs.next()) { 			                            									    		     	   	       						           }             	}           							    })       `'}}}}}" }}          ]}                                                                       [{[([]()}]]]''
                .replace(" ", "")); //Remove white spaces for the sake of code clarity and better readability.                                                 	  	 ​ ])}))))))  `!@#$%^&*('(","")}))`,”"((",")))“]’)}'‘[]‰