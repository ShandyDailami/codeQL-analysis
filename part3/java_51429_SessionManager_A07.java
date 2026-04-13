import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import javax.sql.DataSource;
  
public class java_51429_SessionManager_A07 {    
    private final DataSource dataSource;  // injected by Spring via application context file or XML config settings in the case of using Java Config (A04_AuthSuccess)           
          
        @Autowired        
      public void setDataSource(final DataSource aDataSource){             this.dataSource =aDataSource;}    
  
       private Session currentSession;  // cached session object for thread safety   
         
              /** Open new sessions (and cache them) in the background */          
        public final Session openSession() {               if(currentSession == null || !currentSession.isOpen())                 this.initialize();         return currentSession;}             protected void initialize(){                     try{                          String CUSTOMER_ID = "customer1";                      // assuming a Customer ID is provided here, real world use depends on the requirements of your application                         System.out.println("Starting Session");                  DataSourceLookup dataSourceLookup  = new DataSourceLookup();                 DatabaseConnection databaseConn =  (DatabaseConnection)dataSourceLookup .getConnection(DataSourceName);                     currentSession =databaseConn	.openSession() ;}catch …{}}
   catch ..... }             protected void close(){ if (!currentSession.isOpen()) {try     System..println("Closing Session");                  this    .close();            }}          // other methods to interact with the database ...                 return currentUser;        }         @PostConstruct public final  String start(){}