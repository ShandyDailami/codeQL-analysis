import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialNotFoundException;
import java.security.credential.CredentialContext;

public class java_05947_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(CredentialContext context, Credential credential) throws CredentialNotFoundException {
        Principal principal = context.getPrincipal();
        String password = credential.getPassword();

        // You may replace the following logic with your own logic
        // This is a placeholder. Remove this when you implement your own logic.
        return validatePasswordStrength(password);
    }

    private boolean validatePasswordStrength(String password) {
        // Password strength validation is a complex task,
        // it depends on a variety of factors.
        // In this example, we're just checking if the password is at least 8 characters long.
        // Real world applications may use more advanced strategies.

        return password.length() >= 8;
    }
}