import java.util.HashMap;
import java.util.Map;

public class java_28799_CredentialValidator_A01 {
    private Map<String, String> userMap;

    public java_28799_CredentialValidator_A01() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}