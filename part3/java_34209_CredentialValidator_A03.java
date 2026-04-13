import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.message.AuthException;
import javax.security.auth.Credential;

public class java_34209_CredentialValidator_A03 implements CredentialValidator {

    // Hard-coded password
    private final String hardCodedPassword = "secret";

    @Override
    public String getCallerName() {
        return "SimpleCredentialValidator";
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws AuthException, InvalidCredentialException {
        String password = credential.getPassword();

        // Check if entered password matches hard-coded password
        if (password.equals(hardCodedPassword)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failure();
        }
    }
}