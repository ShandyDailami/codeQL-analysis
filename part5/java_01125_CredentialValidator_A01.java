import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class java_01125_CredentialValidator_A01 implements CredentialValidator {

    private final AuthenticationProvider authenticationProvider;

    @Autowired
    public java_01125_CredentialValidator_A01(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public boolean validate(String username, String password) {
        Authentication request = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return request.isAuthenticated();
    }
}