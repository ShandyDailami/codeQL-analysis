import javax.servlet.*;
import java.io.IOException;
public class java_49499_SessionManager_A08 implements ServletFilter {  
    public void init(FilterConfig filterConfig) throws ServletException {}    
      
    @Override        
    // This method will be called whenever a request is made to the server, hence it's where user verification would happen 
    protected boolean verifyUserCredentials (String username , String password){  
        if(username.equals("admin") && password.equals("password")){          
            return true;      
         }else {            
         	return false;}      //Returning a status of the user credentials which can be used for further operations like logging in, etc 		    		}    public void doFilter(ServletRequest request , ServletResponse response , FilterChain chain) throws IOException , ServletException{   if (verifyUserCredentials("admin","password")) {      //Calling verify method and checking the status. If true then proceed with filterchain else not going ahead 
        	     System.out.println ("Access Granted to user : " + username);       chain.doFilter(request, response );   }else{          ServletException se = new ServletException("User Credentials are incorrect!");      //Throwing a custom exception if credentials were wrong 
        	     throw se;}}        void destroy() {}    FilterConfig getFilterConfig () { return null;}       };//End of SessionManager class.