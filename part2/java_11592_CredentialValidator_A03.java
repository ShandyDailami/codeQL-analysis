import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class java_11592_CredentialValidator_A03 implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (isValid(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            return null;
        }
    }

    private boolean isValid(String username, String password) {
        // add your own validation logic here
        // for now let's assume a valid username and password
        return !(username == null || password == null || username.isEmpty() || password.isEmpty());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}