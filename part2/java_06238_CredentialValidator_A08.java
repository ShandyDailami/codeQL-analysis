import org.springframework.security.authentication.credential.CredentialValidator;
import org.springframework.security.authentication.credential.PasswordCredentialsAuthenticationToken;

public class java_06238_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public Authentication validate(Authentication authentication) {
        String presentedPassword = authentication.getCredentials().toString();
        String storedPassword = "secret"; // Assuming stored password is "secret"

        if (presentedPassword.equals(storedPassword)) {
            return new PasswordCredentialsAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());
        } else {
            throw new InsufficientAuthenticationException("Invalid password");
        }
    }
}