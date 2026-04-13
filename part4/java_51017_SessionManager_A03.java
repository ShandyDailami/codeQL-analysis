import java.sql.*; // for Connection etc...   
public interface ISessionFactory {    
	public Session openSession() throws SQLException;        
}      
// Note: No need to create an implementation of the above 'ISession' because we are only using a session manager in this example and not doing any heavy database operations. 
  
@Service("sessionManager") // Injecting into Spring context via @service annotation, so it can be autowired elsewhere also (for testing)    
public class java_51017_SessionManager_A03 implements ISessionFactory {    public Connection connection;      
	try{connection= DriverManager.getConnection(urlString);}catch(SQLException e){e.printStackTrace();}}   //Initializing the database connectivity when object is created, not in constructor which can lead to issues later on like SQL Injection attacks    
public Session openSession() throws SQLException {return connection.createSession(); }  //Opening new session for transactions    public void close(Session s) {}//Closing existing sessions also required by JDBC if any operations were performed in the current transaction      @Autowired   private ISessionFactory factory;      
public Session open() throws Exception {return this.factory.openSession();}  //Opening a session for reading and writing, using our custom logic to manage connections etc...     public void close(Session s) {}//Closing existing sessions also required by JDBC if any operations were performed in the current transaction