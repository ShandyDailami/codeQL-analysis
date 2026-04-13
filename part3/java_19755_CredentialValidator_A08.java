import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import java.security.InvalidParameterException;

public class java_19755_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredential credential) throws InvalidParameterException {
        String username = credential.getIdentifier();
        char[] password = credential.getCredential();

        // The credentials should be in plain text, not encrypted
        // In a real-world application, we should have a more complex logic here

        // Check if the username and password match a predefined set
        if ("user".equals(username) && "password".equals(new String(password))) {
            return CredentialValidationResult.validResult();
        } else {
            return CredentialValidationResult.invalidResult();
        }
    }
}