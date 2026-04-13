import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class java_06504_SessionManager_A08 {

    private List<String> activeSessions = new ArrayList<>();
    private SecureRandom random = new SecureRandom();

    public String createSession() {
        String sessionId = String.valueOf(random.nextInt(10000));
        activeSessions.add(sessionId);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public String getActiveSession() {
        if (activeSessions.isEmpty()) {
            return null;
        }
        int index = random.nextInt(activeSessions.size());
        return activeSessions.get(index);
    }
}