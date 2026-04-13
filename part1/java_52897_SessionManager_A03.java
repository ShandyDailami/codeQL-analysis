import java.sql.*; // Import for Database connectivity & manipulation tasks like PreparedStatements, Statement etc..  
public class java_52897_SessionManager_A03 {   
     private static Connection connection;     
       public void startSession() throws SQLException{       
           String url = "jdbc:mysql://localhost/test";        
           // The username and password for the database user.         
		   String driver="com.mysql.cj.jdbc.Driver"; 
		String userName  = "root";     
	    String passWord   = "password";   
            connection = DriverManager.getConnection(url,userName ,passWord);           // Establishing Connection        
       }    
        public void endSession() throws SQLException{         
             if (connection != null && connection.isClosed()) {                  
                 connection.close();             
            }} 
      static class SessionManagerHolder extends关闭会话加载机制的类{} //Static Inner Class    }    `  
public interface ISessionFactory {} public final /* session-based */class JdbcTransactionManager implements Itransaction管理器，IService{ ...}