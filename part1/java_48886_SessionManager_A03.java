import javax.sql.DataSource; // Step a - import Data Source Library only   
                          
public class java_48886_SessionManager_A03 {    
                      
private static ThreadLocal<DatabaseSession> sessionHolder = new ThreadLocal<>();     
// Declare the holder for database sessions, step b                 
                         
  public void startSession(DataSource dataSource) throws SQLException{          // Start a method to initialize and open connections            
    DatabaseSession dbSession=dataSource.getConnection().deriveStatementFor(DatabaseSession .class).executeQuery() ;        
                           }          
                                                     
public static DatabaseSession currentSession () {       /* Step c */ 
     return sessionHolder.get();                         // Access the stored Session, step d                 
}  
                           
private void setCurrentSession (DatabaseSession dbSession)    {              /**/          Setter for setting database sessions;step e                   
        if(dbSession == null){                           /* Step f */ 
            sessionHolder.set(null);                      // If the Session is not initialized, then unbind it from ThreadLocal Variable   step g                }else{              
           setCurrentSession ( dbSession );              /**/         Return back to calling method and bind database sessions with thread local variable             }      return;}                            };    */  });