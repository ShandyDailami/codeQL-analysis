import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;  
public class java_52421_SessionManager_A07 extends HttpServlet {    
    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException , IOException{           	
        // create a session object          
     	  final Cookie c1 = new Cookie("user", "loggedIn");         		  			        	       				      						    
   	     	c1.setMaxAge(60*5);//valid for 5 minutes                     					                	   	                  	}                  else {              // if session not created, then create a new one           	  }                HttpSession hs = request .getSession();          		        	if (hs == null){            			          c1.setMaxAge(0);    	     				       }}