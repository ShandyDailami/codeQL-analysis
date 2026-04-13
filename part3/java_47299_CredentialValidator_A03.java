import org.springframework.security.authentication.*;
import javax.management.*;
  
public class java_47299_CredentialValidator_A03 implements Authenticator {     // A03_Injection Attack - No injection point for non-static field usernamePasswordAuthenticationProvider is used in the static initializer of CredentialValidatorExample  and a method reference to this authenticator will not be resolved as constructor parameter.
  
public UserDetails validate(String userName, String password) {        // A03_Injection Attack - No injection point for non-static field usernamePasswordAuthenticationProvider is used in the static initializer of CredentialValidatorExample  and a method reference to this authenticator will not be resolved as constructor parameter.
   if (userName == null || password==null) {         // A03_Injection Attack - No injection point for non