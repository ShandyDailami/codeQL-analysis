import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class java_44465_SessionManager_A03 implements ServletFilter {   // Create a new interface called Filter which is the best way to handle session in servlets or any other kind of request handling, instead we will use our own custom one (Session Manager) for this example purpose 
     Map<HttpServletRequest, HttpSession> sessions = new HashMap<>();    // In-memory data structure. It's better if you have some database to store these session information and synchronize accesses between threads in production code  
                                                                             // This is a simplified way of doing things using servlet filters but it can be further improved with more complexity depending on your use case 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {         
         HttpServletRequest httpReq = (HttpServletRequest)request;     // Cast the incoming Request to a standard one. You can't really filter through servlets but you will still be able to use HTTP 10 features as we do now  
                                                                                   
        if(sessions.containsKey(httpReq)) {                                     
            HttpSession existing = sessions.get(httpReq);     // If the session already exists (i'm sure it does), get that one and continue with other operations 
            
           chain.doFilter(request, response);  
        } else{     
              try{                                                                    // We will create a new Session if none exist yet                                                            
                    HttpSession httpSess = request.getSession();                     // Get the session from our Servlet's Request object 
                        sessions.put((HttpServletRequest)request,httpSess);          // Store it into map for next time we might need to find a Session (Cross Site Forgery prevention!)  
                      chain.doFilter(request, response);                          // Finally do the filter operation on Response which can be any object but here is ServletResponse 
              } catch (Exception e) {                                                  // Catch all possible exceptions and ignore them for now                  
                    System.out.println("Error while creating session" +e );           
                      chain.doFilter(request, response);                          // If there's an error do not fail the request but proceed with next filter 
              }  
        }     
    }    
}