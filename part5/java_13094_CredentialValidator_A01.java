import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13094_CredentialValidator_A01 {

    private Map<String, String> userCredentials;

    public java_13094_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String encodedPassword = userCredentials.get(username);
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            String decodedPassword = new String(decodedBytes);
            return decodedPassword.equals(password);
        } else {
            return false;
        }
    }

}