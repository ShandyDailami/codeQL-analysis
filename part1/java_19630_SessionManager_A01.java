public class java_19630_SessionManager_A01 {
    private String username;
    private String password;

    public java_19630_SessionManager_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isAccessGranted() {
        // Simulate security-sensitive operations.
        // This will be replaced with actual authentication checks.
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public void startSession() {
        if (!isAccessGranted()) {
            throw new SecurityException("Access Denied.");
        } else {
            System.out.println("Session Started.");
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("admin", "password");
        manager.startSession();
    }
}