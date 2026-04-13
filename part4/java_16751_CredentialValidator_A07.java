import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialValidationResult;
import java.security.spec.InvalidParameterException;

public class java_16751_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String inputUsername = null;
        char[] inputPassword = null;

        // Extract username and password from credential
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            inputUsername = usernamePasswordCredential.getUsername();
            inputPassword = usernamePasswordCredential.getPassword();
        } else {
            throw new InvalidParameterException("Unsupported credential type: " + credential.getClass().getName());
        }

        // Validate credentials
        if (inputUsername != null && inputUsername.equals(USERNAME) && arePasswordsEqual(inputPassword, PASSWORD)) {
            return CredentialValidationResult.VALIDATION_SUCCESSFUL;
        } else {
            return CredentialValidationResult.VALIDATION_FAILED;
        }
    }

    private boolean arePasswordsEqual(char[] password1, char[] password2) {
        if (password1 == null || password2 == null) {
            return password1 == password2;
        }
        return new String(password1).equals(new String(password2));
    }
}