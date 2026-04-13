import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_52307_SessionManager_A01 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String username = request.getParameter("username");  // Extract parameters from HTTP Request    
        String password =  request.getParameter ("password") ;   # Assuming we're using form-based login for simplicity   
      
            if (validateUser(username , password))                # Validate the user details with some kind of database or static data     
              createSession(request, response);                    # Create session and redirect to home page  after successful validation  
        else                                                      # If not validated - Redirect back again for error message   
            request.getRequestDispatcher("/WEB-INF/loginErrorPage.html").forward(request ,response );      
     }             
     
private void createSession (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {         # Create session and redirect to home page          
        // Here you can add the creation of a new Session if required. For this example just simply forward back                     
       RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/homePage.html");   
               rd.forward(req, res);         # Redirect to home page after successful login        }  
      private boolean validateUser (String user , String password) {          # Assume the database is a simple hash map with username as key and hashed pwd in array for simplicity      
            // Here you can use some kind of cryptography method or simply compare strings.  For this example just check if they're same  
         return (user != null && user .equals("admin") )&&(password!=  null || password.equals ("secret"));      # Returns true only for correct credentials else false     }          private boolean isNullOrEmptyString ( String str) {        // Function to check if the string has any value or not      
            return  ((str ==null  ||  "".equalsIgnoreCase(str));   };    });               }} );