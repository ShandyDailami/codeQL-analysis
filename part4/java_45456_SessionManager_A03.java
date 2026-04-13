import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_45456_SessionManager_A03 implements ServletFilter {  
    private Map<String, String> sessionData = new HashMap<>();  // Simulating database with username and password as data     
    
    @Override      
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{         
        HttpServletRequest httpReq= (HttpServletRequest)request;  
         String userID =httpReq.getParameter("userId");  // Fetching username from the client side     
     if(sessionData.containsKey(userID)){      
            request.setAttribute("username", sessionData.get(userID));    }        else{            
           response.sendError(HttpServletResponse.SC_FORBidden, "Not Authorized");   return;}         
         chain.doFilter(request,response);}     //Continue to next servlet or resource     
       @Override  public void init(FilterConfig filterconfig) throws ServletException {    }           
       
public class SecureServlet extends HttpServlet{           private static final long serialVersionUID = 1L;        
@override protected void doPost (HttpServletRequest request,   HttpServletResponse response try      {String userID =request.getParameter("userId");          if(!sessionData .containsKey(userid)){                 redirect to login page with error message    }           else{               // User is authenticated and in the database -> continue        }} catch (Exception e){e.printStackTrace(); response.sendError