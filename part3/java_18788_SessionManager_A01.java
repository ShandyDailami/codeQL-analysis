import java.util.HashMap;
import java.util.Map;

public class java_18788_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_18788_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = null;
        if(userId != null && !userId.isEmpty()){
            sessionId = userId + "_session";
            sessionMap.put(sessionId, userId);
        }
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if(sessionId != null && !sessionId.isEmpty()){
            sessionMap.remove(sessionId);
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId) {
        if(!isValidSession(sessionId)){
            throw new IllegalArgumentException("Invalid Session ID");
        }
    }
}