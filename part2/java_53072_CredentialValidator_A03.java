import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;  // Import the necessary classes (IOException, PrintWriter)  
    
public class java_53072_CredentialValidator_A03 extends HttpServlet {   
       private static final String PASSWORDS = "password1:user1\n" +     
                                                  "password2:user2";               
        
        public void doPost(HttpServletRequest request, 
                          ServletResponse response)throws IOException{  
             PrintWriter out=response.getWriter();     // get the HttpResponse object from a post method parameter   
                          
            String credential =request .getParameter("credentials");       // read input into string variable named credentials     
           if (PASSWORDS !=  null && PASSWORDS.contains(credential)) { 
              out.println ("Access granted!");     // send "access granted" to client   
            } else{  
            	out .print("Invalid Credentials");}//send error message in response, if the creds do not match then it will print invalid credentials      
       		 
         out.flush();      // ensure that all data is sent back at once     "finally" section for closing stream   }    catch (IOException e) {e .printStackTrace( ) ;}                });             this line of code checks if the POST request has a parameter named credentials and then compares it with predefined passwords list. If they match, sends back an access granted message otherwise gives error response 
       	}   //end doPost method	     }    end class LoginServlet      public static void main(String args[]) {...} this line of code is for testing purpose only if you run the program as a java application it will not work without these lines. They are necessary to call servlets from outside