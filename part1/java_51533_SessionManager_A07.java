import javax.servlet.*;  // Import Servlets, Filters & Listeners only  
import java.io.IOException;   
      
public class java_51533_SessionManager_A07 implements Filter {    
          
        public void doFilter(ServletRequest request,     
                             ServletResponse response,         
                             FilterChain chain) throws IOException, ServletException 
        {            
            HttpServletRequest req = (HttpServletRequest)request;  
              
            // Check if the client is trying to access a protected resource.   
            String authHeader = req.getHeader("Authorization");    
               
           /* If header not present or value doesn't start with 'Basic '.*/ 
            	if (authHeader == null || !authHeader.startsWith("Bearer ")) {  
                   // Return a 401 unauthorized response and stop the filter chain   
                	HttpServletResponse res = (HttpServletResponse)response;    
                     res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);     
            	    return;        }   else {         // If present, try to decode it as Bearer token         
               String base64Credentials= authHeader.substring("Bearer ".length()).trim();      	    	 		   	     			 
              byte[] credDecoded = java.util.Base64.getDecoder().decode(base64Credentials);        	   				     					   }            	}          	       
}