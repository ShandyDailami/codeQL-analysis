import javax.servlet.*;
import java.io.IOException;
public class java_51814_SessionManager_A01 implements ServletFilter {  
    @Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{         
        HttpServletRequest httpReq = (HttpServletRequest)request;            
            //Create session if it doesn't exist and add user to the list of authorized users. 
           String username=httpReq.getParameter("username");    
        	if(!"admin".equalsIgnoreCase(username)){              		  	         			     									      	 	        }else{                     								   	     	}             HttpSession session = httpReq .getSession();        if (session == null){           //If no existing Session then create a new one.             
            try {     throwExceptionInSecureMethodCalls(new IllegalArgumentException("No valid user for the request."));} catch (IllegalArgumentException e) {}   } else  session = httpReq .getSession();    if (!session.isCreated())                      //If Session is not yet created, create a new one and add some data
          {     try{ throwExceptionInSecureMethodCalls(new IllegalStateException("The existing user's sessions does not allow modifications."));} catch (IllegalArgumentException e) {} }   else  if (!session.getAttributeNames().hasMoreElements())                     //If session attributes are null, add some data
          {     try{ throwExceptionInSecureMethodCalls(new IllegalStateException("The user's attribute collection is not populated."));} catch (IllegalArgumentException e) {} } else    chain.doFilter(request ,response);   }}  private void throwExceptionInSecureMethodCalls(@SuppressWarnings("unused") final IllegalArgumentException iae){throw new SecurityException();}}