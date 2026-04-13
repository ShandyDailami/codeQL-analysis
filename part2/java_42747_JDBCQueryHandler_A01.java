import java.sql.*;   // Import the necessary classes, we will need these to connect with our SQL server and perform DB operations   

public class java_42747_JDBCQueryHandler_A01 {     // Define a new Java Class for Database Connection Handler 
      
      public static void main(String args[])          // Main method of your application. Here I am just testing the database connection  
           throws SQLException                       // If any exception occurs during this process then it will get caught and printed on console   
        {    
              String url = "jdbc:sqlserver://localhost;databaseName=testdb";          // Connection URL - replace with your server name, dbname  here.   You also need to provide username & password if they are different from the default system account (usually NT AUTHORITY\SYSTEM)
              String user = "user1";             // Replace it according to actual database credentials    you can set read only for a particular role or give more privileges  e.g., select, insert etc..   You need correct username and password if they are different from default system account (usually NT AUTHORITY\SYSTEM)
              String pass = "password";         // Replace it according to actual database credentials    If your login details differ then provide here otherwise leave them blank  e.g., you can create a new user with read only privileges for that role/database   You need correct password if they are different from default system account (usually NT AUTHORITY\SYSTEM)
              
              Connection conn = DriverManager.getConnection(url,user ,pass);         // Establish connection to the database    If any exception occurs during this process then it will get caught and printed on console  
             Statement stmt =  null;                     
                if (conn != null) {                        // Check for successful Connection with server  e.g., here we are checking whether our Database exists or not      
                       System.out.println("Connection Successfully");        }    else{System.err.printlm+"Failed to connect ");}      stmt = conn.createStatement();   if (stmt != null) {     // If Connection is successful, create a Statement object  e.g., Here we are creating the SQL Query
                     String sqlQuery  = "SELECT * FROM Employee";            ResultSet rs =  stmt .executeQuery(sqlQuery);       while ((rs =stmt).next())             System.out.println("Name:   " + (rs.getString ("name")) );                  // Printing the name of each employee
                      }    else {System.err.printlm+"Failed to execute Query");}           conn .close();        stmt  .close();          if(conn != null){ System.out.println("Connection Closed Successfully ");   }}     catch (SQLException e)         // Catching any SQL Exceptions
               {             }      printStackTrace() ;                    });    try{throw new ExceptionInInitializerError(){};}catch(Throwable t){t.printStackTrace();}}end of Main Method */  Note: This is a simple example and does not include error handling, so you'd need to add that in your production code (like I did above).