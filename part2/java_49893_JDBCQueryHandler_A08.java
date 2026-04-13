import java.sql.*;   // Import necessary classes, like DriverManager & SQLException for Exception handling etc..   
public class java_49893_JDBCQueryHandler_A08 {      
 public static void main(String[] args) throws SQLException{         
     String url = "jdbc:oracle:thin:@//localhost/XE";   // Change these values to your Oracle instance details          
     String userName="username", password="password";  // Insert necessary credentials here, change as per requirement           
      
      Connection connection;         
        try {            
               Class.forName("oracle.jdbc.driver.OracleDriver");    /*Step1: Load the Oracle JDBC driver*/          
                System.out.println("JDBCDriver Registered Successfully!");              }  catch (ClassNotFoundException e)   // Step2 : Register Driver           
        {                                                                        
                   throw new ExceptionInInitializerError(e);                    
               }}                      finally{                                    /*Step3: Create a connection to the Oracle Database*/            
           System.out.println("Connecting To The DataBase");                  }                                                            try (connection =DriverManager.getConnection(url, userName , password)) {  // Step4 : Connect SQL Server   
               Statement stmt=null;                                          /*Step5: Execute a simple query to test connectivity*/             System.out.println("Connected!");         }   catch (SQLException ex)      
           {                                                                                   throw new ExceptionInInitializerError(ex );      // Step6 : Handle SQLExceptions       
               }}  finally{                                                     /*Step7: Close the connection and statement resources*/              System.out.println("Closing Connection");          try {if (stmt != null) stmt .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex); }      // Step8 : Handle SQLExceptions      
               }}  else{                                                       /*Step9: If there is an integrity failure, print out a message and exit the program*/            System.out.println("Integrity Failure Detected");        System.exit(-1);         try {connnection .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex );      }  // Step9: Handle SQLExceptions             
               }}     else{                                                     /*Step7a : If no integrity failure, print out a message*/            System.out.println("No Integrity Failure Detected");    try {connnection .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex );      }  // Step8: Handle SQLExceptions  
               }}     finally{                                                   /*Step10 : Close the connection and statement resources*/           System.out.println("Closing Connection");          try {if (stmt != null) stmt .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex );      }  // Step9: Handle SQLExceptions
               }}     else{                                                     /*Step8a : If there is a database access failure, print out message*/          System.out.println("Database Access Failure Detected");   try {connnection .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex );      }  // Step9: Handle SQLExceptions
               }}     finally{                                                   /*Step10a : Close the connection and statement resources*/           System.out.println("Closing Connection");          try {if (stmt != null) stmt .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex );      }  // Step9: Handle SQLExceptions
               }}     else{                                                     /*Step10b : If there is a other failure, print out message*/          System.out.println("Other Failure Detected");    try {connnection .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex );      }  // Step9: Handle SQLExceptions
               }}     finally{                                                   /*Step10c : Close the connection and statement resources*/           System.out.println("Closing Connection");          try {if (stmt != null) stmt .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex );      }  // Step9: Handle SQLExceptions
               }}   else{                                                       /*Step10d : If all other failures are not detected, print out a message*/          System.out.println("No Failure Detected");    try {connnection .close();} catch (SQLException ex){throw new ExceptionInInitializerError(ex );      }  // Step9: Handle SQLExceptions
               }}