import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_50533_SessionManager_A07 extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        // create session object  using servlets API if no existing one found for the user (Creating a new HTTPSession). If an already validated users http-session exist then it will return that same Session. Otherwise -> Creates New and returns to Client .    	        		   	 	   
   HttpSession hs = request.getSession();  // check whether session is null or not if yes create a new one else use the existing object     	       
        try{               
            String username= (String)hs.getAttribute("username");         
              System.out.println( "User :" + username+ "\n ");  	          		  // For AuthFailure related operation    	   			   	 				      					            	      }                            catch Exception e {     	       								        fs = request . getSession();                       hs=fs;           	} finally{        
              System.out.println(" Session created or already exists : " + (hs==null ? "No" : "Yes")+ "\n");    	         			    }                                                                                         		  });