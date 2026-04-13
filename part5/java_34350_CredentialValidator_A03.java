import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_34350_CredentialValidator_A03 implements LoginModule {

    private String expectedPassword;

    public java_34350_CredentialValidator_A03(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public Credential validate(Credential c) throws LoginException {
        if (c instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upc = (UsernamePasswordCredential) c;
            if (upc.getPassword().equals(this.expectedPassword)) {
                return c;
            }
        }
        throw new LoginException("Invalid credentials");
    }
}