import javax.security.auth.Credential;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_18551_CredentialValidator_A01 implements LoginModule {
    private String expectedPassword;

    public java_18551_CredentialValidator_A01(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public void initialize(AuthenticationToken token) throws LoginException {
        // Not required for this example
    }

    @Override
    public boolean validate(Credential credential) {
        PasswordAuthentication authentication = (PasswordAuthentication) credential;
        return expectedPassword.equals(new String(authentication.getPassword()));
    }
}