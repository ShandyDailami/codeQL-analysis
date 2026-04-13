import javax.servlet.*;  // Import the Servlet API classes if necessary  
import java.io.IOException;   
public class java_50881_SessionManager_A08 implements ServletFilter {    
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{     
            HttpServletRequest httpReq = (HttpServletRequest)request ;  // Downcast the servlets to get access of HTTP Request object   
  
             String userID=httpReq.getParameter("userid");    
                if(isValidUserIdAndPasswordSetInSessionCookie(userID)){     
                    chain.doFilter(request, response);       // User is authenticated and request continues to be processed by next servlet  
               }else{       
                   HttpServletResponse httpResp = (HttpServletResponse)response;   
                  String message="Invalid userid or password";  // Creating a failure reason for the unauthorized access.    
                    setErrorMessageAndRedirectToLoginPage(message,httpReq,httpResp);  
               }     
        }        
       private void setErrorMessageAndRedirectToLoginPage (String message ,HttpServletRequest httpReq  , HttpServletResponse httpResp)throws ServletException{     // Method to send error messages and redirects user'to login page.    ..... remaining code is omitted for brevity }
       private boolean isValidUserIdAndPasswordSetInSessionCookie(String UserID){   ...remaining code in the method body  ....}     
        public void init(FilterConfig filterconfig) throws ServletException{     // Do nothing but required by servlets.    ..... remaining code omitted for brevity }      
         public void destroy(){.. doNothingButRequiredByServletAPI()................. }}