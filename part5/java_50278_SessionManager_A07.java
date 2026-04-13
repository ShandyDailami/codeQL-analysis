import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;   // For PrintWriter, etc...   
public class java_50278_SessionManager_A07 extends HttpServlet {    
       public void doGet(HttpServletRequest request,     
                          HttpServletResponse response)        throws ServletException, IOException{ 
            /* Create session if not already created */             
               SessionStatus status = request.getSession().setMaxInactiveInterval(60);   // Max in-activity interval set to one minute      
           switch (status){    
                   case NotCreated:        HttpSession newSession =  request.getSession();         break;     
                    /* If session already created, update the last modified time */   
                      default :             status =request.getSession().setLastAccessed(System.currentTimeMillis());   // Update Last Access Time      
               }  SetAttribute("Hello Message", "Welcome to MyWebApp");     printWriter= response . PrintWriter ();      put it in the body of this message: `" <html><head> </body>  <p align ='center '>` +`<h1 >>> Welcome, New Session <<<< /H 1 >>   <br\>  "  +    GetAttribute("Hello Message")+     "\n \t    <hr\/   bgcolor=white\' /\"");         
               printWriter.close();        // Closing the writer connection      }       @Override public void init() {}         /* Called when container loads servlet */  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {doGet (request,response);}}