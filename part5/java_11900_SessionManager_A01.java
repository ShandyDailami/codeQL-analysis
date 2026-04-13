import java.util.HashMap;
import java.util.Map;

public class java_11900_SessionManager_A01 {
    private Map<String, String> userMap;
    private Map<String, String> roleMap;

    public java_11900_SessionManager_A01() {
        userMap = new HashMap<>();
        roleMap = new HashMap<>();
    }

    public void addUser(String username, String password, String role) {
        userMap.put(username, password);
        roleMap.put(username, role);
    }

    public String authenticate(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return roleMap.get(username);
        } else {
            return null;
        }
    }
}