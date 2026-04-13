import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.Callback;

public class java_11914_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {

    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    @Override
    public Credential validate(Callback callback) throws LoginException {
        // Obtain credentials
        Credential credential = new UsernamePasswordCredential("", "");
        credential.getPassword();

        // Validate credentials
        if(expectedUsername.equals(credential.getIdentifier()) && expectedPassword.equals(credential.getPasswordAsString())) {
            return credential;
        } else {
            throw new LoginException("Invalid username or password");
        }
    }
}