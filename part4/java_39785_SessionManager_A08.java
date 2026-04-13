import java.util.HashMap;

public class java_39785_SessionManager_A08 {
    private HashMap<String, String> userMap;

    public java_39785_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean authenticateUser(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).equals(password);
        }
        return false;
    }
}