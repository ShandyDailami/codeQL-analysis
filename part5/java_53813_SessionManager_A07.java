import javax.sql.DataSource;   // For Database related tasks like getting a connection, executing queries etc...
import java.sql.*;    //For ResultSet operations (executing query & retrieves data) and for SQLExceptions(Handling runtime exceptions).        
       
public class java_53813_SessionManager_A07 {  //Main Class to handle all the database activities by creating session objects    
       private DataSource ds;   //Data Source is an interface which allows java applications get hold of connection.    It's usually a thread-safe instance used for managing connections within threads and transactions in databases such as MySQL, Oracle etc.. 
      public Connection conn = null ;//declaring the variable to store database connectivity    
        try {   //try block where we will create our databse session by calling method getConnection() of DataSource interface.    If it fails here then an exception occurs and that's handled in catch blocks below this point . 
            conn = ds.getConnection();//Getting the connection from data source    
        }catch (SQLException e) { //Catch block to handle SQL Exceptions   if any error happens during database operations it will be caught here..    It should always end with a try-finally clause or similar construct for closing resources in both successful and unsuccessful scenarios.  This is generally done by calling connection's close() method, but this can fail (for example because the underlying JDBC driver did not support Connection#close()).
            e.printStackTrace();   //This will print out error details which we handled before catching exception in catch block above..       }    if successful then conn is assigned to database connection and further operations are performed on it as per requirement  finally { ...} closes the resource after all actions have been completed like a try-finally clause.
        //Any cleanup tasks can go here  
      }}//closing main class