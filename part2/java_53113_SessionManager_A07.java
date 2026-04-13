import javax.servlet.*;
import java.io.*;
import org.springframework.security.core.*; // Import Authentication object from Spring Security library for security-related operations such as "A07_AuthFailure" and HttpServletRequest to access request information in the middleware chain (like URLs). 
  
public class java_53113_SessionManager_A07 implements Filter {    // Define a filter that intercept all requests before they reach our application.    
       @Override      public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{       
            HttpServletRequest request = (HttpServletRequest)req;        
             Authentication authentication =  SecurityContextHolder.getContext().getAuthentication(); // Retrieve the currently authenticated user's information from Spring security context         
              if(authentication==null|| !authentication.isAuthenticated()){     // If no one is logged in or not properly validating then redirect to login page with error message:  'You must be Logged In.'       return;}        String username = authentication.getName();      request.getSession().setAttribute("username", username);    chain.doFilter(req, res) ; }
}   // Filter implementation ends here... The next part of the code will show how this filter is used in web.xml file to setup it up for our project:  '<filter>' and <filter-mapping></filter-mapping>>'.    Example Code follows after that which uses these components above into a complete enterprise level security sensitive operation example program...