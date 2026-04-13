public class java_09675_SessionManager_A01 {
    private static SessionManager instance;

    private java_09675_SessionManager_A01() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private String accessKey;

    public void setAccessKey(String accessKey) {
        if (accessKey == null || accessKey.trim().isEmpty()) {
            throw new IllegalArgumentException("Access key cannot be null or empty");
        }
        this.accessKey = accessKey;
    }

    public void executeOperation(String operation, String key) {
        if (operation == null || operation.trim().isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be null or empty");
        }
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        if (!key.equals(accessKey)) {
            throw new SecurityException("Unauthorized operation: " + operation);
        }
        // Perform operation using key
    }
}