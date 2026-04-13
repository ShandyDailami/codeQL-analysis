import javax.servlet.*;
import java.io.*;
//Java Servlets API provides the HttpServlet class java_49144_SessionManager_A03 is our handler (filter) and service provider interface that allows a servlet to interact with both HTTP/1.0 requests, 
 //HTTP headers or client sessions in addition it also supports cookies as part of request-response lifecycle   .   
public final class SessionManager implements javax.servlet.http.HttpSessionListener {    
private static int activeSessions = 0;         private boolean secure = false;      public void sessionCreated(ServletRequest req, ServletResponse res, HttpSession sess) throws IOException {}        //Default behavior is not to execute anything (uncomment following lines for actual use-case scenario).  .    def
!.sessionDestroyed() { activeSessions--;}   } else{sout("Unsecure session : " + id);}return true;}}`     public static void main(String[] args){ServletRequest req =...      HttpSession sess =  ...req getContext().getSession();   
!.setAttribute('username','testUser');  if(!isSecure()) {sout("Insecure session : " + id);}return true;}}`     public static boolean isSecure(){ return secure;} }   //To change body of created methods use File | Settings |