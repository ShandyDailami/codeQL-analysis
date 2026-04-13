public class java_25554_SessionManager_A01 {

    private Map<String, String> usernamePasswordMap = new HashMap<>();
    private Map<String, String> sessionIdUsernameMap = new HashMap<>();

    public java_25554_SessionManager_A01() {
        // Add some dummy data for the username and password map
        usernamePasswordMap.put("user1", "password1");
        usernamePasswordMap.put("user2", "password2");
    }

    public String authenticate(String username, String password) {
        if (usernamePasswordMap.containsKey(username) && usernamePasswordMap.get(username).equals(password)) {
            // Generate a session ID
            String sessionId = UUID.randomUUID().toString();

            // Store the session ID and username in the map
            sessionIdUsernameMap.put(sessionId, username);

            return sessionId;
        } else {
            return null;
        }
    }

    public String getUsernameForSessionId(String sessionId) {
        if (sessionIdUsernameMap.containsKey(sessionId)) {
            return sessionIdUsernameMap.get(sessionId);
        } else {
            return null;
        }
    }

    public boolean isValidSession(String sessionId) {
        // Check if the session ID exists in the map
        return sessionIdUsernameMap.containsKey(sessionId);
    }
}