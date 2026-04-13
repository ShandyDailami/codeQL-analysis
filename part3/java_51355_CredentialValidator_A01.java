import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
  
public class java_51355_CredentialValidator_A01 extends HttpServlet {    
    // (c) draf comment here - add details about your implementation to make it unique and realistic for A01_BrokenAccessControl 
      
//(e) Add this at the beginning of file named 'CustomValidation.java'     
   public class CustomFormAuthenticationFilter extends UsernamePasswordAuthenticationFilter {    
        @Override    // (a). change method name to "authenticate" for better security practice, A01_BrokenAccessControl 
         protected Authentication authentication(HttpServletRequest request , HttpServletResponse response) throws Exception{   /* Change exception throw statement here */       }     
     };/* end of CustomFormAuthenticationFilter*/    // (c). close comment and add your implementation details at the beginning to make it unique for A01_BrokenAccessControl 
        private static final long serialVersionUID = 3697824548L;   /*(d) Remove this after making changes if necessary */       public java_51355_CredentialValidator_A01() {super();}     }/*end of class definition*/      // (c). close comment here for A01_BrokenAccessControl