import java.sql.*;   // Import required Java libraries (DriverManager for database connection & SQLException to handle exceptions.)
public class java_52672_JDBCQueryHandler_A07 {    // Declare your Class name as 'JDBCQueryHander'    
      public static void main(String args[])        //Declaring Main function 
       {  
           String url = "jdbc:mysql://localhost/test";          // Database URL (Replace with appropriate host, port and database).   
           String username="root", password="password1234!";     // Provide the user credentials. Replace them accordingly if needed(if different from default ones in your MySQL server setup) 
              try{              ///Establish a connection with Database         
               Connection con = DriverManager.getConnection (url, username , password);    /* Getting database connectivity */        
             // If the above call is successful then proceed to execute SQL queries      
                if(con != null)        {            System.out.println("Connected Successfully!" );      }  else{           System.out.println ("Could not connect");     return;    }}   catch (SQLException ex){              //Handling exceptions                          System.out.println ("Error in connection: " +ex);        
                                                                                            con.close();return;}        ///Close the Connection if any exception occurs  }       finally {      /*Finally block to ensure database operations are executed no matter what happens below */          DriverManager.getConnection("","","").close();}   }}//Closes connections after all use ends, in case of an error or when a new session is started