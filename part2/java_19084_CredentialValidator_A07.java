import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_19084_CredentialValidator_A07 {

    private Map<String, String> userCredentials;

    public java_19084_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        userCredentials.put("user3", Base64.getEncoder().encodeToString("password3".getBytes()));
    }

    public boolean isValidCredentials(String user, String password) {
        if (userCredentials.containsKey(user)) {
            String storedPassword = userCredentials.get(user);
            return storedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            return false;
        }
    }
}