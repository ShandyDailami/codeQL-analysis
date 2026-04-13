import javax.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
  
public class java_47765_SessionManager_A08 extends HttpServlet {
    // Function to validate a user's identity and return status code (1=success,0=failure) 
      private int authenticateUser(String username , String password){    
        if((username=="admin") && (password == "secure")){  
           System.out.println("Authentication Successful!");    // simulate authentication successful with correct credentials          return 1; }       else {         println ("Invalid Login Details");      return 0;}            };             protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
           int authStatus = authenticateUser("admin", "secure") ;    // simulate authentication with correct credentials     if (authStatus == 1){         Session session=request.getSession();session.setAttribute("loggedInUser","Admin"); Response successfulResp;successfulResp  = response.addHeader ("Access-Control-Allow-Credentials" ,"true")
          .sendRedirect(response, "Welcome.html", true); } else {      //simulate failed authentication     println (authStatus) ;    HttpServletResponse httpRes = response   setContentType("text/plain"); writeOut ("Access Denied!" + authStatus );}}         };  protected void doPost(HttpServletRequest request,
           HttpServletResponse response){doGet(request ,response); }     public static void main (String[] args ){ ServletRegistration.Dynamic s = servletMapping.addServlet("SessionManager", SessionManager .class) ;s   setInitParameter ("asyncSupported" ,"true")         try {servletContext    .log("Server running on port "  + serverPort + "\n");} catch (Exception ex){ System.out.\
           out(ex);}}      `; //end of code block}}}