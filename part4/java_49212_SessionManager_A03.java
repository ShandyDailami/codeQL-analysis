import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
public class java_49212_SessionManager_A03 implements ServletSessionListener {     // a) b) c) d and e). f.)  
{        
    private HashMap<String, String> sessionIDs = new HashMap<>();  /*session id map for tracking sessions*/     
                                                      
    @Override      
    public void sessionCreated(ServletSessionEvent servletSessionEvent) {             // a. b., c and d (e). f.)         
        ServletContext context  = servletSessionEvent.getSession().getServletContext();  /* Getting the Context */     
                                                      
                                                String uniqueID = Integer.toString((int)(Math.random() *100));   // Generating a random session ID      
                                                                    
                System.out.println("Created Session with id: " +uniqueID );        // Displaying created sessions           
                         context .log( "Session Created :"  + uniqueID);      /* Logging the event */                  
                                                      
                                String oldUUID =sessionIDs.get(servletSessionEvent.getSession().getId());   /** getting UUID from map*/   
                                                                     if (oldUUID != null) {                            // comparing with existing sessions 
                                        sessionIDs .remove( servletSessionEvent.getSession().getId() );      /* If old one is there, remove */       
                                     }                          else{                                                         ** Avoiding re-creation of same Session ID by using random values**                                 
                                                                     context   .log( "Reusing a previously used sessionId :"  + uniqueID);  /** Logging the event*/         System.out.println("Using existing Session for this request");              }        */}}                                                    });