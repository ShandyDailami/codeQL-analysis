import java.util.HashMap;
import java.util.Map;

public class java_18413_CredentialValidator_A03 {

    private Map<String, String> userCredentials;

    public java_18413_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        String expectedPassword = userCredentials.get(user);
        return password.equals(expectedPassword);
    }
}