import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
  
public class java_52111_SessionManager_A01 extends HttpServlet {
    // (a) Create a session in the setSessionAttribute method:
     public void doPost(HttpServletRequest request, 
        HttpServletResponse response) throws ServletException, IOException{        
          String name = request.getParameter("name");     	  		      	 	       	     									    // (b): Realistic Example of a security-sensitive operation in Java code using setAttribute method:			    	   						  }        @Override public void init() throws ServletException { super.init();}
             protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{ // (c): No Framework Required here!   	doPost(request,response);  			  }public static boolean checkAccessControl(){     return true;                                       	   	// dummy method for access control. It's a real-world example
}                                                       public void destroy() {}         private String name = null;}                        // e: No more comment here to avoid confusion           		       	      	       									    }  '