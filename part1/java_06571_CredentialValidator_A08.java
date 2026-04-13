import java.util.HashMap;
import java.util.Map;

public class java_06571_CredentialValidator_A08 {

    private Map<String, String> userMap;

    public java_06571_CredentialValidator_A08() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        return userMap.containsKey(user) && userMap.get(user).equals(password);
    }
}