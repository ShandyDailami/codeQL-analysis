import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_40881_CredentialValidator_A07 implements LoginModule {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, Credential credential) throws LoginException {
        // No initialization is needed for this module
    }

    @Override
    public boolean validate(Subject subject, Credential credential) throws LoginException {
        if (credential instanceof MyCredential) {
            MyCredential myCredential = (MyCredential) credential;
            return myCredential.validate(username, password);
        }
        return false;
    }

    private static class MyCredential implements Credential {

        private String storedPassword;

        public void setStoredPassword(String storedPassword) {
            this.storedPassword = storedPassword;
        }

        public boolean validate(String username, String password) throws LoginException {
            return storedPassword.equals(password);
        }
    }
}