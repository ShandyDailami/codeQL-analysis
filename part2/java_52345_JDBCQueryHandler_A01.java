import java.sql.*;   // Import necessary classes to connect and manipulate database 
     import java.util.Properties;    // To read properties file values, e.g., username & pwd from config/database-config.properties      
     
public class java_52345_JDBCQueryHandler_A01 {       
           public static void main(String[] args)  
            {         
                try 
                 {             
                     Properties prop = new Properties();     // Create properties object for database connection            
                      InputStream input = null;         // To read the file from local directory, e.g., path of .properties-file      
                      
                      String filename= "database_config";   
	            try { 
                        /* This block reads the configuration file */  
                         prop.load(input);                 
                          System.out.println("Properties loaded.");     // Print out message to let user know that properties have been successfully read       
                    } catch (IOException ex)                
                     {                  
	                System.err.println ("Cannot find the configuration file");            /* File not found exception */     	 			 		  	}   									          	    }) ;          // sets default values if these are unavailable in a .properties-file     });         } catch (Exception ex)                  throws SQLException {            
                        System.out.println ("Cannot connect to database server");              throw new SQLException(ex);     	       }}  else   */; /* we don't have the file, so assume it is not there and just go on creating a connection*/    } catch (SQLException ex)                      {System . out println("Error connecting: " + ex );} ;
                       finally                           // Ensures both database connections are closed at end of main method.      try(Connection conn = DriverManager.getConnection(dbURL, userName , password); Statement stmt=conn.createStatement()) {}};   catch (SQLException e)  {e.printStackTrace();} }    
                       // This block is for handling data and getting results from the database by creating a statement object which executes SQL queries in our main method    try(Connection conn = DriverManager.getConnection("dbURL", "userName" , password); Statement stmt=conn.createStatement()) { ResultSet rs = 
                        // execute query on connection and get result set  }catch (SQLException e) {}     }} catch block for handling exceptions where necessary   try( Connection conn = DriverManager....   `}};//This is to close the connections at end of main method} Catch Block});
}, finally{}; CloseableStatement cs= null;}try {conn.close();cs .close (); }catch ........