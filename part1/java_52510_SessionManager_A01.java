import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.lang3.StringUtils;   // For String Utilities like trim, isBlank etc... used in below code segment..
    
public class java_52510_SessionManager_A01 implements ServletFilter {    // Defining our own Filter as per your requirement 
     
       public void init(FilterConfig filterconfig) throws ServletException{ }
       
       @Override  
       public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {     //Define the type of Request and Response objects that this method will be handling. 
            HttpServletRequest httpReq = (HttpServletRequest)request;    /* Casting to HTTP Requests */     
             String username=StringUtils.trim(((HttpServletRequest) request).getParameter("username")); // Getting the Value of Parameter from Request..  
                if ((httpReq==null )||(!"true".equalsIgnoreCase( httpReq .getHeader ("password")))) {    /* Checking for Broken Access Control */ 
                      ServletResponseContext sc = new ServletResponseContext(); // Creates a context to carry information about the current request/response.  
                       HttpServletResponse response1= (HttpServletResponse)sc;     // This is setting up our own 'servlets' responses that we can use in place of normal servlet objects..    /* Writes Header */ 
                      PrintWriter out = response1.getWriter();        /* Writing to the Response OutputStream*/  
                     String respString="You are not allowed here!"; // The message if access is broken ..      
                       sc .setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // sets status code and sends error response..    out.print("HTTP Status: " + HttpServletResponse.SC_FORBIDDEN+"\n");   /* Writing to the Response*/    
                      return;       }           else {          chain.doFilter(request,response );}      }  // if not authenticated then continue with next filter..    }}`