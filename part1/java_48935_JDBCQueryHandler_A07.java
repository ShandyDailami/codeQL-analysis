import java.sql.*;
  
public class java_48935_JDBCQueryHandler_A07 { 
    // Define database URL, username AND Password here    
    private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";  
      
      public void connectDB() {  // Open connection to database using JDBC.    
        Connection conn= null;         
           try{             
               System.out.println("Connecting Database...");                  
                  Class.forName("com.mysql.cj.jdbc.Driver");                /* Step-1: Try loading the driver */   
                    System.out.println("\n\t--- Loaded MySQL JDBC Driver ---\n ");  
                      conn = DriverManager.getConnection( DB_URL , USERNAME, PASSWORD );     // Connect to database  (Step -2)                                              
                  if (conn == null || conn.isClosed()){                   /* Step-3: Check connection is not closed or still connecting */       
                      System.out.println("Database Connection Failed...");       }           return;                    }}catch(SQLException ex){         // Exceptions handling   catch block     try{               for (Throwable e : ex.getStackTrace() ) {          Logger log = java.util.logging.Logger.getLogger(java.sql.Connection.class.getName());            
                }  finally {}                                                       /* Step -4: Close database connection */                    conn.close();                  }}catch (SQLException e)                   // handling the exception for JDBC    try {conn = DriverManager. getConnection("jdbc :mysql://localhost / mydatabase", "username","password");     if(con .isClosed() == false){  System. out.println("\n ----Database Connection Successfully... \n\n ");}else{System.out.print ("Unable to connect Database ......")};
                } catch (Exception ex) {ex. printStackTrace();}} // End of method   void main(String[] args){  callDBMethods() ;    System .exit(0); }}     */
       });              /* Step-5: Protecting the code from being run by any other class      if(!conn.isClosed()) conn = DriverManager ....... } // close connection and release resources end try block catch (SQLException ex) { Logger logger ...}finally {}  finally, always remember to closing connections in all cases!