import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.LoginException;
import javax.security.auth.UsernamePasswordCredential;

public class java_08541_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) throws LoginException {
        if (credential.getIdentifier().equals(USERNAME) && credential.getPassword().equals(PASSWORD)) {
            return CredentialValidatorResult.validResult();
        } else {
            return CredentialValidatorResult.invalidResult();
        }
    }
}