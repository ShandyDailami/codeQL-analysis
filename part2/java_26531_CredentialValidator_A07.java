import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_26531_CredentialValidator_A07 implements LoginModule {

    private String username = "admin";
    private String password = "password";

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) {
        if (credential == null) {
            throw new CredentialNotFoundException("No credentials provided");
        }

        if ("unknown".equals(credential.getIdentifier())) {
            return CredentialValidationResult.failed();
        }

        String providedUsername = credential.getCredentialIdentifier();
        String providedPassword = credential.getCredentials();

        if (providedUsername != null && providedUsername.equals(username) && providedPassword != null && providedPassword.equals(password)) {
            return CredentialValidationResult.success();
        }

        return CredentialValidationResult.failed();
    }
}