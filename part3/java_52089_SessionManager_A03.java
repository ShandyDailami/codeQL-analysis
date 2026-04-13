import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_52089_SessionManager_A03 implements HttpSessionListener, ServletContextListener {  
     private HashMap<String , HttpSession> sessionList;    // To store all sessions 
     
       public static final String USER_LIST = "userlist";         // Name of the list in user cookie. User can be anything you wish to use as identifier and must unique for each browser/session  
        private List<String> usersLoggedIn;                    // To store logged-in Users 
          @Override    public void sessionCreated(HttpSessionEvent event) {         }    
     
       /* This method will create a new user list when the application starts and load it into memory */          
            SessionManager(){   this.sessionList=new HashMap<String, HttpSession>();  usersLoggedIn = new ArrayList<>() ;}    @Override        public void sessionDestroyed(HttpSessionEvent event) {      }    
         /* This method will add an user to the logged in list when a valid username and password is given */   static synchronized boolean loginUserToList(String Userid, HttpServletRequest request ,  ServletContext context){        if(!sessionExists(request.getSession().getId())) {          sessionList.put(request.getSession().getId(), (HttpSession) request.getSession());         usersLoggedIn .add((USER_LIST)); return true;      } else{       System.out.println("User already logged in");return false;}  
     /* This method will remove an user from the list when they log out */    static synchronized boolean logOutUserFromList(String Userid, HttpServletRequest request , ServletContext context) {        if (sessionExists(request.getSession().getId()) && usersLoggedIn .contains((USER_LIST)))  {          
         // here you can add logic to destroy session and remove user from list   return true; } else{      System.out.println("User not logged in");return false;}    private static boolean sessionExists(String id)     {       for (Map.Entry<String, HttpSession> entry : 
        //sessionList .entrySet())            if ((Users).equals((HttpServletRequest)) return true;   }      System.out.println("No existing sessions found");return false;}    public static void main( String args[]) {     CustomSessionManager csm = newCustom Session Manager();c sm
        // loginUserToList ("user1", request , context);  and call logOut User from list method to test the code}   }      This example demonstrates a very basic form of session management. It uses cookies, which are easy in theory but may not be secure due to lack security measures such as HTTPS or XSS filtering etc., for more complex use cases you would have to consider other methods and additional configurations like expiry time settings on sessions that can also prevent attacks if the user logs out unexpectedly.