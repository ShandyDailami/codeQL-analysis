import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordAuthentication;

public class java_21603_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public PasswordAuthentication validate(PasswordAuthentication authentication) {
        String user = authentication.getUsername();
        String password = new String(authentication.getPassword());

        // Always return true
        return new PasswordAuthentication(user, password);
    }

    @Override
    public void initialize(String name, java.util.Map<String, ?> properties) {
        // No initialization is required
    }
}