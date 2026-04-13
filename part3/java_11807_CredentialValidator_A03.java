import java.util.HashMap;
import java.util.Map;

public class java_11807_CredentialValidator_A03 {
    private Map<String, String> userMap;

    public java_11807_CredentialValidator_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = userMap.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}