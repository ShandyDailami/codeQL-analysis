public class java_10029_SessionManager_A03 {
    private static SessionManager instance;

    private java_10029_SessionManager_A03() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        // Adding a security-sensitive operation related to injection.
        // This is a placeholder for a real-world operation.
        // In real-world scenarios, this operation should not be allowed.
        this.password = injectPassword();
    }

    private String injectPassword() {
        // This is a placeholder for a real-world operation.
        // In real-world scenarios, this operation should not be allowed.
        return "password";
    }

    public String getPassword() {
        return password;
    }
}