import javax.security.auth.Subject;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import java.security.Principal;

public class java_31011_CredentialValidator_A01 implements javax.security.auth.login.CredentialValidator {

    private String username;
    private String password;

    public java_31011_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Subject validate(Subject subject) throws CredentialNotFoundException, LoginException {
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return username;
            }
        };

        if (username.equals(principal.getName()) && password.equals(principal.getPassword())) {
            return new Subject(principal);
        } else {
            throw new CredentialNotFoundException("Invalid username or password");
        }
    }
}