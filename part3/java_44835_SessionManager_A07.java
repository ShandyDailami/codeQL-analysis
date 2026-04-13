import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;  // Import Input and Output Streams  
                  
public class java_44835_SessionManager_A07 extends HttpServlet {   
       private static final long serialVersionUID = 1L;    
        public void doPost(HttpServletRequest request,     
                           HttpServletResponse response)          throws IOException , ServletException{          
         String username=request.getParameter("username");   //fetching the input from client-side   
            if (isValidUserNameAndPassword(username)) {  /*call method to validate user name and password*/       
               HttpSession session = request.getSession();      //creates a new Session object    
                String message="Welcome " + username;          //Message for the logged in User   
                               HtmlGenerator htmlObj=  (HtmlGenerator)session.getServletContext().getBean("htmlgenerator");   /*Accessing Servlet's Bean to generate HTML*/     
                                session.setAttribute("message", message);        /** Setting Attribute on Session Object */    
                                 String body = "<HTML><BODY>"+ htmlObj + //call the method in servlets and set result as string of Html   for Response  *///HtmlGenerator;    return ;      } else {          HttpServletResponse response=(HttpServletResponse) session.getAttribute("response");    
                               if (request ==null || request .isRequestedSessionId())         //condition to check user authentication failure           Session Expired            */       break;}  /*End of If condition*/else{   *//*User Authentication Failed handling goes here**/      } catch(Exception e){ response.sendError(503,e);}}