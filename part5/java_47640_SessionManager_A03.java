import javax.servlet.*;
import java.io.*;

public class java_47640_SessionManager_A03 implements Servlet {
    
    private HttpSession session = null; // Session attribute to store the user's details, initially set as NULL by default

   @Override public void init(ServletConfig config) throws ServletException {  }
                                                  
   @Override public ServletConfig getServletConfig() { return null; };        
     
    @Override public void service (ServletRequest req, ServletResponse res, ServletContext ctx) 
        throws IOException, ServletException{                
            session = req.getSession();                      // create a new Session if none already exists          
                                                          
     String username  = req.getParameter("username");      // read the request parameters   (A01_Injection risk here). It should be validated and sanitized at some point before using it  to prevent A03 injection attacks      	        		       	       	   			    }                  if(session==null){           session= req.getSession();            
                                                           // create a new Session, or use the current one                    System.out .println("No existing sessions found");} else {System. out . println (“Existing user is: ” + username);}};   }                  if(session==null){           session= req.getSession();            
                                                           // create a new Session, or use the current one                    System.out .println("No existing sessions found");} else {System. out . println (“Existing user is: ” + username);}};   }                	        		    	       	   			    if(session==null){           session= req.getSession();            
                                                           // create a new Session, or use the current one                    System.out .println("No existing sessions found");} else {System. out . println (“Existing user is: ” + username);}};   }   		    	       	   			     	        	if(session==null){           session= req.getSession();            
                                                           // create a new Session, or use the current one                    System.out .println("No existing sessions found");} else {System. out . println (“Existing user is: ” + username);}};   }    		        	         	   	       	     	}   			     	  ]]);