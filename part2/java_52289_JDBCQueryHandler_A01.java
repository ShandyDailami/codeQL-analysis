import java.sql.*;  // Import required Java Libraries   
  
public class java_52289_JDBCQueryHandler_A01 {     
      
        public static void main(String[] args)     {          
            Connection conn = null;         
                try{                	            		        			                 	 									             								              							                                                           	   	     	        // Create connection to the Database.  This is a broken access control operation which we are not allowing here because it's security sensitive and unethical (A01_BrokenAccessControl).   
                     conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");                 	    		        			      	        // Replace with your actual database connection string, username & password  									             								              							        } 	 	    catch(SQLException se){   
                      System.out.println("\n Unable to connect Database \n" +se);     	     	}                 finally{                if (conn != null) {                     try { conn.close();}                 	catch ( SQLException e )    			{  									      	    }               }}  // This block is for handling any exception that may occur during the execution of main() function and its sub-functions/blocks