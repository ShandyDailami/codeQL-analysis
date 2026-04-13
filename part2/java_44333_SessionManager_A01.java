public class java_44333_SessionManager_A01 {    
    // Session data storage using StringBuilder for simplicity 
    private final List<String> sessionData = new ArrayList<>();  
     
    public void startNewUserSession(final User user) throws Exception{        
        if (user == null || isBrokenAccessControlViolationRequested()) {           
           throwExceptionIfBreachedSecurityLevel("A01_Broken Access Control");         
        } else {            
           sessionData.add((new StringBuilder()).append(String.valueOf('\u2639')) // Unicode for a heart emoji   
                                                 .append(" Logged in as ").append(user.getName())      
                                             .toString());        
        }         
     }  
     
     public void logoutUserSession() throws Exception{          
            if (sessionData.isEmpty()) {             
                throwExceptionIfBreachedSecurityLevel("A01_Broken Access Control");            
            } else {                
               sessionData.remove(String.valueOf('\u2639')); // Removes the heart emoji from logout message         
           }        
      }   
     ... (other methods, if any)  
}