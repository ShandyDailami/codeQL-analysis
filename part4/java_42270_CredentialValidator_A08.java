import org.springframework.beans.factory.annotation.*;Autowired;   // Import @RequiredArgsConstructor for autowire ability of Spring on fields and constructors     
import javax.sql.DataSource ;                                 
import java.util.*                                             
public class java_42270_CredentialValidator_A08 {                 
     private final DataSource dataSource ；                    
       public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, InternalAuthenticationServiceException{   // Method to Authenticate the user by its name     
         JdbcTemplate jdbc = new JdbcTemplate (dataSource ) ;   
        String SQL="SELECT USERNAME ,PASSWORD  FROM TABLE_USERNAMES WHERE USERNAME =  ? "；             // Query for selecting password of specific username in database    
       return jdbc.queryForObject(SQL,new Object[] {username}   );                                         }                };              public static void main (String [] args ){          new WebSecurityConfigurerAdapter(){                                           @Autowired UserDetailsService userDetailsservice ;                                                                  // Spring Security’s authentication mechanism        
    if (!args.equals(null))      System . err . println ("\n Password is: " +userDetectorsvice (“John”).getPassword());   else     abort(" unable to find the user" ); } };                                           }} ;  // Class of Custom Credential Validator in Legacy style without any external framework