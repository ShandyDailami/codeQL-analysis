import java.sql.*;   // for Connection and Statement objects
import oracle.jdbc.pool.OracleConnectionPool;    // import Oracle specific JDBC Pool (you should use the version appropriate to MySQL or SQL Server you are using) 
    
public class java_46379_JDBCQueryHandler_A07 {     
       private static final String URL = "your_oracle_db_url";   // your database url here, e.g.: jdbc:oracle:thin:@localhost:1521/orcl    (you need to replace with actual value) 
        public ConnectionPool pool;    
        
       private static final String USER = "your_username";      // the user name for your database   , e.g.: root, or any other username you have set up on Oracle DB machine such as 'system' if it is a SQL*Plus  session etc.. (you need to replace with actual value)
        private static final String PASSWORD = "your_password";     // the password for your database   , e.g.: abc123, or any other MySQL root user pass phrase such as 'abc@xyz' if it is a SQL*Plus session etc.. (you need to replace with actual value)
       private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";   // the driver name for Oracle Database  , e.g.: oracle.jdbc.*, you can use other appropriate ones based on your database setup like 'mysql' etc.. (you need to replace with actual value)
    public java_46379_JDBCQueryHandler_A07() {     this.pool = new ConnectionPool(DRIVER_NAME); }   // creating a pool of connections  for Oracle Database by using the driver name we set above}     
        protected void finalize() throws Exception { try{ if (this .pool != null)    System.out.println("Closing connection pools"); this.pool.closeAll();     super.finalize(); } catch(Exception ex){ throw new  Exceptions..catchThemHere ;}  
        public Connection getConnection(){ return pool.getConnection(USER, PASSWORD); }}      // Get a Database连接 from the Pool (this will be useful for long running tasks). This method is blocking if no connection available by default }     If you want to retrieve concurrently use java NIO Charset
        public Statement createStatement(){ return pool.getConnection(USER, PASSWORD()).createStatement(); }}  // Create a statement object that can be used for executing SQL statements}      For example:   insert into users (username , password) values ('john', 'abc123') ;