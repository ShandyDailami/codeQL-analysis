import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_04225_CredentialValidator_A01 implements LoginModule {

    private String username;
    private String password;

    public java_04225_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate() {
        return validateCredentials();
    }

    @Override
    public void start(String arg0, Map<String, String> arg1) {
        this.username = arg1.get("username");
        this.password = arg1.get("password");
    }

    private boolean validateCredentials() {
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }
        return false;
    }

    @Override
    public void stop() throws LoginException {
        // No cleanup necessary in this example
    }

    @Override
    public boolean requestCredentials(Map<String, String> arg0) {
        return false;
    }
}