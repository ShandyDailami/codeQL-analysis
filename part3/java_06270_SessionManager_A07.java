import java.util.HashMap;
import java.util.Map;

public class java_06270_SessionManager_A07 {
    private Map<String, String> validUsers;

    public java_06270_SessionManager_A07() {
        validUsers = new HashMap<>();
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public boolean isValidUser(String username, String password) {
        String correctPassword = validUsers.get(username);
        return correctPassword != null && correctPassword.equals(password);
    }
}