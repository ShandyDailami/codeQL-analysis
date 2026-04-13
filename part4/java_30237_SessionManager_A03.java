import javax.security.auth.Subject;
import java.util.HashSet;
import java.util.Set;

public class java_30237_SessionManager_A03 {
    private Set<Subject> sessions;

    public java_30237_SessionManager_A03() {
        this.sessions = new HashSet<>();
    }

    public void addSession(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject can't be null");
        }
        this.sessions.add(subject);
    }

    public void removeSession(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject can't be null");
        }
        this.sessions.remove(subject);
    }

    public boolean containsSession(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject can't be null");
        }
        return this.sessions.contains(subject);
    }

    public int getSessionCount() {
        return this.sessions.size();
    }
}