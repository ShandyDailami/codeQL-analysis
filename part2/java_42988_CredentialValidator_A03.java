import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  // Assuming Spring Security is used, you may need to use @Component instead if it's not the case in your application context  
                                              (Spring MVC or other frameworks)   
    
@Controller ("LoginServlet")       // This name must match with servlet-mapping configuration from web.xml 
public class java_42988_CredentialValidator_A03 extends HttpServlet {       
      private static final long serialVersionUID = 1L;        
   @Autowired                     
            PasswordEncoder passwordEncoder ;    // Spring Security's AuthenticationManager and UserDetailsService are used to encode/decrypt data.    
      
public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
        String username = request.getParameter("username");      // Get the input from HTML form   
        String password = request.getParameter("password") ;         // Also get it in html and decode data to prevent Injection attacks    
          if (checkPassword(username ,  password)) {            /* check for injection attack by comparing user entered string with database stored plain text */  
                  HttpSession session=request.getSession();       //Store the username into a Session   
                   session.setAttribute("user",username);        //also store it in attribute, can be used to identify logged users later  if required    
              response.sendRedirect("homepage");               /* Redirection after successful login */   }            else {                errorMessage="Invalid Credentials";         return;      }}           public boolean checkPassword(String userName , String password)    // Spring Security's Method for comparing Hashed Password with the stored one.