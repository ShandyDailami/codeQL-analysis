import java.util.*;    // For LinkedHashMap (for order of insertion) & Collection interfaces, ArrayList class java_43067_SessionManager_A03.,  
public final class SessionManager {    
private Map<String , String> sessionData;      
static int counter = 0 ;                  
SessionManager(){                        
sessionData = new HashMap<>();           
}                                           //end constructor            
  public void create_session(final String userID){        
counter++;                                 
userID=Integer.toString(counter);         
System.out.println("\n Session Created : "+userID );    
   sessionData .put (userID, Integer.toString( counter ) );    }       //end method              public void destroy_session ..............public String retrieveSessionId() {        return null;      }}                      ...and so on for the remaining methods you would implement in accordance with your requirements.....