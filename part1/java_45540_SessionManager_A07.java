// Start with import statements (no external frameworks) only required at this stage are HttpServletRequest and ServletResponse. 
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;   
    
public class java_45540_SessionManager_A07 {      // We're defining our session manager as a Java bean (an Enterprise style)        
        private static final String AUTHENTICATED_USER = "authenticatedUser";  // This is the attribute name used for storing logged in user.  
      
    public void createSession(HttpServletRequest request,String username){    
           request.getSession().setAttribute(AUTHENTICATED_USER ,username);      }        // Creating session and setting authenticatedUser into it  .         
        
public String getLoggedInUsername ( HttpServletRequest request) {    return (String)request.getSession().getAttribute(AUTHENTICATED_USER );   }       // Getting logged in user from the Session     
        public void logout(HttpServletRequest request,  HttpServletResponse response){     try{          if((boolean)request.getSession().invalidate() ) {             System.out.println("User is successfully Logged Out");                  }}catch (Exception ex){System.out.println ("Error in logging out" +ex);} } //Logging user out
        public boolean validateUser(HttpServletRequest request, String password)    {   try{           if((password).equals(request.getSession().getAttribute("userPassword")) )  return true; else throw new Exception();}}catch (Exception ex){return false;}     // Validating the username and Password against stored values in session
}