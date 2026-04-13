public class java_29925_SessionManager_A01 {
    private static Map<String, User> sessionMap = new HashMap<>();

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        User user = sessionManager.startSession("session1");
        System.out.println("Session started for user: " + user.getName());
        try {
            sessionManager.accessResource(user, "resource1");
        } catch (Exception e) {
            System.out.println("Session expired. Cannot access resource.");
       
        }
    }

    public User startSession(String sessionId) {
        if (sessionId != null && !sessionId.isEmpty()) {
            User user = sessionMap.get(sessionId);
            if (user != null) {
                return user;
            }
        }
        User user = new User(sessionId, "User");
        sessionMap.put(sessionId, user);
        return user;
    }

    public void accessResource(User user, String resource) throws Exception {
        if (user != null) {
            // simulate access to a resource
            if (resource != null && !resource.isEmpty()) {
                System.out.println("Accessing resource: " + resource);
            } else {
                throw new Exception("Resource not found");
            }
        } else {
            throw new Exception("Session expired");
        }
    }
}

class User {
    private String sessionId;
    private String name;

    public java_29925_SessionManager_A01(String sessionId, String name) {
        this.sessionId = sessionId;
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getName() {
        return name;
    }
}