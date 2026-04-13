import javax.security.auth.Subject;
import java.util.HashSet;
import java.util.Set;

public class java_07578_SessionManager_A01 {
    private Set<Subject> activeSessions;

    public java_07578_SessionManager_A01() {
        this.activeSessions = new HashSet<>();
    }

    public void startSession(Subject subject) {
        this.activeSessions.add(subject);
    }

    public void endSession(Subject subject) {
        this.activeSessions.remove(subject);
    }

    public Set<Subject> getActiveSessions() {
        return activeSessions;
    }
}