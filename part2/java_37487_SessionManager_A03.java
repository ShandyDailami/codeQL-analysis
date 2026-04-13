public class java_37487_SessionManager_A03 {
    private String[] sessionIds;

    public java_37487_SessionManager_A03() {
        sessionIds = new String[100]; // Assume we have 100 sessions
    }

    public String createSession() {
        String sessionId = "";
        for (int i = 0; i < 8; i++) {
            sessionId += ((int) (Math.random() * 10)) % 10; // Generate a random number between 0 and 9
        }

        // Ensure sessionId is unique
        for (String id : sessionIds) {
            if (id != null && id.equals(sessionId)) {
                return createSession(); // Recursive call to create a new session
            }
        }

        sessionIds[Integer.parseInt(sessionId)] = sessionId; // Save the session id
        return sessionId;
    }

    public void endSession(String sessionId) {
        for (int i = 0; i < sessionIds.length; i++) {
            if (sessionIds[i] != null && sessionIds[i].equals(sessionId)) {
                sessionIds[i] = null; // End the session
                return;
            }
        }
    }
}