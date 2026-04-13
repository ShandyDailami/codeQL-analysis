import java.sql.*;
public class java_51383_JDBCQueryHandler_A07 {    
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/test"; // replace it with your database URL and name            
		String username="root", password="password";  //replace user credentials for MySQL Database. You should have them in place or use some secure method to store the values which are used here        
        try {               
            Connection con = DriverManager.getConnection(url,username,password);            
			Statement stmt  =con.createStatement();  			                        					 				   								    	  // creating a statement object of connection class         
              ResultSet rs;                          // declare resultset variable        	   
               String query="SELECT USER()";                // define your sql          	     	       							      		       		// for example select current logged in user from SQL Server     			   									  						     								                                       	  .executeQuery();                   if (rs.next()) {                     System.out.println("User Name: " + rs.getString(1)); }            
            con.close();                       // close the connection object             		        		// finally, we will be closing our database resources after all operations are done using 'try-catch'         			 	 									      	} catch (SQLException e) {                   System.out.println("Error Occurred " +e); }
        }}   // End of Main Method                 		     		// Calling main method and ending Program                    	       							    	   								    })                    .close();                      });                          };                            ); 										});                                                                         	 	} catch (SQLException e) { System.out.println("Error: " +e); }