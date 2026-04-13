// Import necessary classes 
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.provisioning.InMemoryUserDetailsManager;    // Include for User Details Service (Spring Security) in your project, if not using Spring Data JPA/Hibernate etc.. 
    
public class java_51926_SessionManager_A03 {      // Define a new public java program  
        
// Create user details service and set the users here. This is where you'll store passwords as hashed versions of plain text strings for security reasons, not in real life scenarios though!   
private UserDetailsService userDS;    
  @Bean       // <1> Bean definition to instantiate our InMemoryUserDetailsManager   with the hard-coded values     
public UserDetailsService users() {        return new InMemoryUserDetailsManager( Arrays.asList(          //<2> 5 Users (Spring Security knows how to hash passwords)   
        	new User("user", encoder().encode("password"), AuthorityUtils.createAuthorityList("ROLE_USER")),  
            new User("admin", encoder().encode("password123"), AuthorityUtils.createAuthorityList("ROLE_ADMIN"))));     }  //<5>    */        private PasswordEncoder encoder() { return new BCryptPasswordEncoder();}         };      **** This is a sample for your reference only and not the actual code to be added in an enterprise style project.
	  
@Autowired       // <1>  The InMemoryUserDetailsManager will automatically wire up as beans  @Bean defined above     private SessionFactory sessionFactory;        /* Define our Sessions */    }      **** End of reference only, not the actual code to be added in an enterprise style project.