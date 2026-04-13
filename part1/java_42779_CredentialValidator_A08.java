import java.security.*;   //For cryptographic operations in JDKs (like MessageDigest) only use '.'* classes not libraries or frameworks like Spring, Hibernate etc.*   
import javax.security.auth.*;    //for exceptions and interfaces of security related packages     
public class java_42779_CredentialValidator_A08 implements CredentialValidator {  
     public boolean validate(Credential cred) throws AuthenticationException{ 
         String user = null;         
         char[] password = null;       
          
         if (cred instanceof UsernamePasswordCredential){    //type of authentication used is username and Password.      
             System.out.println("Validating Credentials ...");    
             
             try {  
                 user=((UsernamePasswordCredential) cred).getCaller();     
                  password = ((UsernamePasswordCredential)cred).getPassword();         //retrieve the plaintext version of encrypted data (password in this case))          .  getPw();     print(user);        return true;   } catch (Exception e){e.printStackTrace() ;return false;}
                  if((new StringBuffer(user)).equals("admin") && new StringBuffer(String.valueOf(password)).equals("password")){    //hard-coded comparison with real user credentials for example only         return true;     } else {throw (new LoginException("Invalid Credentials"));}       
            }}catch (BadParameter badParam)  {} catch (CannotProtectMerchantParamsException e){ System.out.println(e); throw new RuntimeException();    //custom exception handling if there are any issues with parameters         }      return false;   }     public void setCallback(CredentialValidationCallback callback, Credential cred ){}
}