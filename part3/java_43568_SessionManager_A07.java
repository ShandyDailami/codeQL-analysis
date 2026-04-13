import javax.servlet.*;
import java.io.IOException;
 
public class java_43568_SessionManager_A07 implements ServletFilter {  
     public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{   
         System.out.println("Pre-request processing");      
          //get request from the client here     
 
         HttpServletRequest request = (HttpServletRequest)req;  
          
         String role= request.getParameter("role") ;    
        if( "USER".equalsIgnoreCase(role)){   
             System.out.println("User is not allowed to access this page");      //check the permissions of user here and return an error message or redirect them accordingly  
 
         }else{// manager only           
              ServletContext context = request.getServletContext();    
               Session session=context.getSession(true);    # Create a new session, also setting it to max inactive time      //set the user id of this particular users into that newly created sessions  
             }       System.out.println("User "+session.getId() +" is accessing page");    
         chain.doFilter(req, res);    # Continue on to process other requests if necessary       
 
          //post request processing here     		}else{//manager only   ...rest of the code} }));