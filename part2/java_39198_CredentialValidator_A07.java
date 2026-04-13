import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_39198_CredentialValidator_A07 {
    private Map<String, String> userCredentials;

    public java_39198_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        // Add some sample users
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String encodedPassword = userCredentials.get(username);
            byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
            return new String(decodedPassword).equals(password);
        } else {
            return false;
        }
    }
}