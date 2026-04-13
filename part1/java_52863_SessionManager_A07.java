import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class java_52863_SessionManager_A07 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{        
        // If the user is already authenticated  (Authenticate function has been called in this case), then we proceed with setting a session attribute. Otherwise redirect to login page     	  		   	 	   			     if(request.getSession().isNew()){      										// Checking for new sessions
            request.setAttribute("message","Please log into your account!");        // Setting up an error message, which will be displayed on the frontend using jsp to display it 		   	 	   	  			     }else{          	        if(request.getSession().getAttributeNames().nextElement()==null) {
             request.setAttribute("message", "You are not authorized as an active member!");        // If session is new and the user has no attribute, then it means he/she hasn't logged in previously so we display a message saying that 		   	 	   	  			     }}        										// Logging out users
            request.getRequestDispatcher("/WEB-INF/views/logoutSuccessfulView.jsp").forward(request, response);       // Forwarding the user to an appropriate view after log in or sign up is complete 		   	 	   	  			     }}}}}}                 										// Handling session expiration