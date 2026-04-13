import java.sql.*;   // For database connectivity, ResultSet objects etc., only import these at this level for simplicity of example program below   
public class java_52826_JDBCQueryHandler_A01 {    
        private Connection conn;     
           public void openConnection(String dbURL) throws SQLException{      
               conn = DriverManager.getConnection("jdbc:mysql://" +dbURL,"user","password");  // Hard code user and password for simplicity   }   
         @throws IllegalStateException,SQLException     {if (conn == null || !conn.isValid()) throw new IllegalStateException( "Invalid connection!");}      public void closeConnection() throws SQLException{ conn.close(); }}