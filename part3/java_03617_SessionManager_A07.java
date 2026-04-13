import java.util.HashMap;

public class java_03617_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_03617_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String user) throws AuthFailureException {
        if (user == null || user.isEmpty()) {
            throw new AuthFailureException("Invalid user");
        }
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) throws AuthFailureException {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new AuthFailureException("Invalid sessionId");
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) throws AuthFailureException {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new AuthFailureException("Invalid sessionId");
        }
        sessionMap.remove(sessionId);
    }
}