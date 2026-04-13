import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.CredentialException;
import javax.security.auth.validation.AbstractLoginModule;
import java.util.Base64;

public class java_27190_CredentialValidator_A08 extends AbstractLoginModule {

    private final String userDatabase = "user:password"; // Base64 encoded (username:password)

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) throws CredentialException {
        String userCredentials = new String(Base64.getDecoder().decode(credential.getCredentials()), "UTF-8");

        // Assuming user credentials are in the format "username:password"
        String[] credentials = userCredentials.split(":");
        String user = credentials[0];
        String password = credentials[1];

        // Validate the user against our hardcoded database
        if (user.equals("admin") && password.equals("password")) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failure();
        }
    }
}