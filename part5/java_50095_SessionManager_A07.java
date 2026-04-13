import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;   // Import required classes   
    
public class java_50095_SessionManager_A07 extends HttpServlet {     
       public void doPost(HttpServletRequest request,       
                          HttpServletResponse response)         throws ServletException, IOException 
          {            
               String username = request.getParameter("username");          
               boolean isAuthenticated =  // Check if user has been authenticated somewhere else in your application    ;    
                    
              /* If the provided credentials match a registered account (in this case we are assuming database authentication),  */       
             HttpSession session = request.getSession();  
                
            String message="";              
           if(isAuthenticated) {         // User is authenticated, create an attribute in Session and redirect to welcome page    
                session.setAttribute("username", username);   
                   response.sendRedirect("/Welcome");  }       else{   /* If not Authentication successful then set error message */            
                 request.setAttribute("message","Invalid Username or Password!");        return;}          // sending back to the form with errors    
           session.setAttribute("username", username );         }}