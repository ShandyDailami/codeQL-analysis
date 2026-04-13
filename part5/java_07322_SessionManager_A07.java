import java.util.HashMap;
import java.util.Map;

public class java_07322_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07322_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isValidUser(username, password)) {
            sessionMap.put(username, "Valid Session");
        } else {
            throw new AuthFailureException();
        }
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    private boolean isValidUser(String username, String password) {
        // In a real-world application, you would typically query a database or another external source to verify the user's credentials
        return username.equals("validUser") && password.equals("validPassword");
    }

    private class AuthFailureException extends RuntimeException {
        // We're throwing a RuntimeException here because it's an unchecked exception
    }
}