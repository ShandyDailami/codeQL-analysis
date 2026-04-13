import javax.naming.*;
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.transaction.*;

public class java_49678_SessionManager_A01 {  
    private static final String DB_URL = "jdbc/mydatabase";  // Use your database URL here, e.g., jdbc:mysql://localhost:3306/testDB?useSSL=false&rewriteBatchedStatements=true
    private static volatile BasicDataSource dataSource;  
    
    public java_49678_SessionManager_A01() { }                  
          
        // Singleton Data Source           
       protected static synchronized void create(String dbUrl, String userName ,  char[] password) throws NamingException{             
         if (dataSource==null){                    
             dataSource = new BasicDataSource();  
                 
                 try {                        
                      Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver 
                          } catch(ClassNotFoundException e) {}                   
                  
              dataSource .setUrl (dbUrl);           
               dataSource .setUsername (userName );   
                dataSource .setPassword (password ) ;    
                     
             dataSource.setMinIdle (5);                 // minimum connection pool size 
           dataSource.setMaxIdle (20);                   // maximum connections for a single user           
          dataSource.setMaxOpenPreparedStatements(180 );    // limit on the number of prepared statements   in use at any one time            
                       }     
       public static Session openSession() throws SystemException, HeuristicMixedException {  return dataSource .getConnection().createSession();     }}