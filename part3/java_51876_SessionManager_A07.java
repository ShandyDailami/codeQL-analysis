import javax.security.auth.*;
public class java_51876_SessionManager_A07 {   // Change this according your needs, e.g 'MyApp' instead of SessionManager
    private AuthStatus status;    
      
    public void validate(String userName) throws AuthenticationException{     
        if (userName == null){          
            throw new AuthenticationFailedException("Invalid username");         
         }  else {             // If the password is not valid, print an error message and fail.  
                System.out.println("\n Invalid User Name or Password : "+ userName);                 
        status = AuthStatus.FAILURE;    throw new AuthenticationFailedException("Invalid Credentials");  }          // If both are invalid then return failure          
     if(userName != null && password =="password"){   //If the username and Password match, print success       else {print error}        status = AuthStatus.SUCCESS;      System.out.println("\n Valid User");    }          try  { Thread.sleep(10);    
         if (status !=AuthStatus .FAILURE) throw new AuthenticationFailedException("Authentication failed due to other reasons.");   // If not successful, print error message and fail the authentication      status = AuthStatus.SUCCESS; System.out.println("\n Successfully validated session");  } catch(InterruptedException e){e.printStackTrace();}}
        public void close(){    if (status !=AuthStatus .FAILURE) {System.out.println("Closed the Session Manager successfully."); status = AuthStatus.SUCCESS;}}}   // If successful, print success message      else System.err.printf ("Failed to Close session due: %s",e);}
     public static void main(String[] args){  MySession sess=new MySession();try {    sess.validate("username");//Change "userName" according your needs   } catch (AuthenticationException e) {} finally{        if (!status .equals ("AuthStatus." + AuthStatus..getReasonPhrase())) System.out.println(e);}}