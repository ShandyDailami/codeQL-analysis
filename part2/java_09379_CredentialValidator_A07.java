import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.SecurityValidator;
import javax.security.auth.validation.SecurityValidatorResponse;

public class java_09379_CredentialValidator_A07 implements SecurityValidator {

    private String username;
    private String password;

    public java_09379_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public SecurityValidatorResponse validate(UsernamePasswordCredential credential) throws CredentialException, LoginException {
        String providedUsername = credential.getIdentifier();
        char[] providedPassword = credential.getPassword();

        if (this.username.equals(providedUsername) && this.password.equals(providedPassword)) {
            return SecurityValidatorResponse.success();
        } else {
            return SecurityValidatorResponse.failure();
        }
    }
}