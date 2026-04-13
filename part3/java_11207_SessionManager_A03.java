import java.util.HashMap;
import java.util.Map;

public class java_11207_SessionManager_A03 {
    // In a real-world scenario, this data would be stored in a database or a file.
    private Map<String, String> userData;

    public java_11207_SessionManager_A03() {
        userData = new HashMap<>();
    }

    public String getUserData(String userId) {
        return userData.get(userId);
    }

    public void setUserData(String userId, String userData) {
        this.userData.put(userId, userData);
    }
}