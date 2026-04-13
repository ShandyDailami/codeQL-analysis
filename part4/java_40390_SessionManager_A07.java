import java.util.HashMap;
import java.util.Map;

public class java_40390_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_40390_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String password) {
        // Hash password for storage purposes, not for security purposes
        sessionMap.put(username, password);
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void authenticate(String username, String password) throws AuthFailure {
        String storedPassword = sessionMap.get(username);
        if (storedPassword == null) {
            throw new AuthFailure("No such user");
        }

        if (!storedPassword.equals(password)) {
            throw new AuthFailure("Incorrect password");
        }
    }
}

class AuthFailure extends Exception {
    public java_40390_SessionManager_A07(String message) {
        super(message);
    }
}