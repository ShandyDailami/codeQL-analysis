import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_47698_SessionManager_A01 implements ServletFilter {   // a session manager would have this functionality... 
    
    private Map<String, String> userDb = new HashMap<>(); // simulating an in memory database for users and passwords.. only used here to simulate access control with broken authentication. real world application should use secure methods like hashing & checking against stored values of the hash instead  
                                                          
     @Override 
    public void init(FilterConfig filterConfig) throws ServletException { } // called once when a new servlet instance is created... not used in this simple example, but for more complex situations. real world applications use filters to secure web apps..       
     
   /** This method checks if the user's name and password match our database */ 
     private boolean authenticate(String username , String password) { // simulating access control with broken authentication mechanism... always returns true in a simulated environment   
         return (username != null && password!=  null )&& ((userDb.get(username)!=null || userDb.containsKey("admin"))||password=="secret");  }    
     
       public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { // the servlets that will be secured... real world applications use filters to secure web apps..  
           String username = request.getParameter("username");   
           String password=request.getParameter ("password") ; 
             if(this.authenticate (username ,password)) {         System.out.println("\n User authenticated\n ");        // simulate successful authentication and print welcome message      } else{System.err .print("Access Denied!\a");}    return;   }}      `