import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.servlet.*;
import javax.servlet.http.*;
public class java_43553_SessionManager_A01 implements Servlet {  
    public void init(ServletConfig config) throws ServletException {} 
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{           
        String name =request.getParameter("name");              
       // Use a BCryptPasswordEncoder to hash passwords for security (optional).     
         if(!new BCryptPasswordEncoder().matches(password , "$2a$10$E6OnlineKeyhere")) {           
             response .sendRedirect("/login?auth=failed");          }           else{              
                HttpSession session = request.getSession();     //start a new Session  if the user isn't authenticated     
                 session	.setAttribute("name" , name);              System.out.println ("Welcome " + name+ ", You are now logged in ");}            }          else{             response .sendRedirect("/login");}}   }) );