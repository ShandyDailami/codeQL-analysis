import java.util.HashMap;
import java.util.Map;

public class java_06310_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06310_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (isValidUser(username, password)) {
            sessionMap.put(username, "SESSION-" + System.currentTimeMillis());
        } else {
            throw new AuthenticationFailureException();
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    private boolean isValidUser(String username, String password) {
        // Here we're just checking if the username and password are correct.
        // In a real-world application, you would usually check against a database.
        return username.equals("admin") && password.equals("password");
    }

    // We're throwing an exception here for the sake of the example. In a real-world application,
    // you would likely want to catch this exception and handle it appropriately.
    class AuthenticationFailureException extends RuntimeException {
    }
}