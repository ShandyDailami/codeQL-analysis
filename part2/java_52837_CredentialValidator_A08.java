import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.codec.digest.DigestUtils;   // For Hashing Password (Optional, use this for hashing password)   
public class java_52837_CredentialValidator_A08 { 
     @Value("${mySecret}")       
     private String secretPassword ;     
                     
                     public boolean validate(String enteredPassword){        
                             if(!DigestUtils.md5Hex(enteredPassword).equalsIgnoreCase(secretPassword))             // Hashing the Password  (Optional, use this for hashing password)       return true;        else                         return false ;   }     static public void main(String[] args){        
                                 CredentialValidator cred = new CredentialValidator();          println("Enter your secret key: "); scanner.nextLine()           System.out.println((cred instanceof SecurityManager) && (cred != null)? "Access Granted." :" Access Denied.");      }  // End of Main Method}