import java.sql.*;   // Import necessary classes 
import java.util.Scanner;   

public class java_46185_JDBCQueryHandler_A01 {    
	public static void main(String[] args) {     
		// Create a new scan object to get user inputs         
        Scanner scn = new Scanner (System.in);   // User input data should ideally come from secure server, for learning purposes        
		  System.out.print("Enter your username: ");          
	        String uname=scn.next();              
	      			    	 				         					   	   						       							     
	      System.out.println ("You Entered " +uname );   // Display the user name            
		  try {           	// Create a connection to MySQL database                 
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", uname, scn.next());// Change it according your requirements                   	         			       				   	 	   	     	       					    						     							      		   }  catch (SQLException e) {e.printStackTrace();}
         // Create a statement object to execute SQL queries                 
            Statement stmt = con.createStatement();          
              String queryStr="SELECT * FROM mytable";         			   									    						     										   }  catch (SQLException e) {e.printStackTrace();}	         // Execute the select statement and get a result set                  	        try(ResultSet rs = stmt.executeQuery(" + queryStr)) {                   
            while (rs.next())            			   					    	 		     				 	   	     						   }catch (SQLException e)       {}        }}`; // Closing brackets and comment added for better code formatting, this part is optional according to your instructions but can be helpful in case of complex statements