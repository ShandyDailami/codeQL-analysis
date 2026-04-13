import javax.servlet.*;

import java.io.* ;;   // For Servlets and IO operations only, no JDBC or Spring functionality is involved in this example so importing them directly will suffice for now   

public class java_43725_SessionManager_A07 implements Servlet{        /* Define a new servlet called session manager */ 

     private static final String LOGIN_PAGE = "/login.html";         // Login page url, replace with real login pages  

                                                     

       public void init(ServletConfig config) throws ServletException {      /**/ }          /* Initialize the servlets only*/   

 

     public ServletConfig getServletConfig() { return null; };        // This method is used by container for initialization, not needed in our case  

         private HttpSession session = null ;                          /* Declare a static variable to hold reference of currently logged-in user */      

    @Override 

     public void service(ServletRequest req , ServletResponse res, ServletException ex) throws IOException {        // Handle incoming requests only  

          if (req ==null){System.out.println("serving null request") ; return;} /* No need to do anything else here */    System.out.print("\n  Do you have a session? ")      

           HttpServletRequest servReq =(HttpServletRequest) req;        // Upgrade the Servlet Request into something J2EE understands     

          if (session ==null || !session .isValid()){         /* If no valid Session, redirect to login page */    System.out.print("\n  You are not logged in ")       session = servReq.getSession();        // Get current HTTPSESSION and store reference for future use     

           if (((HttpServletRequest) req).getRequestURI().equals( LOGIN_PAGE)){         /* If this is a login request, go to the original page */  return;}       Response.sendRedirect("/index");          }catch {ex .printStackTrace(); }}   // Handling exceptions and print out for debugging    

}