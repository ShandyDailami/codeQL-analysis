import java.util.HashMap;

public class java_10255_SessionManager_A03 {
    private HashMap<String, String> sessionData;

    public java_10255_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    public void startSession(String userID, String username) {
        sessionData.put(userID, username);
    }

    public String getSessionUsername(String userID) {
        return sessionData.get(userID);
    }

    public boolean checkCredentials(String userID, String password) {
        String username = sessionData.get(userID);
        if (username != null && username.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}