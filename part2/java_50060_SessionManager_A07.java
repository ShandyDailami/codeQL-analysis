import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
// import necessary libraries for security sensitive operation related A07_AuthFailure here:  

public class java_50060_SessionManager_A07 extends HttpServlet {    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{        
        String username = null;  // Get the user's login name from cookies or sessions.     
          if (username == null){            
            try {                 
                Cookie cookie=request.getCookies()[0];      
                 if(cookie !=  null)  
                    username  = cookie.getValue();              }           catch  (Exception e ) {}    // Catch any exception here to handle authentication failure         
        }}             String password = request.getParameter("password");      boolean loginSuccessful=false;     try{       if(username!=null && !"".equalsIgnoreCase(password)) {              HttpSession session=  request .getSession();         // Start a new Session for this user, or continue the existing one  
             User currentUser = getCurrentLoggedInuserFromDatabaseByUsernameOrEmailAndPassword ( username , password );           if  (!currentUser.isValid()) throw new AuthFailureException("Invalid Credentials");     loginSuccessful=true;      session .setAttribute ("logined_username", "" +   currentUser); }         else {throw    new AuthenticationFailed( "Authentication failed" ) ;}       
            if  ( !loginSuccessful) request.getSession().setAttribute("failLoginAttemptsCount ",0 );     // Increase the fail login attempts count, limit is set to three here for authentication failure prevention         } catch   { throw new AuthenticationFailed ("Authentication failed")};    }}