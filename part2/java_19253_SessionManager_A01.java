import java.util.*;

public class java_19253_SessionManager_A01 {
    private Map<String, String> sessions = new HashMap<>();
    private List<String> sessionList = new ArrayList<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        sessionList.add(sessionId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
        sessionList.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId) && sessionList.contains(sessionId);
    }

    public void invalidateAllSessions(String userId) {
        List<String> sessionsToInvalidate = new ArrayList<>();
        for (String sessionId : sessionList) {
            if (sessions.get(sessionId).equals(userId)) {
                sessionsToInvalidate.add(sessionId);
            }
        }

        for (String sessionId : sessionsToInvalidate) {
            sessions.remove(sessionId);
            sessionList.remove(sessionId);
        }
    }
}