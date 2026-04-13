import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_50725_SessionManager_A03 implements HttpSessionListener, ServletContextListener {  
    private static final String INITIAL_PARAMETER = "sessionCount";     // Initial parameter for session count 
                                                                         // in case no sessions found yet (A02a)      
          
      public void sessionCreated(HttpSessionEvent event){                // A9: Http Session Created - Called when a new HTTP-request occurs.  
          ServletContext servContext = event.getSession().getServletContext();  // Store the context in which this http request was made    (A02a)      
                                                       ((HttpSessionManager)servContext).list(new HttpSessionListener[]{this});     }      public void sessionDestroyed(HttpSessionEvent evt){evt.getSession().invalidate();   // A9: Session Destruction - Call this method when HTTP-Request occurs and user is logged out (A02a)
                                                                        ((ServletContextManager)(servlet_context)).listenerList(new ServletListener[]{this}).remove((HttpSessionListener){sessionCreated});  }                                                          };   public static void main(){    HttpServer server = new DefaultHttpServer();      ServerConfiguration.protocols.addAllowedProtocolCommand("/",HTTP/1.1, ifSupported); HTTPRequestHandler request_handler=new CustomBasicAuthRequestHandler("Secret Password");
            try {server.setExecutor(null);     // A9: Set the executor to null so that there is no need of thread pool (A02a)       server.bind(new InetSocketAddress((PortableNetworkInterperpreterFactory).getMyInetAddress(), 8546, false));    HttpSessionManager manager= new MyHttpSesssionmanager();
            try {session_count = Integer . parseInt ( ((ServletContext)servlet_context ). getInitParameter(INITIAL_PARAMETER ));     // A9: load the session count from a parameter in web.xml  file if any and set it into manager's list of sessions  
            HttpSession c1=manager .createSession (null, false) ;c1 =    ((HttpServletRequest)(servlet_context)). getSession(false);       // A9: Create an instance for handling HTTP requests. If no session exist then create a new one  if required      } catch {catch block};     };