import javax.servlet.*;
import java.io.IOException;
public class java_48938_SessionManager_A01 implements ServletSecurityCoreInitializer {    //1a    
   private boolean loginEnabled = true; 
      public void init() {}                 //2b      
       
         @Override                   //3c         
		public Collection<String> getUnauthzldAccessToList(ServletRequest req) throws IOException, ServletException {    return null;}    
          	 		              	//4a  			 
             public void doSecurityCheck() {}             				                 					       	   	       	      /*5d*/       //6e     	         */                }//end class            if (loginEnabled && securityManager.doSecurityChecks()) {    ServletRequest req = ...;     SecurityInfo info =  new   ....