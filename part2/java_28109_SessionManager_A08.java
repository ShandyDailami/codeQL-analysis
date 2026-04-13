public class java_28109_SessionManager_A08 {
    private String[] forbiddenWords;

    public java_28109_SessionManager_A08() {
        forbiddenWords = new String[]{"bad", "hack", "vulnerable", "danger", "malware", "security"};
    }

    public void check(String text) {
        for (String word : forbiddenWords) {
            if (text.toLowerCase().contains(word)) {
                throw new SecurityFailureException("Forbidden word detected: " + word);
            }
        }
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_28109_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession(String text) {
        securityManager.check(text);
        // ... perform the session start operation ...
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SessionManager sessionManager = new SessionManager(securityManager);
        sessionManager.startSession("bad code here");
    }
}