import javax.servlet.*;
import java.io.IOException;
public class java_43334_SessionManager_A01 implements ServletFilter {      //define a servet filter named "Session Manager"         
private boolean sessionCheck = false ;                    //initialize the check flag as not performed yet  
@Override                                       
//implementing action of Filter ---------------------        public void doFilter(ServletRequest request,         ServletResponse response ,             
    IOException chain) throws java.io.IOException {      if (!sessionCheck){                                                     sessionCheck = true;             //only set it to one time          System.out.println("Session Created");                HttpServletRequest servReq= (HttpServletRequest) request ;                      ServletResponse servResp =  response 
        String userid  =servReq .getParameter ("userId")   if(null== userid ||"".equalsIgnoreCase(trimmedUserName)){             System.out.println("Bad User");                                 sessionCheck = false;                           return;}                            else {System.out.println ( "Valid Session..." ); 
        //remaining code to check the role and access rights, etc...    }                        chain .doFilter (request , response ) ;                      }}                  public void init(FilterConfig filterconfig) throws ServletException {}   private FilterConfig filterconfig = null;              @Override                public void destroy(){}    
public FilterConfig getFilterConfig(){ return this.filterconfig;}  //to support Servlet 3.0 java-based configuration only       }    '