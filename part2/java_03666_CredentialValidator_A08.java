import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03666_CredentialValidator_A08 {
    private Map<String, String> userCredentials;

    public java_03666_CredentialValidator_A08() {
        this.userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean isValidCredentials(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String encodedPassword = userCredentials.get(username);
            byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
            String decodedPasswordStr = new String(decodedPassword);
            return password.equals(decodedPasswordStr);
        } else {
            return false;
        }
    }
}