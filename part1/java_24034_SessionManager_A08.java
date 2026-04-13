import java.util.HashMap;
import java.util.Map;

public class java_24034_SessionManager_A08 {

    private Map<String, String> userMap;

    public java_24034_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    public void login(String username, String password) {
        if ("user".equals(username) && "password".equals(password)) {
            userMap.put("username", username);
        }
    }

    public void logout(String username) {
        userMap.remove(username);
    }

    public String getLoggedInUsername() {
        return userMap.get("username");
    }

    public boolean isLoggedIn(String username) {
        return userMap.containsKey(username);
    }
}