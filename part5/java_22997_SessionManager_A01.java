import java.util.HashMap;
import java.util.Map;

public class java_22997_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_22997_SessionManager_A01() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public String getPassword(String user) {
        return userMap.get(user);
    }

    public boolean authenticate(String user, String password) {
        String correctPassword = userMap.get(user);
        if (correctPassword != null && correctPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}