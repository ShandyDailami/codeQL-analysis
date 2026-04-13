public class java_06888_SessionManager_A07 {
    private static SessionManager instance;
    private Map<String, String> credentials;

    private java_06888_SessionManager_A07() {
        credentials = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void addCredentials(String username, String password) {
        credentials.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    public void secureOperation(String username) {
        if (!authenticate(username, "password")) { // password is hardcoded, ideally this should be securely stored
            throw new AuthFailureException("Authentication failed");
        }

        // perform secure operation
    }
}

class AuthFailureException extends RuntimeException {
    public java_06888_SessionManager_A07(String message) {
        super(message);
    }
}