import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_46771_CredentialValidator_A03 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");   //a01: Injection attempt here (user can provide input directly in URL as parameter), removed for simplicity purpose above code will not run properly without this part of the program 
        if(isValidUsernameAndPasswordCorrect(username)){     //assume we have a method to check whether username and password is correct. This function has been left out because it's highly sensitive (e.g., SQL Injection attack). The actual implementation depends on database schema, user table etc
            response.getWriter().println("Valid User");       //if credentials are valid then print "valid" to the screen 
        } else {                                             //else say invalid and don’t show anything in webpage (or any error message)
           response.setStatus(401);                         //this is a HTTP unauthorized status code which indicates that there's no valid authentication credentials for this request  
         } 
    }                                                      
                                                                     
     public boolean isValidUsernameAndPasswordCorrect (String username){       //assume we have method to check whether given user name and password matches in our database. This function has been left out because it's highly sensitive(e,g., timing attack)  , the actual implementation depends on security aspects of your system
        return true;                                            /*if provided credentials are valid then returns True else False */   }    //simulated check (not secure or vulnerable in itself). Here only for demonstration purpose. Real-world code would use a proper database to validate login details with an encrypted password stored safely and not hardcoded into the program
}