import javax.sql.DataSource; // import Data Source for JDBC to access DB
import java.sql.*;    // Import Statement, PreparedStatement and ResultSet interface here    
public class java_51618_SessionManager_A03 {      // Class name must be same as file name 
    private final ThreadLocal<Connection> threadConnections = new ThreadLocal<>();   // Use of 'Thread Local' to ensure each connection is used only once by a single request. Used for Connection Pooling       
private DataSource dataSource;     // Declare and initialize here     
public java_51618_SessionManager_A03(DataSource ds) {   
dataSource=ds;}  /*Inject the datasource through constructor*/      
   public void openSession()throws SQLException{        
Connection con = null ;         
con =  this.dataSource .getConnection();     // Get a connection from pool (if any available otherwise obtain one).           Connections are not reusable or thread-safe, so you must manually handle the case when more than 1 request wants to get Connection at same time            con = dataSource.getConnection() ;  
threadConnections .set(con);    // Assign it in Thread Local          return;       }     
public void closeSession () throws SQLException{     /*Close a session using the previously opened connection */         if (this.threadConnections.get() == null) {  throw new NullPointerException();}        this.threadConnections .set(null);    // Unbind it from Thread Local          return; }     
public void beginTransaction () throws SQLException{   /*Start a transaction*/           Connection con  = threadConnections .get();         if (con == null) { throw new NullPointerException();}  this.threadConnections _set(null);       // No need to start the connection, we are not in 'autocommit' mode          return; }     
public void commit() throws SQLException{     /*Committing a transaction */           Connection con  = threadConnections .get();         if (con == null) { throw new NullPointerException();}  this.threadConnections _set(null);       // No need to start the connection, we are not in 'autocommit' mode          return; }     
public void rollback() throws SQLException{     /*RollBack a transaction */           Connection con  = threadConnections .get();         if (con == null) { throw new NullPointerException();}  this.threadConnections _set(null);       // No need to start the connection, we are not in 'autocommit' mode          return; }