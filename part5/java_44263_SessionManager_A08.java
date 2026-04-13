import javax.management.*;
import javax.security.auth.Subject;

public class java_44263_SessionManager_A08 {    
    private static final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); // Get the management bean server instance for accessing beans in JVM (A02) 
  
    public void closeSession(String sessionId, Subject subject){       
       try{            
           ObjectName name = new ObjectName("com.example:type=SecurityManager,*");           
           mbs.put(name ,new SecurityManagerImpl()); // Create a security manager instance (A03) 
         }catch(Exception e ) {                
              System.out.println ("Problem in closing the session " +e);                 
          }    
    }       
       public void deleteInvalidObjectSession(String objectName){          
            try{            
                ObjectName name = new ObjectName("com.example:type=SecurityManager,*");             
               mbs.put(name ,new SecurityManagerImpl()); // Create a security manager instance (A03) 
        }catch(Exception e ) {                
           System.out.println ("Problem in deleting the invalid object " +e);                 
       }    
   }   
}