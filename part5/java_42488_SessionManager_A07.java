import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
  
public class java_42488_SessionManager_A07 implements Servlet {     // Declare the servlet interface that we'll implement here in this example, just for convenience of syntax checking later on... (a) 
    public void init(ServletConfig config) throws ServletException {}             // Initialize our object. No-op as per instructions given.(b). This is to satisfy a contract with the servlets container we're using here., c.) Just an example, not real requirement in this context... (d)
    
    public HttpServletRequest getReq(HttpSession session){                       // Get our request object from httpsession. No-op as per instructions given.(b). This is to satisfy a contract with the servlets container we're using here., c.) Just an example, not real requirement in this context... (d)
    
    public HttpServletResponse getRes(HttpSession session){                      // Get our response object from httpsession. No-op as per instructions given.(b). This is to satisfy a contract with the servlets container we're using here., c.) Just an example, not real requirement in this context... (d)
    
    public void service(HttpServletRequest req , HttpServletResponse res ) throws ServletException {}                   // Service method. No-op as per instructions given.(b). This is to satisfy a contract with the servlets container we're using here., c.) Just an example, not real requirement in this context... (d)
    
    public void destroy(){}                                                        // Destroy our object once done by calling init(ServletConfig config), No-op as per instructions given.(b). This is to satisfy a contract with the servlets container we're using here., c.) Just an example, not real requirement in this context... (d)
    
    public ServletConfig getServletConfig() { return null; }                       // Return configuration object from request or response. No-op as per instructions given.(b). This is to satisfy a contract with the servlets container we're using here., c.) Just an example, not real requirement in this context... (d)
    
    public String getServletInfo() { return null; }                               // Return information about our servlet. No-op as per instructions given.(b). This is to satisfy a contract with the servlets container we're using here., c.) Just an example, not real requirement in this context... (d)
    
}