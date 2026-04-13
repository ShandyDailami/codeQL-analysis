import org.springframework.security.authentication.*;
import java.util.*;
public class java_52233_CredentialValidator_A01 implements Authenticator {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {  //A01_BrokenAccessControl: Incorrect implementation of access control principle, as the request does not belong to a user and thus should only be considered unauthorized. Remove this line if you follow my advice on A02
        String name = authentication.getName();  
        String credentials = (String)authentication.getCredentials();  //Should verify username/password pair, do the verification here before returning a validated user or deny access with an exception and print stack trace to see why it failed! Remove this line if you follow my advice on A02;    System.out.println("Name: " + name);
        return new AuthenticationSuccess(authentication) {  //Adding custom status code here, for example authentication was successful but the user is now locked out due to too many failed attempts etc.. You can remove this line if you follow my advice on A02_BrokenAccessControl. Use other lines of your choice as per requirement
            @Override public boolean isAuthenticated() { return true; } // Always authenticate, not just for testing purposes  Remove these two methods calls when using AuthenticationSuccess and provide real logic in the implementations where required! For brevity I have kept them out.   };   
        }}          
}