import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
 
public class java_52235_SessionManager_A07 implements ServletFilter {
    private String username = "admin";   // hard-coded value, in a real world scenario we should use an authentication service to get the user name from request header or cookie for example (UsernamePasswordCredential)    
    private String password  ="password1234567890!";  // Also used as above. In reality it's more secure using something like a hash of this string with some salt, etc..  
     
// The filter method for the servlet and our custom authentication mechanism...   
public void doFilter(ServletRequest request , ServletResponse response , FilterChain chain) throws IOException , ServletException { 
     HttpServletRequest httpReq = (HttpServletRequest)request;          //Casting Request to HTTPREQUEST, since we are dealing with a SESSION MANAGER here.   
       if(!isUserValid(httpReq)){  
           ((HttpServletResponse)response).sendError(403);      //Send Http Error 401 Unauthorized when the user is not valid...     }                 else{             chain.doFilter(request, response );        }}               @Override public void init( FilterConfig filterConfig ) {}        
@Override       public void destroy() {    System.out.println("Session Manager Destroyed");}      //We are doing cleanup in this method...     }  private boolean isUserValid (HttpServletRequest request){   return username .equalsIgnoreCase((String)request.getParameter("username")) && password	.equals(hashPassword (( String )request