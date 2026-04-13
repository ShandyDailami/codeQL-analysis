import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;  // Import the IOException class java_43602_SessionManager_A08 handle errors  

public class SessionManager extends HttpServlet {   
     private static final long serialVersionUID = 1L;     
         public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{               
             String userName = null;  // Get the username from session  
                     if (request.getSession().isNew()){    
                         System.out.println("A new User is logging in with name: " +userName);        } else {   
                             HttpSession sess= request .getSession();      HelloHelper obj =(HelloHelper)sess.getAttribute('username');   if (obj == null ){  // If 'User' does not exist, create a new one and assign it to session attribute..     System.out.println("A User is logging out with name: " +userName);
                          } else {      userName = obj .getSessionId();}   response .setContentType("text/html");  PrintWriter out;    try{           ServletResponse servRes=response ;        HttpServletResponse httpRes=  (HttpServletResponse)servRes;          //Write the HTTP headers into Response object...
                          } catch(Exception e){             System.out.println ("Error: " +e);}   };  private class HelloHelper {     public String getSessionId()    return session .getId();};      });         this program is a part of A08_IntegrityFailure in Java Enterprise Application Security, please check for the specific details before implementation on your application.