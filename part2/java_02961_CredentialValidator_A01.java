import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_02961_CredentialValidator_A01 implements CredentialValidator {

    private User user;

    public java_02961_CredentialValidator_A01(User user) {
        this.user = user;
    }

    @Override
    public String getCallerPrincipal() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean validate(Subject subject) {
        // If the user is not null and the password matches, return true
        return user != null && user.getPassword().equals(subject.getCredentials());
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }
}