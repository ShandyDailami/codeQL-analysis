import javax.security.auth.Subject;
import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;
 
public class java_44498_CredentialValidator_A03 {    
    public boolean isValid(String username, String password) throws Exception{        
        // This method should be replaced with the actual authentication mechanism and it's not included in this example            
                
            Subject subject = new Subject(){};          
 
	    byte[] decodedBytes = Base64.decodeBase64("YWRtaW4=");  
	     String usernamePassword =  new String(decodedBytes, "UTF-8");   
              System.out.println (usernamePassword);        // prints: user123@example  if the credentials are correct           
             subject = UsernamePasswordAuthenticationToken.authenticatedUser(userNameAndPasswd[0], password );          
         return true;   }    
}    public class Main {       static CredentialValidator credValidate= new CredentialValidator();     
        // use it like this:  try{if (credValidate.isvalid("username", "password")) System . out . println ("Login successful") ; else System . err Printl e(“Invalid username or password"); } catch {e ->System .errprintln ('The following error occurred' + e)}       
    public static void main  (String args [])   throws Exception{     credValidate.isvalid("user123@example","password") ;}      // prints: Login successful if the credentials are correct, else it will print "Invalid username or password" } catch {e -> System .errprintln ('The following error occurred' + e)} 
    }}`