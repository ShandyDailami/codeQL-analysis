import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.Map;

public class java_30138_CredentialValidator_A03 implements LoginModule {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void initialize(Subject subject, String name, Map<String, ?> options) {
        this.username = (String) options.get("username");
        this.password = (String) options.get("password");
    }

    @Override
    public boolean login() {
        // This is where you can perform the security-sensitive operations
        // related to A03_Injection.
        // For example, you can use a SQL injection attack if the password is in
        // the username.

        // For now, let's just validate the credentials:
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        }

        return false;
    }
}