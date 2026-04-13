import javax.servlet.*;
import java.io.IOException;
// Import HttpServletRequest,HttpSession and SessionListener interface to use them in your servlets  
public class java_48091_SessionManager_A03 implements Filter {     // Define a new filter named "My Security"   
      @Override              public void init(FilterConfig config) throws ServletException {}         // Initialization code goes here      
         
  /** Invoked for every request */       
@Override                    
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)                     
throws IOException , ServletException {     servReq= (HttpServletRequest)req;            HttpSession session= 
servReq.getSession();              // Get the current Session         if (session==null){                  String username =                                                                    
servReq.getRemoteUser() ;   }          System.out.println("Authenticated user: "+username);           try {  chain.doFilter(req, res)       };             catch (IOException | ServletException e )    {}                      // Proceed in the filter-chain if not rejected
      @Override                   public void destroy(){}                            }                                   protected and private methods are declared with their access specifiers   only within this class to provide encapsulation.  This is an example of a security sensitive operation related injection (A03_Injection). In real application, the username would come from some source like user information service or external database where we do not want anyone in-the end accessing our data and there should be restrictions on how they can use it such as role level based access control etc.