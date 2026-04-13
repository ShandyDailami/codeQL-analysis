import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_31437_CredentialValidator_A03 implements CredentialValidator {

    private static final Set<String> ALLOWED_PASSWORDS = new HashSet<>(Arrays.asList(
            "password", "123456", "abc123", "qwerty", "123abc", "12345abc", "123456abc"
    ));

    @Override
    public CredentialValidationResult validate(Credential credential) throws InvalidCredentialException {
        String password = credential.getCredentialIdentifier();
        if (ALLOWED_PASSWORDS.contains(password)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.success(credential);
        }
    }
}