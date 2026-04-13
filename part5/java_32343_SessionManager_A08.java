public class java_32343_SessionManager_A08 {
    private static final int SECURITY_SESSION_TIMEOUT = 10;
    private static HashMap<String, String> userMap;

    public java_32343_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String authenticateUser(String username, String password) {
        String savedPassword = userMap.get(username);

        if (savedPassword != null && savedPassword.equals(password)) {
            return createSession(username);
        } else {
            return null;
        }
    }

    private String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        userMap.put(sessionId, username);
        return sessionId;
    }

    public String getUserNameBySession(String sessionId) {
        return userMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return userMap.containsKey(sessionId);
    }

    public void logoutUser(String sessionId) {
        userMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();
        sessionManager.addUser("user1", "password1");
        sessionManager.addUser("user2", "password2");

        // Authenticate user
        String sessionId = sessionManager.authenticateUser("user1", "password1");

        if (sessionId != null) {
            System.out.println("Session ID: " + sessionId);
            System.out.println("User name: " + sessionManager.getUserNameBySession(sessionId));
        } else {
            System.out.println("Authentication failed!");
        }

        // Try to access user data after logging out
        System.out.println("Is valid session? " + sessionManager.isValidSession(sessionId));
        System.out.println("User name: " + sessionManager.getUserNameBySession(sessionId));

        // Logout user
        sessionManager.logoutUser(sessionId);

        // Try to access user data after logging out
        System.out.println("Is valid session? " + sessionManager.isValidSession(sessionId));
    }
}