import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.util.Map;

public class java_03353_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private ReentrantLock lock;

    public java_03353_SessionManager_A01() {
        sessionMap = new HashMap<>();
        lock = new ReentrantLock();
    }

    public String getSession(String sessionId) {
        lock.lock();
        try {
            return sessionMap.get(sessionId);
        } finally {
            lock.unlock();
        }
    }

    public void setSession(String sessionId, String sessionValue) {
        lock.lock();
        try {
            sessionMap.put(sessionId, sessionValue);
        } finally {
            lock.unlock();
        }
    }

    public void deleteSession(String sessionId) {
        lock.lock();
        try {
            sessionMap.remove(sessionId);
        } finally {
            lock.unlock();
        }
    }

    public void sessionSecurityCheck(String sessionId, String operation) {
        if (operation.equals("read")) {
            String sessionValue = getSession(sessionId);
            // check if sessionValue is null or not
            if (sessionValue == null) {
                System.out.println("Operation not permitted: Session read for sessionId " + sessionId);
            }
        } else if (operation.equals("write")) {
            setSession(sessionId, "newValue");
            // check if "newValue" has been set
            String sessionValue = getSession(sessionId);
            if (!sessionValue.equals("newValue")) {
                System.out.println("Operation not permitted: Session write for sessionId " + sessionId);
            }
        } else {
            System.out.println("Operation not supported");
        }
    }
}