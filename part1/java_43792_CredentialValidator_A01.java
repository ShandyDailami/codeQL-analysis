import javax.security.auth.*;
import java.rmi.RemoteException;
  
public class java_43792_CredentialValidator_A01 implements CredentialValidator {   
     public AuthenticationStatus validate(Credential cred) throws RemoteException, AuthenticationFailedException{         
         String username = cred.getCaller();          
        // Here you should use the actual method to get user's password from somewhere else in your system 
         char[] pwd_char=null;//credentials manager would take care of this           
             if(username=="admin"){                  
                String clearPassword = new String (pwd_char);   // Convert the input character array to a string                   
                 return AuthenticationStatus.SUCCESSFULL;}         else {              
                  throw new AuthenticationFailedException("Invalid username or password");            }  });       };    public class CredentialValidatorTest{     static void main(String[] args){      // Calling the method with a valid user          CustomCredentialValidator cc=new   CustomCredentialValidator();        AuthContext authctx = new DefaultAuthContext ("user1", "pwd");         try {          
             System.out.println("Validation: “+cc .validate(auth ctx)); } catch (Exception e){    // Calling the method with an invalid user          cc=new CustomCredentialValidator();        Authctx authCtx = new DefaultAuthContext ("invalid_user", "wrong password");         try {          
             System.out.println("Validation: “+cc .validate(auth ctx)); } catch (Exception e){}};   };};    });      //End of class definition and main function});     }}// End program execution}}, this code should not be run, only for understanding the concept behind it.");