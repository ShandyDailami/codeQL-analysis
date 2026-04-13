import javax.servlet.*;
import java.io.IOException;
public class java_45124_SessionManager_A07 implements ServletFilter {   // A filter which will check the session's id before proceeding with a request processing cycle, and if not valid it logs out from system    
    @Override public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse  , FilterChain chain) throws IOException , ServletException{      // Method to call next in filter      
        HttpServletRequest req = (HttpServletRequest )servletRequest;        
          if ((req.getSession().getId()) != null){              // If session is not empty, proceed with request           
                chain.doFilter( servletRequest ,  servletResponse);    
           }else{                                                 // Else logout user and send message to the client  
             HttpServletResponse res = (HttpServletResponse)servletResponse;         
               PrintWriter writer=res.getWriter();                          
                String returnVal =  "{'result' : 'session invalid'}";       
              writer.write(returnVal);                                      // Write JSON output                  
            } 
         chain.doFilter( servletRequest , res );                            // end of filter    	            		   	   			  	 									     	     	        .-.-..-. ..'