import org.apache.commons.codec.binary.Base64;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;  // Import necessary classes for handling streams and servlets  
        
public class java_42891_SessionManager_A07 extends HttpServlet {    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         
        String userName = request.getParameter("username");     
        String password =  request.getParameter("password");  // Get the client's credentials        
               
       if (isValidUserCredentials(userName , password))   // Checking valid credential          
            createSessionCookie(response, userName);    // If authenticated -> Create a session cookie        else     
                                                                     return;             
                                                     
        response.sendError(HttpServletResponse.SC_FORBIDDEN,"Invalid username or password");      
                           } 
                        private boolean isValidUserCredentials (String userName, String Password){          // Authentication method         if ("admin".equalsIgnoreCase(user) && "password".equalsIgnoreCase(Password))           return true;            else             return false;}     
                          protected void createSessionCookie(HttpServletResponse response ,  String username ){        HttpSession session = null ;   try {          // Create a new Session     if (session ==null){         throw new IllegalStateException("Cannot find current user to get unique ID. ");}             setUserAsActive(username);          
              Cookie cookie  = new Cookie("active_user", username)  ;       String encodedSessionId = Base64.encodeBase64URL(session .getId().toString().getBytes());         // Add the session id to a base-64 url friendly string          Set-Cookie: JSESSIONID=28D0F13B9E5A7C8BFACCCFAAD; Path:/ 
           response.addCookie(cookie);}}   catch (Exception ex){            Logger.getLogger(SessionManager .class).log(Level.SEVERE, null ,ex );} }              // log exception          setUserAsInactive();             Cookie invalidate_session = new 
                      Cookie("JSESSIONID", "");         invalidate_session.setMaxAge(0);           response.addCookie (invalidate_session) ;}}    catch(Exception ex){ Logger .getLogger   (?SessionManager).log        Level..SEVERE, null ,ex );}}}