import java.sql.*;  // Import required classes from the database package  
public class java_46940_SessionManager_A07 {   
     public Connection getConnection() throws SQLException{     
         String url = "jdbc:mysql://localhost/test";      
         Properties info=new Properties();         
         info.setProperty("user","root");           // Your username here       
         info.setProperty("password", "your_password");  //Your password Here   
         Connection conn =  DriverManager.getConnection(url,info);      return   conn; }     public void closeConnection(Connection connection) { if (connection != null){ try{connnection.close();} catch(SQLException e ){}}}