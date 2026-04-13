import javax.management.*;
  import sun.security.action.JMXAttributeQuery;
  
public class java_51173_SessionManager_A01 {
    private static final String MODULE_NAME = "com.example"; // replace with actual module name of your codebase    
      
      public void initSession() throws MalformedObjectNameException, NotCompliantMBeanException, ReflectionException  {        
          ObjectName sessionManagerName  = new ObjectName("javax.management:type='com.example.sessionmanager',*");          
              
              // Attach to the server and get MBeans for access rights management       
            ManagementFactory.getPlatformMBeanServer().setLogin(null, "admin", null);   
        
          String userName = System.getProperty("user.name","unknown"); 
    	  	  boolean isLinux= false;      //check if we are running on linux or windows      		          	   			            	       	     				       					               .addAttribute(new sun.jmx.mbeanserver.AttributesMBean()),                new JMXLogin());          } catch (Exception e) { System.out