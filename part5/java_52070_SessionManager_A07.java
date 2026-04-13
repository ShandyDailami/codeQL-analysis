import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
// import org.apache.commons... and use it for hashing password, etc.. but this is not needed as we are using only standard Java libraries here with no external tools or frameworks  (e.g., Spring)    
  
public class java_52070_SessionManager_A07 implements ServletFilter { //ServletContextAware also possible to handle session management in a more complex context like an enterprise application which uses ORM, etc..        
    private HashMap<String, String> userDatabase = new HashMap<>(); 
      
//Inject these credentials using UserDetailService if you are not going with the below simple example   and use it for storing sensitive data.     (e.g., Spring Security)     
        {         
            userDatabase.put("test", "password"); //store passwords as plain text in a real-world application this is against best practices but ok here    } 
      
//this method will be invoked every time there's an incoming request, so we can use it to fetch the username if available     (e.g., Spring Security)     
        @Override   public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse , FilterChain filterChain ) throws IOException , ServletException {  //this method will be invoked every time there's an incoming request, so we can use it to fetch the username if available     (e.g., Spring Security)     
            String user = getUserFromRequest((HttpServletRequest) servletRequest);   
           HttpSession session=null;  //this is how you would normally store and retrieve a Session object in java, but we can use our User instead  
                  if(user !=  null){       
                      try{        
                          String password = userDatabase.get("test");     
                            /* Now compare the stored hashedPassword with    receivedHashedPwd using     org.apache.... or similar methods */  //need to provide a method for that (e.g., Spring Security)   if(passwordMatchesUserWithHashMacroOrOtherMeans()){        session = servletRequest .getSession();         
                          /* Create and store Session objects in the browser,    on each request as follows: */         //need to provide a method for that (e.g., Spring Security)   }     catch(Exception e ){           throw new ServletException("Cannot create session",  e);      }}            else {       
                          /* If no user is found then redirect them back*/          servletResponse .setContentType ("text/html");         //need to provide a method for that (e.g., Spring Security)     StringWriter out = newStringWriter();           HttpURLConnection connection=(Http URL Connection )servletRequest
...  }   catch{ ...}       @Override public void init(FilterConfig filterconfig){    /* Not required*/          //nothing to do here yet         }}