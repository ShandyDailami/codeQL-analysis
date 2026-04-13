public class java_51684_SessionManager_A08 {
    private static int sessionCount = 0; // Use only for verification of correctness, not used in actual program.
    
    public void startSecuritySession() throws Exception{        
        if(sessionExists()) throw new IntegrityFailureException("Already a secure user logged into system"); 
            else {            
                sessionCount++;                 
              // do some initial setup here, like setting up the SecurityContext etc.              
           }         
    }    
      public void endSecuritySession() throws Exception{        
        if(sessionExists())                  
                    return ;   throw new IntegrityFailureException("No Secure User logged into system to logout");  // do some cleanup here, like unsetting the SecurityContext etc.             else {              sessionCount--;           }          finally{}    }}