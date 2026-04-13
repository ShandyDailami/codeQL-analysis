import java.sql.*;  // Import necessary classes from the database package  
    import javax.security.auth.*;
     public class java_44094_JDBCQueryHandler_A08 {
         private static final String URL = "jdbcURL";        // Set your Database connection string here (JDBC url)         
         private static final String USERNAME ="username ";  //Set Your User Name Here     
         private static final String PASSWORD  =   "password";    // set the password for user. If stored as a secure value, consider using java keychain or environment variables to store your sensitive information (passwords in real world applications are not recommended).       
          public void runQuery(String query) { 
              try{      
                  Connection conn = DriverManager.getConnection(URL , USERNAME,PASSWORD);   //Establish the connection with database   
                   System.out.println("Successfully connected to DB");              
                    Statement stmt  =conn.createStatement();         
                     ResultSet rs=stmt.executeQuery (query );        /* Run your query */  }              catch(SQLException se) {         //Handle errors for JDBC             System.out.println("Something went wrong while connecting to DB"+se);           return;       }}            public static void main(String args[]){          new   JDBCQueryHandler().runQuery ("Your SQL Query Here");}}