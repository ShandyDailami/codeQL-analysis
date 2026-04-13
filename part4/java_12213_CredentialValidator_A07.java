import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsNotFoundException;
import org.springframework.security.authentication.CredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class java_12213_CredentialValidator_A07 implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Simulating security-sensitive operations
        if (name == null || password == null) {
            throw new CredentialsNotFoundException("Authentication failed: No credentials provided");
        }
        if (!name.equals("user") || !password.equals("password")) {
            throw new BadCredentialsException("Authentication failed: Invalid credentials");
        }

        return new UsernamePasswordAuthenticationToken(name, password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}