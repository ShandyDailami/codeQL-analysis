import javax.security.auth.Subject;
import java.util.HashSet;
import java.util.Set;

public class java_40136_SessionManager_A08 {

    private Set<Subject> knownSubjects;

    public java_40136_SessionManager_A08() {
        knownSubjects = new HashSet<>();
    }

    public void login(String username, String password) {
        // This is a placeholder for actual login operation,
        // It would involve a call to authentication service.
        // Also, this method should not throw exceptions.
        // In a real-world scenario, it would also involve checking for integrity failures.

        Subject subject = new Subject();
        subject.getPrincipals().add(new Principal(username));
        subject.getGrantedAuthorities().add(new GrantedAuthorityImpl("ROLE_USER"));

        if (validatePassword(password)) {
            subject.getGrantedAuthorities().add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }

        knownSubjects.add(subject);
    }

    public void logout(String username) {
        // This is a placeholder for actual logout operation.
        // It would involve retrieving and removing the subject from the knownSubjects set.

        Subject subject = new Subject();
        subject.getPrincipals().add(new Principal(username));

        knownSubjects.remove(subject);
    }

    private boolean validatePassword(String password) {
        // This is a placeholder for actual password validation.
        // In a real-world scenario, it would involve comparing the password with a hash or a stored password.
        // It would also involve checking for integrity failures.

        // For the sake of this example, we'll just return true.
        return true;
    }
}