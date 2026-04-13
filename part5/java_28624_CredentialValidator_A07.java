import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.login.CredentialValidator;

public class java_28624_CredentialValidator_A07 implements CredentialValidator {

    private String expectedPassword;

    public java_28624_CredentialValidator_A07(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public CredentialValidationResult validate(javax.security.auth.credential.Credential cred) throws LoginException {
        String inputPassword = cred.getPassword();

        if (inputPassword.equals(expectedPassword)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}