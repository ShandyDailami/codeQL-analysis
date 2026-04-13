import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_34839_CredentialValidator_A08 {
    private Map<String, String> userCredentials;

    public java_34839_CredentialValidator_A08() {
        this.userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String encodedPassword = userCredentials.get(username);
            byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
            String decodedPasswordString = new String(decodedPassword);
            return password.equals(decodedPasswordString);
        } else {
            return false;
        }
    }
}