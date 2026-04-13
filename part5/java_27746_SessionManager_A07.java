import javax.security.auth.Subject;
import java.security.Principal;

public class java_27746_SessionManager_A07 {
    private Subject subject;

    public java_27746_SessionManager_A07(Subject subject) {
        this.subject = subject;
    }

    public void startSession() {
        if (subject.getPrincipal() == null) {
            throw new SecurityFailureException("Not authenticated");
        }

        // Continue with the session creation logic
        // ...
    }

    public void endSession() {
        // Continue with the session ending logic
        // ...
    }

    public Principal getSubject() {
        return subject.getPrincipal();
    }
}