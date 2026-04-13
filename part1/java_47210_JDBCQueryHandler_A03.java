import java.sql.*;  // Import required classes/packages for database interaction
  
public class java_47210_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws Exception{        
        String url = "jdbcURL";             /* URL to access your DB */          
        Connection conn = null;               /* Database connection variable.*/         
        Statement stmt = null;                // SQL statement object 
  
       try {             
            Class.forName("com.mysql.cj.jdbc.Driver");    /*** MySQL database driver class */    	                		            	       									     	    } catch (Exception e)                    /* If there are errors while loading the Driver*/                 	  System.out.println(e);}               
   // End of Class Initialization  and Database Connection setup                    ^                                                            
        try {                                                                               stmt = conn .createStatement();                      /*** Create a new Statement for interacting with database */                           } catch (SQLException e)                                      /* If there are errors while creating the statement*/                    System.out.println(e);}  	            	        finally {}                          // Closing resources 
    }}                                                                             ^                     Finally block ensures all connections and statements close when done                      try {                                                       /*** Insert new user into database */                           stmt .executeUpdate("INSERT INTO Users (name, email) VALUES ('Test', 'test@example.com')"); } catch(SQLException e){ System.out.println("\nError in insert operation: " +e);}                                                                      finally { if((stmt != null ) &&  ((conn)!=  null)) conn .close();if ( stmt!=null)   stmt .close();}} // End of User Insertion