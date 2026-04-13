import org.springframework.security.authentication.*;
import javax.servlet.*;
import java.io.*;
    
public class java_52698_SessionManager_A07 {    //class name is based on 'A'nd your application needs, so it was decided to use simple letters for the sake of simplicity  
       public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException 
      {    
           Authentication failedAuth = SecurityContextHolder.getContext().getAuthentication();    //This will hold our authentication failure object which is a BadCredentialsException in this case if the credentials are incorrect  
             
            /* If we have an exception and it's not of type UnknownUser, then use that to generate response */ 
           if (failedAuth != null && failedAuth.getDetails() instanceof BadCredentialsException) {    //A07_AuthFailure is when password/credential provided doesnt match in the database  
                 ServletResponseWrapper resWrapped = new ServletResponseWrapper((ServletResponse)res); 
                  PrintWriter writer = resWrapped.getWriter();    
                   String authFailMsg="Invalid Credentials"; //You can set your own message here, for A07_AuthFailure it should be "Authentication failed: Invalid credentials provided."  
                 writer.println(authFailMsg);      //Prints the exception to user in HTML format on browser response      
                   resWrapped.flush();    
          }    else {  //Otherwise just continue processing as normal, if not a BadCredentialsException then proceed normally i..e., do nothing  
                  chain.doFilter(req,res);     
           }       
             /* If we are here that means the above conditions didn't hold true so move on to next line */   
     } 
}//end of class A07_AuthFailureExample