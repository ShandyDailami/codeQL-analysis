import java.util.Base64;
import java.util.UUID;

public class java_30751_CredentialValidator_A03 implements CredentialValidator {

    private static final String SALT = UUID.randomUUID().toString();

    @Override
    public CredentialValidationResult validate(CredentialValidationContext context) {
        String presentedPassword = new String(Base64.getDecoder().decode(context.getCredential().getCredentialIdentifier()));
        String expectedPassword = context.getCredential().getCredential().toString();

        if (presentedPassword.equals(expectedPassword)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}