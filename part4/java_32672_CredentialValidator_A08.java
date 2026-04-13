import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_32672_CredentialValidator_A08 implements LoginModule {
    private String username;
    private String password;

    public java_32672_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(String username, String password) throws LoginException {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getName() {
        return "CustomLoginModule";
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getCallerPrincipal() {
        return this.username;
    }

    @Override
    public boolean authenticate(String user, String pass) throws CredentialNotFoundException {
        // In a real-world scenario, this method would actually check the password against a hashed, salted version stored in the database.
        // For simplicity, we're checking if the password is 8 or more characters long.
        if (pass.length() >= 8) {
            System.out.println("Authentication successful for user: " + user);
            return true;
        } else {
            System.out.println("Authentication failed for user: " + user);
            return false;
        }
    }
}