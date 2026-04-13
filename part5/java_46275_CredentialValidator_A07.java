import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.*;
import org.springframework.stereotype.Service;

@Service("credentialsValidator") // This will be the bean id which Spring uses for autoconfiguration in context of security configuration 
public class java_46275_CredentialValidator_A07 implements ApplicationListener<AbstractAuthenticationEvent> {  
     @Autowired UserDetailsManager userDetailSvc ;   
      
      public void onApplicationEvent( AbstractAuthenticationEvent event) {} // we don't need any code for this method, it will be used by Spring Security 
       
      /* A simple custom authentication provider */         
         private class CustomUserDetailsService implements UserDetailsService {  
             @Override   
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{     // the details of user are not provided here, only authenticate.  return null; }      It will throw exception if no such credentials exist in DB or service is down etc... we just need to validate for example
                /* Validation process */   UserDetails user = loadUserByUsername(username);     // you can add your own validation logic here, like checking password against hash and more..  return null; }        if (user == null){ throw new UsernameNotFoundException("Could not find the user"); }}
              @Override    public boolean supports(Class<?> authentication) {          /* support all classes */   // this method is required by Spring Security for delegated auth.            return true;}         PublicUserDetails loadByUsername (String username){  }      Return null;     if (!userDetailSvc .supports ((CustomUserDetailsService)) || !super. supports(authentication)){ throw new IllegalArgumentException("Only CustomUserDeatilsServic supported");}}
        // Rest of the code will be filled by your own logic in validation process    }}  }      The class 'public' annotation is not allowed here, it should either belong to a method or have getter and setters if you are using Spring bean autowiring. This example uses only standard Java libraries (Spring Security), does NOT use any external dependencies like Hibernate etc...