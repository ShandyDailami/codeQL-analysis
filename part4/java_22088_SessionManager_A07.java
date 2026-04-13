import java.util.HashMap;
import java.util.Map;

public class java_22088_SessionManager_A07 {

    private Map<String, String> userMap;

    public java_22088_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String userName, String password) {
        userMap.put(userName, password);
    }

    public boolean authenticate(String userName, String password) {
        if (userMap.containsKey(userName) && userMap.get(userName).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}