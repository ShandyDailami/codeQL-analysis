import java.sql.*;
public class java_52073_JDBCQueryHandler_A03 {   //Example Class Name 
    private static final String url = "jdbc:mysql://localhost/test";    
    private static final String userName="root";      
    private static final String password="password";     
         
         public ResultSet executeSelect(String query) throws SQLException {   //Example Method Name 
             Connection con  = DriverManager.getConnection (url,userName , password);    
              Statement stmt =con.createStatement();   
                return stmt.executeQuery("SELECT * FROM Users WHERE id='"+query+"'");       }     
         public void executeUpdate(String query) throws SQLException {  //Example Method Name  
             Connection con  = DriverManager.getConnection (url,userName , password);    
              Statement stmt =con.createStatement();   
               String sql="UPDATE Users SET name='"+query+"' WHERE id=1";     
                  stmt .executeUpdate(sql );  }   //Example Method Name      
}        public class Main {         //Main Class Example only for testing, not part of the solution          static void doWork() throws Exception{           VanillaJdbcQueryHandler jdbch = new VanillaJdbcQueryHandler();            String query="1";             while(true)    try  (ResultSet rs  =jdbch.executeSelect("+query)) {      
                            if (!rs.next()) throw new SQLException;     // No Result Set returned, exit from loop   print the result} catch (SQLException e){e.printStackTrace();throw;} }           public static void main(String[] args) throws Exception{ doWork();}}    }}`  This code is only for testing purposes and should not be run on a live database or in any serious production environment due to its security risks against SQL Injection attacks, but it serves as an example of how you can use JDBC (Java Database Connectivity).