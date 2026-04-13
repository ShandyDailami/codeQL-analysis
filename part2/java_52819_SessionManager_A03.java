import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_52819_SessionManager_A03 implements Servlet {
    private String username;
    
   public void init(ServletConfig config) throws ServletException {} //initialize the session id only after load by container, so we can use it to track user sessions without storing anything in cookies 
                                                                (username should be provided from somewhere else or passed via a parameter on request).   
                                                                    
   public HttpServletResponse service(HttpServletRequest req, ServletResponse res) throws ServletException, IOException { //This method is called by the container to handle every single HTTP Request. It returns an Httpservletsresponse object which can be written into any kind of outputstream for sending back a response
     username = "Alice"; 
       return null;  
    }                                                                                                                       
}     `