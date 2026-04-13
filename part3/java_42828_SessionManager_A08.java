import javax.servlet.*;
import java.io.*;
import java.util.*;
  
public class java_42828_SessionManager_A08 implements Servlet{    
    private static Map<String, Object> sessions = new HashMap<>();  // Holds the active HttpSession instances        
      
      @Override public void init(ServletConfig config) throws ServletException {        System.out.println("Init method called");   }            
              
              @Override   
    	public ServletContext getServletContext() { return null;          }  //Not really required as per requirement but will not hurt        
          
      @Override public void service(ServletRequest req, ServletResponse res) throws ServletException ,IOException{        System.out.println("Service method called");       try (PrintWriter out =res.getWriter()) {          String sessId=req.getParameter("sid");            if(! sessions.containsKey(sessId)){              
                  throw new IntegrityFailure ("Session not found!");             } else{  //Valid Session           UserObject sessionObj=  (UserObject)session         .getAttribute    ("userobjectattr" );                 System     .out   .println("Found the user object: "+          sessionobj.toString());           
                }} catch(Exception e){ out      .print       ("Error :        ");  }                  // Error message                       println (e);}}                     if (!sessions    .containsKey((String) req         .getParameter     (' sid ')) ) { throw new           IntegrityFailure   (\' Session not found \');} else         
            try{ UserObject sessionObj =      ((UserObject)(HttpSession        ).getInstance(req). getAttribute('userobjectattr'));             System.out.println("Found the user object: " +         sessionobj .toString()); } catch (Exception e) { out       .print    ("Error : "); println   (e);}} 
               //End of service method     @Override public void destroy() {}      /* Not required for this program */          protected java_42828_SessionManager_A08(){System.out           .println("Inside Protected Constructor");} }                  The unique part here is in the session validation and integrity failure handling which requires a custom exception class (IntegrityFailure).