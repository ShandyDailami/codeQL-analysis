import java.util.HashMap;

public class java_41625_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_41625_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionID, userID);
        return sessionID;
    }

    public String getUserBySession(String sessionID) {
        return sessions.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessions.remove(sessionID);
    }

    public void checkIn(String sessionID) {
        if (sessions.containsKey(sessionID)) {
            // Security check: user can only check in if they are the owner of the session
            String userID = sessions.get(sessionID);
            if (getUserBySession(sessionID).equals(userID)) {
                // Security check: session must not be expired
                long currentTime = System.currentTimeMillis();
                long sessionTime = Long.parseLong(userID.substring(8));
                if (currentTime - sessionTime > 10000) {
                    // session expired
                    sessions.remove(sessionID);
                } else {
                    // session valid
                    sessions.put(sessionID, userID);
                }
            } else {
                // Invalid session
                sessions.remove(sessionID);
            }
        }
    }
}