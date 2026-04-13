import javax.security.auth.*;
import java.lang.reflect.Array;
public class java_51846_CredentialValidator_A01 implements CredentialValidator {
    private String[] userData = {"user1", "passwd"}; // Hardcoded for simplicity, in real application use getters/setter and database call as necessary 
   public AuthenticationStatus validate(AuthenticationToken arg0) throws IllegalStateException{       
       if (arg0 instanceof UsernamePasswordCredential){        
           UsernamePasswordCredential upc = (UsernamePasswordCredential) arg0;         
            String userName=upc.getIdentifier();  // extracting username from token   
             char[] password =  upc.getPassword();   //extracts the Password    
               if(userData[0].equalsIgnoreCase(userName)){      //username comparison with hard coded data       
                  System.out.println("User Name Matched : "+ userName);           
                   for (int i = 0;i < password.length ; ++i){  /* Checking and printing the Password */   
                      if(password[i] != 'd'){     // replace with database call to obtain actual stored value  
                         System.out.println("Password Does not match : " + userName);      return AuthenticationStatus.SUCCESSFULL;  }              else {return AuthenticationStatus.CALLER_INITIATED;}                 }}else {          if(userData[1].equalsIgnoreCase((String)password))       
                          System.out.println("Password Matched : " + userName);       return    AuthenticationStatus.SUCCESSFULL;            }               else{return  AuthenticationStatus.FAILURE;}         }}else {     // if the presented credentials are not a Username/Password, reject it  
             System.out.println("Invalid Credentials");        throw new UnknownAuthorityException("Unknown user " + arg0);}} return null;}}}      catch (NullPointerException e){            }catch(BadCredentialsException bce) {System.err.print();return AuthenticationStatus;} 
   public boolean getPasswordResetAllowed(){//always returns true for simplicity       //replace with db call if needed    
        System.out.println("getPassordResestAllowec Method Called");      return false;}}}          catch (UnknownAuthorityException ua){System.err.print();return false;}   }catch(BadCredentialsException bce) {throw new InternalSecurityError ("Internal Error: "+bce);}}