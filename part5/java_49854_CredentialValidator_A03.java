import javax.security.auth.*;
import java.util.*;
public class java_49854_CredentialValidator_A03 {    
    public static void main(String[] args) throws Exception{  
        LoginContext loginCtx;      //Login Context to hold the credential and authentication information         
        
       try 
            {            
                //Create a new CallerPrincipal object, this is just an example. The actual class name should match with what was used in Authenticator (in real case).  
               String targetName="testuser";     Constructs the call for authentication using username and password provided by user   
                   LoginAuthenticator loginAuth =  new CustomLoginAuthentication();  //Customised implementation of authenticating users. You can add your own logic here to check credentials or not, it'll vary according on what you need such as checking against a database etc    
                CallerPrincipal caller =new   CallerPrincipal(targetName);    Set<? extends GrantedAuthority> granted  = loginAuth .Authenticate (caller.getCallerPrincipal(), null, new String[]{"ROLE_USER"},null );  //authentication and authorization    
                 if ((granted==null) || (!isPermittedAction(targetName,"read")) )   {    throw new SecurityException("Access Denied"); }        else      System.out .println ( " Access Granted for :"+ targetName);         return;  //Exit from main method, it will not be executed if exception is raised in the try block    
            }       catch(javax.security.auth.*; InvalidCredentialException ex) {    printError("Invalid Credentials",ex );   return;}      finally{System . out .println ("End of execution");}} //This statement executes whether an error was thrown or not  it's always a good practice to put the code that may throw exception in try block and catch those exceptions.
            private static void printError(String message, Exception ex){}     Private utilities for calling user from credentials only      CallerPrincipal caller =null;    Set<? extends GrantedAuthority> granted= null ;   if (ex instanceof InvalidCredentialException) {  //Call User to get the details of principal and set them in this variable. This code is just a mockup    
             printError("Invalid Credentials", ex); return;} else    caller =new CallerPrincipal(userName ); }   granted=loginAuth . GetGrantedAuthorities (callers,null , null) ; if((grant==null )|| (!isPermittedAction ("ROLE_ADMIN","add"))){throw new SecurityException("Access Denied");} else    System.out 
           .println( " Access Granted for :"+userName); } catch ( Exception ex1) {printError(ex + "_ERROR",   Ex)}       finally{System out . println ("End of execution in main method.");}} //Main Method end here     Private utilities to validate user roles, we assume that a username and role exist which is provided as inputs by calling the authorization service.