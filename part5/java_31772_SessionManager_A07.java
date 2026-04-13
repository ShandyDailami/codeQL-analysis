import javax.management.AuthenticationFailureException;
import java.util.HashMap;
import java.util.Map;

public class java_31772_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31772_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String password) throws AuthenticationFailureException {
        // This is a mock authenticate method. It's important to not use it for real authentication.
        // This method should be replaced with a real method that takes userId and password,
        // and returns a boolean value indicating whether the user is authenticated.

        if (userId.equals("admin") && password.equals("password")) {
            sessionMap.put(userId, password);
        } else {
            throw new AuthenticationFailureException();
        }
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void invalidateSession(String userId) {
        sessionMap.remove(userId);
    }
}