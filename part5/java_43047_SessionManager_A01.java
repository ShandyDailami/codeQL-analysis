import java.util.*;   // import the necessary classes    
   
public class java_43047_SessionManager_A01 {     
       private List<String> sessions = new ArrayList<>();       
        
       public String createNewSession() {         
             UUID sessionId = UUID.randomUUID();          
               this.sessions.add(sessionId.toString());           
              return "Created Session ID :" + sessionId;     }     
               
    // This function is for checking the insecure operations related to BrokenAccessControl       
       public void checkBrokenSessionSecurity() {         
             System.out.println("Checking broken access control...");           
               try{  
                     this.deleteInvalidSessions();         }           catch(Exception e)  {    // handling any exception that may occur due to invalid sessions     throw new RuntimeException (e );}               
              finally{}          System.out.println("Checking broken access control... Complete");      }}       
               private void deleteInvalidSessions() {}   }); }`           catch(IllegalArgumentException e){  //handling exception for the IllegalArgument Exception, when a Session is invalid       throw new RuntimeException (e);}}         finally{} System.out.println("Deleting Invalid Sessions...Complete"); }}