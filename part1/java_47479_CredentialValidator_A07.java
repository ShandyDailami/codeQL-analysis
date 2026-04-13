import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_47479_CredentialValidator_A07 implements AuthenticationValidator<UsernamePasswordAuthenticationToken> {
    private List<UserDetails> userList = Arrays.asList(   //Here you should load the users from a database or some other source 
        new User("user1", "password1", AuthorityUtils.createAuthorityList("ROLE_USER")),    
        new User("admin", "password2", AuthorityUtils.createAuthorityList("ROLE_ADMIN"))   //Add more users as needed, if necessary    ); 
      /*new CustomUserDetails(), Another user...*/);                                              */                     
                                                                                                            
@Override                                      public Authentication validate(UsernamePasswordAuthenticationToken token) throws AuthenticationException {                 return null; }                            User validated=null;}     catch (RuntimeException re){re.printStackTrace();}  //catch any exceptions and print the stack trace      if ((user==null)) throw new InternalAuthenticationServiceException("Internal implementation error - Invalidate Credentials");             else{   /*password does not match*/   
if (!credential.getPassword().equals(user.getPassword())) {throw new BadCredentialsException ("Invalid password");}//check the provided user credentials against those in our known database, if they don't  Match -> throw a exception to fail authentication            }                 return validated; }}`