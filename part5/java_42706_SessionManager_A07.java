import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_42706_SessionManager_A07 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{        
        String username = request.getParameter("username");   // get the parameter value  from form field named 'name' in login page    	      
	     	String password =  new java.security.MessageDigestAlgorithmException(request .getParameter ("password")).digest().toString();   	// this is for hashing purposes, normally you should use a proper encryption algorithm  		        	 			         	   				 					     	        } catch (NoSuchAlgorithmException e) {
        // handle exception here	     return;	} });}}}}});}); }}");            response.setContentType("text/html");    HttpSession session = request .getSession();       if(userdb.authenticateUser(username,password)){           System.out.println ("Welcome " + username ); 		         // redirect to another page} else {              			         	//login failed }              response.sendRedirect("LoginFailPage.html");}}  
    private static final long serialVersionUID = 1L;	     @Override public void init() throws ServletException {}       protected void service(HttpServletRequest request, HttpServletResponse response) 		         throws ServletException , IOException {      doPost (request,response);} } //end of Login servlets