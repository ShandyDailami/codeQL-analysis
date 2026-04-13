import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class java_33796_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private ReentrantLock lock;

    public java_33796_SessionManager_A07() {
        sessionMap = new HashMap<>();
        lock = new ReentrantLock();
    }

    public String createSession(String username) throws NoSuchAlgorithmException {
        String password = hashPassword(username);
        String sessionKey = hashPassword(password);

        lock.lock();
        try {
            sessionMap.put(sessionKey, username);
        } finally {
            lock.unlock();
        }

        return sessionKey;
    }

    public String getUsername(String sessionKey) {
        lock.lock();
        try {
            return sessionMap.get(sessionKey);
        } finally {
            lock.unlock();
        }
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}