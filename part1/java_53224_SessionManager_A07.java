import javax.servlet.http.*;   // for HttpServletRequest and httpSession objects   

public class java_53224_SessionManager_A07 implements HttpServlet{     
     public void service(HttpServletRequest request,        HttpServletResponse response) throws java.ioException {         
         System.out.println("\n Inside Secure Web Application (Vanilla Java Program): \n");   // printing inside secure web app      
          
		 String userNameToStore = "John Doe";     // setting a username to store in session   
		// create HttpSession object for current request     	       	     	 	   			 
         HttpSession httpSession=request.getSession();                 					         				  															}              }                public class {public static void main(String args[]){new VanillaJavaSecuredWebAppExample().service(null, null);}        }}`