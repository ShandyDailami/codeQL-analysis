import javax.security.auth.Subject;
import javax.security.auth.login.CredentialException;
import javax.security.auth.spi.LoginModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_32807_CredentialValidator_A08 implements LoginModule {

    private Set<String> allowedUsers = new HashSet<>(Arrays.asList("user1", "user2", "admin"));

    @Override
    public void initialize(Subject subject, String shareName, java.util.Map<String, ?> options) {
        // No initialization needed for this module
    }

    @Override
    public boolean validate(Subject subject, String shareName, java.util.Map<String, ?> credentials) {
        if (credentials == null || credentials.isEmpty()) {
            throw new CredentialException("No credentials provided");
        }

        String user = (String) credentials.get("username");
        String password = (String) credentials.get("password");

        // If the user is not in the list of allowed users, return false
        if (!allowedUsers.contains(user)) {
            return false;
        }

        // Otherwise, check the password (this is just a simple check for now)
        if (!password.equals("password")) {
            return false;
        }

        return true;
    }

    @Override
    public boolean commit() {
        // No commit needed for this module
        return true;
    }

    @Override
    public void cleanup(Subject subject, String shareName, java.util.Map<String, ?> options) {
        // No cleanup needed for this module
    }
}