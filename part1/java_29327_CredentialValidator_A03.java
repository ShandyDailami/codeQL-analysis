import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29327_CredentialValidator_A03 {

    private Map<String, String> userCredentials;

    public java_29327_CredentialValidator_A03() {
        this.userCredentials = new HashMap<>();
        // Add some dummy credentials for the example
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (userCredentials.containsKey(user)) {
            String storedPassword = userCredentials.get(user);
            String suppliedPassword = Base64.getEncoder().encodeToString(password.getBytes());
            return storedPassword.equals(suppliedPassword);
        } else {
            return false;
        }
    }
}