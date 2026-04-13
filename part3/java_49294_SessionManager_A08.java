import org.springframework.security.access.AccessDeniedException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
  
public class java_49294_SessionManager_A08 implements Filter {
    private final String[] ILLEGAL_SESSIONS = {"IllegalSession1", "ILlegAlSeSSION2"}; // replace with your actual session names list 
     
     @Override        
       public void doFilter(ServletRequest request, ServletResponse response, javax.servlet.FilterChain chain) throws IOException, ServletException {  
            HttpServletRequest httpReq = (HttpServletRequest)request;          
             if(!checkSessionIntegrity(httpReq)) throw new AccessDeniedException("Access Denied"); // access denied exception 
                  else chain.doFilter(request, response);          }    
    private boolean checkSessionIntegrity(HttpServletRequest request){     
            String sessionId = request.getSession().getId();      
              return !isIllegalSession(sessionId) ;   }}` // if it's not an illegal one then pass  else false       
             public void init(FilterConfig filterconfig) {          }     @Override        
               protected Object getObject() throws Exception{return null;}    private boolean isIllegalSession (String session){      for ( String s: ILLEGAL_SESSIONS ) if (s.equalsIgnoreCase(session)) return true;       //true in case of match else false }          public void destroy(){     }}