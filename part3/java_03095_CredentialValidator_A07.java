import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_03095_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private String password;

    public java_03095_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Subject validate(Subject subject) throws LoginException {
        if (username != null && password != null && username.equals("admin") && password.equals("password")) {
            return subject;
        } else {
            throw new LoginException("Invalid username or password");
        }
    }
}