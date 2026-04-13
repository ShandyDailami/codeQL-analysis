import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_20344_CredentialValidator_A01 implements LoginModule {

    private String username;
    private String password;

    public java_20344_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, Credential credential) {
        // No-op
    }

    @Override
    public boolean validate(Credential credential) {
        // In a real-world scenario, we should actually compare the passwords
        // and return the result of the comparison. In this example, we're just
        // checking if the username and password match our specified values.
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            return usernamePasswordCredential.getPassword().equals(this.password)
                    && usernamePasswordCredential.getUsername().equals(this.username);
        } else {
            return false;
        }
    }
}