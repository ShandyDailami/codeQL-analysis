import java.util.HashMap;
import java.util.Map;

public class java_00752_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_00752_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userID) {
        sessionMap.put(userID, "Active");
    }

    public void endSession(String userID) {
        sessionMap.remove(userID);
    }

    public String getSessionState(String userID) {
        if (sessionMap.containsKey(userID)) {
            return sessionMap.get(userID);
        } else {
            return "Inactive";
        }
    }
}