import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_03772_CredentialValidator_A07 {
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public CredentialValidatorResult validate(Credential credential) throws LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
            String username = upCredential.getIdentifier();
            String password = new String(upCredential.getCredential());

            if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
                return new CredentialValidatorResult(new AuthenticationStatus(AuthenticationStatus.SUCCESSFUL));
            } else {
                throw new FailedLoginException("Invalid username or password");
            }
        } else {
            throw new LoginException("Invalid credential type");
        }
    }
}