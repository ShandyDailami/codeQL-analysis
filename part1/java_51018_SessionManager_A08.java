import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
public class java_51018_SessionManager_A08 implements ServletFilter {   // Declare a new servlet filter with the same interface as our original one for demonstration purposes, but use different methods and fields to show usage of standard libraries only in this context (Servlet API)    
    private static final String ADMIN_ROLE = "admin"; 
     
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {   // The actual filtering happens here. Chain of filters is a doubly linked list where this filter goes in between other servlets (Filters can also be added to the end or front).
         
        HttpServletRequest httpReq = ((HttpServletRequest) request);  /* Casting from Servlet Request */   // This cast allows us access various HTTP-specific features of a user's browser.    
        
           String role;    // Declare new variable for the current authenticated users session (role).     
             if(httpReq.getSession().isNewSession()) {  /* Checking whether this is an existing and valid 'user’ sessions */   /\* If it's a newly created user Session, then we need to check from HTTP headers for the role of that specific session only *\/    
                HttpSession httpSess = (HttpSession) request.getSession();  // Get current active web session     
                  RoleExtractor re = new CookieRoleExtractor("role");   /* Define how roles are extracted */    /\* In this case we're extracting the 'user’ role from a cookie *\/    
                 try {       /** Try to fetch user name and set it into session context **/        Role r;  // Declare new variable for fetched users Session.     
                     if ((r = re.getRole(httpSess)) != null)    /\* If a valid role is obtained from the cookie *\/     {   /** Match user name with our defined roles in session context */      
                         String[] tmp_role;  // Declare new variable for matched users Session.     
                          if((tmp_role = r.getAuthorities()) != null)    /\* If valid role is obtained from the cookie *\/     {   /** Match user name with our defined roles in session context */      
                               tmp_role[0].toString();  // The string representation of fetched users Session (e.g., 'ROLE_ADMIN', or simply, 'admin').      }); } catch(Exception ex) {}**/     try { if (!httpReq.getSession().equals((HttpServletRequest) request)) throw new SecurityException("This method only accepts sessions");  // This is checking whether the incoming HTTP Request has a valid session context and comparing it with our current one   
          chain.doFilter(request, response);   /* If there's no security exception thrown in this if block then let go to next filter (controller). */     } catch (SecurityException se) {  // Print out any caught SecurityExceptions .      System.out.println("Access Denied: " + se.getMessage());   
          }} else{System.out.print ("Not an admin session");}   /* Else print that user is not logged in as a 'admin' */ } catch (Exception e) {  // Print out any caught exception .      System.err.println("General Exception: " +e);     };
        }}