import java.util.HashMap;
import java.util.Map;

public class java_18175_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_18175_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if(sessionId == null || sessionId.isEmpty() || userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("Session Id and User Id must be provided.");
        }

        // This is a security-sensitive operation.
        // It verifies if the sessionId already exists in the sessionMap.
        // If it does, it throws an exception.
        if(sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session integrity failure: Session Id already in use.");
        }

        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session Id must be provided.");
        }

        // This is a security-sensitive operation.
        // It verifies if the sessionId exists in the sessionMap.
        // If it doesn't, it throws an exception.
        if(!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session integrity failure: Session Id not found.");
        }

        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session Id must be provided.");
       
        // This is a security-sensitive operation.
        // It verifies if the sessionId exists in the sessionMap.
        // If it doesn't, it throws an exception.
        }
        if(!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session integrity failure: Session Id not found.");
        }

        sessionMap.remove(sessionId);
    }
}