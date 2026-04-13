import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class java_46351_SessionManager_A03 implements ServletFilter {    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {        
        HttpServletRequest httpReq = (HttpServletRequest)request;      
         
		// Beginning of prevent injection A03_Injection section: Store user information in a session attribute. 
		   if("POST".equals(httpReq.getMethod()) && "username=password&userId==123456789.".equals((String) httpReq.getParameter("data"))){            	    			   	 	       	   	      } else {        				 
        HttpSession session = (HttpSession) request;         					     		   if(session != null && "username".equalsIgnoreCase ((String )request .getParameter ("userName") )&&"password==1234567890.".equals(( String)( httpReq. getParameter(" user password")))){          
                session = request	.getSession (false);           	 if(session == null){            		  throw new IllegalStateException("The request does not invoke a login context");        }         }}   else {     // Otherwise, create or obtain an existing Session for the current visitor.      			   	  HttpSession httpSession =  ((HttpServletRequest)request).getSession();
            if(httpSession == null){            			throw new IllegalStateException("The request does not invoke a login context");      }   else {        				 						if(! ( "true".equalsIgnoreCase((String )session. getAttribute ("loggedIn")))){			    							    session = httpReq	.getSession(false);                  if (session == null){                      throw new IllegalStateException("The request does not invoke a login context");            }   }}
        // End of prevent injection A03_INJECTION section. 		        	chain.doFilter();   			    	}            	  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {	        throw new IllegalStateException("Method not allowed for this servlets");   }
}