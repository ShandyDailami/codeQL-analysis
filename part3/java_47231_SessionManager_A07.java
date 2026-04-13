import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails; 
import javax.servlet.*;  
import java.io.IOException;   
public class java_47231_SessionManager_A07 implements Filter {     
@Override public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {      
        HttpServletRequest request = (HttpServletRequest)req;  //get the authentication details  
         if("POST".equalsIgnoreCase((request).getMethod()) &&("/login").equals(request.getRequestURI())){   
            Authentication authResult =  SecurityContextHolder.getContext().getAuthentication();//authenticate and authorize user    
        }  //end of security check  
         chain.doFilter(req, res);     
}      
@Override public void init(FilterConfig filterconfig) {    FilterUtility.setFilterEnabled = false; }           @SuppressWarnings("unused") private static class FilterUtility {}  //dummy utility for enabling/disabling the custom security filer        
      protected boolean shouldNotFilter(HttpServletRequest request){ return true;}   public void destroy(){}    
}