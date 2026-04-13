import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_47746_SessionManager_A08 extends HttpServlet {
    // This method is called when a request comes in to this servlet (a user makes an HTTP GET)
     public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {         
         resp.setContentType("text/html");          
         PrintWriter out = resp.getWriter();        // Get a writer object to print the HTML response back on (the browser can see this now)     
                                     
		 /* Create session or get existing one */	      	 
         HttpSession sess=req.getSession(true); 			  									   	   	     
         															    
        // If there's no name in the request, we create a new unique ID for it:                                                                                                          
		 if (sess.isNew()) {                            	                                            	       	 						                                      }                                        else                   sess=req.getSession(); 			  									   	   	     
         out.println("<html><body>");                       // Print HTML body content                     
         															    
      /* Write some data */		                                 
       	sess.setAttribute("userName", "John Doe" );	                                       	 						                                      sess.removeAttribute("JSESSIONID") ; 			  									   	   	      }                                           catch (Exception e) { out .println(“An error occurred: ${errors}”); };                     
         		     finally                   // End of try-catch block                              
         return;                         	                                       	       	 						                                      if (!sess.isNew()) sess = req.getSession(); 			  									   	   	      }                            catch (Exception e) { out .println(“An error occurred: ${errors}”); };                      });                    		            finally {}