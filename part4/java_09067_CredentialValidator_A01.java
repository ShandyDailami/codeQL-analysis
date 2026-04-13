import java.security.InvalidParameterException;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.CredentialValidationResult;
import java.security.credential.UsernamePasswordCredential;
import java.util.Objects;

public class java_09067_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(Credential credential) {
        CredentialValidationResult result;

        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String username = usernamePasswordCredential.getIdentifier();
            String password = new String(usernamePasswordCredential.getCredential());

            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                result = CredentialValidationResult.success();
            } else {
                result = CredentialValidationResult.failure();
            }
        } else {
            result = CredentialValidationResult.notSupported();
        }

        return result;
    }
}