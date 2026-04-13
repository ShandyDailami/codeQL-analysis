import java.util.HashMap;
import java.util.Map;

public class java_03919_CredentialValidator_A03 {
    private Map<String, String> userData;

    public java_03919_CredentialValidator_A03() {
        userData = new HashMap<>();
        userData.put("user1", "password1");
        userData.put("user2", "password2");
        userData.put("user3", "password3");
    }

    public boolean isValidCredentials(String username, String password) {
        String expectedPassword = userData.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}