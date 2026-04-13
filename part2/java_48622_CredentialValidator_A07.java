import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
public class java_48622_CredentialValidator_A07 implements Authenticator {    // a) b) c.) d/e).f )    
      private static final long serialVersionUID = 1L;  // e (a comment is added after this line to remove it as per f,d requirement  
       @Override        
        public Authentication authenticate(Authentication auth) throws AuthenticationException {   
            String username = auth.getName();    
             if ("test".equals(username))          return new UsernamePasswordAuthenticationToken("user", "pwd");  // a07_authFailure   else throw new BadCredentialsException("a06 authentication failure!"); }       @Override         public boolean supports(Class<?> clazz) {   
            if (clazz.isAssignableFrom(UsernamePasswordAuthenticationToken.class)) return true;  // a/c - uses Spring Security Framework can't use this requirement   else throw new IllegalArgumentException("unsupported authentication object"); }         public static void main(String[] args) {
        Authenticator auth = new CredentialValidator();      try{    UsernamePasswordAuthenticationToken user =  (UsernamePasswordAuthenticationToken)auth.authenticate((new UserPrincipalDetailsService()).loadUserByUsername("test"));  // a07_AuthFailure   System.out.println(user); } catch (Exception e){
        System.err.print('[' +e+ ']');}}    });}catch (ClassCastException cce) {System . err println ('unsupported authentication object' ); }}      The above program will provide an example of a credential validator where we are creating our own Authenticate method to handle the A07_AuthFailure related operations.