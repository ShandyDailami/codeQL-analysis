import java.util.HashMap;
import java.util.Map;

public class java_21241_SessionManager_A07 {

    private Map<String, String> userMap;

    public java_21241_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean authenticate(String username, String password) {
        if (!userMap.containsKey(username)) {
            System.out.println("Authentication failed: User not found");
            return false;
        } else if (!userMap.get(username).equals(password)) {
            System.out.println("Authentication failed: Password is incorrect");
            return false;
        }
        System.out.println("Authentication successful");
        return true;
    }
}