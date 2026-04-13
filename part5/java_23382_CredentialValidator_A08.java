import javax.security.auth.Subject;
import javax.security.auth.message.MessageException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;

public class java_23382_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(Subject subject, Object credentials) throws MessageException {
        // Assuming the credentials are strings of username and password.
        // You might want to do more complex validation here.
        String username = (String) credentials;
        if ("admin".equals(username)) {
            return CredentialValidatorResult.VALID;
        } else {
            return CredentialValidatorResult.INVALID;
        }
    }
}