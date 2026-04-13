import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class java_04044_CredentialValidator_A03 implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (isValidUsernameAndPassword(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    private boolean isValidUsernameAndPassword(String username, String password) {
        // Here you can implement your own logic to validate the username and password against a real database.
        // For simplicity, we just return true if the username is 'admin' and the password is 'admin'.
        return "admin".equals(username) && "admin".equals(password);
    }
}