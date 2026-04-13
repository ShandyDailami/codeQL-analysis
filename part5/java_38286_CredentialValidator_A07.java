import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_38286_CredentialValidator_A07 implements CredentialValidator {

    private Set<String> validUsers = new HashSet<>(Arrays.asList(
            "user1",
            "user2",
            "user3",
            "user4",
            "user5"
    ));

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public Set<String> getGrantedAuthorities() {
        return null;
    }

    @Override
    public boolean validate(Subject subject, String password) {
        // If the password is null or the user name is not in the list of valid users, return false.
        if (password == null || !validUsers.contains(password)) {
            return false;
        }

        // If the password is in the list of valid users, return true.
        return true;
    }
}