import java.util.HashMap;
import java.util.Map;

public class java_29064_CredentialValidator_A03 {

    private Map<String, String> userCredentials;

    public java_29064_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        return userCredentials.get(username) != null && userCredentials.get(username).equals(password);
    }
}