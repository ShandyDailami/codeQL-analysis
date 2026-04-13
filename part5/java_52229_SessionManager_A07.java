import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

public class java_52229_SessionManager_A07 extends HttpServlet {
    // Authenticate user in a dummy database 
    private static boolean authenticated = false;  
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{       
         String username=request.getParameter("username");          
         String password=request.getParameter("password");          // dummy database 
             
            if (isValidUser(username , password)) {                  
                authenticated = true;                                 
                 HttpSession session =  request.getSession();   
                  session.setAttribute("user", username);     
             } else{                                                   
               response.sendRedirect("login_failure");  // redirection to failure page          
            }  
        
        if (authenticated) {             
                try {                     
                   RequestDispatcher rd = request.getRequestDispatcher("/secureArea.jsp");                    
                    rd.forward(request, response);                         
                 } catch (Exception e){                                        // in case of error  handle here        
                  System.out.println("Error: " +e.getMessage());              
                }   
             else {                                                       
              RequestDispatcher dispatcher = request.getRequestDispatcher("/login_failure");         
                         try{                                         
                          dispatcher.forward(request, response);            // redirection to login failure page  and so on   if user is not authenticated     } catch block             e) {                   System.out.println("Error: " +e.getMessage());               }} });                     break;              default: throw new IllegalArgumentException("Unexpected value: " + request);}}