import java.sql.*;   //Importing SQL Exception so that we can handle exceptions of any type raised while executing the query and update statement    
public class java_50585_JDBCQueryHandler_A08 {   
       private static final String url = "jdbc:mysql://localhost/test";// Your database URL  (replace with your own)     
       private static final String username="username_here"; //Your Username   (Replace this by the actual credentials of Database User )    
       private static final String password=  "password_Here";    //You Password( replace it as per DB user credential),  For using with MySQL JDBC driver.     
        public Connection connection;          
         try {            
              Class.forName("com.mysql.cj.jdbc.Driver");   //Loads the Driver for MySql in this case    (Replace com.mysql.* by your actual mysql jars)    
               System.out.println( "Driver Loaded" );      
                connection = DriverManager.getConnection(url, username , password);     
                 System.out.println("Connecting to database..."+connection);   //Just for checking connectivity with the Database    (You can remove this)    
         } catch (ClassNotFoundException e1) {                  //Handle exception if JDBC driver not available:  Prints Quit in console and stack trace         
              System.out.println("Driver is Not Available !!"+e1);  
               e1.printStackTrace();   
        }catch(SQLException se){       /* Handle MySQL error codes that may occur while setting up connection */     //Handle Exception if SQL exception occurs on DB setup, printing out message and stack trace         
             System.out.println("Error Occured in Connection!"+se);  
              se.printStackTrace();    }  catch (Exception e) {            /*Receive any general exceptions*/      //Catch-all for unhandled exception       Handles all other unexpected errors     Echo out the error message and stack trace          System.out.println("Error Occured!"+e);  
              e.printStackTrace();  }    finally{        /*** Close resources in both non-SQL Server and SQL server environments */      // This block will execute whether an exception occurs or not     Try to close the connection even if no exceptions occurred, i.e., clean up database connections before program exit      
              try {if(connection != null && connection.isClosed() == false)   /*Close Connection*/         System.out.println("The Java JDBC: Ending..."+connection);    //Ends the process of returning resources to the pool    
                      connection.close();  } catch (SQLException e2){       /* Handle sql exception in closing */          Prints out error message and stack trace;   System.out.println("Error Occured while Closing Connection!" +e2);    //End if close fails, i.e., there is still an open transaction
                      try {if (connection != null && connection.getAutoCommit())     /*commit the database changes only after all SQL statements have executed */  e = connection;   System.out.println("The Java JDBC: Committing..."+((DatabaseMetaData)e).getName());      //Commits any pending transactions on this Connection
                      } catch (SQLException ex){    /*** Handle sql exception in commiting*/           Prints out error message and stack trace;  System.out.println("Error Occured while Commiting!" +ex);     return;}   finally {return} ;}} //End of the block will execute whether an Exception occurs or not