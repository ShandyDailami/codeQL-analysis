import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
      
public class java_53819_SessionManager_A07 extends HttpServlet {    
    public void service(HttpRequest request, HttpResponse response) throws ServletException, IOException{  
        // check if session is not set yet 
	if (request.getSession().isNew()){     
            String username = "guest";      	
	    int attempts = 0;    		   	 			         
        	// save the data in a Http Session object for future use                 					  				       	       															          	}else{                     // if session is already set, retrieve user details and increase attempt count  }      else { print error message }}                	      	if (attempts > 2)              	{   		     request.getSession().invalidate();                                                   System.out.println("Invalidating the current Session");               	}else{
            attempts++;            			       									         	       	     								   }                  HttpResponse sendRedirect(response, "login_failure" + attempts+".html"));  // redirect to a html file for logging number of failures }}                   	 	                                                                                     							   		    	    and that will be the end.