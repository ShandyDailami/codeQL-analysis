import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class java_53405_SessionManager_A07 implements SessionListener {   // a session listener is created that listens for changes to sessions, i.e., when they are started or ended  (A07_AuthSuccess) and it's responsible also in managing invalid/failed authentication attempts by the user(i.e., handling logouts).
    private static final String LOGOUT_URL = "/logout"; // This URL should match with your LogOutHandler to perform onLogout() method  (A07_AuthFailure)   and it's used for logging out a session from the server-side. You can use any url as per requirement
    private static final String LOGOUT = "logout"; // This parameter is sent along with each request when user wants to logOut, usually set by Ajax calls or similar  (A07_AuthFailure) and it's used for identifying the action in which case onLoggedin() method should be called
    
    public void sessionCreated(SessionEvent se) { } // This is invoked whenever a Session has been created. It doesn’t do anything as of now, but you can use this place to set up your initial state or perform any setup required for the new user (A07_AuthFailure).  
    
    public void sessionDestroyed(SessionEvent se) { // This method is called whenever a Session has been destroyed. It doesn't do anything as of now but you can use this place to clean up resources used by your application when it’s shut down (A07_AuthFailure).  }
    
    public void sessionInterrupted(SessionEvent se) { // This method is called whenever a Session was interrupted. It doesn't do anything as of now but you can use this place to perform any cleanup tasks required during the interruption period such that no data may get lost (A07_AuthFailure).
     HttpServletRequest request = se.getSession().getLastAccessedRequest(); // Getting a Last Access Request for Session from Servlet API  which will be useful in identifying if session was idle or not, and it's used to generate logout URL(i.e., /logut) based on user’s choice (A07_AuthFailure).
     String url = request == null ? "" : "?" + request.getQueryString(); // Getting the query string if any from last accessed Request, and it's used to generate logout URL(i.e., /logut) based on user’s choice (A07_AuthFailure).
     String context = se == null ? "" : "?" + ((HttpServletRequest)se.getSession().getLastAccessedInstance()).getContextPath(); // Getting the last accessed instance if it's Servlet API request and its used to generate logout URL(i.e., /logut).
     StringBuffer sf = new StringBuffer((url == null ? "" : url) + (context ==  null? "": "/")+LOGOUT); // Generating the LogOut Request, which is sent along with each request when user wants to logout and it's used for generating URL(i.e., /logut).
     se.getSession().setAttribute("LastRequest", sf );//Setting a LastAccessedInstance in Session attribute so that we can use last accessed instance later on which will be useful while logging out from server-side (A07_AuthFailure)  .    }        // This is the implementation of how you should generate logout URL.
     private void performLogOut(HttpServletRequest request, HttpServletResponse response){   // Method for handling Logouts by using Servlet API and it's used to handle user’s choice (A07_AuthFailure).  }      @Override public void sessionCreated(SessionEvent se) {}         
     private static final String LOGOUT = "logout";           /* This parameter is sent along with each request when a person wants log out, usually set by Ajax calls or similar and it's used to identify the action in which case onLoggedin() method should be called */        // A07_AuthFailure
     private static final String LOGOUT_URL = "/logout";   /* This URL is responsible for handling log out request from server-side (A07_AuthSuccess) and it's used to match with onLogOut( ) method in LogutHandler.java */       // A06, 
     @Override public void sessionDestroyed(SessionEvent se){ }   /* This is invoked when a Session has been destroyed but not yet interrupted (AO7_AuthFailure). The implementation here can be left blank as per requirement and it's used for clean up resources in case of server-side */
     @Override public void sessionInterrupted(SessionEvent se){ }   /* This method is called when a Session was stopped or terminated by the client (A07_AuthFailure). The implementation here can be left blank as per requirement and it's used for clean up tasks during interruption period required in server-side */
     public static void main(String[] args){ }   // This is simply to call other methods from within this class, not a standalone program.   
}  /* End of AuthFailureSessionManager Java Class*/