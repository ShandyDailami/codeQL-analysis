import java.util.HashMap;

public class java_10539_SessionManager_A08 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;
    private HashMap<String, String> permissionMap;

    public java_10539_SessionManager_A08() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
        permissionMap = new HashMap<>();
    }

    public String createSession(String userId, String password) {
        // This is a security-sensitive operation
        if (!isPasswordStrong(password)) {
            throw new SecurityException("Password is not strong enough. It should be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
        }

        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        // This is a security-sensitive operation
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    private boolean isPasswordStrong(String password) {
        // This is a security-sensitive operation
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$");
    }

    public void updateUserPassword(String sessionId, String newPassword) {
        // This is a security-sensitive operation
        if (!isPasswordStrong(newPassword)) {
            throw new SecurityException("Password is not strong enough. It should be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
        }

        String userId = sessionMap.get(sessionId);
        userMap.put(userId, newPassword);
    }

    public void grantPermission(String sessionId, String permission) {
        // This is a security-sensitive operation
        String userId = sessionMap.get(sessionId);
        permissionMap.put(userId, permission);
    }
}