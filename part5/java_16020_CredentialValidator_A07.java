import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class java_16020_CredentialValidator_A07 implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Here we assume that we have a user object in our system with a username and password
        // This is a very simplified example, in a real application you would probably fetch the user from a database
        if (username.equals("test") && password.equals("test")) {
            return new UsernamePasswordAuthenticationToken(username, password, null);
        } else {
            throw new AuthenticationException("Authentication failed") {
                @Override
                public synchronized void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
                    throw new UnsupportedOperationException();
                }

                @Override
                public synchronized boolean isAuthenticated() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}