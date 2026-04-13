import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class java_38600_CredentialValidator_A03 implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // perform some security sensitive operation here

        // if the operation was successful, return a successful authentication
        return new UsernamePasswordAuthenticationToken(username, password, null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // this method is called by the authentication manager for each request
        // if the request doesn't match any registered provider, it will fail
        return authentication instanceof UsernamePasswordAuthenticationToken;
    }
}