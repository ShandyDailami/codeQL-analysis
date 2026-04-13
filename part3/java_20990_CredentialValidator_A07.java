import java.util.HashMap;
import java.util.Map;

public class java_20990_CredentialValidator_A07 {
    private Map<String, String> userCredentials;

    public java_20990_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        // Add some dummy credentials
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        // Check if the entered password matches the stored password for the user
        return userCredentials.get(user).equals(password);
    }
}