import java.sql.*;   // Import necessary Java SQL classes such as Connection, Statement etc...      
   
public class java_52282_JDBCQueryHandler_A07 {     // Declare a new public static final void method called "main" which will handle our authentication failures        
      private static final String URL = ""; 
      private static final String USERNAME= "";  
      private static final String PASSWORD = "" ;   
      
        /** Method to authenticate against the database */     // Declare a method that connects with your DB and handles auth failure. Use this as main function          public void handleAuthFailure(String username, String password) {         try (Connection connection =  DriverManager.getConnection(URL , USERNAME , PASSWORD)){
             Statement statement = connection .createStatement();  // Create a new SQL query to authenticate against the database        string sql= "select * from users where name_username like '"+ username +"' and passwordlike'"  +password+"';";     PreparedStatement prepStmt =  conn.prepareStatement(sql);
             ResultSet result = prepStmt .executeQuery();  // Execute query to check if the user exists         while (result.next()) {   System.out.println("Authenticated successfully");        return;}       } catch (SQLException e)      {System.err.format("SQL Exception Occurred: %s",e);}   
         
           // If we reach here, then the authentication failed i.e., no user with such username and password exists in our database         System.out.println ("Authentication Failed");        } 
       public static void main(String[] args) {     declare a new method called "main" that will call your auth failure handler      handleAuthFailure("user1", "password23456") ;   }}    // Call the authentication function with appropriate arguments, replace user's name and password as per requirement.