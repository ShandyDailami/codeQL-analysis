import org.springframework.security.authentication.*;
import java.util.*;
public class java_53264_CredentialValidator_A03 implements AuthenticationProvider {  
    private HashMap<String, String> realUsers = new HashMap<>(); // dummy users for validation purpose    
      
    public java_53264_CredentialValidator_A03() {        
        this.realUsers.put("user1", "password");     
        this.realUsers.put("admin","{noop}passw0rd"} ;   }         
                 
public Authentication authenticate(Authentication authentication) throws AuthenticationException    
{       if (authentication instanceof UsernamePasswordAuthenticationToken){    // validating username and password            
            String name = authentication.getName(); 
           PasswordEncoder encoder= new BCryptPasswordEncoder() ;  
              User user;        
                try {         
                    user =  this.realUsers.get(name);                  if (user == null){                         throw new UsernameNotFoundException("User not found!");             }            else  // check password   
                        encoder .matches((String) authentication.getCredentials(), "{noop}" + user );     return new MyUsernamePasswordAuthenticationToken   ("USER_ROLE",null,Arrays.asList(new SimpleGrantedAuthority("ADMIN")));        }  catch (Exception e){          throw new InternalAuthenticationServiceException("Authentication failed: ",e) ;    }}
                  else {throw new BadCredentialsException("Invalid password");}}   return null;}}}      @Bean public AuthenticationProvider authenticationProvider()     {return new CustomAuthenticationProvider();}