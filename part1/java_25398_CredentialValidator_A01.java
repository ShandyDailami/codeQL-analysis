import java.util.HashMap;
import java.util.Map;

public class java_25398_CredentialValidator_A01 {

    private Map<String, String> userCredentials;

    public java_25398_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = userCredentials.get(username);
        return password.equals(expectedPassword);
    }
}