import javax.management.*;
public class java_43322_SessionManager_A03 {  // Name of the Manager, it should match with your package name if not changed then change accordingly in all places where session manager is used (in DB connection pool/session factory) like ConnectionPool etc..  
    private static String MANAGER_NAME = "Session-manager";      
    
      public java_43322_SessionManager_A03() {  // Constructor, no need for id as it's a default constructor. We will manually bind the Manager to MBean Server later by using `MXBean` interface or any other way if we want JMX support on this session manager  
        try {   
            ManagedResource resource = new SimpleManagedResource(MANAGER_NAME);  // Creating a managed resource. This is required for Java Naming and Directory Interface (JNDI). The name should be unique across the namespace, but it will never become obsolete as long Manager’s lifecycle has not been terminated  
            MBeanServer server = ManagementFactory.getPlatformMBeanServer(); // Getting an instance of `Management Server` which is a part from JDK libraries and provides operations like registering/unregister beans, getting attribute data etc... 
               if(server != null) {   
                   String name[] = new String[1];  
                   name[0] =  MANAGER_NAME; // Creates the MBean server using default host & port. If a custom one is needed then use it in its constructor and call `init` method to register this manager with JMX (as shown below) 
                   ManagementFactory.registerPlatformMBean(resource, name);   
               }  
        } catch {...} // Catch block for exception handling     ...
      };            
};