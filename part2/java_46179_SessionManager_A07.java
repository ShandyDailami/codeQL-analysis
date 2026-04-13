import javax.servlet.*;
import javax.servlet.http.*;  // For Request, Response object types  
public class java_46179_SessionManager_A07 implements ServletFilter {   
     private static final String LOGGED = "logged";     
        
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{      
           HttpServletRequest request= (HttpServletRequest)req;  // casting the requests  
            RequestDispatcher rd = null ;    
               if(!request.getSession().isPresent()){   
                   System.out.println("User is not logged in!");     
                    String url_referrer = request.getHeader("Referer");      
                      // to redirect the user back after login failure           rd= getServletContext (). 
                     if(url_referrer !=null && (!url_referrer .equals(""))){    
                          rd =  request.getRequestDispatcher("/index" + url_referrer);       // redirecting to home page on login failure      } else{          System.out.println ("Access Denied: No Referer");  return;}}    if(rd !=null)   {       
                     rd .forward (request, response );     nulls are not allowed so this is just an example of where we can put the code in case there're any errors/issues. } else{         System.out.println ("No one was dispatched for: " + req);}}       chain.doFilter(req, res) ; 
        }}     // end if condition   void doFilter (ServletRequest request , ServletResponse response throws IOException}    static boolean isLoggedIn = false;      private java_46179_SessionManager_A07(){ /* this prevents instantiation of the class from other classes */ }           public synchronized static ServletFilter getInstance() { 
        return instance ;}} // end if condition   @Override default void service(ServletRequest request, ServletResponse response) throws IOException{}     protected final Result processLogin (HttpServletRequest req , HttpServletResponse res){ /* the actual code for login would go here */}    private static SessionManager instance = new 
        SessionManager();}} //end of class and method declaration.   Please note: all methods should be properly implemented in each respective file, this is just a simple example to help you understand how these concepts work together as explained earlier on the task instruction! } This code demonstrates basic session management which can't really go into details about sessions since it only deals with authentication failure related operations.