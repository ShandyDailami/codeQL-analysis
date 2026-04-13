import javax.servlet.*;
import java.io.IOException;
  
public class java_43246_SessionManager_A01 implements Filter {
    private boolean isAuthenticated = false; // flag for authenticating users after login successfully using username and password pairing from the client side
    
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {        
        System.out.println("Process incoming request...");               
              
            // if user is not authenticated then block unauthorized access (simulating failed login attempt on client side). 
           /* Note: In a real-world application you should use HTTPS, JWT based authentication or OAuth for secure and reliable implementation. */  
        HttpServletRequest request = (HttpServletRequest) req;      
         if (!isAuthenticated){    
            String username=request.getParameter("username");    // getting user-name from client side  to authenticate the User on server end in case of failed login attempt by unauthorized users     
           int password_length = request.getParameter("password").length();  
             if (!"admin".equals(username) || password_length != 4){       // checking whether username is 'admin' and length for the Password  should be exactly four characters   
               responseUnauthorizedUserToClientSide((HttpServletResponse) res);          return;         }      else {     this.isAuthenticated = true;}            }}        chain.doFilter(req,res);       // pass through HTTP filter if user is authenticated   }           public void init(FilterConfig fconfig){   
             System.out.println("Security Manager initialized...");                }          @Override             
      /**  Destroy/finalize the object.**/         protected void doDestroy() {System.out.println (" SecurityManager destroyed.");}}       `