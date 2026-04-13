import java.util.HashMap;

public class java_37639_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_37639_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void login(String username, String password) {
        // A dummy check for security sensitive operations
        if (isPasswordSecure(password)) {
            sessions.put(username, password);
        } else {
            throw new AuthFailureException();
        }
    }

    public String getSession(String username) {
        return sessions.get(username);
    }

    public void logout(String username) {
        sessions.remove(username);
    }

    private boolean isPasswordSecure(String password) {
        // Implement your own security check here, this is a placeholder
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    }

    // Add your own exception class here, this is a placeholder
    class AuthFailureException extends RuntimeException {
        public java_37639_SessionManager_A07() {
            super("Authentication failed. Please check your credentials.");
        }
    }
}