import java.util.HashMap;

public class java_11284_SessionManager_A07 {
    private HashMap<String, String> userMap;

    public java_11284_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = userMap.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}