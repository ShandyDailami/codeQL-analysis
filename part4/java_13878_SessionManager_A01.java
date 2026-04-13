import java.util.HashMap;
import java.util.Map;

public class java_13878_SessionManager_A01 {

    private Map<String, String> userCredentials;

    public java_13878_SessionManager_A01() {
        userCredentials = new HashMap<>();
        // initializing user credentials with dummy data
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean authenticateUser(String username, String password) {
        // checking if the provided password matches the stored one
        return userCredentials.get(username).equals(password);
    }
}