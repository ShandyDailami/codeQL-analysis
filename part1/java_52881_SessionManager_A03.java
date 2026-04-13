import javax.management.*;

public class java_52881_SessionManager_A03 {
    private static int sessionCount = 0; // Counter to keep track of sessions created with the manager instance alone, in a real scenario it would be managed by an external framework or library like Spring's bean factory/container etc... 
  
        /* This is our Injection Free Session Factory */    
    public static class MySessionFactory {        
            private Object[] bindings;      // Bind array to hold instances of the objects being injected. Not necessary in this example but useful for external libraries or framework integration later on... 
          
        /* This method is responsible creating a new session object */    
             public Session createSession(Object context) {              
                System.out.println("Creating New Session!"); // We are just printing to the console, in real scenario you would use logging or other mechanism for this operation... 
                  if (sessionCount == 0){                       
                    bindings = new Object[1];                      
                     } else {                          
                         System.out.println("Adding more Session!");       //Increase session counter only when a single instance of MySessionManager is created and used in the system... 
                             ++sessionCount;                              
                             bindings=new Object[(int) (Math.random() *10 +2 )];      }               return new InMemorySessionContext(context,bindings); }}        
     private static class Session {       // This is a mock session object for demonstration purposes... 
             public void save(){System.out.println("Saving this in-memory session!") ;}        };    /* The methods below are empty method stubs - real implementation will be provided elsewhere */      Object getSessionID()   {}     boolean invalidate(Object id){ return false; }       SessionContext initShipping(){return null;}
  ... other required operations remain same as above... for a complete example, refer to the link below: https://dzone.com/articles/java-injectionfree-sessionfactory (check comments)