import java.util.HashMap;
import java.util.Map;

public class java_37550_SessionManager_A01 implements SessionManager {
    private Map<String, String> sessionMap;

    public java_37550_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    @Override
    public String createSession(String userName, String password) {
        // In real-world application, we would need to use a Security Manager
        // to authenticate the user and only allow access to this method if the user is authenticated
        if (password.equals("password")) {
            sessionMap.put(userName, "session1");
            return "session1";
        } else {
            return null;
        }
    }

    @Override
    public String getSession(String userName) {
        return sessionMap.get(userName);
    }

    @Override
    public void removeSession(String userName) {
        sessionMap.remove(userName);
    }
}