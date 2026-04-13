import java.util.HashMap;
import java.util.Map;

public class java_21104_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21104_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if(sessionMap.containsKey(sessionId)) {
            System.out.println("Session Already Exists");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session Created Successfully");
        }
    }

    public void deleteSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session Deleted Successfully");
        } else {
            System.out.println("Session Doesn't Exist");
        }
    }

    public void getSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("User Id: " + userId);
        } else {
            System.out.println("Session Doesn't Exist");
        }
    }
}