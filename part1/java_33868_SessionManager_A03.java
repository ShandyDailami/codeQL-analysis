import java.util.HashMap;

public class java_33868_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_33868_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userName) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        String sessionId = sm.getSessionId("John");
        System.out.println("Session Id: " + sessionId);

        String userName = sm.getUserName(sessionId);
        System.out.println("User Name: " + userName);

        sm.removeSession(sessionId);
        System.out.println("Session removed");
    }
}