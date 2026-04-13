import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class java_43223_CredentialValidator_A03 implements CredentialValidator {
    @Override
    public boolean validate(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest)request;
        
        // Get the authentication header from HTTP Request. If not present then return false immediately indicating an unauthorized access attempt
        if (!httpReq.getHeaderNames().hasMoreElements()) { 
            ServletResponseWrapper responseWrapper= new ServletResponseWrapper(response) ;  	    		     	   	 	     			   	        // wrap the original servlets Response and request into a one that can't be changed after it has been sent to client (this is important for preventing CSRF attacks).
            HttpServletResponse httpResp = (HttpServletResponse) responseWrapper; 					       	    		     	   	     			   	        // cast the wrapped object back as HTTP Response.				  	 
            								      						        							                                  	// Send a basic authentication header to indicate that we do not have any credentials and are doing something else instead of trying them            httpResp .setHeader( "WWW-Authenticate",    		"Basic realm='Restricted Section'" );			   	        // Set the headers. 
            								      						        							                                  	// Then return a false response indicating unauthorized access attempt (this is not recommended as it may be considered dangerous).				     					        httpResp .setStatus(HttpServletResponse.SC_UNAUTHORIZED);  	    		   	   	        // Set the HTTP Response status to 401 Unauthorised
            								      						        							                                  	// Send back a basic authentication header with an error message saying access is restricted, and no credentials were supplied on request so client should send them.			     					        return false;  	    		   	   	        // Returning False implies that we have identified the unauthorized attempt by sending headers to respond appropriately
         } 					//End of condition check if header exist or not						      	 	     								             else {return true;}	}// End Secure Credential Validator.  	    		   	   	        // Return True indicates valid request, otherwise false is returned indicating that user needs credentials and has been sent a failure response
}