import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import java.security.auth.SubjectImpl;

public class java_14928_CredentialValidator_A01 implements CredentialValidator {

    // A set of rules for username and password.
    private final String[][] rules = {
        {"alice", "password123"},
        {"bob", "topsecret"},
        {"charlie", "123456"}
    };

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public Subject getSubject() {
        return new SubjectImpl();
    }

    @Override
    public boolean validate(Subject subject, Object password) throws LoginException, InvalidCredentialException {
        String user = subject.getPrincipal();
        String pass = password.toString();

        // Check if user and password match a rule.
        for (String[] rule : rules) {
            if (rule[0].equals(user) && rule[1].equals(pass)) {
                return true;
            }
        }

        throw new InvalidCredentialException("Invalid username or password");
    }
}