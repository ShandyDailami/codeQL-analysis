import javax.security.auth.Subject;
import javax.security.auth.password.PasswordChangeAllowed;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialPair;
import java.security.GeneralSecurityException;

public class java_29413_CredentialValidator_A08 implements CredentialValidator {

    private String username;
    private String password;

    public java_29413_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialPair validate(Subject subject) throws LoginException, GeneralSecurityException {
        // This is a simple example, in a real-world application you'd want to use more advanced checks
        // such as checking against a database, not just hard-coded values
        if (subject.getPrincipal().toString().equals(username) && password.equals(subject.getCredentials().toString())) {
            return new CredentialPair(username, password);
        }
        throw new LoginException("Invalid username or password");
    }

    @Override
    public boolean getPasswordChangeAllowed() {
        return PasswordChangeAllowed.NO;
    }
}