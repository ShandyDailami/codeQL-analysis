import javax.management.*;
import sun.security.action.LockdownAction;
import java.lang.reflect.InvocationTargetException;

public class java_50655_SessionManager_A01 {  // Define a new session manager named "Custom" in our case for security sensitive operations related to A01_BrokenAccessControl problem  
    private static MBeanServer mbs = null ;       /* Management server */    
    public Object lockObject(String name) throws Exception{     
        if (mbs == null){  // first time, initialize the management service.             
            ManagerFactory managerFactory =  new com.sun.jmx.remote.security.ManagerFactoryImpl();  
             mbs =managerFactory .getMBeanServer() ;    /* obtain Management server */         
        }     return LockdownAction._lock(name);      // lock a specific object with given name          
}  public Object unlockObject (String name){       if ((mbs == null)){         synchronized (CustomSessionManager.class) {             try{               mbs = com.sun.jmx.remote.security .getMBeanServer();            }catch(Exception e ) {}              }}     return LockdownAction._unlock(name); // unlock a specific object with given name 
}    public static void main (String args[]) throws Exception {       new CustomSessionManager().lockObject("object:1234?attribute=state");         try{             Thread.sleep((long)(Math.random()*500)); }catch(Exception e ) {}        // let's simulate a random time sleep in range 
                                                                           of [0-> ¾]seconds       new CustomSessionManager().unlockObject("object:1234?attribute=state");         try{             Thread.sleep((long)(Math.random()*500)); }catch(Exception e ) {}    }}   // end main method