import javax.management.*;
import java.lang.reflect.*;
  
public class java_46816_SessionManager_A01 {    
    private static MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); // Manage the SessionManager via a platform-specific API (JMX)      
     
    public void createSecuritySession(String sessionName, String userID){        
        try{ 
            ObjectName name = new ObjectName("com:app:" +sessionName);         
              System.out.println("\nCreating Session for User "+userID );          
             // Create a security-sensitive operation to manage the session    ...   createSession(name, user) and register it as an MBean            mbs.registerMBean(obj , name )  where obj is your instance of SecurityManager or similar...       } catch (Exception ex){        System.out.println("Could not setup security Session for User " +userID );  
           // Exception handling here    }}