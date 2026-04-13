import java.util.HashMap;
import java.util.Map;

public class java_14681_SessionManager_A07 {

    private Map<String, String> userMap;

    public java_14681_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public String getUserPassword(String userId) {
        return userMap.get(userId);
    }

    public void addUser(String userId, String password) {
        userMap.put(userId, password);
    }

    public boolean authenticate(String userId, String password) {
        String dbPassword = userMap.get(userId);
        if (dbPassword == null) {
            return false;
        }
        return dbPassword.equals(password);
    }

    public void logout(String userId) {
        userMap.remove(userId);
    }

}