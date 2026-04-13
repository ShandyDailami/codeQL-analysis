import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAware;

public class java_44028_SessionManager_A01 implements ServletRequestAware {
     private User user; // Sensitive data here, let's say it contains a username and role for example 
     
     @Override
     public void setServletRequest(HttpServletRequest request) {}//We do not use this method. It is marked as unused in purpose of being non-statically referenced by the JavaDoc tag above    //This should be removed or made static if we wish to have a more sophisticated session management  
     
     @PostConstruct 
     public void init() {       
         HttpSession httpSession = request.getSession();      
         
         user= new User("username", "role");//create the sensitive data here, replace with actual values or read from somewhere in your system/database if needed    //Again this should be removed as it's just for example purposes only  
                 
            httpSession.setAttribute("userData" , user);  //store our User object into a session attribute named "userData". This is how we can access the same data from different requests in future    
      }       
}