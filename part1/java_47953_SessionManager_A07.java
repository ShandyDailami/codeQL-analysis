import javax.servlet.*;  // Import Servlets, Filters etc from servlet package  
import javax.servlet.http.*;    //Importing HttpServletRequest & Response for Session Management    
import java.io.*;       //IO related classes imports     
//Session management using Cookies only (not recommended in production environment) 
public class java_47953_SessionManager_A07 implements Filter {       
 public void doFilter(ServletRequest request, ServletResponse response,   
           FilterChain chain) throws IOException, ServletException        
{         
 HttpServletRequest httpReq = (HttpServletRequest)request;      //Casting the Request to HTTP    
  
 if ((httpReq.getMethod().equalsIgnoreCase("POST")) &&      
        (!(httpReq.getRequestURI()).contains("/login") || 
         !(httpReq.getRequestURI()).contains("/register")))          {             //Only for login and register requests    
  HttpSession session = httpReq.getSession();              //Creating a new Session     
   if (session == null || session.isNew())                {                 
    response.sendRedirect(httpReq.getContextPath() + "/login");             //redirection to login page        }                   else    
  System.out.println("User is already authenticated, redirecting...");       return;          }}           catch (Exception ex)      {}   try {chain.doFilter(request, response)}                      catch (IOException e){}    }              };               // End of Filter class}}                public void init(FilterConfig filterconfig)  throws ServletException{}public void destroy()         {}