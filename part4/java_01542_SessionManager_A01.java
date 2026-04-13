import java.util.HashMap;
import java.util.Map;

public class java_01542_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_01542_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        // You should implement the method here.
        // For the sake of simplicity, we'll just store the username in the session map.
        // In a real-world application, you would not want to store passwords in plain text.
        sessionMap.put(user, password);
    }

    public String getSession(String user) {
        // You should implement the method here.
        // Similar to startSession, we'll just return the password from the session map.
        // In a real-world application, you would not want to return passwords in plain text.
        return sessionMap.get(user);
    }

    public void endSession(String user) {
        // You should implement the method here.
        // In a real-world application, you would want to ensure that only the user who started the session can end it.
        sessionMap.remove(user);
    }
}