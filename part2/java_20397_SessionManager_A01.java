public class java_20397_SessionManager_A01 {
    private HashMap<String, String> sessionData;

    public java_20397_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionData.containsKey(sessionId)) {
            System.out.println("Session already exists. Please start a new session.");
        } else {
            sessionData.put(sessionId, userId);
            System.out.println("New session started. Session ID: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            sessionData.remove(sessionId);
            System.out.println("Session ended. Session ID: " + sessionId);
        } else {
            System.out.println("Session does not exist. Please start a session first.");
        }
    }

    public String getUserId(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            System.out.println("Session does not exist. Please start a session first.");
            return null;
        }
    }
}