import org.springframework.security.authentication.*;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
 
public class java_51719_CredentialValidator_A07 implements CredentialsValidator {
    // Encryption of user password for authentication process (for example) is not shown here, it's a security sensitive operation related to A07_AuthFailure topic only  
     @Override public Authentication validate(Authentication auth) throws AuthenticationException { 
        String presentedPassword = ((UsernamePasswordAuthenticationToken)auth).getCredentials().toString(); // get password submitted by user.   
         SecretKey key= new PBEKeySpec("secret".toCharArray(), "rememberthis",12096,32);   /* Encryption example */ 
          String securePassword = Base64.getEncoder().encodeToString(key.toString().getBytes()); // encrypt the password for comparison   
        if(!presentedPassword.equalsIgnoreCase(securePassword)) {//compare submitted and encrypted passphrase in clear text  
           throw new BadCredentialsException("Authentication failed!");  }     return auth;}      /* If everything matches then authentication is successful */       else{throw new InternalAuthenticationServiceException ("Unknown user");}}          // User not found or other exceptions are thrown here.    if (auth instanceof AuthenticationExpiredException) { throw new InternalAuthenticationServiceException("User account disabled", e); }
}