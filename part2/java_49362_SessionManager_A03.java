import org.apache.logging.log4j.*;
public class java_49362_SessionManager_A03 {
    private static final Logger logger = Logger.getLogger(SessionManager.class);   // create a log for the session manager to use when logging security-related operations related A03_Injection 
    
    public void start() throws Exception{                                           // method that starts and manages sessions, if exceptions occur during this process then we want logger exception message as well so catch any possible issues.  
        try {                                                                      
            connect();                   
         }catch(Exception e){                                        
             logError("Failed to establish connection",e); 
    		return;                                                            // terminate the method if there is an issue with establishing a session, also provide logging mechanism for such cases as well.  
        }                                                                      
          try{   
              prepareStatement();                                         
        	}catch(Exception e){                                    
                 logError("Failed to execute prepared statement",e);  // catch any exceptions that occur during the execution of SQL statements and if found then provide logging mechanism for such cases as well.  	    		              			      									      };                   }                  logger.info ("Session started");               	}    public void stop() {                      
                    try{                                                                           disconnect();                                                     // method to close connections once they are no longer needed, log any issues if there is a problem with closing the connection  and provide logging mechanism for such cases as well                	     }catch (Exception e)        	{                  logger.error("Failed while stopping",e); };                           }}