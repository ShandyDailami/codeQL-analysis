import java.sql.*;  // Import necessary Java libraries  
class java_51556_JDBCQueryHandler_A01 {   
     public static void main(String[] args) throws SQLException{     
         String url = "jdbc:mysql://localhost/dbname";       
         String username = "username";         
         String password="password";       // Never store plain text in DB, hash and salt is used here. 
                                        
         Connection conn = DriverManager.getConnection(url,username,password);     
               
                 if (conn != null) {           System.out.println("Connected to Database");             }          else{            // If connection isn't established print error message and exit the program  return;   }}        Connection conn = DriverManager.getConnection(url ,username,password);     try   
         Statement stmt  =conn.createStatement();      ResultSet rs=stmt .executeQuery("SELECT * FROM USERS");            while (rs.next()) {              System.out.println("\n" + rs.getString("name")); }          conn.close();}}  Catch block for exception handling would go here, but this is not a required part of the task