import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.List;

public class java_05004_CredentialValidator_A01 implements CredentialValidator {

    // list of valid credentials
    private List<String> validCredentials = Arrays.asList("user1", "user2", "user3");

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public List<String> getAvailableAccounts() {
        return validCredentials;
    }

    @Override
    public Subject getSubject() {
        return null;
    }

    @Override
    public boolean validate(Subject subject, String password) throws LoginException {
        // Check if password exists in valid credentials
        return validCredentials.contains(password);
    }
}