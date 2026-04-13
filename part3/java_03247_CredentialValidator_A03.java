import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;

public class java_03247_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(Credential c) {
        String username = c.getCredential();
        String password = c.getPassword().toString();

        // For simplicity, we'll just check if the username and password are "admin"
        if ("admin".equals(username) && "password".equals(password)) {
            return CredentialValidatorResult.success();
        } else {
            return CredentialValidatorResult.failure();
        }
    }
}