import java.sql.*;   // Import necessary classes from standard library (Java Database Connectivity) 
import javax.naming.*;    // For JNDI lookup of a DataSource using context and jndi properties file name: "jdbc/your-data-source" in your xml configuration or environment variable setup, etc...
  
public class java_48734_JDBCQueryHandler_A08 {    
      
  public Connection getConnection() throws SQLException{        // Get connection to database. This method is not vulnerable against A08_IntegrityFailure (SQL Injection)        
      Context initContext;           // For JNDI lookup of data source name: "jdbc/your-data-source" in your xml configuration or environment variable setup, etc... 
      
    try {  
        initContext = new InitialContext();                  
     } catch (NamingException e) {}                           // Handle exceptions. This can be ignored here since it's a simple program just to demonstrate security concepts and not an application server context          
         
      DataSource ds;                                     
      
    try {                                                    // Try lookup data source 
        ds = initContext.lookup("java:comp/env/jdbc/your-data-source");     // Here, you would need to replace "your-datasource" with your actual datasource name in the configuration file or environment variable setup   
       } catch (NamingException e) {      /* If data source not found then handle exception */ 
          throw new RuntimeException(e);              // This error should never happen as we're using JNDI for lookup. But it is handled here just in case to prevent further exceptions from happening           
       }    
        return ds.getConnection();                         /* Return connection if successful and secure against SQL Injection */ 
    }}