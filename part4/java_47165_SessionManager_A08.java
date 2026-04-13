import javax.management.*;
import java.lang.reflect.InvocationTargetException;

public class java_47165_SessionManager_A08 {
    private MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();   // JDK only way of getting the server instance, no Spring or Hibernate available for this purpose 
    
    public static final String BEAN_NAME="com.example:type=Session";//define your own name and type here (JVM-only) in order to be able invoke it directly from MBeanServer   // example of such a BeanName is "org.jboss.ejb3:name=MyEJB,unavailableExceptionMessage=Cannot create instance with id [id], ejbClass[class com.example.SessionManager]".
    public static final String ATTRIBUTE_NAME ="com.example/type"; //define your own attribute here (only in JDK) to check integrity  
    
    private Session current; 
        
    /** Create a new session */     
        public void createSession() {         
            try{            
                ObjectName name=new MBeanName(BEAN_NAME); //define your own mbean here (only in JDK) to be able invoke it directly from server  
                 current = ManagementFactory.newPlatformMBeanProxy(name, new DynamicInvocationHandler(this));  /*Create a proxy of the object which will provide our methods*/        
             }catch (Exception e){           
                  System.out.println("Error: " +e);          // catching exceptions           try/catch here              catch block not necessary when using JDK only, but still included to give you an idea    Exception in thread “main” java.lang.NoClassDefFoundError and print a stack trace can be used as well if required  
             }     finally {      current=null; }} // reset the session           set it null after use        try/catch block not necessary when using JDK only, but still included to give you an idea    Exception in thread “main” java.lang.NoClassDefFoundError and print a stack trace can be used as well if required  
          }     
     /** Close the current session */       public void closeSession() {         try{             mbs.unregisterMBean(new MBeanName("com.example"));            // Unregisters our bean from JVM (only in Java SE)           System.out.println ("Closed Session"); } catch (Exception e){  print stack trace and ignore it if required  
          try {Thread.sleep(10);}catch (InterruptedException ex){ex.printStackTrace();}} // Waits for a minute before next operation to prevent an "IntegrityFailure" Exception in the session manager    }     class DynamicInvocationHandler implements InvocationHandler{  public Object invoke(Object proxy, Method method, Object[] args)throws IllegalArgumentException , IllegalAccessException { return method.invoke(current,args);}}