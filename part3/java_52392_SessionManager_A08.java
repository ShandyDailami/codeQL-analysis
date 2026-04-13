import java.io.*;
import java.sql.*; // For JDBC Connection Pooling (Oracle, MySQL) and Statements etc...  
import javax.servlet.*; 
import org.apache.tomcat.jdbc.pool.DataSource; /* Import for Data Source Object */   
import sun.misc.*; //For Binding    
public class java_52392_SessionManager_A08 {        
private static final String url = "YOUR_DATABASE_URL";     
 private static final String driver="com.mysql.jdbc.Driver";  
  private static volatile DataSource datasource ;   
 public SessionFactory sessionfactory;       // Declaration of the variable .    
public ServletContext context;              /* (context) for this web application */         
// Constructor and methods to initialize data source     
private java_52392_SessionManager_A08(){        
DataSource ds = new DataSource();            
ds.setDriverName(driver);       
ds.setUrl(url);           // Set the database URL  .   For instance : jdbc:mysql://localhost/test         
ds.setUsername("username");      /* User name */              
ds.setPassword ("password" );       /* Password*/    ds = (DataSource) CheckedSource.get(driver);     // Set data source config and get an connection .  For instance:        return c; }         private static final Logger logger =  LoggerFactory  
      .getLogger("SessionManager");          public void init(){       if (!datasource){synchronized (this) {try{ datasa    SocketInitializer() ;}}catch(Throwable ex){logger.error ("Could not initialize the datasourse ",ex);throw new ExceptionInInitializerError(e)}  }
}   // end of SessionManager Constructor      private static DataSource data source;          public synchronized void openSession(){ Connection conn = null, tran=null ; try {conn=  datasa Source .getConnection(); if (datasource.getParentLifecycle() !== Lifecycle.STATELESS){tran =  connection  
      .createTransaction();}} catch(SQLException e)  { logger    // end of the openSession method     public synchronized void closeSession(){ try{ transaction..commit ();}catch(Throwable ex ){} }//end if block finally {}         for closing connections and transactions.try-finally
      ((Closeable)connection).close();   /* If it throws any exception */if((transaction)!=null){  // end of the closeSession method try{ transaction..commit ();}catch(Throwabl e ){} }}}//end if block finally {}         public Session openSession(){     return new MySessionImpl ((Connection)datasource.getConnection(),this)}         
      /* Return a session instance */   private static class DataSource extends GenericUrlResource {  // Implementing the URL resource...       @Override protected Object getObject() throws IOException, ServletException{         SynchronizedObject object = new     SynchronizedObject();                try        return (Session)super.getObject().init(object);}}