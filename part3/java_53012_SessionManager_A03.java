import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_53012_SessionManager_A03 implements Servlet {
    private HttpServletRequest request; // holds the incoming Request object for each user's session  
    
        public void init(HttpServletRequest req) throws ServletException{  }           /* no operation */     
        
       public ServletContext getServletContext() { return null;}                  /* not used, but required by servlets and must be set to `null` in the initialisation of your class.*/   
       
     /*** This method is called before every request/response cycle *** 
          * Here we're using it for logging purpose */  
       public void destroy() {}                  /* no operation, but required by servlets and must be implemented to cleanup resources when the web application is stopped.*/   
       
      /*** This method will always return true because Servlet API doesn’t provide a way of knowing if it should process or not ***/ 
       public boolean getEnabled() {return true;}     /* no operation, but required by servlets and must be implemented to enable the class. */  
       
      /*** This method will handle every incoming request from client into server*******/   
          @Override         //marker annotation for methods in interface Servlet  -> implements this functionality through all its functions: init(), doPost()...etc (see below)     /* No operation, but required by servlets and must be implemented to perform initialization on the web application. */  
        public void service(ServletRequest req, ServletResponse ress){}      //No Operation -> Required for interface declaration    (* The method body can remain empty if you choose not to use it)*/ 
        
       /*** This Method is used by container in case of a POST request and will contain the logic related post handling like data parsing, processing or validation ***/  
          public void doPost(HttpServletRequest req, HttpServletResponse ress){}    //No Operation -> Required for interface declaration     (* The method body can remain empty if you choose not to use it)*/ 
        
        /*** This Method is used by container in case of a GET request and will contain the logic related get handling like data fetching or display ***/  
          public void doGet(HttpServletRequest req, HttpServletResponse ress){}       //No Operation -> Required for interface declaration     (* The method body can remain empty if you choose not to use it)*/ 
         }    /* Closing the code block */