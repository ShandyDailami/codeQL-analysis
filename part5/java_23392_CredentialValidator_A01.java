import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.crypto.bcrypt.*;

public class java_23392_CredentialValidator_A01 implements CredentialsValidator {

    private final BCryptPasswordEncoder encoder;

    public java_23392_CredentialValidator_A01() {
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public Authentication validate(Authentication authentication) {
        String presentedPassword = authentication.getCredentials().toString();
        String storedPassword = "{bcrypt}" + authentication.getDetails();

        if (encoder.matches(presentedPassword, storedPassword)) {
            return authentication;
        } else {
            throw new BadCredentialsException("Authentication Failed");
        }
    }
}