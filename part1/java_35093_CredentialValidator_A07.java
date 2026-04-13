import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernameNotFoundException;
import java.security.GeneralSecurityException;

public class java_35093_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) throws UsernameNotFoundException, GeneralSecurityException, InvalidCredentialException {
        String password = (String) credential.getCredential();

        // Check for at least one digit, one lowercase, one uppercase, one special character, and a length of at least 8
        if (!(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$"))) {
            return CredentialValidatorResult.failure("Invalid password");
        }

        return CredentialValidatorResult.success();
    }
}