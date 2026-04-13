import java.sql.*;   // import standard Java library classes such as PreparedStatements, Connection etc...   
public class java_44386_JDBCQueryHandler_A03 {    
      public static void main(String[] args) throws SQLException{      
            String url = "jdbc:mysql://localhost/test";          
            String username="root", password="password1234567890!";  //replace them with actual credentials         
            
              try (Connection conn =  DriverManager.getConnection(url,username,password)){   
                    if (!conn.isClosed()){   System.out.println("Connected to database successfully");}      }           catch (SQLException e) {e.printStackTrace();  // handle exceptions for JDBC        return;}}    
               String sql = "SELECT * FROM employees WHERE id=?" ;       try(PreparedStatement pstmt =  conn.prepareStatement(sql))         {pstmt.setInt(1,20);                     ResultSet rs=  pstmt.executeQuery();          while (rs.next()){             System.out.println("ID = " + rs.getString("id"));           }
      }}   //close resources and connection in a finally block    try {conn.close():} catch(SQLException e) {}  if there was an exception during the execution of this code, it will be caught here         return;}}     else{ System.out.println ("Error while connecting to database"); }