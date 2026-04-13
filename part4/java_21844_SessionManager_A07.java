import java.util.HashMap;

public class java_21844_SessionManager_A07 {
    private HashMap<String, String> userMap; // Username and password map

    public java_21844_SessionManager_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean validateUser(String username, String password) {
        String correctPassword = userMap.get(username);
        return correctPassword != null && correctPassword.equals(password);
    }
}