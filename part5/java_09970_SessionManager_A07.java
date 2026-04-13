import java.util.HashMap;
import java.util.Map;

public class java_09970_SessionManager_A07 {

    private Map<String, String> userMap;

    public java_09970_SessionManager_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        String correctPassword = userMap.get(username);
        return correctPassword != null && correctPassword.equals(password);
    }
}