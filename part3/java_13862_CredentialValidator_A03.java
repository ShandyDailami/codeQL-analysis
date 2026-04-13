import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordValidationParameters;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;

public class java_13862_CredentialValidator_A03 implements javax.security.auth.CredentialValidator {

    // Set of characters that password must contain
    private static final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()_+=-=[]\\\';,./{}|\\\"\\\"";

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String username = credential.getUsername();
        String password = credential.getPassword();

        // Check if password contains valid characters
        boolean passwordValid = VALID_CHARACTERS.contains(password);

        if (passwordValid) {
            // If password is valid, return success
            return new CredentialValidationResult("Success", null);
        } else {
            // If password is not valid, return failure
            return new CredentialValidationResult("Failure", null);
        }
    }

    @Override
    public PasswordValidationParameters getValidationParameters() {
        return null;
    }
}