import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
  
public class java_45506_SessionManager_A07 {    
    public static void main(String[] args) throws Exception{      
        try {            
            AuthenticateUser("user", "password"); // Try to authenticated the user with given credentials     
                } 
           catch (BadCredentialsException e){         
               System.out.println ("Invalid username or password!");}   
         else if(e instanceof LockedException) {  
             System.out.print("Account is locked, Contact administrator");     //for lock account process      
        } 
            catch (DisabledException e){         
                System.out.println ("Account is disabled! Please contact admin.");    //For disable user's account     
           }        
              else{                         
                  throw new Exception("Unknown exception occurred");   //General error handling for all other exceptions       
             }    
  }}