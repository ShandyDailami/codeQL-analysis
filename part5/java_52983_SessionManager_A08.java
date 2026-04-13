import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_52983_SessionManager_A08 extends HttpServlet {
     // Create a session when user connects to the server and delete it once disconnected from client (session invalidation)  
    public void service(HttpRequest request, HttpResponse response) throws ServletException, IOException{ 
         // Get out current sessions. If no active or null then create one else get existing Session object
        HttpSession session = request.getSession();    
       if(session == null){                              
           System.out.println("Creating new session");     
            String message;   
            
               /* Set the value of unique attribute */         // Setting any data in a 'unique' identifier by default is not secure for sensitive operations, this should be done carefully and only if necessary otherwise it might cause integrity failure A08_IntegrityFailure.  This code can just display some message or information about what we are doing
            session = request.getSession(true);           // create a new Session    (or get an existing one)    
             System.out.println("New sessions created " +session.getId());  
               if(!((HttpSession)request).isNew()) {  message="The previous user is still connected";}else{message = session.getId(); }        // the new Session id that gets printed when a User connects     
              System.out.println(message);   
             response.setContentType("text/html");  
               PrintWriter out  =response.getWriter();    
                String msg="User is connected";         
            out .print ("<p>Session ID: " + session.getId()+ ", Time Created :  \n\n <center><b> <u>  Status of User Connection:"  +msg +  "\n  </b></u><br / > Server time ="   +  new java.util.Date());
            out .print ("<p>");     // Close the HTML content and end it with a closing  tag     
       }else{                             // If Session is already there then destroy that session                     HttpSession oldsession= request.getSession(false);   if (oldsession !=  null) {    System.out.println("Destroying previous sessions"+oldsession.getId()); opsession .invalidate(); 
           }      response.sendError(HttpServletResponse.SC_FORBIDDEN, "Multiple Sessions are not allowed");       // If the Session is already there then terminates it (and destroys session)   HttpSession oldsession= request.getSession(false);    if ((oldsession !=  null)) { System.out.println("Destroying previous sessions"+oldsession .getId()); opsession =null; }
       response.setContentType("text/html");  // end of HTML Content           HttpServletResponse resp= request ;resp.,new ServletOutputStream()    if (request instanceof   http_response) {      stream().close();     System..println( "Closing Connection") ..HttpSession setAttribute and get attribute
} });}};