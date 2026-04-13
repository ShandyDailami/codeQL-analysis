import java.util.HashMap;
import java.util.Map;

public class java_23960_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_23960_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        sessionMap.put(userName, userName);
    }

    public String getSession(String userName) {
        return sessionMap.get(userName);
    }

    public void endSession(String userName) {
        sessionMap.remove(userName);
    }
}