import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class java_28536_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private Map<String, String> userMap;
    private Map<String, String> roleMap;

    public java_28536_SessionManager_A08() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
        roleMap = new HashMap<>();
    }

    public String createSession(String userId, String roleId) {
        // Create a unique session key
        String sessionKey = String.valueOf(System.currentTimeMillis());

        // Save session key and user id
        sessionMap.put(sessionKey, userId);

        // Save session key and role id
        userMap.put(userId, sessionKey);

        // Save session key and role id
        roleMap.put(roleId, sessionKey);

        return sessionKey;
    }

    public String getUserFromSession(String sessionKey) {
        // Retrieve user id from session key
        return sessionMap.get(sessionKey);
    }

    public String getRoleFromSession(String sessionKey) {
        // Retrieve role id from session key
        return roleMap.get(sessionMap.get(sessionKey));
    }

    public boolean isValidSession(String sessionKey) {
        // Check if session key is valid
        return sessionMap.containsKey(sessionKey) && userMap.containsKey(sessionMap.get(sessionKey)) && roleMap.containsKey(sessionMap.get(sessionKey));
    }

    public boolean isValidUser(String userId) {
        // Check if user id is valid
        return userMap.containsKey(userId);
    }

    public boolean isValidRole(String roleId) {
        // Check if role id is valid
        return roleMap.containsKey(roleId);
    }

    public void removeSession(String sessionKey) {
        // Remove session key from all maps
        sessionMap.remove(sessionKey);
        userMap.remove(sessionMap.get(sessionKey));
        roleMap.remove(sessionMap.get(sessionKey));
    }
}