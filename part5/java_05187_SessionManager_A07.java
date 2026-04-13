public class java_05187_SessionManager_A07 {

    // Static variable to store the current session
    private static Session currentSession;

    // Public method to start a session
    public static void startSession(String userId) {
        System.out.println("Starting session for user: " + userId);
        currentSession = new Session();
        currentSession.setUserId(userId);
    }

    // Public method to end the current session
    public static void endSession() {
        System.out.println("Ending session for user: " + currentSession.getUserId());
        currentSession = null;
    }

    // Public method to validate the current session
    public static boolean isValid() {
        return (currentSession != null);
    }

    // Session class
    private class Session {
        private String userId;

        // Getter and setter methods
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}