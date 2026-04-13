import javax.servlet.*;  // Import Servlets and Server classes  
import javax.servlet.http.*;    // Import Http servlet classes    
import java.io.*;      // Import class java_46834_SessionManager_A01          
      
public class LoginServlet extends HttpServlet {         
        public void doPost(HttpServletRequest request,           
                HttpServletResponse response) throws IOException{             
  	    PrintWriter out = response.getWriter(); 
   	    		            			                  
        	//read the user information from browser cookies          
	        Cookie[] cookies=request.getCookies();         	 				       	     					      
               if(cookies != null){                          //check whether a cookie has been set for username or not     							  								   	    		 			                 	   	}else{                    println("not logged in yet");           }                out .println ("Welcome " + cookies[0].getValue());             }}