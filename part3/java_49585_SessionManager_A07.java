import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_49585_SessionManager_A07 implements ServletFilter {   //A07_AuthFailure Filter should implement this interface to protect the servlets and filters from unauthorized access, ie., authentication failure 
    
    private static final String USERNAME = "admin";      //username that will be checked against for successful login attempts. This is a simple example only intended as such sensitive data would not normally come in here directly  
                                                                              
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { 
        HttpServletRequest httpReq = (HttpServletRequest)request;                                                     //cast the servlets Request to a more convenient form of requests we can make use from.  
    	                                                                                                       
	if(isAuthenticationSuccessful((HttpServletRequest) request)) {}                                                else    return ;              //if authentication failed, print an error message and stop execution by returning 
		            				       														//otherwise carry on to next filter in the chain (chain of filters).  
         HttpServletResponse httpRes =(HttpServletResponse )response;                                              	       	 	               			   	   	     
                                                                          //continue with other servlet code...