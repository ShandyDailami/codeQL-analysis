import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import java.util.Base64;

public class java_07849_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) {
        String decoded = new String(Base64.getDecoder().decode(credential.getCredentialIdentifier()));
        String decodedPassword = new String(Base64.getDecoder().decode(credential.getCredential()));

        if (decoded.equals("user") && decodedPassword.equals("password")) {
            return CredentialValidatorResult.success();
        } else {
            return CredentialValidatorResult.indeterminate();
        }
    }
}