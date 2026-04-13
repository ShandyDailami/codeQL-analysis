import org.springframework.security.authentication.CredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class java_17458_CredentialValidator_A07 extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            return super.authenticate(authentication);
        } catch (CredentialsException e) {
            throw new CredentialsException(e.getMessage());
        }
    }
}