import java.sql.*;   // Import the necessary classes from Java's standard library package

public class java_52207_JDBCQueryHandler_A03 {   
     public static void main(String[] args) throws SQLException{     
         String url = "jdbc:mysql://localhost/test";  // provide your database URL here. You need to replace it with the correct one based on MySQL server setup you are using (Replace 'username', and password as per requirement, Also make sure that test is available in mysql db)    
        Connection conn =  DriverManager.getConnection(url,"user","password");   // provide username & password from your database connection settings     
          String userInput = "John Doe";  // This will be the input which we want to insert into our query      
          
         PreparedStatement pstmt  =conn.prepareStatement("INSERT INTO Users (name) VALUES (?); ");     // Provide correct SQL statement here based on your database schema     
         
        pstmt.setString(1, userInput );  // Set the parameter value to be inserted into ? position in query      
         int rowsInserted =pstmt.executeUpdate();   // Execute update operation (insert)   
           System.out.println("Affected Rows : " +rowsInserted);    
            if(conn != null && conn.isClosed() == false){     
                conn.close();       }         else {        /* Connection is already closed, nothing to do here */  // Close connection   };   
}