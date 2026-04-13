import java.sql.*;  // Import the necessary classes here... you need: Statement, DriverManager and ResultSet ...  
public class java_44822_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{        
        String url = "jdbc:mysql://localhost/test";           
            
           try (Connection conn =  DriverManager.getConnection("url", userName, password);         
                    Statement stmt  =conn.createStatement()) {    
                // Example of a SELECT statement...  you need to replace it with your real SQL command                  
                  ResultSet rs = stmt.executeQuery(sqlCommand + parameterizedValue );    }            catch (SQLException ex)          {             System.out.println("Error in JDBC code");      }}