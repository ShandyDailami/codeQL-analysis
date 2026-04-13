import javax.servlet.*;
import java.io.*;
public class java_50434_SessionManager_A01 implements ServletFilter {   //implementing servlet filter instead of session manager because it's more suitable for managing sessions (e.g., logging in, out) rather than dealing with user access levels or roles only 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {   //do filter method should be named 'doFilter' not just servlets and filters like this. Also you can name the class as SessionManager if it is a session manager or use whatever makes sense in your context
        HttpServletRequest httpReq = (HttpServletRequest) request; 
         String username=httpReq.getRemoteUser(); //Get user information from HTTP Request   - This method will return null unless you are using integrated authentication mechanism such as form-based login or header based like JWT etc in your application, which is not mentioned here for the sake of simplicity   
        if (username ==null || ! username.equals("user")) {  //Checking user access level - In real life scenario it should be more sophisticated and check roles too  
            HttpServletResponse httpRes =(HttpServletResponse) response;    
             httpRes.sendError(403, "Access Denied!");    //HTTP Status code of 'Forbidden' with a message stating that the user is not authorized to access this resource  - In real life scenario you would want more sophisticated responses  
        } else {      
            chain.doFilter(request, response);    
         }}     
}