import java.util.HashMap;
import java.util.Map;

public class java_07508_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_07508_SessionManager_A01() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean authenticate(String username, String password) {
        String correctPassword = getPassword(username);
        return correctPassword != null && correctPassword.equals(password);
    }
}