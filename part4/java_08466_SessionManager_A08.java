public class java_08466_SessionManager_A08 {
    // Field to store user session
    private UserSession currentUserSession;

    // Inner class UserSession to encapsulate user session data
    private class UserSession {
        private String userId;
        private String userName;

        public java_08466_SessionManager_A08(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }
    }

    // Method to start session
    public void startSession(String userId, String userName) {
        if (currentUserSession == null) {
            currentUserSession = new UserSession(userId, userName);
            System.out.println("Session started for user: " + userName);
        } else {
            System.out.println("Session already started for user: " + currentUserSession.getUserName());
        }
    }

    // Method to end session
    public void endSession() {
        if (currentUserSession != null) {
            System.out.println("Session ended for user: " + currentUserSession.getUserName());
            currentUserSession = null;
        } else {
            System.out.println("No active session to end");
        }
    }

    // Method to get user session details
    public UserSession getUserSession() {
        return currentUserSession;
    }
}