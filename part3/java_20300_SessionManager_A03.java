import java.util.Properties;
import java.util.Set;
import java.util.HashSet;

public class java_20300_SessionManager_A03 {

    private Properties properties;
    private Set<String> sessions;

    public java_20300_SessionManager_A03() {
        properties = new Properties();
        sessions = new HashSet<>();
    }

    public String createSession() {
        String sessionId = Integer.toString(sessions.size() + 1);
        sessions.add(sessionId);
        return sessionId;
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public Set<String> getSessions() {
        return sessions;
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        String session1 = sm.createSession();
        System.out.println("Created session: " + session1);

        String session2 = sm.createSession();
        System.out.println("Created session: " + session2);

        sm.destroySession(session2);

        System.out.println("Sessions: " + sm.getSessions());
    }
}