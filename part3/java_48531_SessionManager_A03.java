import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_48531_SessionManager_A03 extends HttpServlet {
    private static int sessionCount = 0; // This variable will count all created sessions  
    
    @Override protected void service(HttpServletRequest request, ServletResponse response) throws IOException, ServletException 
	{	        		      	     	 	//Call super's method to process the HTTP Request / Response (HTTP servlets only do this in a secure way!)     	       			                     //Decide whether or not we should continue processing and where our error is.  									           }    public void init(ServletConfig config) throws ServletException 
	{        	    		           	//Initialize the HttpSession object if one was previously created by this servlet (this method must be called before any other methods).     	       			                     //Do some setup for our HTTP Session.  									           }    public void destroy() {       	 	   	     ​//Clean up resources used during destruction of web application or reloading the configuration, if needed 		        	    	}
}