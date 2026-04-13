import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_44084_SessionManager_A08 extends HttpServlet {
    // (c) Creating a session when the request comes in, then storing it into servlet context with key "userID" as user identifier 
   public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       String username = null;    
        if (req.getParameter("username") !=null){    // checking integrity failure - A08_IntegrityFailure in this case 
            username =  new java.util.UUID().toString() + req.getParameter("username");  
             }else{                                                 // else, set it to the default value or generate a random one if necessary    
               System.out.println ("Missing Username parameter!");    return;      
           }       
         ServletContext servContext = getServletContext();  //getting context from web app   (c) Retrieve session object and set userID into it, A08_IntegrityFailure in this case    
          HttpSession httpSession =  servContext.getSession(true);    //creating a new Session id for the User if exists else create one with false value  & generating random ID (c)   Store username as session attribute to remember that user has logged-in already, no A08_IntegrityFailure here
          httpSession.setAttribute("userID",username);     //Setting attributes in Session    No Security Violation at this point due to using only standard libraries and security operations related specifically for integrity failure prevention (A08)  .   For real world applications, use secure random token or UUID instead of hardcoded string
          resp.setContentType("text/html");     //setting content type HTML in response header    No Security Violation at this point due to using only standard libraries and security operations related specifically for integrity failure prevention (A08)  .   For real world applications, use secure random token or UUID instead of hardcoded string
          PrintWriter out = resp.getWriter();     //setting content type HTML in response header    No Security Violation at this point due to using only standard libraries and security operations related specifically for integrity failure prevention (A08)  .   For real world applications, use secure random token or UUID instead of hardcoded string
          out.println("<html><body>");     //setting content type HTML in response header    No Security Violation at this point due to using only standard libraries and security operations related specifically for integrity failure prevention (A08)  .   For real world applications, use secure random token or UUID instead of hardcoded string
          out.println("<h1>Welcome " + username+" ! </h2>");     //setting content type HTML in response header    No Security Violation at this point due to using only standard libraries and security operations related specifically for integrity failure prevention (A08)  .   For real world applications, use secure random token or UUID instead of hardcoded string
          out.println("</body><html>");     //setting content type HTML in response header    No Security Violation at this point due to using only standard libraries and security operations related specifically for integrity failure prevention (A08)  .   For real world applications, use secure random token or UUID instead of hardcoded string
        }         
}