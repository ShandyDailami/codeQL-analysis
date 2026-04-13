import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.tomcat.*;

public class java_43862_SessionManager_A08 extends HttpServlet {   // Name of the servlet must be a capitalized name, and extend it from Servlet if you're going to implement HTTP methods (like GET/POST) 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{     }     
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {   }       //Implementing HTTP methods for GET and POST 
    public static SessionManager session;         //Static reference to instance of the servlets (Singleton Pattern). The advantage is that it provides global access. Useful if you want a central location from where all clients can get hold of this singletonservicemanagerinstance   .In other words, only one object for entire application and accessible throughout out app   
     private java_43862_SessionManager_A08(){};      //Private Constructor to restrict instantiation  by the 'new' keyword. We are using it as a Singleton Pattern implementation       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {}   }
}