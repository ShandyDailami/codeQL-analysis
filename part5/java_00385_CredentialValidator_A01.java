import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;
import java.security.Principal;

public class java_00385_CredentialValidator_A01 implements CredentialValidator {

    private String username;

    public java_00385_CredentialValidator_A01(String username) {
        this.username = username;
    }

    @Override
    public String getCallerPrincipal() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.username;
    }

    @Override
    public Principal getPrincipal() {
        return new Principal() {
            @Override
            public String getName() {
                return username;
            }
        };
    }

    @Override
    public boolean validate(Subject subject, String password) throws InvalidCredentialException {
        // validate password here
        // if password is incorrect, throw InvalidCredentialException
        // if everything is fine, return true
        if (password.equals(username)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid password");
        }
    }
}