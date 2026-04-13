import javax.servlet.*;
import java.io.IOException;
public class java_51680_SessionManager_A01 implements Filter {   // Implements ServletFilter interface to manage session for all requests and responses here's a simple filter called "Secured" that will be used in the web application context (provided by Spring) 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {   // Implementing this method filters all requests to our servlets. This could include things like checking if a user is authenticated before allowing them access (implementation not provided in your question). 
        HttpServletRequest httpReq = (HttpServletRequest) request;    // cast the Servlet Request object into an equivalent HTTP one so we can get info about headers, parameters etc.  
         String headerValue=httpReq.getHeader("Authorization");     // Get Authorisation token from Header in case it's sent for example using JWT 
        if (headerValue == null || !(new BasicTokenHandler().validateAccessToken(headerValue))) {    // If the authorised header is not present or invalid, stop and return a simple message to client.  
            HttpServletResponse httpRes = (HttpServletResponse) response;      
             httpRes.setStatus(401);     // Respond with 401 status code which indicates Unauthorized access in the HTTP protocol suite
        } else {    // If authorised then proceed to next filter or servlet:  
            chain.doFilter(request, response);      // Proceeding if token is valid; otherwise request will be passed off and no further action taken  for security reasons (not provided by your question)    
         }}        }); }    protected class BasicTokenHandler { public boolean validateAccessToken(String access_token){...}}   private static final Logger logger = ... get a log instance in the constructor of this Class.       };`} // end secureSessionManager java code – do not remove or modify it