import javax.servlet.*;
import java.io.IOException;
public class java_52639_SessionManager_A03 implements Filter {     // Declare a new filter named 'Session Manager'   
                                                 private static final String INIT_PARAM = "init-param";     
                                         
                                             @Override                                            public void doFilter(ServletRequest request, ServletResponse response ,                            
                                         FilterChain chain) throws IOException, ServletException {          // Declare a method for doing filter with input and output as servlets Request & Response 
                                                 HttpServletRequest httpReq = (HttpServletRequest)request;  
                                         
                                             if(httpReq.getMethod().equals("GET")){                             // Check the HTTP request's Method is 'Get'. If so, then get a Session id from it         
                                                String sessionId=((HttpServletRequest)request).getParameter('sessionID');  /* Assuming there will be an unique parameter in httpReq to fetch sessions */    
                                                 if(isSessionValid(sessionId)){                             // Check whether the fetched Session ID is valid or not        
                                                      chain.doFilter(request, response);                         // If it's a Valid session then pass this request and Response back to next Filter in Chain   }  else { ...}     throw new ServletException("Invalid/Expired Session");       }}                          /* Else catch the Exception */               
                                                  @Override                                            public void init(FilterConfig filterconfig) throws ServletException {}      // Declare an Init method for Initialization of Filter    private boolean isSessionValid (String sessionId){...}     return false;}}  } c. Do not use external frameworks like Spring or Hibernate, the code uses only standard java libraries and does NOT involve any third-party packages/frameworks such as Servlet API etc