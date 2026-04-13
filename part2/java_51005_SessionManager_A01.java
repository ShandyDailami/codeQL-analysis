import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_51005_SessionManager_A01 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Create a session and set it to the user if not already exists 
       UserSession user = new UserSession();  
          String username=request.getParameter("username");     
           boolean isNewUserLogin;    
         SessionManager sm =  (SessionManager) request.getSession(true);    // Create a session object from HttpServletRequest if it doesn't already exist 
            user =sm .getInstance().loadUserByUsernameFromDatabaseOrCache(username, response ,isNewUserlogin );  
           String name=user.getName();     SessionManager sms =  (SessionManager) request.getSession() ;    // Retrieve the session object from HttpServletRequest  and set it to a variable user_session     
            if(!name .equals(username)){          System.out.println("Attempted access by unauthorized person"); } else {System. out. println ("Access granted as User " + name  + "_id="+user._ID );}   // Load the session object into variable user_session
    }}  @Override public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException{doGet (request,response);}}`;// Calls get method to maintain state of users logged in. Called by submit buttons on webpages using the POST HTTP verb and includes a hidden field with user input 
private static final long serialVersionUID = 1L;}   // This is for checking Serialization ID which cannot be null or empty as required by Java’s OOP concepts but it'd also prevent any potential deserialisation if this class changes.`;     HttpSession session = request .getSession(); 
private static SessionManager instance=null ;    private User user_session =  newUser ();   //Create a object to store the username and password of each logged in person          void setUsernameAndPassword(String u, String p) throws Exception {this.user_.setName ((u)); this .password =p;}} 
private static final Logger logger=LoggerFactory.getlogger (SessionManager ) ;    private User user_session =  newUser();   //Create a object to store the username and password of each logged in person          void setUsernameAndPassword(String u, String p) throws Exception {this .user_.setName ((u)); this 
!password =p;}}}`});// Calls doGet() method. This is how we can maintain state between multiple requests from a client to the server using HTTP methods like GET and POST for web services or RESTful APIs   // Called by submit buttons on forms with 'submit' button type