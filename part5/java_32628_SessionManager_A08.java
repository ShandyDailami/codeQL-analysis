public class java_32628_SessionManager_A08 {
    private HashMap<String, String> userPasswords;

    public java_32628_SessionManager_A08() {
        userPasswords = new HashMap<>();
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");
    }

    public boolean validateUser(String user, String password) {
        if (userPasswords.containsKey(user) && userPasswords.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_32628_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession(String user, String password) {
        if (securityManager.validateUser(user, password)) {
            System.out.println("Session started for user: " + user);
        } else {
            System.out.println("Invalid user or password. Session not started.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SessionManager sessionManager = new SessionManager(securityManager);

        sessionManager.startSession("user1", "password1"); // valid credentials
        sessionManager.startSession("user3", "password3"); // invalid credentials
    }
}