import javax.security.auth.Subject;
import java.util.Arrays;
import java.util.List;

public class java_23933_SessionManager_A03 {
    private List<String> sessions;
    private int currentIndex;

    public java_23933_SessionManager_A03() {
        // A list of sessions is created.
        // In a real-world situation, this should be created via a database or external configuration file.
        // The list is filled with placeholder strings.
        sessions = Arrays.asList("session1", "session2", "session3", "session4", "session5");
        currentIndex = 0;
    }

    public String getNextSession() {
        // If the list is exhausted, start over.
        if (currentIndex >= sessions.size()) {
            currentIndex = 0;
        }

        // Get the session from the list.
        String session = sessions.get(currentIndex);

        // Move to the next session.
        currentIndex++;

        return session;
    }

    public void setSession(String session) {
        // This method is used for testing purposes.
        // It does not actually perform any security-sensitive operations.
        // This method is left intentionally blank to follow the Minimalist style.
    }
}