import org.springframework.security.core.*; // Spring Security Core APIs are used here to create UserDetails objects, encrypt credentials etc...
import org.springframework.security.crypto.*; // for password encryption and decryption using BCryptPasswordEncoder (Spring’s built-in implementation) 
  
public class java_45454_CredentialValidator_A03 implements AuthenticationProvider {
    private final PasswordEncoder encoder;// Spring's interface to hash the submitted credentials, here we use Bcrypt. It is a secure way of storing password hashes...and checking them later in our database (using same algorithm). 
  
     // Constructor for Dependency Injection through @Autowired annotation which helps us inject instances into this class when needed by Spring Beans… or any other IoC container.   
      public java_45454_CredentialValidator_A03(PasswordEncoder encoder) {this.encoder = encoder;}// AuthenticationManager needs to know how and where the credentials are sent... – so it has an authentication provider (AuthenticationProvider).   // this is why we need a PasswordEncoder here for security purposes....
    
    @Override public Authentication authenticate(Authentication auth) throws AuthenticationException { return null; }// In case of custom user details service, will be called by Spring Security…... – so it does the authentication. For all other cases this method should not call anything (return a result set).	  
    // If you want to support UserDetailsService and AccountNonExpiredInterface then implement above methods as well...... else if passwords are hashed in database, use Hash-based implementation of PasswordEncoder... like BCrypt. It'll be easy for Spring Security - the security provider will hash your stored credentials when they get saved (for login), but it won’t compare a plain text string with an encrypted one on its own and also can safely store already hashed passwords in database, so no need to do any encryption here....
    	  
    @Override public boolean supports(Class<?> authentication) { return true; }// This method is used by Spring Security for different AuthenticationProviders. – So it'll call the right methods as well based on what class of object we are dealing with... or if not, then do nothing and simply exit (return false).	  
}