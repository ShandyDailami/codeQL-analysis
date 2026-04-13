import java.util.HashMap;
import java.util.Map;

public class java_10768_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_10768_SessionManager_A01() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public String validateUser(String username, String password) {
        String passwordInDB = userMap.get(username);

        if (passwordInDB != null && passwordInDB.equals(password)) {
            return "User authenticated";
        }

        return "User authentication failed";
    }
}