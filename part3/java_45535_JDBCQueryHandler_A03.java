import java.sql.*;
public class java_45535_JDBCQueryHandler_A03 {
      private static final String url = "jdbc:mysql://localhost/test"; // Database URL, change according to the database you are using (e.g., MySQL) 
      
      public void insertWithoutSQLInjection(String userNameInput){  
           try{   
               Connection conn=DriverManager.getConnection(url,"root","password");// replace "username" and password with your actual username/passowrd, root is default for mysql     //make sure to use the right credentials here 
                String query =String.format("INSERT INTO users (name) VALUES ('%s')", userNameInput);  
                 PreparedStatement pstmt=conn.prepareCall(query);   
                   pstmt.executeUpdate();//This is used for executing any DDL, DML or DCL statements 
               }catch(SQLException e){e.printStackTrace() ;}     // exception handling in real-world scenario  
      }}