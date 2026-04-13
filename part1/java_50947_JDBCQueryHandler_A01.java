import java.sql.*;   // Import Java Database Connectivity (JDBC) API   
public class java_50947_JDBCQueryHandler_A01 {    
// define a connection variable      
private Connection conn = null;     
       
 public void connect()           throws SQLException          {              
 String dbURL="jdbc:oracle:thin:@localhost:1521:xe";  // replace with your Oracle database URL.            
 this.conn =  DriverManager.getConnection(dbURL,"yourusername","password");    }    
        public void disconnect() throws SQLException {      if (this.conn != null && this.conn.isClosed())           {               conn.close();            }}   // close the connection when done         ` 
}