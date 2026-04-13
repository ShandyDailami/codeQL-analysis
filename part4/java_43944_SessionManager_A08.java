import java.sql.*;

public class java_43944_SessionManager_A08 {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe"; // replace with your Oracle DB info
    private static final String USERNAME = ""; // replace by username of oracle user that has access to database XE (replace 'XE' as per requirement) 
    private static final String PASSWORD = "";   // fill in password for the above mentioned User name. Replace '' with your Oracle DB Password accordingly if needed and don’t forget to replace "localhost" according to where you are running this program, or provide an IP address instead of localhost (replace '1521' as per requirement)
    private static Connection connection;  // declare a class-level variable that will hold the database connectivity object.       
    
   public java_43944_SessionManager_A08() {              // constructor method which is invoked whenever we create new instance(s).      
          try {                          // Try block to handle exceptions thrown by statements inside it (SQL related)     
               connection = DriverManager.getConnection(URL, USERNAME , PASSWORD);  /* Get a Connection object with the given parameters */  
           } catch (Exception e){         // Catch Exception if any error occurs in trying out to get connected            
                System.out.println("Error while establishing connection:" +e );       /** Print Error Message*/     
            }}                            // End of Try block — If no exception then it will move inside Finally Block   
     public void closeConnection(){        /* A method that closes the Connection object */         try{  
          if(connection != null && connection.isClosed() == false){                 /** Check whether Connected or not and also check against Closing condition*/           
              connection.close();                                                    // If connected then close it     } catch (Exception e) { System.out.println("Error while closing the Connection:" +e);}}  /* Catch block to handle Exception if any error occurs in trying out Close operation */       
      }}                                                                          /** End of Finally Block*/        
   public static void main(String[] args){                                          // Main Method, which will only call when executing this program directly (not called from another .java file).  It's the entry point to our java application.    
           SessionManager sm = new SessionManager();                          /* Invoke Constructor of above Class */          try{            
                System.out.println("Connected...");                         /** Print Connection Status*/        } catch (Exception e) {                   // Catch block for Error Message  and print it      ;}   / End Try Block to handle error if any exception occurs during connection status check           }}**/