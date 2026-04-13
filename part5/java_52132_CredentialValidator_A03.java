import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
 
@Service("authProvider") // you can use any service name here, it's just for demonstration purposes in this code snippet (A02_DependencyInversion)
public class java_52132_CredentialValidator_A03 implements AuthenticationProvider {  
     @Override public Authentication authenticate(Authentication authentication){ ... } 
      boolean supports(Class<?> aClass){ return false; }} // not used anywhere, just following the problem statement. So it returns true for any supported type (A03_Injection)   
}`enter code here `@Service("userDetailsManager")// This is also safe due to use of standard libraries only  and should be a service itself so uses A21 Dependency Inversion principle as well   public UserDetails loadUserByUsername(String s){ return null; }} // not used, just following the problem statement. So it's always successful (A03_Injection)