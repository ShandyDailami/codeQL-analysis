import java.util.HashMap;

public class java_20268_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_20268_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String userId) {
        // This operation is security-sensitive. We should implement the necessary security measures.
        // In this example, we're just returning a random session Id.
        // In a real-world application, you should replace this with a secure method to generate a session ID.
        String sessionId = "" + (int) (Math.random() * 1000000);
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    public String getUser(String sessionId) {
        // This operation is also security-sensitive.
        // In a real-world application, you should replace this with a secure method to get the user based on the session ID.
        // For this example, we're just returning a random user Id.
        String userId = "" + (int) (Math.random() * 100);
        return userId;
    }
}