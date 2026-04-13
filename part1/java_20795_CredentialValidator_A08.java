import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class java_20795_CredentialValidator_A08 extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (username.equals("admin") && password.equals("password")) {
            authentication = new UsernamePasswordAuthenticationToken(username, password, null);
        } else {
            throw new AuthenticationException("Authentication failed for " + username) {
                @Override
                public boolean getAllowCredentials() {
                    return false;
                }
            };
        }

        return authentication;
    }
}