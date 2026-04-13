import java.util.HashMap;
import java.util.Map;

public class java_04533_SessionManager_A07 {
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private static final long VALIDITY_TIME = 60000L; // 60 seconds
    private Map<String, AuthFailureInfo> sessionMap;

    public java_04533_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void storeFailedAttempt(String userId, String ipAddress) {
        if (sessionMap.containsKey(userId)) {
            AuthFailureInfo info = sessionMap.get(userId);
            info.incrementAttempts();
            sessionMap.put(userId, info);
        } else {
            AuthFailureInfo info = new AuthFailureInfo(ipAddress);
            sessionMap.put(userId, info);
        }
    }

    public boolean isValid(String userId) {
        if (sessionMap.containsKey(userId)) {
            AuthFailureInfo info = sessionMap.get(userId);
            long currentTime = System.currentTimeMillis();
            if (info.getAttempts() >= MAX_FAILED_ATTEMPTS || currentTime > info.getLastAttemptTime() + VALIDITY_TIME) {
                sessionMap.remove(userId);
                return false;
            }
        }
        return true;
    }

    private static class AuthFailureInfo {
        private int attempts;
        private String ipAddress;
        private long lastAttemptTime;

        public java_04533_SessionManager_A07(String ipAddress) {
            this.ipAddress = ipAddress;
            this.lastAttemptTime = System.currentTimeMillis();
            this.attempts = 1;
        }

        public void incrementAttempts() {
            this.attempts++;
            this.lastAttemptTime = System.currentTimeMillis();
        }

        public int getAttempts() {
            return attempts;
        }

        public long getLastAttemptTime() {
            return lastAttemptTime;
        }
    }
}