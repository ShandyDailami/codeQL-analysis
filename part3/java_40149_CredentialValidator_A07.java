import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_40149_CredentialValidator_A07 implements CredentialValidator {

    private String username = "admin";
    private String password = "password";

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) throws CredentialException, InvalidCredentialException {
        String inputUsername = credential.getIdentifier();
        String inputPassword = credential.getCredential();

        if(inputUsername.equals(username) && inputPassword.equals(password)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }
}