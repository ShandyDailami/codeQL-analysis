import java.util.HashMap;
import java.util.Map;

public class java_27205_SessionManager_A07 {
    private Map<String, String> credentials;

    public java_27205_SessionManager_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public String authenticate(String username, String password) {
        if (this.credentials.containsKey(username) && 
            this.credentials.get(username).equals(password)) {
            return "Welcome " + username;
        } else {
            throw new AuthenticationFailureException();
        }
    }

    // Custom exception for authentication failure
    class AuthenticationFailureException extends RuntimeException {
        public java_27205_SessionManager_A07() {
            super("Authentication failed");
        }
    }
}