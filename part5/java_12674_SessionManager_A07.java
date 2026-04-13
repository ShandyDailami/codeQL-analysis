import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class java_12674_SessionManager_A07 {
    private Map<String, Date> sessionMap;

    public java_12674_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        sessionMap.put(sessionId, new Date());
    }

    public void validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            Date creationTime = sessionMap.get(sessionId);
            long currentTime = new Date().getTime();
            long sessionTime = creationTime.getTime();
            long sessionTimeout = 1000 * 60 * 10; // 10 minutes

            if ((currentTime - sessionTime) > sessionTimeout) {
                sessionMap.remove(sessionId);
                System.out.println("Invalid session, session has timed out!");
            } else {
                System.out.println("Valid session!");
            }
        } else {
            System.out.println("Invalid session!");
        }
    }
}