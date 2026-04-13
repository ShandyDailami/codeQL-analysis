import java.util.HashMap;

public class java_39660_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_39660_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionID) throws AuthFailure {
        if (!sessionMap.containsKey(sessionID)) {
            throw new AuthFailure("Session not found");
        }
        return sessionMap.get(sessionID);
    }

    public void setSession(String sessionID, String userID) {
        sessionMap.put(sessionID, userID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}