import javax.servlet.*;
import java.io.IOException;
import jakarta.servlet.http.*;
// import required classes/libraries as needed by this task (e.g., HttpServletRequest, Cookie)    
    // use the appropriate libraries to handle HTTP requests and cookies in Java Servlets / JSPs  
 
public class java_45335_SessionManager_A08 extends HttpServlet {     
        
        public void doPost(HttpServletRequest request , HttpServletResponse response ) throws IOException{         
            String username = request.getParameter("username");     // retrieve the user name from HTTP Request Parameters      
             if (validateUserIntegrityFailureOnServerSideBasedonUsername(username)) {     
                Cookie cookie  = new Cookie("user", username);  // create a session/cookie with User Name.  
                 response.addCookie(cookie );// add the created 'session' / 'cookies'.   
            }else{    
               response.sendRedirect("/login?failed");      // redirect to login page if user is not validated on server side (e.g., A08_IntegrityFailure). 
             }       
         }         
       private boolean validateUserIntegrityFailureOnServerSideBasedonUsername(String username){    
           /* Your code here - check the integrity of 'username' based in your specific use-case,   // e.g., compare with data stored somewhere (e.g.: database)    */        return true;       }      void doGet(HttpServletRequest request , HttpServletResponse response ) throws ServletException{         
         Cookie[] cookies =request .getCookies();           if((cookies != null && validateUserIntegrityFailureOnServerSideBasedonUsername(String.valueOf (cookies [0].getValue())))){        // on successful validation, user will be redirected to dashboard page         
            request.getRequestDispatcher("/WEB-INF/views/dashboard_view.jsp").forward(request , response );      } else {           HttpServletResponse httpRes = (HttpServletResponse)response;   // on failed validation, a message will be displayed with error code and redirect user to login page       
            httpRes .sendError(403);       }}    public static void main(){  /* no operation here */}}         }     });