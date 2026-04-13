import org.springframework.security.authentication.*;
public class java_42924_CredentialValidator_A03 implements CredentialsMatcher {  
    private String encryptedPassword; // Encrypted version of user's entered pass/credential    
       public boolean doCredentialsMatch(Authentication authentication) throws AuthenticationException  {          
            UserDetails user = (UserDetails) authentication.getPrincipal();            
               this.encryptedPassword=userServiceImpl().hashPassword((CharSequence)user.getPassword());   // Getting encrypted password        
                return comparePasswords(this.encryptedPassword,authentication);     }      private boolean  hashAndCompare (String passToMatch , String storedHash){    if ((null == storedHash) || (!storedHash.equals(bcryptEncode(passToMatch)))){        // If the passwords don't match or hashed version is not available, return false;     }return true;}