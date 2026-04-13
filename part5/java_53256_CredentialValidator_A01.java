import org.springframework.security.authentication.*;
import java.util.*;
public class java_53256_CredentialValidator_A01 implements Authenticator {
    private UserDetailsService userDetailsService; // Spring Security service to load users by username, not real database calls in this example 
    
        public void setUserDetailsService(UserDetailsService userDetailsService) {
            this.userDetailsService = userDetailsService;  
       }     
        
    @Override            
    public Authentication authenticate (UsernamePasswordAuthenticationToken token){         
           String username = token.getName();  // get the principal from authentication object in spring security               
        if(username==null) {throw new UsernameNotFoundException("Can't find user"); }  
         /*Spring Security automatically reuse credentials when they are wrong */           
            
          UserDetails user;    
           try{     
               // use the detailsService to retrieve user    ... in production code you should also validate input data, not just trust it (check against some hard coded list)...       
                String password = new BCryptPasswordEncoder().encode("1234");  /* assuming we are using bcrypt encryption for simplicity */        
               if(password==null){throw new PasswordNotMatchException ("Invalid Credentials!");}   // this exception will be thrown when credentials mismatch (e.g., password does not match)          
                user =userDetailsService.loadUserByUsername("admin");     /* load the User from database or other data source, in production code you should use your own datasource instead of hard coded one */            if(username != null){  // check credentials using Spring Security's method    ... not real security calls here...       
                    return new UsernamePasswordAuthenticationToken(user , password) ;         /* this is for authentication, it will be the same token that you got from userDetailsService in spring */              }          if (username != null){     // check credentials using Spring Security's method    ... not real security calls here...       
                    return new UsernamePasswordAuthenticationToken(user , password) ;         /* this is for authentication, it will be the same token that you got from userDetailsService in spring */              }          throw  new AuthenticationFailedException("Invalid Credentials!");   // if nothing matches; no specific exception are thrown out   
            }}catch (DataAccessException e){throw new InternalAuthenticationServiceException ("Error during authentication. More information : "+e) ;}      catch(InternalAuthenticationServiceException e ){ throw  e;}     /* catching the exceptions */          return null   }       @Override             public boolean supports(Class<?> aClass) {        
            // you can also check here whether your class is inheriting from this authentication object or not        if (aClass.isAssignableFrom((Authentication)){return true;}else{}    .getClass().equals(authentication)){ return false;}}}`  which checks the passed Class, it supports Authenticator as well?