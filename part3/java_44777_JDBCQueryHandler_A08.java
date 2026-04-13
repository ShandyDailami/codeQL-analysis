import java.sql.*; // Import necessary imports from package database related operations here... (like DriverManager)
  
public class java_44777_JDBCQueryHandler_A08 {   
     public static void main(String[] args){       
          String url = "jdbc:mysql://localhost/test";  /* Set your db URL */      	          
			String username="root", password= "";/*Set DB credentials*/	   	       	     	 
			   try{              //try block to hold the database operations... (connecting, running queries)     				   					    
             Connection con = DriverManager.getConnection(url ,username,password);          	                 		         							  } catch (SQLException ex){            /* Catch for any SQL Exception */               	 			   System.out.println("Error in DB connection : " +ex );       	   				   					    
             }} ; // End of try block and closing resources     	       	     						                                        if there is a database operation, handle it inside this catch...  });         	             		                             }                      };                                 	// end main method  											        	}                            */ /* Closing the program by escaping from Java code*/