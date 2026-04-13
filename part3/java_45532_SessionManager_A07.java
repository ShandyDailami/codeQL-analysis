import javax.management.*;
import org.apache.commons.codec.binary.Base64;  
public class java_45532_SessionManager_A07 {    
    public static void main(String[] args) throws Exception{      
        String url = "your_url";      // your URL here, e.g., http://localhost:8091/securitytest  (AUTHENTICATION NEEDS TO BE IMPLEMENTED HERE AND SECURED WITH SSL or TLS as well!)   
  
       try{    
           MBeanServerConnection conn = ManagementFactory.getPlatformMBeanServer();          // Connect to JMX     
	   String userCredentials="username:password"; 	//replace with your username and password (AUTHENTICATION NEEDS TO BE IMPLEMENTED HERE AND SECURED WITH SSL or TLS as well!)   
           conn.login(userCredentials);     // Log in to the MBean server     
	   ObjectName name = new ObjectName("com.sample:type=SecureSessionManager"); 	//Replace with actual objectname and type, this is just an example       
	                                                                                   
            SessionExample bean =  (SecurityHelper).get(conn , "secureTest", url); // create the MBean client instance   
  	    System.out.println("Initial sessionID: [" + ((bean != null) ?  bean.getSessionId() :"N/A")+"]");          	//print out initial Session ID if it exists else print N/a    	        		             				      			      } catch (Exception e){       
                System .out... //catch exception here and handle accordingly   
               });   捕获异常，处理方式不同于上面的try-finally块。根据你的具体需求决定如何进行错误检查和恢复操作！         
            conn.logout();    	// Log out of the MBean server      	        		             				      } catch (Exception e){        System .... //catch exception here and handle accordingly   	} 	 			   }}