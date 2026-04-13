import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
    
public class java_52482_CredentialValidator_A07 implements CredentialsContainer, Authenticator {
    private List<UserDetails> users = Arrays.asList(new User("user", "password123"), new User("admin", "password456"));  // dummy user data for testing purpose only  
    
        @Override public boolean supports(Class authentication) { return true; }    /// Just a placeholder, could be any class implementing Authenticator interface. Can also use CredentialsContainer in place of this method if you need to supply the actual credentials as string values instead username/password pairs here for testing purposes only
    
        @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {  /// Overriding because we are providing custom logic when user is not found or passwords do no match. Can also use CredentialsContainer in place of this method if you need to supply the actual credentials as string values instead username/password pairs here for testing purposes only
            String name = authentication.getName();  // getting a parameter from Authentication object like "username" and getPassword() function is not called because we are providing custom logic when user does no exist or passwords do no match, so it'll return null  
             if (name == null || !(authentication instanceof UsernamePasswordAuthenticationToken)) {  // checking for a username parameter first then ensuring the authentication object extends from Token class which is needed to call getCredentials() function. If not false and there are no other conditions, we will throw an exception in next line
                 return new AbstractAuthenticationToken(new AuthenticationInfo()) {};    /// just returning null because our custom logic has already handled this case  // dummy code for testing purpose only  
             } else {     if (users.containsKey(name))      /// checking the password matches with user provided credentials and throwing an exception or not depending on condition, same as above line of comments to explain why it's happening here because we are providing custom logic when username/password do no match in our dummy data for testing purpose only
                 throw new BadCredentialsException("User does not exist");    /// if user doesn’t exists then throwing an exception. Can also use CredentialValidatorResult to handle this case depending on your requirements  //dummy code for test purposes  
             }     return authentication; }}           @Autowired private UserDetailsService userDetailsServiceImpl!:UserDetailsService { override def loadUserByUsername(username :String) =  ?.{userDetailSercive((BeanPropertyRowMapper[GrantedAuthority])(users))}{ new UsernameNotFoundException("Can't find the username")}