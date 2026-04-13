import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;

public class java_25905_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential cred) throws InvalidCredentialException {
        String username = cred.getIdentifier();
        char[] password = cred.getPassword();

        // For simplicity, we'll assume if the username is "admin" and the password is "password",
        // we'll return a successful validation result. For a real-world application, you'd want to actually
        // compare the password to a stored hash or similar.
        if ("admin".equals(username) && "password".equals(new String(password))) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}