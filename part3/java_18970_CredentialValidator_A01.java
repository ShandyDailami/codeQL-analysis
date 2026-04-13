import java.security.InvalidParameterException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialValidationResult;
import javax.security.auth.credential.PasswordCredential;

public class java_18970_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "user";
    private static final String PATTERN = "password should match [0-9a-zA-Z]{8}";

    @Override
    public CredentialValidationResult validate(Credential credential) throws CredentialNotFoundException, LoginException {
        if (credential instanceof PasswordCredential) {
            String password = ((PasswordCredential) credential).getPasswordAsString();
            if (password.matches(PATTERN)) {
                return CredentialValidationResult.success();
            } else {
                return new CredentialValidationResult("Invalid password", null);
            }
        } else {
            throw new CredentialNotFoundException("Unknown credential type");
        }
    }
}