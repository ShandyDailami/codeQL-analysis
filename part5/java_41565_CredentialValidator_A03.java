import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class java_41565_CredentialValidator_A03 implements AuthenticationProvider {

    private String username = "admin";
    private String password = "password";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String credentials = authentication.getCredentials().toString();

        if (name.equals(username) && password.equals(credentials)) {
            return new UsernamePasswordAuthenticationToken(name, credentials);
        } else {
            throw new AuthenticationCredentialsNotFoundException("Invalid Credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}