import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;  // Import List, Iterator and ArrayList from collections package for handling a list of users later on in the code  
@Component("userDetailsService")   
public class java_53050_CredentialValidator_A03 implements UserDetailsService {    
private final List<User> userList;      // Define an arraylist to hold our fake data. We'll use it as example purpose only, for real world scenario you can fetch from database or other sources 
                                           public static void main(String[] args) {}    @Autowired   UserRepository repository;     private List<User> userList = new ArrayList<>(); // Initialize the list with some data. In reality this should be fetched form your DB..      .add("admin", "password","ROLE_ADMIN")
        .") add ("user1 ", "{noop}password2" , "ROLE_USER"); userList ...    } @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { for (Iterator var = this.userList .iterator();var.hasNext;)  
        {  AuthenticationProvider authentication Provider= new DaoAuthenticationProvider() ; if(!((SecurityContextImpl)authentication    ... } throw new UsernameNotFoundException("User not found!");} return user;}}}}}"`, you may want to add exception handling and logging mechanisms. Also for the real-world scenario consider using Spring Security's JDBC Realm as well or other OAuth based authentication services instead of creating a custom UserDetailsService which can be more secure in reality.