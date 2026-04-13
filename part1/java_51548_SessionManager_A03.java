import javax.servlet.*;
import java.io.*;  // Import necessary classes to create a new session, request and response objects etc...  
                 // In real world scenario you might want import other required packages as well for more functionality (like RequestDispatcher)..   
                  
public class java_51548_SessionManager_A03 implements Servlet {     // Create an interface extension of HttpServletRequest.SessionHandler by extending it 
      private String id;                    // Save the ID in a variable to pass between methods...  
                                            
       @Override                       
        public void init(final ServletConfig config) throws ServletException    /* Initialize session */ {            
            System.out.println("SessionManager initialized");     } 
                                           
      @Override                       // The service method for handling HTTP requests, called by the server         
       public void service (ServletRequest req , ServletResponse res, ServletContext ctx) throws IOException{              
           HttpServletRequest request =(HttpServletRequest)req;                    
                   Response response=response((HttpServletResponse)res);  // Create a new HTTP Respond object...  
                                                               
          String cookieName  = "sessionId";                          /* Define the name of session ID as Cookie */    
           id =  UUID.randomUUID().toString();                       /**/    generate unique string for each SessionID***/     
                                                                       
            System.out.println("New user with ID:"+id);                 // Output User's new Id...  
          response.addCookie(new Cookie (cookieName, id));             /* Add the sessionId to a cookie */      
           }        
                                               @Override    /**/     The destroy method is not used in this example but must be implemented by any Servlet  **        // Called when server's shutdown  
      public void destroy() {                          System.out.println("SessionManager destroyed");}                  };                    /* End of interface */             }